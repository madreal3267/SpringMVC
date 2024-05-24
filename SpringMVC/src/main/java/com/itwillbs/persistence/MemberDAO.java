package com.itwillbs.persistence;

import com.itwillbs.domain.MemberVO;

/**
 * 회원에 동작을 처리하는 객체 
 */

public interface MemberDAO {
	
	// 디비 서버의 시간정보 조회
	public String getTime();
	
	// 회원가입
	public void insertMember(MemberVO vo);
	
	// 로그인
	public MemberVO loginMember(MemberVO vo);
	public MemberVO loginMember(String userid, String userpw);
	
	// 회원정보 조회
	
	public MemberVO infoMember(MemberVO vo);
//	public MemberVO infoMember(String userid);
	
}
