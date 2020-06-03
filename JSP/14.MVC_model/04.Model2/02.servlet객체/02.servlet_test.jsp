<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/MVCModel2Basic/apple">
	<h4>서블릿 테스크하기</h4>
	<input type="submit" value="test"/>
</form>
<%-- 처음 submit 버튼을 누르면
apple페이지 서블릿 객체 생성! - 객체 생성
init메서드가 호출됨! - init함수 호출
doGet메서드 호출! 
그 다음 f5를 누르면 doGet메서드 호출! 만 뜬다.
객체 하나를 가지고쓴다. destroy가 되지 않는다. 
--%>

</body>
</html>
