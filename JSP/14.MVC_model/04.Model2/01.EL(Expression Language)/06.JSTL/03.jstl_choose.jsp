<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- prefix는 소문자c--%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:choose>
	<c:when test="${param.name == '김철수'}">
		<p>당신의 이름은 김철수입니다.</p>
	</c:when>
	<c:when test="${param.age > 19}">
		<p>당신은 성인입니다.</p>
	</c:when>
	<c:otherwise>
		<p>당신의 이름은 김철수가 아니고 미성년자입니다.</p>
	</c:otherwise>
</c:choose>
<%-- 기존방식
<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));

	if(name.equals("김철수")){
%>
 <p>당신의 이름은 김철수 입니다.</p>
 <%} else if(age>19){ %>
 <p> 당신은 성인입니다.</p>
 <%} else {%>
 <p> 당신의 이름은 김철수가 아니고 미성년자입니다. </p>
 <%} %>--%>
 





</body>
</html>
