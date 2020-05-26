<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		1. 로그인하지 않은 사용자가 주소창에 이페이지의 URL을 적고
		들어왔을 경우 로그인창으로 돌려보내는 코드를 작성하세요.
		
		2. 로그인한 회원의 아이디와 별명을 통해 "nick(id)님 환영하세요"를
		출력하세요.
		
		3. a태그로 로그인창으로 돌아가는 링크와 request폴더에 앨범페이지로
		갈 수 있는 링크를 2개 작성하세요 
	*/
	
	//getAttribute는 값이 없거나 잘못적으면 null을 return
	if (session.getAttribute("user_id") == null){
		response.sendRedirect("session_login.jsp");	
	}
	String nick = (String)session.getAttribute("user_nick");
	String id = (String)session.getAttribute("user_id");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- //내코드 : if (id ==null)로 여기서 처리--%>
<%= nick %>(<%=id %>)님 환영합니다!<br/>
<a href="session_login.jsp">로그인페이지로가기<br/></a>
<a href="session_album.jsp">엘범페이지로 가기<br/></a>
<a href="session_logout.jsp">로그아웃<br/></a>
 


</body>
</html>
