<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 기초 내용은 주석과 같다.  
<%
	String name = request.getParameter("name");
	String nick = request.getParameter("nick");
%>

이름 : <%=name %> <br/>
별명 : <%=nick %> <br/>
--%>
<!-- EL로는 다음과 같이 할 수 있다.servlet을 굉장히 가볍게 쓸 수 있다. -->
이름 : ${param.name} <br/>
별명 : ${param.nick} <br/>

</body>
</html>
