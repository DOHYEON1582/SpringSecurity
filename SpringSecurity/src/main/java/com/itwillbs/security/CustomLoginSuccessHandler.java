package com.itwillbs.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{
	
	private static final Logger logger = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		logger.info(" onAuthenticationSuccess() 호출 ");
		logger.info(" 인증성공(로그인 성공,토큰정보O) 후 처리 수행 ");
		
		// 권한정보를 저장하는 리스트
		List<String> roleNames = new ArrayList<String>();
		
		// 이클립스 기능 : 익명클래스 -> 람다 표현식 해당영역 블럭 + ctrl + 1
//		auth.getAuthorities().forEach(new Consumer<GrantedAuthority>() {
//			@Override
//			public void accept(GrantedAuthority authority) {
//				roleNames.add(authority.getAuthority());
//			}
//		});
		
		auth.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
		
	
		
		
		logger.info(" roleNames : "+roleNames);
		
		
		
	}
	
	
	
	
}
