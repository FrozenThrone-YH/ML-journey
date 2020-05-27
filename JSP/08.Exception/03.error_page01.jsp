<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error_page02.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%= request.getParameter("id").toLowerCase() %>

<%-- 인터넷 익스플로러 브라우저의 경우 전체 응답 결과의
데이터가 512바이트 보다 작을 경우 마이크로소프트에서 자체 제공하는
에러 페이지를 출력합니다. --%>

</body>
</html>
