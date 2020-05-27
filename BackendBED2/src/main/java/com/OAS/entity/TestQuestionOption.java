package com.OAS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TestQuestionOption")
@SequenceGenerator(name = "testquestionoption_seq", initialValue = 1)
public class TestQuestionOption {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "testquestionoption_seq")
	@Column(name = "testquestionoptionid")
	private int testquestionoptionid;
	
	@Column(name = "TestQuestionOptionV")
	private String TestQuestionOptionV;
	
	@Column(name = "TestOptionCode")
	private String TestOptionCode;

	
	public TestQuestionOption() {
	}

	public TestQuestionOption(String testQuestionOptionv, String testOptionCode) {
		TestQuestionOptionV = testQuestionOptionv;
		TestOptionCode = testOptionCode;
	}

	public int getTestquestionoptionid() {
		return testquestionoptionid;
	}

	public void setTestquestionoptionid(int testquestionoptionid) {
		this.testquestionoptionid = testquestionoptionid;
	}

	public String getTestQuestionOption() {
		return TestQuestionOptionV;
	}

	public void setTestQuestionOption(String testQuestionOption) {
		TestQuestionOptionV = testQuestionOption;
	}

	public String getTestOptionCode() {
		return TestOptionCode;
	}

	public void setTestOptionCode(String testOptionCode) {
		TestOptionCode = testOptionCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((TestOptionCode == null) ? 0 : TestOptionCode.hashCode());
		result = prime * result + ((TestQuestionOptionV == null) ? 0 : TestQuestionOptionV.hashCode());
		result = prime * result + testquestionoptionid;
		return result;
	}	
}
