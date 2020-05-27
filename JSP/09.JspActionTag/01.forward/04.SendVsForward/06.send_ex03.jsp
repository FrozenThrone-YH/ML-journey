<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%

	String id = request.getParameter("id");
	String pw = request.getParameter("id");
	//01의 parameter가 아니라, 02의 parameter를 땡겨오는거다. 
	//02에서 parameter를 따놓은것이 아니라 받을 수 없다. 
	
	%>


--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
# 아이디 : <%= id %><br/>
# 비밀번호 : <%= pw %><br/>

<%-- 아이디와 비밀번호가 null로 뜬다.  --%>
   
		
</body>
</html>
