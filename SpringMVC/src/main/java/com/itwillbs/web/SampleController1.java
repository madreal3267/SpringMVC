package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//@Controller : 해당 클래스를 컨트롤러로 처리

@Controller
public class SampleController1 {
	
	// mylog 명령어
	private static final Logger logger = LoggerFactory.getLogger(SampleController1.class);

//	@RequestMapping(value = "/test",method = RequestMethod.GET)
//	ㄴ 사용자의 요청을 매핑 value값으로 호출, GET방식 호출
//	http://localhost:8088/web/test
//	http://localhost:8088/web/itwill
	
//	* 404 페이지에서 메세지 정보가 있는지 없는지에 따라서 컨트롤러 매핑유무 판단
//	메세지 정보 O - 컨트롤러 매핑 O
//	메세지 정보 X - 컨트롤러 매핑 X
	
	@RequestMapping(value = "/itwill",method = RequestMethod.GET)
	public void test() {
		System.out.println(" test() 실행 ");
		
		logger.info(" test() 실행 - logger-info "); 
		logger.debug(" test() 실행 - logger-debug "); 
		
		logger.info("li");
		logger.debug("ld");
	}
	
	
	
//	http://localhost:8088/web/doA
//	@RequestMapping(value = "/doA", method = RequestMethod.GET)
//	@GetMapping(value = "/doA")
//	@PostMapping(value = "/doA")
	@RequestMapping(value = "/doA", method = RequestMethod.GET)
	public void doA() {
		logger.debug(" /doA -> doA() 메서드 호출");
		// 메서드의 리턴타입이 void 일 때
//		   주소 이름 사용해서 뷰페이지를 연결 /WEB-INF/views/주소.jsp
		logger.debug("컨트롤러(스프링MVC)가 자동으로 연결된 뷰페이지 이동");
	}
	
	@RequestMapping(value = "/doA1", method = RequestMethod.GET)
	public void doA1() {
		logger.debug(" /doA1 -> doA1() 메서드 호출");
		
	}
	
	
	
	
}
