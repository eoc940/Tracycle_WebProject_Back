package com.tracycle.recycle.repository;

import java.util.HashMap;
import java.util.List;

import com.tracycle.recycle.domain.CommentVO;

public interface CommentDao {

	void writeComment(CommentVO comment) throws Exception;
	boolean updateComment(CommentVO comment) throws Exception;
	boolean deleteComment(int commentId) throws Exception;
	List<CommentVO> getAllComment(int boardId) throws Exception;
	List<CommentVO> findCommentById(String userId) throws Exception;
	
	public List<CommentVO> getCommentLimitOffset(HashMap<String, Integer> map);
	public int getCommentTotalCount(int boardId)throws Exception;
}
