<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	//1.폼데이터 처리
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String phone1 = request.getParameter("phone1");
	String phone2 = request.getParameter("phone2");
	String phone3 = request.getParameter("phone3");
	String gender = request.getParameter("gender");
	
	//2. JDBC로직 작성.
	String url = "jdbc:mysql://localhost:3306/jsp_practice";
	String uid = "jsp";
	String upw = "jsp";
	
	Connection conn = null;
	Statement stmt = null;
	
	String sql = "INSERT INTO users VALUES ('"
			+name+"','"+id+"','"+pw
			+"','"+phone1+"','"+phone2
			+"','"+phone3+"','"+gender+"')";
	
	System.out.println(sql);
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url,uid,upw);
		stmt = conn.createStatement();
		int rn = stmt.executeUpdate(sql);
		
		if (rn==1){
			session.setAttribute("user_name",name);
			response.sendRedirect("join_success.jsp");
		} else{
			response.sendRedirect("join_form.jsp");
		}
		
	} catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			conn.close(); stmt.close(); 
		} catch(Exception e2){
			e2.printStackTrace();
		}
	}
	
%>
