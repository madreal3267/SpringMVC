package com.itwillbs.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

/**
 * 서비스는 컨트롤러와 DAO를 연결
 * => DAO를 호출
 *
 */

//@Service : 해당 객체를 Service 객체(bean)로 root-context.xml이 인식하도록 설정


@Service
public class MemberServiceImpl implements MemberService{
	
	

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	
	
	// DAO를 호출하기(객체를 생성) => 의존 객체 주입
	// MemberDAO mdao = new MemberDAOImple(); (직접생성 X)
	// root-context.xml에 생성되어 있는 DAO 객체(빈)을 주입
	
	@Inject
	private MemberDAO mdao;

	@Override
	public String getDbServerTime() {
		
		
		return mdao.getTime();
	}

	@Override
	public void memberJoin(MemberVO vo) {
		// 컨트롤러 -> 서비스
		logger.debug(" memberJoin(MemberVO vo) 실행");
		
		// DAO 메서드 호출
		mdao.insertMember(vo);
		
		logger.debug(" 회원가입 성공!");
	}

	@Override
	public MemberVO memberLogin(MemberVO loginVO) {
		logger.debug(" 컨트롤러 - > 서비스 호출 ");
		logger.debug(" memberLogin(loginVO)");
		
		logger.debug(" 서비스 -> DAO 호출");
		// DAO 로그인처리 동작 호출
		MemberVO resultVO = mdao.loginMember(loginVO);
		logger.debug(" DAO처리결과 -> 서비스 ");
		logger.debug(" 서비스 - > 컨트롤러");
		
		return resultVO;
	}

	@Override
	public MemberVO getMember(String userid) {
		
		logger.debug("getMember(String userid) 호출 ");
		
		return mdao.getMember(userid);
	}

	@Override
	public void memberUpdate(MemberVO uvo) {
		
		logger.debug(" memberUpdate(MemberVO uvo) 호출");
		
		mdao.updateMember(uvo);
	}

	@Override
	public int memberDelete(MemberVO dvo) {
		
		logger.debug(" memberDelete(MemberVO dvo) 호출");
		
		return mdao.deleteMember(dvo);
	}

	
	
	
	
	

	
	
}
