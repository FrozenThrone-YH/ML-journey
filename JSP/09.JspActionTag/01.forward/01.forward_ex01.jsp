<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 
	*jsp action tag사용법
	-생김새 : <jsp:forward 속성=값,...></jsp:forward>
	 ※ HTML과 비슷하게 생겼다.
	-닫는 태그는 태그 내부 추가적으로 종속된 태그가 없다면 닫는 태그를 
	 생략하고 연린태그 끝부분은 />로 마감할 수 있습니다.
	  ex) <jsp:forward 속성=값,.../>

 --%>
 
 <jsp:forward page="forward_ex02.jsp"/>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>forward_ex02 페이지입니다. </h3>
	<p> 포워드 기능에 의해 이 메시지를 보실 수 없습니다.</p>

</body>
</html>

<%-- 강제로 이동된 페이지의 주소는 forward_ex01.jsp이다. 
      sendRedirect와는 다르다. --%>
