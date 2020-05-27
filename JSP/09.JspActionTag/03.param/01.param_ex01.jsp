<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="param_ex02.jsp" method="post">
	
		이름 : <input type="text" name="name" size="10px" /> <br/>
		<%-- type : email은 어느 정도 email형식을 체크 해준다 @가 있다거나  --%>
		이메일 : <input type="email" name="email" size="20px" /> <br/>
		<input type="submit" value="확인" />
	</form>


</body>
</html>
