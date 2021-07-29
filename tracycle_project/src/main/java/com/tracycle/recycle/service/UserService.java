package com.tracycle.recycle.service;

import javax.servlet.http.HttpSession;

import com.tracycle.recycle.domain.UserVO;

public interface UserService {

	void addUser(UserVO user) throws Exception;
	UserVO login(UserVO user) throws Exception;
	String getServerInfo() throws Exception;
	void logout(HttpSession session) throws Exception;
	boolean checkUserId(String userId) throws Exception;
	UserVO findByUserId(String userId) throws Exception;
	boolean updateUser(UserVO user) throws Exception;
	boolean deleteUser(String userId) throws Exception;
	
}
