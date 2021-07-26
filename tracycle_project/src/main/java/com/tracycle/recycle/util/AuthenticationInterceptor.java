package com.tracycle.recycle.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tracycle.recycle.domain.UserVO;


@Component
public class AuthenticationInterceptor implements HandlerInterceptor{

	Logger log = LoggerFactory.getLogger(AuthenticationInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		HttpSession httpSession = request.getSession();
		UserVO user = (UserVO)httpSession.getAttribute("user");
		log.debug("=======START=======");
		log.debug("Request URI : " + request.getRequestURI());
		if (user == null) {
			log.info("로그아웃 상태");
			throw new Exception("로그인 해주세요");
		}
		log.info("로그인 되어있음");
		httpSession.setMaxInactiveInterval(60*60);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		
		log.info("postHandle");
		log.debug("=======END=======");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) throws Exception {
		log.info("afterCompletion");
		
	}
	
	
	
	
}
