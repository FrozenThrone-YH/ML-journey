<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> 안녕하세요~~ 여기는 1번페이지입니다.</h3>
	
		<%@ include file="include_ex02.jsp" %>
		<jsp:include page="include_ex02.jsp"/>
		<%-- 
			# 디렉티브 태그의 include 
			ex) <%@ include file="include_ex02.jsp"%>
			- 페이지 내부에서 공유하면서 써야할 변수나 메서드를 다른 파일에 선언해두고
			삽입하여 사용합니다.
			
			# 액션태그의 include:
			ex) <jsp:include page="삽입할 페이지" />
			-단순히 UI를 복사하고 싶을 때 주로 사용합니다. 
			- 광고 배너 등 
		 --%>
	
	<h4> 다시 여기는 1번 페이지 입니다.</h4>

</body>
</html>
