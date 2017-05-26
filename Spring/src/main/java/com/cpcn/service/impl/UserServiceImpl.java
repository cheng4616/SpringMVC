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

	/**
	 * 用户登录校验
	 */
	public ProcessResult login(User user) {
		logger.debug("login check is start" + user.getUsername());

		ProcessResult result = new ProcessResult(UserConstant.USER_NOT_EXIST, "user is not exist.");
		User user1 = usermapper.selectByPrimaryKey(user.getUsername());
		// 进行判断
		if (null != user1) {
			if (user.getUsername().equals(user1.getUsername()) && user.getPassword().equals(user1.getPassword())) {
				result.setResultCode(UserConstant.OPERATE_SUCCESS);
				result.setResultMsg("login success.");
				logger.debug("login check success.");
				return result;
			} else if (user.getUsername().equals(user1.getUsername()) && !user.getPassword().equals(user1.getPassword())) {
				result.setResultCode(UserConstant.PASSWORD_ERROR);
				result.setResultMsg("password is wrong!");
				logger.debug("failed. reson:password is wrong.");
				return result;
			}
		}
		logger.debug("failed. reson: user is not exist.");
		return result;
	}

	public ProcessResult addUser(User user) {
		ProcessResult result = new ProcessResult(UserConstant.OPERATE_FAIL, "addUser failed");
		int record;
		User user1 = usermapper.selectByPrimaryKey(user.getUsername());
		if (user1 != null) {
			result.setResultCode(UserConstant.USER_EXIST);
			result.setResultMsg("user is exist");
			return result;
		} else {
			record = usermapper.insert(user);
			if (record == 1) {
				result.setResultCode(UserConstant.OPERATE_SUCCESS);
				result.setResultMsg("addUser seccessfully");
				return result;
			}
		}
		return result;
	}
}
