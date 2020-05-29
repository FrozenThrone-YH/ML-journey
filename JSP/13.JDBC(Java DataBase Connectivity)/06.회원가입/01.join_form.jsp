<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join_ok.jsp" method="post">
		이름: <input type="text" name="name" size="10"><br>
		아이디: <input type="text" name="id" size="10"><br>
		비밀번호: <input type="password" name="pw" size="10"><br>
		전화번호:
		<select name="phone1">
			<option>010</option>
			<option>011</option>
			<option>016</option>
			<option>019</option>
		</select> 
		<input type="text" name="phone2" size="10"> - 
		<input type="text" name="phone3" size="10"><br>
		
		성별: 
		<input type="radio" name="gender" value="남">남 &nbsp;
		<input type="radio" name="gender" value="여">여 <br>
		
		<input type="submit" value="회원가입">
		
		
	</form>


</body>
</html>
