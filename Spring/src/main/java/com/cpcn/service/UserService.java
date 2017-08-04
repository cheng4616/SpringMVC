package com.cpcn.service;

import com.cpcn.domain.User;
import com.cpcn.util.ProcessResult;

/**
 * 用户服务接口
 * 
 * @author liuzhicheng
 *
 */
public interface UserService {

	/**
	 * 用户登录校验
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
    public ProcessResult login(User user);

	/**
	 * 注册用户
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public ProcessResult addUser(User user);
}
