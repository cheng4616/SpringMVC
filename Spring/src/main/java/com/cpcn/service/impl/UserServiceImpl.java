package com.cpcn.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cpcn.dao.UserMapper;
import com.cpcn.domain.User;
import com.cpcn.service.UserService;

/**
 * 用户服务实现类
 * 
 * @author liuzhicheng
 *
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private UserMapper usermapper;

	public boolean login(String username, String password) {
		logger.debug("login is start" + username);
		User user = usermapper.selectByPrimaryKey(username);
		// 进行判断
		if (null != user) {
			if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
