package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)
// ㄴ 스프링으로 JUNIT을 사용해서 테스트 하겠다
//@WebAppConfiguration
// ㄴ 스프링 MVC(웹)으로 테스트 하겠다	// 컨트롤러 테스트 시 사용
//@ContextConfiguration(
//		locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"}
//		)
//		=> root-context.xml,servlet-context.xml 정보를 모두 가져오기



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"}
		)
public class MemberControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerTest.class);
	
	@Inject
	private WebApplicationContext wac;
	// ㄴ 프로젝트 객체 정보 주입.
	
	private MockMvc mockMVC;
	
//	@Before : @Test 실행하기 전에 처리 동작
	@Before
	public void setUp() {
		// MockMvc 객체 생성
		mockMVC = MockMvcBuilders.webAppContextSetup(wac).build();
		logger.debug(" MockMVC 객체를 생성( 프로젝트 정보를 포함한 )");
		
	}
	
	@Test
	public void dbtime_test() {
		
		try {
			mockMVC.perform(MockMvcRequestBuilders.get("/dbtime"));
			logger.debug("컨트롤러 테스트 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
