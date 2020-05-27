package com.OAS.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.OAS.daoInterface.DaoInterface;
import com.OAS.entity.CandidateStatus;
import com.OAS.entity.TestQuestionAnswer;
import com.OAS.entity.TestSubject;
import com.OAS.entity.Users;
import com.OAS.model.TestData;
import com.OAS.model.UserAuthenticate;
import com.OAS.serviceInterface.TestServiceImp;

@Component
public class TestService implements TestServiceImp {

	private DaoInterface interDao;

	@Autowired
	public TestService(DaoInterface interDao) {
		this.interDao = interDao;
	}

	public void addData(List<Users> users, List<TestSubject> tsubjects) {
		interDao.addData(users, tsubjects);
	}

	public TestSubject getQuestionAnswerOption(String name) {
		return interDao.getQuestionAnswerOption(name);
	}

	public Users doRegister(Users users) {
		return interDao.doRegister(users);
	}

	public Users doAuthenticate(UserAuthenticate userdata) {
		Users data = interDao.doAuthenticate(userdata);
		if (data.getUserid() != 0) {
			if (data.getPassword().equals(userdata.getPassword())) {
				return data;
			} else {
				data.setUserid(0);
				return data;
			}
		} else {
			data.setUserid(-1);
			return data;
		}
	}

	public List<Users> doListUsers() {
		return interDao.doListUsers();
	}

	public List<TestData> doListCandidateTest() {
		return interDao.doListCandidateTest();
	}

	private Map<String, String> convertMapFormatQA(List<TestQuestionAnswer> qalist) {
		Map<String, String> mapQA = new HashMap<String, String>();
		for (TestQuestionAnswer testQuestionAnswer : qalist) {
			mapQA.put(testQuestionAnswer.getTestQuestion(), testQuestionAnswer.getTestAnswer());
		}
		return mapQA;
	}

	private Map<String, String> convertMapFormatDQA(String formData) {
		String[] questioAnswer = formData.split("#");
		Map<String, String> mapQA = new HashMap<String, String>();

		if (questioAnswer.length >= 1 && !questioAnswer[0].equals("")) {
			for (String testQuestionAnswer : questioAnswer) {
				String question = testQuestionAnswer.split("-")[0];
				String answer = testQuestionAnswer.split("-")[1];
				mapQA.put(question, answer);
			}
		}

		return mapQA;
	}

	private Map<String, Object> addCandidateResult(Map<String, String> qa1, Map<String, String> qa2) {
		Set<String> qa1Set = qa1.keySet();
		Map<String, Object> markResult = new HashMap<String, Object>();
		int mark = 0;
		String result = "";
		for (String string : qa1Set) {
			if (qa1.get(string).equals(qa2.get(string))) {
				mark = mark + 10;
			}
		}
		if (mark >= 30)
			result = "PASSED";
		else
			result = "FAILED";
		markResult.put("mark", mark);
		markResult.put("result", result);
		return markResult;
	}

	private int setCandidateData(Map<String, Object> mapper, Users udata, TestSubject testSubject) {
		/*
		 * CandidateStatus cstatus = new CandidateStatus(null,
		 * Integer.parseInt(mapper.get("mark").toString()), (String)
		 * mapper.get("result"));
		 */
		CandidateStatus cstatus = new CandidateStatus(null, Integer.parseInt(mapper.get("mark").toString()),
				(String) mapper.get("result") , null);
		CandidateStatus ccdata = interDao.doInsertCandidateData(cstatus, udata, testSubject);
		if (ccdata.getCandidatestatusid() != 0)
			return 1;
		else
			return 0;
	}

	public int finalUpgradeData(String TestName, String exam_data, int id) {
		TestSubject testObj = this.getQuestionAnswerOption(TestName);
		List<TestQuestionAnswer> QAObject = testObj.getTestQuestionAnswerList();

		Map<String, String> mapper1 = this.convertMapFormatDQA(exam_data);
		Map<String, String> mapper2 = this.convertMapFormatQA(QAObject);
		Map<String, Object> resultData = this.addCandidateResult(mapper2, mapper1);

		int status = this.setCandidateData(resultData, new Users(id), testObj);
		if (status == 1) {
			if (resultData.get("result").equals("PASSED"))
				return 1;
			else
				return 0;
		} else
			return -1;
	}
}