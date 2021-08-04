package com.tracycle.recycle.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracycle.recycle.domain.CommentVO;
import com.tracycle.recycle.repository.CommentDao;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao commentDao;

	@Override
	public void writeComment(CommentVO comment) throws Exception {
		commentDao.writeComment(comment);
	}

	@Override
	public boolean updateComment(CommentVO comment) throws Exception {
		return commentDao.updateComment(comment);
	}

	@Override
	public boolean deleteComment(int commentId) throws Exception {
		return commentDao.deleteComment(commentId);
	}

	@Override
	public List<CommentVO> getAllComment(int boardId) throws Exception {
		return commentDao.getAllComment(boardId);
	}

	@Override
	public List<CommentVO> findCommentById(String userId) throws Exception {
		return commentDao.findCommentById(userId);
	}

	@Override
	public int getCommentTotalCount(int boardId) throws Exception {
		return commentDao.getCommentTotalCount(boardId);
	}

	@Override
	public List<CommentVO> getCommentLimitOffset(HashMap<String, Integer> map) {
		return commentDao.getCommentLimitOffset(map);
	}

}
