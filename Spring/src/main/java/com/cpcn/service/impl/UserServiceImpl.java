package com.cpcn.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cpcn.dao.UserMapper;
import com.cpcn.domain.User;
import com.cpcn.service.UserService;
import com.cpcn.util.ProcessResult;
import com.cpcn.util.UserConstant;

/**
 * 用户服务实现类
 * 
 * @author liuzhicheng
 *
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Resource
	private UserMapper usermapper;

	public ProcessResult login(String username, String password) {
		logger.debug("loginService is start" + username);

		ProcessResult result = new ProcessResult(UserConstant.USER_NOT_EXIST, "user is not exist.");
		User user = usermapper.selectByPrimaryKey(username);
		// 进行判断
		if (null != user) {
			if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
				result.setResultCode(UserConstant.OPERATE_SUCCESS);
				result.setResultMsg("login success.");
				return result;
			} else if (username.equals(user.getUsername()) && !password.equals(user.getPassword())) {
				result.setResultCode(UserConstant.PASSWORD_ERROR);
				result.setResultMsg("password is wrong!");
				return result;
			}
		}
		logger.debug("loginService is end.");
		return result;
	}
}
