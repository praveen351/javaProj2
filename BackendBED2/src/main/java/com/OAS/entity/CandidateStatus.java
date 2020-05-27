package com.OAS.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CandidateStatus")
@SequenceGenerator(name = "candidatestatus_seq", initialValue = 1)
public class CandidateStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidatestatus_seq")
	@Column(name = "candidatestatusid")
	private int candidatestatusid;

	@Column(name = "TestDate")
	private String TestDate;

	@Column(name = "TestMark")
	private int TestMark;

	@Column(name = "Result")
	private String Result;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tscsid")
	private TestSubject testSubject;

	public CandidateStatus() {
	}

	public CandidateStatus(String testDate, int testMark, String result,
			TestSubject testSubject) {
		TestDate = testDate;
		TestMark = testMark;
		Result = result;
		this.testSubject = testSubject;
	}

	/*
	 * public CandidateStatus(String testDate, int testMark, String result) {
	 * this.TestDate = testDate; this.TestMark = testMark; this.Result = result; }
	 */

	public int getCandidatestatusid() {
		return candidatestatusid;
	}

	public void setCandidatestatusid(int candidatestatusid) {
		this.candidatestatusid = candidatestatusid;
	}

	public String getTestDate() {
		return TestDate;
	}

	public void setTestDate(String testDate) {
		TestDate = testDate;
	}

	public int getTestMark() {
		return TestMark;
	}

	public void setTestMark(int testMark) {
		TestMark = testMark;
	}

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	public TestSubject getTestSubject() {
		return testSubject;
	}

	public void setTestSubject(TestSubject testSubject) {
		this.testSubject = testSubject;
	}

}
