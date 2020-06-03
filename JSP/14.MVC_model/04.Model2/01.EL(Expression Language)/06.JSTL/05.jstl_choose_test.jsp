<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${param.point >= 90}">
		<h4> 당신의 학점은 A입니다.</h4>
	</c:when>
	<c:when test="${param.point >= 80}">
		<h4> 당신의 학점은 B입니다.</h4>
	</c:when>
	<c:when test="${param.point >= 70}">
		<h4> 당신의 학점은 C입니다.</h4>
	</c:when>
	<c:when test="${param.point >= 60}">
		<h4> 당신의 학점은 D입니다.</h4>
	</c:when>
	<c:otherwise>
		<h4> 당신의 학점은 F입니다.</h4>
	</c:otherwise>
</c:choose>

</body>
</html>
