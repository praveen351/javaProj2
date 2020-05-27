package com.OAS.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.OAS.daoInterface.DaoInterface;
import com.OAS.entity.CandidateStatus;
import com.OAS.entity.TestSubject;
import com.OAS.entity.Users;
import com.OAS.model.TestData;
import com.OAS.model.UserAuthenticate;
import com.OAS.util.HibernateCUInterface;

@Component
public class DaoInteraction implements DaoInterface {

	private SessionFactory sessionFactory;

	@Autowired
	public DaoInteraction(@Qualifier("H2DB") HibernateCUInterface service) {
		this.sessionFactory = service.getSessionFactory();
	}

	public void addData(List<Users> users, List<TestSubject> tsubjects) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		if (!transaction.isActive())
			transaction.begin();
		for (Users user : users)
			session.save(user);
		for (TestSubject tsubject : tsubjects)
			session.save(tsubject);
		transaction.commit();
	}

	public TestSubject getQuestionAnswerOption(String name) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		if (!transaction.isActive())
			transaction.begin();
		Query query = session.createQuery("from TestSubject where Subject_Name=:name");
		query.setParameter("name", name);
		TestSubject testSubject = (TestSubject) query.uniqueResult();
		return testSubject;
	}

	public Users doRegister(Users users) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		if (!transaction.isActive())
			transaction.begin();
		users.setUser_Type("candidate");
		session.save(users);
		transaction.commit();
		return users;
	}

	public Users doAuthenticate(UserAuthenticate userdata) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		if (!transaction.isActive())
			transaction.begin();
		Query query = session.createQuery("from Users where Email=:email_id");
		query.setParameter("email_id", userdata.getEmail());
		Users user = (Users) query.uniqueResult();

		if (user.equals(null)) {
			user = new Users();
			user.setUserid(0);
			return user;
		} else
			return user;
	}

	public List<Users> doListUsers() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		if (!transaction.isActive())
			transaction.begin();
		Query query = session.createQuery("from Users");
		List<Users> users = query.list();
		return users;
	}

	public List<TestData> doListCandidateTest() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		if (!transaction.isActive())
			transaction.begin();
		String hsql = "SELECT candstatus.TestDate,testsub.Subject_Name,testsub.Subject_Total_Mark,user.Email,candstatus.TestMark,";
		hsql = hsql + "candstatus.Result FROM Users user join CandidateStatus candstatus ON ";
		hsql = hsql
				+ "user.userid = candstatus.ucsid join TestSubject testsub ON candstatus.tscsid = testsub.testsubjectid";

		String hql = "SELECT candstatus.TestDate,testsub.Subject_Name,testsub.Subject_Total_Mark,user.Email, "
				+ "candstatus.TestMark,candstatus.Result FROM Users user , CandidateStatus candstatus , TestSubject testsub where user.userid = candstatus.ucsid "
				+ "and candstatus.tscsid = testsub.testsubjectid";

		String shql = "SELECT candstatus.TestDate,testsub.Subject_Name,testsub.Subject_Total_Mark,user.Email,candstatus.TestMark,candstatus.Result "
				+ "FROM Users user join user.CandidateStatusList candstatus join candstatus.testSubject testsub";
		Query query = session.createQuery(shql);
		List<TestData> testlist = new ArrayList<TestData>();
		List<Object[]> users = query.getResultList();
		for (Object[] objects : users) {
			testlist.add(new TestData((String) objects[0], (String) objects[1], Integer.parseInt(objects[4].toString()),
					(String) objects[3], Integer.parseInt(objects[2].toString()), (String) objects[5]));
		}
		return testlist;
	}

	public CandidateStatus doInsertCandidateData(CandidateStatus candidateStatus, Users user, TestSubject testSub) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		if (!transaction.isActive())
			transaction.begin();

		SimpleDateFormat ft = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
		candidateStatus.setTestDate(ft.format(new Date()));
		candidateStatus.setTestSubject(testSub);

		session.save(candidateStatus);

		Query query = session.createQuery(
				"update CandidateStatus set ucsid=:userid,tscsid=:testid where candidatestatusid=:candiId");
		query.setParameter("userid", user.getUserid());
		query.setParameter("testid", testSub.getTestsubjectid());
		query.setParameter("candiId", candidateStatus.getCandidatestatusid());
		int count = query.executeUpdate();
		transaction.commit();
		return candidateStatus;
	}

}