package com.itwillbs.service;

import com.itwillbs.domain.MemberVO;

public interface MemberService {
	// 컨트롤러에서 처리를 수행하는 추상메서드 작성
	
	// 디비시간정보 조회
//	public String getTime();
	public String getDbServerTime();
	
	// 회원가입
	public void memberJoin(MemberVO vo);
	
	// 로그인 체크
	public MemberVO memberLogin(MemberVO loginVO);
	
	// 회원정보 조회
	public MemberVO getMember(String userid);
	
	// 회원정보 수정
	public void memberUpdate(MemberVO uvo);
	
	// 회원정보 삭제
	public int memberDelete(MemberVO dvo);
}
