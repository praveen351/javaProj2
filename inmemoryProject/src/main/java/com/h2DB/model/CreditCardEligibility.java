package com.h2DB.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CreditCardEligibility")
public class CreditCardEligibility {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "PANNumber")
	private String PANNumber;
	
	@Column(name = "CreditScore")
	private float CreditScore;

	public CreditCardEligibility() {
		PANNumber = "";
		CreditScore = 0.0f;
	}
	
	public CreditCardEligibility(String pANNumber, float creditScore) {
		PANNumber = pANNumber;
		CreditScore = creditScore;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPANNumber() {
		return PANNumber;
	}

	public void setPANNumber(String pANNumber) {
		PANNumber = pANNumber;
	}

	public float getCreditScore() {
		return CreditScore;
	}

	public void setCreditScore(float creditScore) {
		CreditScore = creditScore;
	}

	
}
