<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 fieldset{
 	width : 50%;
 
 }
</style>

</head>
<body>

<form action="session_login_ok.jsp" method="post">

	<fieldset>
		<legend> 로그인 폼</legend>
	<input type="text" name="id" size="10" placeholder="ID"/><br/>
	<input type="password" name="pw" size="10" placeholder="PW"/><br/>
	<input type="text" name="nick" size="10" placeholder="별명"/><br/>
	<input type="submit" value="로그인"/><br/>
	
	</fieldset>
	
</form>

</body>
</html>
