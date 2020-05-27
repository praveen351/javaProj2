package com.h2DB.service;

import java.util.List;

import com.h2DB.model.CreditCardEligibility;

public interface CreditCardEligibilityService {
	public int getCreditCardEligibility(String PANNumber);
	public void addBulkInsertData(List<CreditCardEligibility> bulkData);
}
