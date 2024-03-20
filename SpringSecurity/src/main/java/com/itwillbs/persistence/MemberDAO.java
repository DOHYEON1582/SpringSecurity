package com.itwillbs.persistence;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {
	
	// 회원정보 조회
	public MemberVO readMember(String userid) throws Exception;

}
