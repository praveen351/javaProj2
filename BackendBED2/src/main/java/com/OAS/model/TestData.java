package com.OAS.model;

public class TestData {
	private String testData;
	private String subjectName;
	private int testMark;
	private String emailID;
	private int totalMark;
	private String result;

	public TestData(String testData, String subjectName, int testMark, String emailID, int totalMark , String result) {
		this.testData = testData;
		this.subjectName = subjectName;
		this.testMark = testMark;
		this.emailID = emailID;
		this.totalMark = totalMark;
		this.result = result;
	}

	public String getTestData() {
		return testData;
	}

	public void setTestData(String testData) {
		this.testData = testData;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getTestMark() {
		return testMark;
	}

	public void setTestMark(int testMark) {
		this.testMark = testMark;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public int getTotalMark() {
		return totalMark;
	}

	public void setTotalMark(int totalMark) {
		this.totalMark = totalMark;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
