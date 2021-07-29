package com.tracycle.recycle.util;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.tracycle.recycle.domain.UserVO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtService {
	
	@Value("${jwt.salt}")
	private String salt;
	
	@Value("${jwt.expmin}")
	private Long expireMin;
	
	public String create(final UserVO user) {
		log.trace("time:{}", expireMin);
		final JwtBuilder builder = Jwts.builder();
		// JWT Token = Header + Payload + Signature
		// Header 설정
		builder.setHeaderParam("typ", "JWT");//토큰의 타입으로 고정 값
		
		// Payload 설정 - claim 정보 포함
		builder.setSubject("로그인토큰")//토큰 제목 설정
		.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * expireMin))
		.claim("User", user).claim("second", "더 담을거?");
		
		// signature - secret key를 이용한 암호화
		builder.signWith(SignatureAlgorithm.HS256, salt.getBytes());
		
		// 마지막 직렬화 처리
		final String jwt = builder.compact();
		log.debug("토큰 발행 : {}", jwt);
		return jwt;
	}
	
	public void checkValid(final String jwt) {
		// 별 문제 없었는지 즉 예외가 발생하지 않으면 OK
		log.trace("토큰 점검 : {}", jwt);
		Jwts.parser().setSigningKey(salt.getBytes()).parseClaimsJws(jwt);
	}
	
	public Map<String, Object> get(final String jwt) {
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser().setSigningKey(salt.getBytes()).parseClaimsJws(jwt);
		}catch(final Exception e) {
			throw new RuntimeException();
		}
		log.trace("claims : {}", claims);
		// Claims는 Map의 구현체이다
		return claims.getBody();
	}
	
	
}
