package com.tracycle.recycle.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tracycle.recycle.domain.UserVO;

@Repository
public class UserDaoImpl implements UserDao {
	
	private String ns = "UserMapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addUser(UserVO user) throws Exception {
		sqlSession.insert(ns + "addUser", user);
	}

	@Override
	public UserVO login(UserVO user) throws Exception {
		return sqlSession.selectOne(ns + "login");
	}

	@Override
	public UserVO checkUserId(String userId) throws Exception {
		return sqlSession.selectOne(ns + "checkUserId");
	}

	@Override
	public UserVO findByUserId(String userId) throws Exception {
		return sqlSession.selectOne(ns + "findByUserId");
	}

	@Override
	public boolean updateUser(UserVO user) throws Exception {
		int update = sqlSession.update(ns + "updateUser");
		if (update > 0) return true;
		return false;
	}

	@Override
	public boolean deleteUser(String userId) throws Exception {
		int delete = sqlSession.delete(ns + "deleteUser");
		if (delete > 0) return true;
		return false;
	}

}
