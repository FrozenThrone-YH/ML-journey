<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.*" %>
<%
	//인증번호 랜덤으로 만드는 api
	//실행시키면 콘솔창에 인증번호가 나온다. 
	UUID uuid = UUID.randomUUID();
	System.out.println(uuid.toString());
	
	//uuid를 -로 쪼개서 배열로 저장
	//uuid : d9415ca5-27b5-4e33-a12b-45a0d3772b1a
	String[] uuids = uuid.toString().split("-");
	//uuids : [d9415ca5, 27b5, 4e33, a12b, 45a0d3772b1a]
	System.out.println(Arrays.toString(uuids));
	// uuids[1] : 27b5
	System.out.println(uuids[1]);
	
	//이 인증번호는 브라우저를 끄기전까지 유효하다.
	session.setAttribute("auth_code",uuids[1]);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 회원 인증 페이지 </h2>
	<%--<del>은 작대기 긋는것 --%>
	<h1> 인증문자 : <del><%= uuids[1] %></del></h1>
	<form action="concert_auth_check.jsp">
		<small>위의 인증문자를 입력해주세요.</small>
		<input type="text" name="code" size=5>
		<input type="submit" value="확인">
	</form>


</body>
</html>
