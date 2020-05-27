package com.h2DB.dao;

import java.util.List;

import com.h2DB.model.CreditCardEligibility;

public interface CreditCardEligibilityDao {
	public CreditCardEligibility getCreditCardEligibility(String PANNumber);
	public void addBulkInsertData(List<CreditCardEligibility> bulkData);
}
