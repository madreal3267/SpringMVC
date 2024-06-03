<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/member/info.jsp</h1>
	
	회원정보 : ${memberVO } <hr>
	
	<table border = "1">
		<tr>
			<td>아이디</td>
			<td>${memberVO.userid }</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${memberVO.userpw }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${memberVO.username }</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${memberVO.useremail }</td>
		</tr>
		<tr>
			<td>회원가입일</td>
			<td>${memberVO.regdate }</td>
		</tr>
		<tr>
			<td>최종수정일</td>
			<td>${memberVO.updatedate }</td>
		</tr>
		
	</table>
	
	<h2><a href = "/member/main">메인페이지로</a></h2>
</body>
</html>