package com.tracycle.recycle.repository;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tracycle.recycle.domain.ResultVO;

@Repository
public class ResultDaoImpl implements ResultDao {

	private String ns = "ResultMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ResultVO getResult(int areaId, int categoryId) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("areaId", areaId);
		paramMap.put("categoryId", categoryId);
		return sqlSession.selectOne(ns + "getResult", paramMap);
	}

}
