package com.tracycle.recycle.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tracycle.recycle.domain.AreaVO;
import com.tracycle.recycle.domain.BoardVO;
import com.tracycle.recycle.domain.CategoryVO;
import com.tracycle.recycle.domain.FileVO;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	private String ns = "BoardMapper.";

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void writeBoard(BoardVO board)  throws Exception{
		sqlSession.insert(ns + "writeBoard", board);

	}

	@Override
	public boolean updateBoard(BoardVO board)  throws Exception{
		int updated = sqlSession.update(ns + "updateBoard", board);
		if (updated > 0) return true;
		return false;
	}

	@Override
	public boolean deleteBoard(int boardId)  throws Exception{
		int deleted = sqlSession.delete(ns + "deleteBoard", boardId);
		if (deleted > 0) return true;
		return false;
	}

	@Override
	public List<BoardVO> getAllBoard()  throws Exception{
		return sqlSession.selectList(ns + "getAllBoard");
	}

	@Override
	public List<BoardVO> findByTitle(String title)  throws Exception{
		return sqlSession.selectList(ns + "findByTitle", title);
	}

	@Override
	public List<BoardVO> findById(String userId)  throws Exception{
		return sqlSession.selectList(ns + "findById", userId);
	}

	@Override
	public List<BoardVO> findByContent(String content)  throws Exception{
		return sqlSession.selectList(ns + "findByContent", content);
	}

	@Override
	public List<BoardVO> findByArea(int areaId)  throws Exception{
		return sqlSession.selectList(ns + "findByArea", areaId);
	}

	@Override
	public List<BoardVO> findByCategory(int categoryId)  throws Exception{
		return sqlSession.selectList(ns + "findByCategory", categoryId);
	}

	@Override
	public List<BoardVO> findByStatus(int status)  throws Exception{
		return sqlSession.selectList(ns + "findByStatus", status);
	}

	@Override
	public void addViewCount(int boardId)  throws Exception{
		sqlSession.update(ns + "addViewCount", boardId);
	}
	
	@Override
	public void deleteFiles(int boardId) throws Exception {
		sqlSession.delete(ns + "deleteFiles", boardId);
	}

	@Override
	public void addFile(FileVO file) throws Exception {
		sqlSession.insert(ns + "addFile", file);
	}

	@Override
	public BoardVO getBoard(int boardId) throws Exception {
		return sqlSession.selectOne(ns + "getBoard", boardId);
	}

	@Override
	public List<FileVO> getFiles(int boardId) throws Exception {
		return sqlSession.selectList(ns + "getFiles", boardId);
	}

	@Override
	public List<AreaVO> getAllArea() throws Exception {
		return sqlSession.selectList(ns + "getAllArea");
	}

	@Override
	public List<CategoryVO> getAllCategory() throws Exception {
		return sqlSession.selectList(ns + "getAllCategory");
	}

	@Override
	public FileVO getMainFile(String fileName) throws Exception {
		return sqlSession.selectOne(ns + "getMainFile", fileName);
	}

	@Override
	public List<BoardVO> getBoardLimitOffset(int offset) {
		return sqlSession.selectList(ns + "getBoardLimitOffset",offset);
	}

	@Override
	public int getBoardTotalCount() {
		return sqlSession.selectOne(ns + "getBoardTotalCount");
	}

	

}
