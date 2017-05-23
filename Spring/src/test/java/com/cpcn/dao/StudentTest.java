package com.cpcn.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cpcn.domain.User;

public class StudentTest {

	public static void main(String[] args) {
		ApplicationContext ac = new FileSystemXmlApplicationContext("E:/workspace_liu/Spring/src/main/resources/applicationContext.xml");

		UserMapper mapper = ac.getBean(UserMapper.class);
		
		User user = mapper.selectByPrimaryKey("liuzhicheng");
		
		System.out.println();

	}

}
