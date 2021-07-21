package com.tracycle.recycle;


import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tracycle.recycle.domain.UserVO;

public class testClass {
	public static void main(String[] args) throws Exception {
		
		// 1. 설정문서 읽기...
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		// 2. SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		// 3. SqlSession
		SqlSession session = factory.openSession();
		
		// 4. 쿼리문 실행...
//		UserVO user = new UserVO("4321", "4321", "짱구씨", "서울시 강남구 대치동");
//		session.insert("UserMapper.addUser", user);
//		session.commit();
//		
		
//		UserVO user = session.selectOne("UserMapper.checkUserId", "1234");
//		System.out.println(user);
		
//		UserVO user = session.selectOne("UserMapper.findByUserId", "1234");
//		System.out.println(user);
		
//		UserVO user = new UserVO();
//		user.setUserId("1234");
//		user.setAddress("서울시 강남구 대치동");
//		user.setNickName("짱구아빠");
//				
//		session.update("UserMapper.updateUser", user);
//		session.commit();
				
//		UserVO user = new UserVO();
//		user.setUserId("4321");
//		
//		session.delete("UserMapper.deleteUser", user);
//		session.commit();
		
//		UserVO user = new UserVO("1234", "1234");
//		UserVO selectd =  session.selectOne("UserMapper.login", user);
//		System.out.println(selectd);
//		
	}
}
