package com.OAS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.OAS.daoInterface.DaoInterface;
import com.OAS.entity.TestQuestionAnswer;
import com.OAS.entity.TestSubject;
import com.OAS.entity.Users;
import com.OAS.model.QAData;
import com.OAS.model.SessionData;
import com.OAS.model.TestData;
import com.OAS.model.UserAuthenticate;
import com.OAS.serviceInterface.TestServiceImp;

@Controller
@SessionAttributes("sessionaluser")
public class InMemoryController {

	private DaoInterface dao;
	private TestServiceImp service;

	@Autowired
	public InMemoryController(DaoInterface dao, TestServiceImp service) {
		this.dao = dao;
		this.service = service;
	}

	@ModelAttribute("userAuthenticate")
	public UserAuthenticate setUpUserAuthenticate() {
		return new UserAuthenticate("", "");
	}

	@ModelAttribute("user")
	public Users setUpUsers() {
		return new Users();
	}

	@ModelAttribute("sessionaluser")
	public SessionData setUpSessionUsers() {
		return new SessionData();
	}

	@ModelAttribute("qaData")
	public QAData setUpQA() {
		return new QAData();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewIndex(@ModelAttribute("userAuthenticate") UserAuthenticate authenticate) {
		return "index";
	}

	@RequestMapping(value = "/login/do", method = RequestMethod.POST)
	public String userLogin(@ModelAttribute("userAuthenticate") UserAuthenticate authenticate,
			@ModelAttribute("sessionaluser") SessionData session) {
		if (session.getUser_id() == 0) {
			Users userData = service.doAuthenticate(authenticate);
			int status = userData.getUserid();
			if (status == -1)
				return "InvalidUserPage";
			else if (status == 0)
				return "passwordErrorPage";
			else {
				session.setUser_id(userData.getUserid());
				session.setUser_mailId(userData.getEmail());
				session.setUser_name(userData.getFirst_Name().concat(" ").concat(userData.getFirst_Name()));
				if (userData.getUser_Type().equals("candidate"))
					return "selectTest";
				else
					return "adminLoginPage";
			}
		} else {
			return "loginConfirm";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String viewHomePage(@ModelAttribute("sessionaluser") SessionData session) {
		if (session.getUser_id() != 0) {
			session.setUser_id(0);
			session.setUser_mailId(null);
			session.setUser_name(null);
			return "index";
		} else {
			return "logoutConfirm";
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewRegistration(@ModelAttribute("user") Users users,
			@ModelAttribute("sessionaluser") SessionData session) {
		if (session.getUser_id() == 0)
			return "registrationPage";
		else
			return "loginConfirm";
	}

	@RequestMapping(value = "/registration/do", method = RequestMethod.POST)
	public String viewRegistrationSuccessfull(@ModelAttribute("user") Users users,
			@ModelAttribute("sessionaluser") SessionData session, ModelMap model) {
		if (session.getUser_id() == 0) {
			Users userRegObj = service.doRegister(users);
			if (userRegObj.getUserid() != 0) {
				model.addAttribute("userName", users.getFirst_Name().concat(" ").concat(users.getLast_Name()));
				return "sampleConfirmationPage";
			}
			return "technicalissue"; // Technical issue
		} else
			return "loginConfirm";
	}

	@RequestMapping(value = "/sprinigAssessment", method = RequestMethod.GET)
	public String viewSpringAssessment(@ModelAttribute("qaData") QAData qadata,
			@ModelAttribute("sessionaluser") SessionData session, ModelMap model) {
		if (session.getUser_id() != 0) {
			TestSubject testObj = service.getQuestionAnswerOption("Spring-L1");
			List<TestQuestionAnswer> QAObject = testObj.getTestQuestionAnswerList();
			model.addAttribute("QAList", QAObject);
			return "springAssessment";
		} else {
			return "logoutConfirm";
		}
	}

	@RequestMapping(value = "/hibernateAssessment", method = RequestMethod.GET)
	public String viewHibernateAssessment(@ModelAttribute("qaData") QAData qadata,
			@ModelAttribute("sessionaluser") SessionData session, ModelMap model) {
		if (session.getUser_id() != 0) {
			TestSubject testObj = service.getQuestionAnswerOption("Hibernate-L1");
			List<TestQuestionAnswer> QAObject = testObj.getTestQuestionAnswerList();
			model.addAttribute("QAList", QAObject);
			return "hibernateAssessment";
		} else {
			return "logoutConfirm";
		}
	}

	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public String viewAllUsers(@ModelAttribute("sessionaluser") SessionData session, ModelMap model) {
		if (session.getUser_id() != 0) {
			List<Users> userList = service.doListUsers();
			model.addAttribute("userData", userList);
			return "userDetails";
		} else {
			return "logoutConfirm";
		}
	}

	@RequestMapping(value = "/testCandidate", method = RequestMethod.GET)
	public String viewAllCandidateStatus(@ModelAttribute("sessionaluser") SessionData session, ModelMap model) {
		if (session.getUser_id() != 0) {
			List<TestData> userTestList = service.doListCandidateTest();
			model.addAttribute("userTestData", userTestList);
			return "testDetail";
		} else {
			return "logoutConfirm";
		}
	}

	@RequestMapping(value = "/evaluate/spring/test", method = RequestMethod.POST)
	public String viewSubmitSpringTest(@ModelAttribute("qaData") QAData qadata,
			@ModelAttribute("sessionaluser") SessionData session, ModelMap model) {
		if (session.getUser_id() != 0) {
			int status = service.finalUpgradeData("Spring-L1", qadata.getAqData(), session.getUser_id());
			if (status == 1) {
				return "springsuccess";
			} else if (status == 0) {
				return "springFailure";
			} else {
				session.setUser_id(0);
				session.setUser_mailId(null);
				session.setUser_name(null);
				return "technicalissue";
			}
		} else
			return "logoutConfirm";
	}

	@RequestMapping(value = "/evaluate/hibernate/test", method = RequestMethod.POST)
	public String viewSubmitHibernateTest(@ModelAttribute("qaData") QAData qadata,
			@ModelAttribute("sessionaluser") SessionData session) {
		if (session.getUser_id() != 0) {
			int status = service.finalUpgradeData("Hibernate-L1", qadata.getAqData(), session.getUser_id());
			if (status == 1) {
				return "hibernatesuccess";
			} else if (status == 0) {
				return "hibernateFailure";
			} else {
				session.setUser_id(0);
				session.setUser_mailId(null);
				session.setUser_name(null);
				return "technicalissue";
			}
		} else
			return "logoutConfirm";
	}
}