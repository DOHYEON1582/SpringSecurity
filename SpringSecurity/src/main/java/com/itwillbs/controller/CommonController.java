package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@GetMapping(value = "/accessErr")
	public void accessDenied(Authentication auth) {
		logger.info(" accessDenied() 호출");
		logger.info(" 접근권한이 없는 접근이 발생");
		
		logger.info(" auth : "+auth);
		
		
	}
	
	// 커스텀 로그인 페이지 /customLogin
	@GetMapping(value = "/customLogin")
	public void customLogin() {
		logger.info(" customLogin() 호출");
		logger.info(" 로그인 입력창 호출");
		
	}
	
	// 로그아웃 페이지
	@GetMapping(value = "customLogout")
	public void customLogout() {
		logger.info(" customLogout() 호출");
		
		
	}
	
	
	
	
	
	
	
}// controller
