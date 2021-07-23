package com.tracycle.recycle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tracycle.recycle.domain.ResultVO;
import com.tracycle.recycle.service.ResultService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("result")
@CrossOrigin(origins = "*", maxAge = 6000)
@Api(tags = {"Tracycle Result Controller"})
public class ResultController {

	@Autowired
	private ResultService resultService;
	
	@ApiOperation(value="폐기물 처리 정보를 출력한다", response=ResultVO.class)
	@GetMapping("getResult")
	public ResponseEntity<ResultVO> getResult(@RequestParam int areaId,
			@RequestParam int categoryId) throws Exception {
		try {
			ResultVO result = resultService.getResult(areaId, categoryId);
			return new ResponseEntity<ResultVO>(result, HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<ResultVO>(HttpStatus.NO_CONTENT);
		}
	}
	
}
