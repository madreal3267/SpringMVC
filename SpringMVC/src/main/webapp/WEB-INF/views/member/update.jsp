<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/member/update.jsp</h1>
	
	<fieldset>
		<legend>회원정보 수정 (SpringMVC)</legend>
		<form action="/member/update" method = "post">
			아이디 : <input type = "text" name = "userid" value = ${memberVO.userid }><br>	
			비밀번호 : <input type = "password" name = "userpw"><br>	
			이름 : <input type = "text" name = "username" value = ${memberVO.username }><br>	
			이메일 : <input type = "email" name = "useremail" value = ${memberVO.useremail }><br>
			
			<input type = "submit" value = "정보 수정">
			<input type = "button" value = "취소" onclick = "location.href = '/member/main'">
		</form>
	</fieldset>
</body>
</html>