package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	// sql쿼리 호출 -> 처리객체 필요
	@Inject
	private SqlSession sql;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	@Override
	public MemberVO readMember(String userid) throws Exception {
		logger.debug(" readMember(String userid) 실행");
		
		return sql.selectOne("com.itwillbs.mapper.MemberMapper.joinMember", userid);
		
	}

}
