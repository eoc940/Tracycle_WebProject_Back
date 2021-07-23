package com.tracycle.recycle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracycle.recycle.domain.BoardVO;
import com.tracycle.recycle.domain.FileVO;
import com.tracycle.recycle.repository.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public void writeBoard(BoardVO board) throws Exception {
		boardDao.writeBoard(board);
	}

	@Override
	public boolean updateBoard(BoardVO board) throws Exception {
		return boardDao.updateBoard(board);
	}

	@Override
	public boolean deleteBoard(int boardId) throws Exception {
		return boardDao.deleteBoard(boardId);
	}

	@Override
	public List<BoardVO> getAllBoard() throws Exception {
		return boardDao.getAllBoard();
	}

	@Override
	public List<BoardVO> findByTitle(String title) throws Exception {
		return boardDao.findByTitle(title);
	}

	@Override
	public List<BoardVO> findById(String userId) throws Exception {
		return boardDao.findById(userId);
	}

	@Override
	public List<BoardVO> findByContent(String content) throws Exception {
		return boardDao.findByContent(content);
	}

	@Override
	public List<BoardVO> findByArea(int areaId) throws Exception {
		return boardDao.findByArea(areaId);
	}

	@Override
	public List<BoardVO> findByCategory(int categoryId) throws Exception {
		return boardDao.findByCategory(categoryId);
	}

	@Override
	public List<BoardVO> findByStatus(int status) throws Exception {
		return boardDao.findByStatus(status);
	}

	@Override
	public void addViewCount(int boardId) throws Exception {
		boardDao.addViewCount(boardId);
	}

	@Override
	public void addFile(FileVO file) throws Exception {
		boardDao.addFile(file);
	}

	@Override
	public BoardVO getBoard(int boardId) throws Exception {
		return boardDao.getBoard(boardId);
	}

	@Override
	public List<FileVO> getFiles(int boardId) throws Exception {
		return boardDao.getFiles(boardId);
	}

}
