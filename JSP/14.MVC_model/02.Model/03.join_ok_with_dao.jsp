<%@page import="kr.co.hee.jdbc.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
//join_ok page가 많이 간단해 졌다. 
request.setCharacterEncoding("utf-8");
%>
<%-- request.getParameter("id") 이걸 일일히 다해야한다. 
     이걸 2줄로 축약 --%>
<jsp:useBean id="users" class="kr.co.hee.jdbc.user.model.UserVo" scope="session"/>
<jsp:setProperty name="users" property="*" />

<%
 UserDAO dao = UserDAO.getInstance();
 //dao.join 회원 가입을 할건데, 무슨 데이터로? => users에 담긴 정보로 
 //회원가입 됐는지 어떻게 알지? int rn으로 
 int rn = dao.join(users);
 
 if(rn==1){
	 //name은 getName으로 받을 수 있다. (은닉)
	 session.setAttribute("user_name",users.getName());
	 response.sendRedirect("join_success.jsp");
 }else{
	 response.sendRedirect("join_form.jsp");
 }
%>
