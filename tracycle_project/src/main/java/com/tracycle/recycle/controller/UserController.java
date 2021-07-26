package com.tracycle.recycle.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
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

import com.tracycle.recycle.domain.UserVO;
import com.tracycle.recycle.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", maxAge = 6000)
@Api(tags = {"Tracycle User Controller"})
public class UserController {

	@Autowired
	private UserService userService;
	
	@ApiOperation(value="회원을 추가한다", response=UserVO.class)
	@PostMapping("addUser")
	public ResponseEntity<UserVO> addUser(@RequestBody UserVO user) throws Exception {
		try {
			userService.addUser(user);
			return new ResponseEntity<UserVO>(HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<UserVO>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="로그인한다", response=UserVO.class)
	@PostMapping("login")
	public ResponseEntity<UserVO> login(@RequestParam String userId, @RequestParam String password,
			HttpSession session) throws Exception {
		try {
			UserVO user = new UserVO();
			user.setUserId(userId);
			user.setPassword(password);
			UserVO loginUser = userService.login(user, session);
			return new ResponseEntity<UserVO>(loginUser, HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<UserVO>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="로그아웃한다", response=UserVO.class)
	@RequestMapping("logout")
	public ResponseEntity<UserVO> logout(HttpSession session) throws Exception {
		try {
			userService.logout(session);
			return new ResponseEntity<UserVO>(HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<UserVO>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="아이디 중복검사한다", response=UserVO.class)
	@GetMapping("checkUserId/{userId}")
	public ResponseEntity<Boolean> checkUserById(@PathVariable String userId) throws Exception {
		try {
			boolean isPossibleId = userService.checkUserId(userId);
			System.out.println(isPossibleId);
			return new ResponseEntity<Boolean>(isPossibleId, HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
	}
	
	//findByUserId
	//작성안함
	
	@ApiOperation(value="회원정보를 수정한다", response=UserVO.class)
	@PutMapping("updateUser")
	public ResponseEntity<UserVO> updateUser(@RequestBody UserVO user) throws Exception {
		try {
			boolean isUpdated = userService.updateUser(user);
			if (isUpdated) return new ResponseEntity<UserVO>(HttpStatus.OK);
			return new ResponseEntity<UserVO>(HttpStatus.NO_CONTENT);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<UserVO>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="회원을 삭제한다", response=UserVO.class)
	@DeleteMapping("deleteUser/{userId}")
	public ResponseEntity<UserVO> deleteUser(@PathVariable String userId) throws Exception {
		try {
			boolean isDeleted = userService.deleteUser(userId);
			if (isDeleted) return new ResponseEntity<UserVO>(HttpStatus.OK);
			return new ResponseEntity<UserVO>(HttpStatus.NO_CONTENT);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<UserVO>(HttpStatus.NO_CONTENT);
		}
		
	}
	
}
