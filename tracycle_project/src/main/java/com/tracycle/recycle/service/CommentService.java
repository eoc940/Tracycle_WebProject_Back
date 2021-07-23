package com.tracycle.recycle.service;

import java.util.List;

import com.tracycle.recycle.domain.CommentVO;

public interface CommentService {
	
	void writeComment(CommentVO comment) throws Exception;
	boolean updateComment(CommentVO comment) throws Exception;
	boolean deleteComment(int commentId) throws Exception;
	List<CommentVO> getAllComment(int boardId) throws Exception;
	List<CommentVO> findCommentById(String userId) throws Exception;

}
