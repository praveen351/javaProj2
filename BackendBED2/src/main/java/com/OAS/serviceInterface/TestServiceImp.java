package com.OAS.serviceInterface;

import java.util.List;

import com.OAS.entity.TestSubject;
import com.OAS.entity.Users;
import com.OAS.model.TestData;
import com.OAS.model.UserAuthenticate;

public interface TestServiceImp {

	public void addData(List<Users> users, List<TestSubject> tsubjects);

	public TestSubject getQuestionAnswerOption(String name);

	public Users doRegister(Users users);

	public Users doAuthenticate(UserAuthenticate userdata);

	public List<Users> doListUsers();

	public List<TestData> doListCandidateTest();
	
	public int finalUpgradeData(String TestName, String exam_data, int id);
}
