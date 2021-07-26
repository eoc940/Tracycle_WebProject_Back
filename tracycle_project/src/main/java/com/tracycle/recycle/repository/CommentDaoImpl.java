package com.tracycle.recycle.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tracycle.recycle.domain.CommentVO;

@Repository
public class CommentDaoImpl implements CommentDao {

	private String ns = "CommentMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void writeComment(CommentVO comment) throws Exception {
		sqlSession.insert(ns + "writeComment", comment);

	}

	@Override
	public boolean updateComment(CommentVO comment) throws Exception {
		int updated = sqlSession.update(ns + "updateComment", comment);
		System.out.println(updated + " DAO!!");
		if (updated > 0) return true;
		return false;
	}

	@Override
	public boolean deleteComment(int commentId) throws Exception {
		int deleted = sqlSession.delete(ns + "deleteComment", commentId);
		if (deleted > 0) return true;
		return false;
	}

	@Override
	public List<CommentVO> getAllComment(int boardId) throws Exception {
		return sqlSession.selectList(ns + "getAllComment", boardId);
	}

	@Override
	public List<CommentVO> findCommentById(String userId) throws Exception {
		return sqlSession.selectList(ns + "findCommentById", userId);
	}

}
