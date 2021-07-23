package com.tracycle.recycle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracycle.recycle.domain.ResultVO;
import com.tracycle.recycle.repository.ResultDao;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultDao resultDao;
	
	@Override
	public ResultVO getResult(int areaId, int categoryId) throws Exception {
		return resultDao.getResult(areaId, categoryId);
	}

}
