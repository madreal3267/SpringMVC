package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
	}
	
	
}
