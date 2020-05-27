<%@page import="kr.co.koo.jspbasic.user.userBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="user" class="kr.co.koo.jspbasic.user.userBean" scope="request"/>
<%-- request영역에서 기존에 있는 변수를 사용하는 것이다.  --%>

# 아이디 : <%= user.getId() %>
# 패스워드 : <%= user.getPw() %>
# 이름 : <%= user.getName() %>
# 이메일 : <%= user.getEmail() %>

</body>
</html>
