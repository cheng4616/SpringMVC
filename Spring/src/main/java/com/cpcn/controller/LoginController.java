package com.cpcn.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cpcn.domain.User;
import com.cpcn.service.UserService;
import com.cpcn.util.ProcessResult;
import com.cpcn.util.UserConstant;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource
	private UserService userService;

	@RequestMapping(value = "ForwardLogin")
	public String forward(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		return "login";
	}

	@RequestMapping(value = "register")
	public String register() {
		return "register";
	}

	@RequestMapping(value = "login")
	public ModelAndView login(String username, String password) {
		logger.debug("login is start. username:" + username + " password:" + password);
		ProcessResult result = new ProcessResult(UserConstant.OPERATE_FAIL, "fail");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		try {
			result = userService.login(user);
		} catch (Exception e) {
			logger.error("error", e);
		}
		if (result.getResultCode() == UserConstant.OPERATE_SUCCESS) {
			return new ModelAndView("login_success", "message", result.getResultMsg());
		}
		return new ModelAndView("error", "message", result.getResultMsg());
	}

	@RequestMapping(value = "addUser")
	public ModelAndView addUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		ProcessResult result = new ProcessResult(UserConstant.OPERATE_FAIL, "fail");
		try {
			result = userService.addUser(user);
		} catch (Exception e) {
			logger.debug("addUser is error", e);
		}
		if (result.getResultCode() == UserConstant.OPERATE_SUCCESS) {
			return new ModelAndView("register_success", "message", result.getResultMsg());
		}

		return new ModelAndView("error", "message", result.getResultMsg());
	}
}
