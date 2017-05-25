package com.cpcn.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cpcn.service.UserService;
import com.cpcn.util.ProcessResult;
import com.cpcn.util.UserConstant;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource(name = "UserService")
	private UserService userService;

	private String login_success;

	@RequestMapping(value = "login")
	public ModelAndView login(String username, String password) {
		logger.debug("login is start. username:" + username + " password:" + password);
		ProcessResult result = new ProcessResult(UserConstant.OPERATE_SUCCESS, "success");
		try {
			userService.login(username, password);
		} catch (Exception e) {
			logger.error("error", e);
		}

		/* result.setResultCode(1001); */
		if (result.getResultCode() == UserConstant.OPERATE_SUCCESS) {
			return new ModelAndView("login_success");
		}
		return new ModelAndView("login_error");
	}

	public String getLogin_success() {
		return login_success;
	}

	public void setLogin_success(String login_success) {
		this.login_success = login_success;
	}

}
