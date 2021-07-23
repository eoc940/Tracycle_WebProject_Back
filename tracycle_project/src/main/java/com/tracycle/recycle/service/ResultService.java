package com.tracycle.recycle.service;

import com.tracycle.recycle.domain.ResultVO;

public interface ResultService {
	
	ResultVO getResult(int areaId, int categoryId) throws Exception;

}
