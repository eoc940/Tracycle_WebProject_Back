package com.tracycle.recycle.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@Api(tags = {"Tracycle Board Controller"})
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
	@PutMapping("updateBoard")
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
	
	 
	@ApiOperation(value="게시글을 삭제한다", response=BoardVO.class)
	@DeleteMapping("deleteBoard/{boardId}")
	public ResponseEntity<BoardVO> deleteBoard(@PathVariable int boardId) throws Exception {
		try {
			boolean isDeleted = boardService.deleteBoard(boardId);
			if (isDeleted) return new ResponseEntity<BoardVO>(HttpStatus.OK);
			return new ResponseEntity<BoardVO>(HttpStatus.NO_CONTENT);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<BoardVO>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="모든 게시물을 출력한다", response=List.class)
	@GetMapping("getAllBoard")
	public ResponseEntity<List<BoardVO>> getAllBoard() throws Exception {
		try {
			List<BoardVO> boardList = boardService.getAllBoard();
			return new ResponseEntity<List<BoardVO>>(boardList, HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<List<BoardVO>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="제목으로 게시물을 검색한다", response=List.class)
	@GetMapping("findByTitle/{title}")
	public ResponseEntity<List<BoardVO>> findByTitle(@PathVariable String title) throws Exception {
		try {
			List<BoardVO> boardList = boardService.findByTitle(title);
			return new ResponseEntity<List<BoardVO>>(boardList, HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<List<BoardVO>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="아이디로 게시물을 검색한다", response=List.class)
	@GetMapping("findById/{userId}")
	public ResponseEntity<List<BoardVO>> findById(@PathVariable String userId) throws Exception {
		try {
			List<BoardVO> boardList = boardService.findById(userId);
			return new ResponseEntity<List<BoardVO>>(boardList, HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<List<BoardVO>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="내용으로 게시물을 검색한다", response=List.class)
	@GetMapping("findById/{content}")
	public ResponseEntity<List<BoardVO>> findByContent(@PathVariable String content) throws Exception {
		try {
			List<BoardVO> boardList = boardService.findByContent(content);
			return new ResponseEntity<List<BoardVO>>(boardList, HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<List<BoardVO>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="지역으로 게시물을 검색한다", response=List.class)
	@GetMapping("findByArea/{areaId}")
	public ResponseEntity<List<BoardVO>> findByArea(@PathVariable int areaId) throws Exception {
		try {
			List<BoardVO> boardList = boardService.findByArea(areaId);
			return new ResponseEntity<List<BoardVO>>(boardList, HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<List<BoardVO>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="품목으로 게시물을 검색한다", response=List.class)
	@GetMapping("findByCategory/{categoryId}")
	public ResponseEntity<List<BoardVO>> findByCategory(@PathVariable int categoryId) throws Exception {
		try {
			List<BoardVO> boardList = boardService.findByCategory(categoryId);
			return new ResponseEntity<List<BoardVO>>(boardList, HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<List<BoardVO>>(HttpStatus.NO_CONTENT);
		}
	}
	
	
}