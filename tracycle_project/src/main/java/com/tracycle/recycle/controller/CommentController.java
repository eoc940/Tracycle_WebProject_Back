package com.tracycle.recycle.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RestController;

import com.tracycle.recycle.domain.BoardVO;
import com.tracycle.recycle.domain.CommentVO;
import com.tracycle.recycle.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("comment")
@CrossOrigin(origins = "*", maxAge = 6000)
@Api(tags = {"Tracycle Comment Controller"})
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@ApiOperation(value="댓글을 작성한다", response=CommentVO.class)
	@PostMapping("writeComment")
	public ResponseEntity<CommentVO> writeComment(@RequestBody CommentVO comment) throws Exception{
		try {
			commentService.writeComment(comment);
			return new ResponseEntity<CommentVO>(HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<CommentVO>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="댓글을 수정한다", response=CommentVO.class)
	@PutMapping("updateComment")
	public ResponseEntity<CommentVO> updateComment(@RequestBody CommentVO comment) throws Exception {
		try {
			boolean isUpdated = commentService.updateComment(comment);
			if (isUpdated) return new ResponseEntity<CommentVO>(HttpStatus.OK);
			return new ResponseEntity<CommentVO>(HttpStatus.NO_CONTENT);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<CommentVO>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="댓글을 삭제한다", response=CommentVO.class)
	@DeleteMapping("deleteComment/{commentId}")
	public ResponseEntity<CommentVO> deleteComment(@PathVariable int commentId) throws Exception {
		try {
			boolean isDeleted = commentService.deleteComment(commentId);
			if (isDeleted) return new ResponseEntity<CommentVO>(HttpStatus.OK);
			return new ResponseEntity<CommentVO>(HttpStatus.NO_CONTENT);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<CommentVO>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="모든 댓글을 출력한다", response=List.class)
	@GetMapping("getAllComment/{boardId}")
	public ResponseEntity<List<CommentVO>> getAllComment(@PathVariable int boardId) throws Exception {
		try {
			List<CommentVO> commentList = commentService.getAllComment(boardId);
			return new ResponseEntity<List<CommentVO>>(commentList, HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<List<CommentVO>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="사용자가 작성한 모든 댓글을 출력한다", response=List.class)
	@GetMapping("findCommentById/{userId}")
	public ResponseEntity<List<CommentVO>> findCommentById(@PathVariable String userId) throws Exception {
		try {
			List<CommentVO> commentList = commentService.findCommentById(userId);
			return new ResponseEntity<List<CommentVO>>(commentList, HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<List<CommentVO>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="limit offset 에 해당하는 댓글 출력한다", response=List.class)
	@GetMapping("getCommentLimitOffset/{boardId}/{offset}")
	public ResponseEntity<List<CommentVO>> getBoardLimitOffset(@PathVariable int boardId, @PathVariable int offset) throws Exception {
		try {
			HashMap<String, Integer> map = new HashMap<String, Integer>(); 
			map.put("boardId", boardId);
			map.put("offset", offset);
			List<CommentVO> commentList = commentService.getCommentLimitOffset(map);
			return new ResponseEntity<List<CommentVO>>(commentList, HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<List<CommentVO>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="전체 댓글 수 출력", response=List.class)
	@GetMapping("getCommentTotalCount/{boardId}")
	public ResponseEntity<Integer>  getCommentTotalCount(@PathVariable int boardId) throws Exception {
		try {
			int totalCount= commentService.getCommentTotalCount(boardId);
			return new ResponseEntity<Integer> (totalCount, HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
		}
	}
	
}
