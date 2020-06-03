<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 페이지 안에서 JSTL tag를 사용하려면 
디렉티브를 통해 taglib 선언을 해야합니다.
습관적으로 넣어햐 한다. prfix="C"는 core를 뜻함 --%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%-- 기존 방식 
	<%
		String name = request.getParameter("name");
		if(name.equals("홍길동")){
	%>
		<p> name파라미터의 값은 홍길동입니다.</p>
	<%} if(name.equals("이순신")){ %>
		<p> name파라미터의 값은 이순신입니다.</p>
	<%}%> --%>
	
	<%-- 다중 분기문은 지원하지 않는다.
	else if는 따로 있다. --%>
	<c:if test="${param.name == '홍길동'}">
		<p>name파라미터의 값은 ${param.name}</p>
	</c:if>
	<c:if test="${param.name == '이순신'}">
		<p>name파라미터의 값은 ${param.name}</p>
	</c:if>
	
	

</body>
</html>
