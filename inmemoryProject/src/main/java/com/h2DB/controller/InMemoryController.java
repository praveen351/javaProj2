package com.h2DB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.h2DB.model.CreditCardEligibility;
import com.h2DB.serviceImp.CreditCardEligibilityServiceImpl;

@Controller
public class InMemoryController {

	private CreditCardEligibilityServiceImpl service;
	
	@Autowired
	public InMemoryController(CreditCardEligibilityServiceImpl service) {
		this.service = service;
	}
	
	@RequestMapping(value="/" , method = RequestMethod.GET)
	public ModelAndView viewIndex(ModelMap model) {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("ccEligibility", new CreditCardEligibility());
		return mav;
	}

	@RequestMapping(value = "checkEligibility", method = RequestMethod.POST)
	public String sayHelloAgain(@ModelAttribute("ccEligibility") CreditCardEligibility ccreditCard) {
		
		int chkresult = service.getCreditCardEligibility(ccreditCard.getPANNumber().toUpperCase());
		if(chkresult == 1)
			return "EligiblePage";
		else if(chkresult == 0)
			return "NotEligiblePage";
		else
			return "InvalidPage";
	}

}