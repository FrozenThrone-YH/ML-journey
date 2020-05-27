<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	String id = request.getParameter("id");
	String pw = request.getParameter("id");


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

# 아이디 : <%= id %><br/>
# 비밀번호 : <%= pw %><br/>

<%-- forward_ex01에서 넘긴 파라미터가 들어온다.  --%>
   

</body>
</html>
