package com.itwillbs.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

/**
 * MemberDAO 인터페이스를 구현한 객체 => 기존의 DAO 객체의 동작 수행
 */

//@Repository : 스프링이 해당파일을 DAO(bean)로 인식하도록 설정

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	// 공용변수, 디비연결, 자원해제 동작 선언 => 기존코드
	
	// root-context.xml (스프링)에서 필요한 기능을 하는 객체를 주입
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE
						 = "com.itwillbs.mapper.MemberMapper.";
	
	
	@Override
	public String getTime() {
		// 1.2. 디비연결 => 생략
		// 3. sql 작성 => 생략 (mapper.xml)
		// 4. sql 실행
		// 5. 데이터 처리
		
//		sqlSession.selectOne(sql 구문이 있는 mapper의 위치 + 이름);
		String result = sqlSession.selectOne(NAMESPACE +"getTime");
//		sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
		// 디비연결, 자원해제, sql 실행
		
		System.out.println(" DAO : 결과 : " + result);
		
		return result;
	}


	@Override
	public void insertMember(MemberVO vo) {
		System.out.println(" DAO : insertMember(vo) 호출 ");
		
		// mapper 생성된 sql 구문 실행
//		sqlSession.insert(sql구문, 전달할 값)
		sqlSession.insert(NAMESPACE + "memberJoin", vo); // 객체 단위로 정보 전달(자동으로 값들을 매핑)
		
		System.out.println(" DAO : 회원가입 완료! ");
	}


	@Override
	public MemberVO loginMember(MemberVO vo) {
		System.out.println(" DAO : loginMember(vo) 실행 ");
		
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE + "loginCheck", vo);
		
		System.out.println(" 결과 : " + resultVO);
		
		return resultVO;
	}


	@Override
	public MemberVO loginMember(String userid, String userpw) {
						// 하나의 객체에 한번에 저장이 불가능한 데이터들..
		System.out.println(" DAO : loginMember(String userid, String userpw) 실행 ");
		MemberVO vo = new MemberVO();
		vo.setUserid(userid);
//		vo.setUserpw(userpw); (저장 불가능)
		
//		sqlSession.selectOne(NAMESPACE + "loginCheck", vo);
//		sqlSession.selectOne(NAMESPACE + "loginCheck", vo); X
		
		Map<String, String> sendVO = new HashMap<String, String>();
		
//		sendVO.put("key:매핑된 이름", value:전달할 데이터);
		sendVO.put("userid", userid);
		sendVO.put("userpw", userpw);
		
		// => 한번에 저장이 불가능한 데이터를 Map 형태로 저장해서 전달가능(Join)

//		결과(vo) 수정 가능성이 있음.
//		MemberVO vo = sqlSession.selectOne(NAMESPACE + "loginCheck", sendVO);
//		vo.setName(dddddd);
//		return vo;
		
		// 결과를 수정없이 전달.
		return sqlSession.selectOne(NAMESPACE + "loginCheck", sendVO);
	}


	@Override
	public MemberVO infoMember(MemberVO vo) {
		System.out.println(" DAO : infoMember(MemberVO vo) 실행 ");
		
		sqlSession.selectOne(NAMESPACE + "memberInfo", vo);
		
//		System.out.println("결과 : " + infoVO);
		
		return sqlSession.selectOne(NAMESPACE + "memberInfo", vo);
	}


	
	
	
	
}
