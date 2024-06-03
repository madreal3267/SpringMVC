<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 로그인 여부 판단 -->
	<c:if test="${empty sessionScope.id}">
		<c:redirect url="/member/login" />	
	</c:if>
	
	<h1>/member/main.jsp</h1>
	
	${id } 님 환영합니다. <hr>
	${sessionScope.id } 님 환영합니다. <hr>
	<input type = "button" value = "로그아웃" onclick = " location.href = '/member/logout';"> 
	
	
	<hr>
	
	<h2><a href = "/member/info">회원정보 조회</a></h2>
	
	<h2><a href = "/member/update">회원정보 수정</a></h2>
	
	<h2><a href = "/member/delete">회원정보 삭제</a></h2>
</body>
</html>