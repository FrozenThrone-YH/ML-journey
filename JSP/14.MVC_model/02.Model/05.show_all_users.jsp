<%@page import="kr.co.hee.jdbc.user.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	UserDAO dao = UserDAO.getInstance();
	List<UserVo> userList = dao.userSelectAll();

	for(UserVo user : userList){
		String name = user.getName();
		String id = user.getId();
		String pw = user.getPw();
		String phone = user.getPhone1() + "-" +
		user.getPhone2()+ "-" + user.getPhone3();
		String gender = user.getGender();
	
		out.println("이름: "+name+", 아이디: "+id+
		", 비밀번호 : "+ pw + ", 전화번호: "+phone
		+", 성별: "+gender+"<br/>");
	}
	
%>
