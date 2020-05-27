<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String email = request.getParameter("email");

	request.setAttribute("user_id",id);
	request.setAttribute("user_pw",pw);
	request.setAttribute("user_name",name);
	request.setAttribute("user_email",email);
%>

<jsp:forward page="bean_use.jsp" />
