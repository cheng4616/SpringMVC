package com.cpcn.dao;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cpcn.service.UserService;
import com.cpcn.service.impl.UserServiceImpl;
import com.cpcn.util.ProcessResult;

public class StudentTest {
	@Resource
	private static UserService userService;

	public static void main(String[] args) {


		ApplicationContext ac = new FileSystemXmlApplicationContext("E:/workspace_liu/Spring/src/main/resources/applicationContext.xml");

		userService = ac.getBean(UserServiceImpl.class);

		ProcessResult result = userService.login("liuzhicheng", "123456");

		System.out.println(result);

	}

}
