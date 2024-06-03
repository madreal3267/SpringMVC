package com.itwillbs.web;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)

public class MemberDAOTest {
	
	// DAO 객체를 실행 => DAO객체를 필요로함 = > DAO 객체를 의존하고 있다.
	
//	MemberDAO dao = new MemberDAO();
//	dao.getTime();
	
	// DAO 객체(bean)가 있는가? yes
	@Inject
	private MemberDAO mdao;
	
//	@Test
	public void testDAO() {
		System.out.println("@@@@: " + mdao);
	}
	
//	@Test
	public void testGetTime() {
		System.out.println(mdao.getTime());
	}
	
	// 회원가입 - 회원가입
//	@Test
	public void 회원가입_테스트() {
		System.out.println(" Test : 회원가입_테스트() 실행");
		
		// 임시데이터 생성 => 나중에 사용자 정보입력으로 변경(컨트롤러사용)
		MemberVO vo = new MemberVO();
		vo.setUserid("test12");		// PK
		vo.setUserpw("1234");
		vo.setUsername("사용자");
		vo.setUseremail("test1@test.com");
		mdao.insertMember(vo);
		
		System.out.println(" Test : 회원가입_테스트() 끝");
	}
	// 회원관리 - 로그인 / 로그아웃
//	@Test
	public void 로그인_테스트() {
		System.out.println(" Test : 로그인_테스트() 시작");
		
		MemberVO loginVO = new MemberVO();
		
		loginVO.setUserid("admin");
		loginVO.setUserpw("1234");
		
		MemberVO resultVO = mdao.loginMember(loginVO);
		
		if(resultVO == null) {
			System.out.println(" Test : 로그인 실패 ");
		}else {
			System.out.println(" Test : 로그인 성공 ");
			
		}
		
		System.out.println(" Test : 로그인_테스트() 끝");
	}
	// 회원관리 - 회원정보 조회(info)
//	@Test
	public void 정보조회_테스트() {
		System.out.println(" Test : 회원정보조회_테스트() 시작 ");
		
		MemberVO infoVO = new MemberVO();
		
		infoVO.setUserid("admin");
		// - 화면에서 사용자가 아이디만 입력
		
		// 아이디에 해당하는 사용자 정보 전부를 DB에서 가져오기
		// 기존) MemberDAO dao = new MemberDAO(); 생략
		MemberVO resultVO = mdao.getMember(infoVO);
		
		if(resultVO == null) {
			System.out.println(" Test : 로그인 실패 ");
		}else {
			System.out.println(" Test : 로그인 성공 ");
			System.out.println("id : " + resultVO.getUserid());
			System.out.println("pw : " + resultVO.getUserpw());
			System.out.println("name : " + resultVO.getUsername());
			System.out.println("email : " + resultVO.getUseremail());
			
		}
		System.out.println(" Test : 회원정보조회_테스트() 끝 ");
	}
	
	private MemberVO uvo = null;
//	@Before
//	=> @Test 실행하기 전 먼저 실행하는 메서드.
//	@Before
	public void 회원수정정보_객체() {
		// 수정할 내용(임의값)
		uvo = new MemberVO();
		uvo.setUserid("admin");
		uvo.setUsername("수정 이름");
		uvo.setUseremail("admin222@admin.com");
		
		
	}
	
	
	// 회원관리 - 회원정보 수정(update)
//	@Test
	public void 회원정보수정_테스트() {
		System.out.println(" Test : 회원정보수정_테스트() 시작");
	
		// DAO - 정보수정 메서드 호출
		mdao.updateMember(uvo);
		
		System.out.println(" Test : 회원정보수정_테스트() 끝");
	}
	
	// 회원관리 - 회원정보 삭제(delete)
//	@Test
	public void 회원정보삭제_테스트() {
		System.out.println(" Test : 회원정보삭제_테스트() 시작");
		
		// DAO - 정보삭제 메서드 호출
		MemberVO dvo = new MemberVO();
		
		dvo.setUserid("test12");
		dvo.setUserpw("1234");
		
		int result = mdao.deleteMember(dvo);
		
		if (result >= 1) {
			System.out.println(" Test : 회원정보 삭제!");
		}else {
			System.out.println(" Test : 회원정보 삭제 실패!");
		}
		
		System.out.println(" Test : 회원정보삭제_테스트() 끝");
	}
	
	@Test
	// 회원관리 - 회원정보 목록(list)
	public void 회원정보목록_테스트() {
		System.out.println(" Test : 회원정보목록_테스트() 시작");
		
		// DAO - 정보목록 메서드 호출
		List<MemberVO> memberList = new ArrayList<MemberVO>(); 
		memberList = mdao.memberList();
		System.out.println(memberList);
		
		System.out.println(" Test : 회원정보목록_테스트() 시작");
	}
	
}
