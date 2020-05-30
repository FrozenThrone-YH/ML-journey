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
	PreparedStatement pstmt = null;
	
	String sql = "INSERT INTO users VALUES (?,?,?,?,?,?,?)";
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url,uid,upw);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,name);
		pstmt.setString(2,id);
		pstmt.setString(3,pw);
		pstmt.setString(4,phone1);
		pstmt.setString(5,phone2);
		pstmt.setString(6,phone3);
		pstmt.setString(7,gender);
		
		int rn = pstmt.executeUpdate();
		
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
			conn.close(); pstmt.close(); 
		} catch(Exception e2){
			e2.printStackTrace();
		}
	}
	
%>
