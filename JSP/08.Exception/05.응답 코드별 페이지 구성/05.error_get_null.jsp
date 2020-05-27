<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <%-- nullpointException도 500페이지 에러이다.  --%>
	<% String str=null; %>
	<%=str.indexOf("메롱") %>

</body>
</html>
