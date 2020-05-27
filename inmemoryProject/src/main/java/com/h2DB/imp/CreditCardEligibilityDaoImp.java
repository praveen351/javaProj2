package com.h2DB.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.h2DB.dao.CreditCardEligibilityDao;
import com.h2DB.model.CreditCardEligibility;
import com.h2DB.util.HibernateCUInterface;

@Component
public class CreditCardEligibilityDaoImp implements CreditCardEligibilityDao {
	private Session session;
	private Transaction transaction;

	@Autowired
	public CreditCardEligibilityDaoImp(HibernateCUInterface uiconnect) {
		this.session = uiconnect.getSessionFactory().openSession();
		this.transaction = this.session.beginTransaction();
	}

	public CreditCardEligibility getCreditCardEligibility(String PANNumber) {
		Query query = session.createQuery("from CreditCardEligibility where PANNumber=:PANNumberval");
		query.setParameter("PANNumberval", PANNumber);
		CreditCardEligibility pandetail = (CreditCardEligibility) query.uniqueResult();

		return pandetail;
	}

	public void addBulkInsertData(List<CreditCardEligibility> bulkData) {
		for (CreditCardEligibility creditCardEligibility : bulkData) {
			session.save(creditCardEligibility);
		}
		transaction.commit();
		transaction.begin();
	}
}
