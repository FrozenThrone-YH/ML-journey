<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.co.koo.jspbasic.user.userBean" %>
    <%

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	//userBean이 빨간줄인 이유는 import를 안해서
	//java resoureces에 만든 package와 call이름 그대로 import 해준다. 
	userBean user = new userBean(id,pw,name,email);
	request.setAttribute("user",user);
%>

<jsp:forward page="bean_use_with_bean.jsp" />

