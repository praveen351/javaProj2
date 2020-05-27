package com.h2DB.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.h2DB.dao.CreditCardEligibilityDao;
import com.h2DB.model.CreditCardEligibility;
import com.h2DB.service.CreditCardEligibilityService;

@Component
public class CreditCardEligibilityServiceImpl implements CreditCardEligibilityService {
	
	@Autowired
	private CreditCardEligibilityDao userDetailDao;

	public int getCreditCardEligibility(String PANNumber) {
		CreditCardEligibility credit = userDetailDao.getCreditCardEligibility(PANNumber);
		if(credit != null)
			return credit.getCreditScore()>=5.0 ? 1 : 0;
		return -1;
	}

	public void addBulkInsertData(List<CreditCardEligibility> bulkData) {
		userDetailDao.addBulkInsertData(bulkData);
	}
}
