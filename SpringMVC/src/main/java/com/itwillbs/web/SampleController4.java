package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {
	

	private static final Logger logger = LoggerFactory.getLogger(SampleController4.class);
	
//	http://localhost:8088/web/doD
//	http://localhost:8088/web/doD?msg=itwill
	@RequestMapping(value = "/doD", method = RequestMethod.GET)
	public String doD(RedirectAttributes rttr/* @ModelAttribute("msg") String msg */) {
		logger.debug("/doD -> doD() 호출");
		
		// RedirectAttributes : 특별한 Model 객체, 반드시 redirect 이동 시에만 사용 가능.
		
		rttr.addFlashAttribute("msg", "addFlashAttribute 정보입니다.");
		// => 데이터를 1회성으로 전달(F5하면 정보는 사라짐)
		
//		addAttribute();
//		ㄴ 정보가 주소줄에 표시 O, F5(새로고침) 데이터가 유지
//		addFlashAttribute();
//		ㄴ 정보가 주소줄에 표시 X, F5(새로고침) 데이터가 사라짐
		
		
		
//		return "/doE"; // 단순 뷰페이지 설정
//		return "redirect:/doE";// 주소줄 바뀜 화면이동
//		return "forward:/doE"; // 주소줄 안바뀜 화면이동
		
		return "redirect:/doE";
	}
	
//	http://localhost:8088/web/doE
	@RequestMapping(value = "/doE", method = RequestMethod.GET)
	public void doE(@ModelAttribute("msg") String msg) {
		logger.debug("/doE -> doE() 호출");
		
		
	}

}
