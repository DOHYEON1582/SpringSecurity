package com.itwillbs.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{
			"file:src/main/webapp/WEB-INF/spring/root-context.xml",
			"file:src/main/webapp/WEB-INF/spring/security-context.xml"
		}
		)
public class MemberTest {

	private static final Logger logger = LoggerFactory.getLogger(MemberTest.class);
	
	// 디비 접속DataSource 객체
	@Inject
	private DataSource ds;
	// 암호화처리 PWEncoder 객체
	@Inject
	private PasswordEncoder pwEncoder;
	
	@Inject
	private MemberDAO mdao;
	
	//@Test
	public void test_회원가입() throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		for(int i = 0; i<100; i++) {
			
		// 1. 디비 연결
		con = ds.getConnection();
		// 2. sql구문 작성 & pstmt 객체
		sql = "INSERT INTO tbl_member(userid,userpw,username,useremail) VALUES(?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		// ???
		
		// 3.sql 구문 실행 - for
		// 비밀번호 암호화
		pstmt.setString(2, pwEncoder.encode("pw"+i));
		
		if(i < 80) {
			pstmt.setString(1, "user"+i);
			pstmt.setString(3, "일반사용자"+i);
			pstmt.setString(4, "user"+i+"@itwillbs.com");
		}else if(i < 90) {
			pstmt.setString(1, "manager"+i);
			pstmt.setString(3, "운영자"+i);
			pstmt.setString(4, "manager"+i+"@itwillbs.com");
		}else {
			pstmt.setString(1, "admin"+i);
			pstmt.setString(3, "관리자"+i);
			pstmt.setString(4, "admin"+i+"@itwillbs.com");
			
		}
		// 4. sql 구문 실행
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();

		}// for
		
		
	}// test
	
	//@Test
	public void test_회원인증정보_가입() throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		for(int i = 0; i<100; i++) {
			
		// 1. 디비 연결
		con = ds.getConnection();
		// 2. sql구문 작성 & pstmt 객체
		sql = "INSERT INTO tbl_member_auth(userid,auth) VALUES(?,?)";
		pstmt = con.prepareStatement(sql);
		// ???
		
		// 3.sql 구문 실행 - for
		
		if(i < 80) {
			pstmt.setString(1, "user"+i);
			pstmt.setString(2, "ROLE_USER");
		}else if(i < 90) {
			pstmt.setString(1, "manager"+i);
			pstmt.setString(2, "ROLE_MANAGER");
		}else {
			pstmt.setString(1, "admin"+i);
			pstmt.setString(2, "ROLE_ADMIN");
			
		}
		// 4. sql 구문 실행
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();

		}// for
		
		
	}// test
	
	@Test
	public void test_회원정보조회() throws Exception{
		logger.debug(" test_회원정보조회() 실행");
		
		MemberVO vo = mdao.readMember("ADMIN99");
		
		logger.debug(" vo : "+vo);
	}
	
	
	
	
}
