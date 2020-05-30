<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
	//1. 폼데이터 처리
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	//2. SQL문 작성(select문으로 가입 당시의 패스워드를 조회)
	
	String sql = "SELECT id,pw,name FROM users WHERE id=?";

	//3. DB연동에 필요한 변수들 선언
	String url = "jdbc:mysql://localhost:3306/jsp_practice";
	String uid = "jsp";
	String upw = "jsp";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//4. JDBC로직 작성.
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url,uid,upw);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		
		rs = pstmt.executeQuery();
		
		if (rs.next()){
		String dbID = rs.getString("id");
		String dbPW = rs.getString("pw");
		String dbName = rs.getString("name");
			if (dbPW.equals(pw)){
				session.setAttribute("user_id",id);
				session.setAttribute("user_name",dbName);
				response.sendRedirect("login_welcome.jsp");
			} else {
				response.sendRedirect("login_fail_password.jsp");
			}
		} else {
			response.sendRedirect("login_fail_id.jsp");	
		}
		
		
		
		
		
	} catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			conn.close(); pstmt.close(); rs.close(); 
		} catch(Exception e2){
			e2.printStackTrace();
		}
	}
	//5. ResultSet을 통해 결과값소비 후 결과에 맞는 페이지 안ㄴ내.
		//로그인성공, 아이디 없을때, 비밀번호 틀렸을 때
		//로그인 성공시 login_welcome.jsp
		//id를 맞게 적었으면, pw를 찾는 쿼리를 적는다
		
	//6. 로그인 성공시 id, name 세션처리.
		

%>
