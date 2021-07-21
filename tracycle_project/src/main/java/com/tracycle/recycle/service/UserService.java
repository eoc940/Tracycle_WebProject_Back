package com.tracycle.recycle.service;

import com.tracycle.recycle.model.UserVO;

public interface UserService {

	void addUser(UserVO user) throws Exception;
	UserVO login(UserVO user) throws Exception;
	boolean checkUserId(String userId) throws Exception;
	UserVO findByUserId(String userId) throws Exception;
	boolean updateUser(UserVO user) throws Exception;
	boolean deleteUser(String userId) throws Exception;
	
}
