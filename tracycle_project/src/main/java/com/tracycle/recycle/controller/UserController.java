package com.tracycle.recycle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.tracycle.recycle.util.JwtService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", maxAge = 6000)
@Api(tags = {"Tracycle User Controller"})
@Slf4j
public class UserController {
	
	@Autowired
	private JwtService jwtService;

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
	
	@ApiOperation(value="로그인한다", response=HashMap.class)
	@PostMapping("login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody UserVO user, HttpServletResponse response) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			UserVO loginUser = userService.login(user);
			System.out.println(user);
//			if(user.getNickName() != null) {
				//로그인 성공하면 토큰을 생성
				String token = jwtService.create(loginUser);
				//토큰 정보는 request의 헤더로 보내고 나머지는 Map에 담아주자
				response.setHeader("jwt-auth-token", token);
				// resultMap.put("auth_token", token);
//			}
			resultMap.put("status", true);
			resultMap.put("data", loginUser);
			status = HttpStatus.ACCEPTED;
		} catch(RuntimeException e) {
			log.error("로그인 실패", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
		
//		try {
//			System.out.println(user);
//			UserVO loginUser = userService.login(user);
//			System.out.println(loginUser);
//			if (loginUser != null) 
//				return new ResponseEntity<UserVO>(loginUser, HttpStatus.OK);
//			return new ResponseEntity<UserVO>(HttpStatus.NO_CONTENT); 
//		}catch(RuntimeException e) {
//			e.printStackTrace();
//			return new ResponseEntity<UserVO>(HttpStatus.NO_CONTENT);
//		}
	}
	
	@ApiOperation(value="서버 정보를 확인한다", response=HashMap.class)
	@PostMapping("info")
	public ResponseEntity<Map<String, Object>> getInfo(HttpServletRequest request, @RequestBody UserVO user) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		HttpStatus status = null;
		try {
			// 사용자에게 전달할 정보이다
			String info = userService.getServerInfo();
			// 보너스로 토큰에 담긴 정보도 전달해보자. 서버에서 토큰을 사용하는 방법임을 알 수 있다
			resultMap.putAll(jwtService.get(request.getHeader("jwt-auth-token")));
			resultMap.put("status", true);
			resultMap.put("info", info);
			resultMap.put("request_body", user);
			status = HttpStatus.ACCEPTED;
		} catch(RuntimeException e) {
			log.error("정보조회 실패", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	
	@ApiOperation(value="로그아웃한다", response=UserVO.class)
	@GetMapping("logout")
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
