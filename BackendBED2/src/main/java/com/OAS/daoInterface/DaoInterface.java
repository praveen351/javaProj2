package com.OAS.daoInterface;

import java.util.List;

import com.OAS.entity.CandidateStatus;
import com.OAS.entity.TestSubject;
import com.OAS.entity.Users;
import com.OAS.model.TestData;
import com.OAS.model.UserAuthenticate;

public interface DaoInterface {

	public void addData(List<Users> users, List<TestSubject> tsubjects);

	public TestSubject getQuestionAnswerOption(String name);

	public Users doRegister(Users users);

	public Users doAuthenticate(UserAuthenticate userdata);

	public List<Users> doListUsers();

	public List<TestData> doListCandidateTest();

	public CandidateStatus doInsertCandidateData(CandidateStatus candidateStatus, Users user, TestSubject testSub);
}
