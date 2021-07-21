package com.tracycle.recycle;


import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tracycle.recycle.domain.UserVO;

@SpringBootTest
public class TracycleProjectApplicationTests {

	@Test
	public static void main(String[] args) throws Exception {
		
		// 1. 설정문서 읽기...
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		// 2. SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		// 3. SqlSession
		SqlSession session = factory.openSession();
		
		// 4. 쿼리문 실행...
		UserVO user = new UserVO("1234", "1234", "짱구", "서울시 도봉구 쌍문동");
		session.insert("UserMapper.addUser", user);
		System.out.println(user);
	}
}

