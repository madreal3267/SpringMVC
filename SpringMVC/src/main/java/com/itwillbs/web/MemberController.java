package com.itwillbs.web;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;
import com.itwillbs.service.MemberService;
//@RequestMapping(value = "/member/*")
// URI가 /member/~ 시작하는 모든 주소를 처리(매핑) ~.me, ~.bo
// GET/POST 방식 상관없이 모두 처리 가능

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 서비스 객체를 주입
	@Inject
	private MemberService mService;
	
//	@Inject
//	private MemberDAO mDao;
	
//	http://localhost:8088/web/member/dbtime
//	http://localhost:8088/web/dbtime
//	http://localhost:8088/member/dbtime
	@RequestMapping(value = "/dbtime", method = RequestMethod.GET)
	public void showDbTime(Model model) {
		// 디비의 서버시간정보 조회 -> 연결된 뷰페이지에 출력
		logger.debug("서버시간 : " + mService.getDbServerTime());
		
		String serverTime = mService.getDbServerTime();
		
		// 뷰페이지로 전달할 정보를 저장
		model.addAttribute("serverTime", serverTime);
		
		
	} 
	
//	http://localhost:8088/member/insert
	// 회원가입 - 회원정보 입력(GET)
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insertGET() {
		logger.debug(" /insert -> insertGET() 호출");
		// 연결된 뷰페이지 실행 /WEB-INF/views/member/insert.jsp
		logger.debug(" /views/member/insert.jsp 페이지 연결");
	}
	
	// 회원가입 - 입력받은 정보 처리(POST)
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertPOST(/* @ModelAttribute("memberVO") */MemberVO vo) {
		logger.debug(" /insert -> insertPOST() 호출");
		// 한글인코딩 => web.xml 필터를 사용해서
		// request.setCharacterEncoding(); (x)
		
		// 전달정보를 저장(파라메터 - 아이디, 비밀번호, 이름, 이메일)
		// => 컨트롤러가 자동으로 파라메터 수집
		logger.debug(" vo : " + vo);
		
		// 서비스 => DB에 회원가입 처리 메서드 호출
		mService.memberJoin(vo);
		
		// 연결된 뷰페이지 실행(페이지 이동) -> 로그인 페이지
		return "redirect:/member/login";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// controller
