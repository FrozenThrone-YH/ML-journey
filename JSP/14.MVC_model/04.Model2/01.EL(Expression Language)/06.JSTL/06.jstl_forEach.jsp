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
<%-- 기존 방식  
<% int sum=0;
   for(int i=0;i<=100;i++){
	   sum += i;
   }
   out.print("<h4>1부터 100까지 누적합 : "+sum+"</h4>");
%>--%>
<h4>1부터 100까지의 합</h4><hr/>
<%-- jstl 변수 선언태그 c:set -> EL 변수로 활용가능--%>
<c:set var="sum" value="0" />
<%-- step 1일때 생략 가능 --%>
<c:forEach var="n" begin="1" end="100" step="1">
	<c:set var="sum" value="${sum+n}"/>
</c:forEach>
<p> 1~100까지의 누적합 : ${sum}</p>

<h4>구구단 4단</h4>
<c:forEach var="hang" begin="1" end="9">
	4 x ${hang} = ${4*hang} <br/>
</c:forEach>

<h4>구구단 전체</h4>
<c:forEach var="dan" begin="2" end="9">
	<h3>${dan}단</h3>
	<c:forEach var="hang" begin="1" end="9">
		${dan} x ${hang} = ${dan*hang} <br/>
	</c:forEach>
</c:forEach>
</body>
</html>
