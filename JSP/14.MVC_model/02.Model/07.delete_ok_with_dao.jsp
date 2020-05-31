<%@page import="kr.co.hee.jdbc.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<% 
request.setCharacterEncoding("utf-8");
%>

<%	
  //session에 있는 id를 입력값으로 준다. 
	String id = (String)session.getAttribute("user_id");
	UserDAO dao = UserDAO.getInstance();
	int rn = dao.userDelete(id);
	
	if(rn==1){
		session.invalidate();
		response.sendRedirect("login_form.jsp");
	}else{
		response.sendRedirect("login_welcome.jsp");
	}
	
%>
