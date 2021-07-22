package com.tracycle.recycle.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tracycle.recycle.domain.BoardVO;
import com.tracycle.recycle.domain.FileVO;
import com.tracycle.recycle.service.BoardService;
import com.tracycle.recycle.util.MD5Generator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("board")
@CrossOrigin(origins = "*", maxAge = 6000)
@Api(tags = {"Tracycle User Controller"})
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@ApiOperation(value="게시글을 작성한다", response=BoardVO.class)
	@PostMapping("writeBoard")
	public ResponseEntity<BoardVO> writeBoard(@RequestBody BoardVO board, 
			@RequestParam("mainFile") MultipartFile mainFile, 
			@RequestParam("file") List<MultipartFile> files ) throws Exception{
		
		try {
			String origMainFileName = mainFile.getOriginalFilename();
			String mainFileName = new MD5Generator(origMainFileName).toString();
			String savePath = System.getProperty("user.dir") + "\\files";
			if(!new File(savePath).exists()) {
				try {
					new File(savePath).mkdir();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			String filePath = savePath + "\\" + mainFileName;
			mainFile.transferTo(new File(filePath));
			board.setPicture(origMainFileName);
			boardService.writeBoard(board);
			//mFile mainFile
			FileVO mFile = new FileVO();
			mFile.setBoard(board);
			mFile.setFileName(mainFileName);
			mFile.setFilePath(filePath);
			mFile.setOriginalFileName(origMainFileName);
			boardService.addFile(mFile);
			
			for(MultipartFile file : files) {
				String origFileName = file.getOriginalFilename();
				String fileName = new MD5Generator(origFileName).toString();
				String path = System.getProperty("user.dir") +"\\files";
				if (!new File(path).exists()) {
					try {
						new File(path).mkdir();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				filePath = path + "\\" + fileName;
				file.transferTo(new File(filePath));
				//sFile subFile
				FileVO sFile = new FileVO();
				sFile.setBoard(board);
				sFile.setOriginalFileName(origFileName);
				sFile.setFileName(fileName);
				sFile.setFilePath(filePath);
				boardService.addFile(sFile);
			}
			return new ResponseEntity<BoardVO>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<BoardVO>(HttpStatus.NO_CONTENT);
		} 
	}
	
	@ApiOperation(value="게시글을 수정한다", response=BoardVO.class)
	@PostMapping("updateBoard")
	public ResponseEntity<BoardVO> updateBoard(@RequestBody BoardVO board) throws Exception{
		try {
			boolean isUpdated = boardService.updateBoard(board);
			if (isUpdated) return new ResponseEntity<BoardVO>(HttpStatus.OK);
			return new ResponseEntity<BoardVO>(HttpStatus.NO_CONTENT);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<BoardVO>(HttpStatus.NO_CONTENT);
		}
	}
	/*
	 * 
	 
	@ApiOperation(value="게시글을 삭제한다", response=BoardVO.class)
	@PostMapping("deleteBoard/{boardId}")
	public ResponseEntity<BoardVO> deleteBoard(@PathVariable int boardId) throws Exception {
		try {
			boolean isDeleted = boardService.deleteBoard(boardId);
			
		}
	}*/
	
	
}
