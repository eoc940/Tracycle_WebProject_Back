package com.tracycle.recycle.repository;

import com.tracycle.recycle.domain.ResultVO;

public interface ResultDao {
	
	ResultVO getResult(int areaId, int categoryId) throws Exception;
	
}
