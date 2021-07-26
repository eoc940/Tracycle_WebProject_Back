package com.tracycle.recycle;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.io.Reader;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tracycle.recycle.domain.AreaVO;
import com.tracycle.recycle.domain.BoardVO;
import com.tracycle.recycle.domain.CategoryVO;
import com.tracycle.recycle.domain.CommentVO;
import com.tracycle.recycle.domain.FileVO;
import com.tracycle.recycle.domain.ResultVO;
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
		
		//user mapping Test..
		
		//1. addUser Test...

		
//		UserVO user = new UserVO("23Corss", "Cucu", "짱구 ", "서울시 종로구 평창동");

//		
//		UserVO user = new UserVO("2314", "qwer", "봄여름가을겨울", "서울시 동대문구 전농동");

//		session.insert("UserMapper.addUser", user);
//		session.commit();
		
		//2. checkUserId Test...
		
//		UserVO user = session.selectOne("UserMapper.checkUserId", "1234");
//		System.out.println(user);
		
		//findByUserId Test...
		
//		UserVO user = session.selectOne("UserMapper.findByUserId", "1234");
//		System.out.println(user);
		
		//3. updateUser Test...
		
//		UserVO user = new UserVO();
//		user.setUserId("1234");
//		user.setAddress("서울시 강남구 대치동");
//		user.setNickName("짱구아빠");
//				
//		session.update("UserMapper.updateUser", user);
//		session.commit();
				
		
		//4. deleteUser Test...
		
//		UserVO user = new UserVO();
//		user.setUserId("4321");
//		session.delete("UserMapper.deleteUser", user);
//		session.commit();
		
		//5. login Test...
		
//		UserVO user = new UserVO("1234", "1234");
//		UserVO selectd =  session.selectOne("UserMapper.login", user);
//		System.out.println(selectd);
//		
// ======================================================================================
		// board mapping Test...
		
		
		//1. writeBoard Test..
		
//		BoardVO board = new BoardVO();

//		board.setTitle("여름아 부탁해!!");
//		board.setContent("바다에 보내줘!!!.");
//		board.setTitle("덥다 덥다고!!");
//		board.setContent("계곡에 놀러가자.");
//		board.setDate("2021-07-23");
//		board.setPicture("img/bread");
//		board.setViewCount(0);
//		board.setStatus(0);
//		board.setUser(new UserVO("23Corss"));
//		board.setUser(new UserVO("2314"));
//		board.setArea(new AreaVO(3));
//		board.setCategory(new CategoryVO(2));
//		System.out.println(board);
//		session.insert("BoardMapper.writeBoard", board);
//		session.commit();
		
		
		//1. getAllBoard Test
		
//		List<BoardVO> list = session.selectList("BoardMapper.getAllBoard");
//		for(BoardVO vo : list) System.out.println(vo);
		
		
		//2. updateBoard Test
		
//		BoardVO board = new BoardVO();
//		board.setBoardId(1);
//		board.setTitle("휴가 가고 싶다!!");
//		board.setContent("나눔 합니다. 빨리 가져가세요!!!!!");
//		board.setDate("21-07-21");
//		board.setPicture("img/tent");
//		board.setViewCount(0);
//		board.setStatus(1);
//		board.setUser(new UserVO("1234"));
//		board.setArea(new AreaVO(2));
//		board.setCategory(new CategoryVO(5));
//		
//		session.update("BoardMapper.updateBoard", board);
//		session.commit();
		
		
		//3. deleteBoard Test
		
//		BoardVO board = new BoardVO();
//		board.setBoardId(13);
//		session.delete("BoardMapper.deleteBoard", board);
//		session.commit();
		
		
		//4. findByTitle Test
		
//		List<BoardVO> list = session.selectList("BoardMapper.findByTitle", "휴가");
//		System.out.println(list);
		
		
		//5. findById Test
		
//		List<BoardVO> list = session.selectList("BoardMapper.findById", "23");
//		System.out.println(list);

		
		//6. findByContent Test
		
//		List<BoardVO> list = session.selectList("BoardMapper.findByContent", "가세요");
//		System.out.println(list);
		

		//7. findByArea Test
		
//		List<BoardVO> list = session.selectList("BoardMapper.findByArea", 2);
//		System.out.println(list);
		

		//8. findByCategory Test
		
//		List<BoardVO> list = session.selectList("BoardMapper.findByCategory", 5);
//		System.out.println(list);
		
		
		//9. addViewCount Test
		
//		BoardVO board = new BoardVO();
//		session.update("BoardMapper.addViewCount", 5);
//		session.commit();
		
		
		//10. addFile Test
		
//		BoardVO board = new BoardVO();
//		board.setBoardId(19);
//		FileVO file = new FileVO("c", "f", "g", board);
//		session.insert("BoardMapper.addFile", file);
//		session.commit();
//		System.out.println(file);
		
		
		//11. getBoard Test
		
//		BoardVO board = session.selectOne("BoardMapper.getBoard", 18);
//		System.out.println(board);
		
		
		//12. getFiles Test
		
//		List<FileVO> list = session.selectList("BoardMapper.getFiles", 19);
//		System.out.println(list);


//     ============================================================================
		
		//  comment mapping Test
		
		
		//1. writeComment Test
		
//		BoardVO board = new BoardVO();
//		board.setBoardId(5);
//		UserVO user = new UserVO();
//		user.setUserId("23Corss");
//		CommentVO comment = new CommentVO("2021-07-23", "무플 방지 위원회 회장", 0, user, board );
//		session.insert("CommentMapper.writeComment", comment);
//		session.commit();
		
		
		//2. updateComment Test
		
//		BoardVO board = new BoardVO();
//		board.setBoardId(3);
//		UserVO user = new UserVO();
//		user.setUserId("23Corss");
//		CommentVO comment = new CommentVO(1, "2021-07-24", "리플을 수정했습니다.", 1, user, board);
//		session.update("CommentMapper.updateComment", comment);
//		session.commit();
				 
		
		//3. deleteComment Test
		
//		int row = session.delete("CommentMapper.deleteComment", 3);
//		session.commit();
//		System.out.println(row);
		
		
		//4. getAllComment
		
//		List<CommentVO> list = session.selectList("CommentMapper.getAllComment", 5);
//		System.out.println(list);
		
		//5. findCommentById
		
//		List<CommentVO> list = session.selectList("CommentMapper.findCommentById", "23Corss");
//		System.out.println(list);
		

// ===============================================================================================
		
		
		//result mapping Test
		
		//1. getResult
		
//		HashMap<String, Object> map  = new HashMap<String, Object>();
//		map.put("areaId", 1);
//		map.put("categoryId", 1);
//		ResultVO result = session.selectOne("ResultMapper.getResult", map);
//		System.out.println(result);

		
	}
}