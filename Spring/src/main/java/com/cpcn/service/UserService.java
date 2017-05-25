package com.cpcn.service;

import com.cpcn.util.ProcessResult;

/**
 * 用户服务接口
 * 
 * @author liuzhicheng
 *
 */
public interface UserService {

	public ProcessResult login(String username, String password);

}
