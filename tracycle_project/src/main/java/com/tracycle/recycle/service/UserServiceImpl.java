package com.tracycle.recycle.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracycle.recycle.domain.UserVO;
import com.tracycle.recycle.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public void addUser(UserVO user) throws Exception {
		userDao.addUser(user);
	}

	@Override
	public UserVO login(UserVO user, HttpSession session) throws Exception {
		session.setAttribute("user", user);
		return userDao.login(user);
	}
	
	@Override
	public void logout(HttpSession session) throws Exception {
		session.removeAttribute("user");
	}

	@Override
	public boolean checkUserId(String userId) throws Exception {
		System.out.println(userId);
		UserVO checkedUser = userDao.checkUserId(userId);
		System.out.println(checkedUser);
		if (checkedUser == null) return true;
		else return false;
	}

	@Override
	public UserVO findByUserId(String userId) throws Exception {
		return userDao.findByUserId(userId);
	}

	@Override
	public boolean updateUser(UserVO user) throws Exception {
		return userDao.updateUser(user);
	}

	@Override
	public boolean deleteUser(String userId) throws Exception {
		return userDao.deleteUser(userId);
	}

	
	
}
