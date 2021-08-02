package com.tracycle.recycle.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
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

import com.tracycle.recycle.domain.AreaVO;
import com.tracycle.recycle.domain.BoardVO;
import com.tracycle.recycle.domain.CategoryVO;
import com.tracycle.recycle.domain.CommentVO;
import com.tracycle.recycle.domain.FileVO;
import com.tracycle.recycle.domain.UserVO;
import com.tracycle.recycle.service.BoardService;
import com.tracycle.recycle.service.CommentService;
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
	
	@Autowired
	private CommentService commentService;
	
	@ApiOperation(value="게시글을 작성한다", response=BoardVO.class)
	@PostMapping("writeBoard")
	public ResponseEntity<BoardVO> writeBoard(BoardVO board,
			@RequestParam("userId") String userId,
			@RequestParam("areaId") int areaId,
			@RequestParam("categoryId") int categoryId,
			@RequestParam("mainFile") MultipartFile mainFile, 
			@RequestParam("file") List<MultipartFile> files ) throws Exception{
		
		try {
			System.out.println(board);
			System.out.println(userId + areaId + categoryId);
			board.setUser(new UserVO(userId));
			board.setArea(new AreaVO(areaId));
			board.setCategory(new CategoryVO(categoryId));
			System.out.println(board);
			System.out.println(mainFile);
			System.out.println(files);
			
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
			board.setPicture(mainFileName);
			boardService.writeBoard(board);
			System.out.println("!@#@!"+board);
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
	public ResponseEntity<BoardVO> updateBoard(@RequestBody BoardVO board,
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
			boolean isUpdated = boardService.updateBoard(board);
			System.out.println("updated 되었나? " + isUpdated);
			boardService.deleteFiles(board.getBoardId());
//			if (isUpdated) return new ResponseEntity<BoardVO>(HttpStatus.OK);
//			return new ResponseEntity<BoardVO>(HttpStatus.NO_CONTENT);
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
	public ResponseEntity<List<BoardVO>> getAllBoard(HttpServletRequest request) throws Exception {
		try {
			System.out.println("게시글리스트 인증 토큰 : " + request.getHeader("jwt-auth-token"));
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
	@GetMapping("findByContent/{content}")
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
	
	@ApiOperation(value="상태로 게시물을 검색한다", response=List.class)
	@GetMapping("findByStatus/{status}")
	public ResponseEntity<List<BoardVO>> findByStatus(@PathVariable int status) throws Exception {
		try {
			List<BoardVO> boardList = boardService.findByStatus(status);
			return new ResponseEntity<List<BoardVO>>(boardList, HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<List<BoardVO>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="조회수를 1 추가한다", response=BoardVO.class)
	@PutMapping("addViewCount/{boardId}")
	public ResponseEntity<BoardVO> addViewCount(@PathVariable int boardId) throws Exception {
		try {
			boardService.addViewCount(boardId);
			return new ResponseEntity<BoardVO>(HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<BoardVO>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="게시글 상세정보", response=BoardVO.class)
	@GetMapping("getBoard/{boardId}")
	public ResponseEntity<BoardVO> getBoard(@PathVariable int boardId) throws Exception {
		try {
			BoardVO board = boardService.getBoard(boardId);
			return new ResponseEntity<BoardVO>(board, HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<BoardVO>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="게시글의 댓글 리스트", response=List.class)
	@GetMapping("getComments/{boardId}")
	public ResponseEntity<List<CommentVO>> getComments(@PathVariable int boardId) throws Exception {
		try {
			List<CommentVO> commentList = commentService.getAllComment(boardId);
			return new ResponseEntity<List<CommentVO>>(commentList, HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<List<CommentVO>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="게시글의 사진 파일들 출력", response=List.class)
	@GetMapping("getFiles/{boardId}")
	public ResponseEntity<List<byte[]>> getFiles(@PathVariable int boardId) throws Exception {
		try {
			List<FileVO> fileList = boardService.getFiles(boardId);
			List<byte[]> imageList = new ArrayList<byte[]>();
			for(FileVO file : fileList) {
				InputStream in = getClass().getResourceAsStream(file.getFilePath());
				byte[] byteArray = IOUtils.toByteArray(in);
				imageList.add(byteArray);
			}
			return new ResponseEntity<List<byte[]>>(imageList, HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<List<byte[]>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="전체 지역 출력", response=List.class)
	@GetMapping("getAllArea")
	public ResponseEntity<List<AreaVO>> getAllArea() throws Exception {
		try {
			List<AreaVO> areaList = boardService.getAllArea();
			return new ResponseEntity<List<AreaVO>>(areaList, HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<List<AreaVO>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="전체 폐기물 목록 출력", response=List.class)
	@GetMapping("getAllCategory")
	public ResponseEntity<List<CategoryVO>> getAllCategory() throws Exception {
		try {
			List<CategoryVO> categoryList = boardService.getAllCategory();
			return new ResponseEntity<List<CategoryVO>>(categoryList, HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<List<CategoryVO>>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	
	
	
}
