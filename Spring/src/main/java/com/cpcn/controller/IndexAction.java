package com.cpcn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexAction implements Controller {

	private static final Logger logger = LoggerFactory.getLogger(IndexAction.class);

	private String view;

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("IndexAction handleRequest is start.");
		ModelAndView modelAndView = new ModelAndView(view);
		modelAndView.addObject("view", "hello world!");
		logger.debug("IndexAction handleRequest is end. model:" + modelAndView);
		return modelAndView;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

}
