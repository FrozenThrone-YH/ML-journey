<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>

<%
	String url = "jdbc:mysql://localhost:3306/jsp_practice";
	String uid = "jsp";
	String upw = "jsp";
	
	Connection conn = null;
	PreparedStatement pstmt = null;

	//Statement style은 +변수+로 따옴표 처리
	//PreparedStatement style은 포매팅 처럼 처리 
	String sql = "INSERT INTO member VALUES(?,?,?,?)";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");		
		conn = DriverManager.getConnection(url, uid, upw);		
		
		/*
			stmt는 createStatement()메서드를 호출
			sql은 executeUpdate때 넣었는데
			pstmt는 Connection이 제공하는 
			PrepareStatement()메서드를 호출합니다. 
			매개값에 sql을 전달합니다.(객체 생성시)
		*/
		pstmt = conn.prepareStatement(sql);
		
		/*
			-pstmt객체를 생성했다면 sql문의 ?값들을 채워줍니다.
			-?는 첫번째 물음표부터 1번의 인덱스 값을 가지며 순차적으로
			 인덱스가 1씩 증가합니다.
			- DB테이블의 컬럼 데이터타입에 따라 setString(),setInt()
			등의 메서드를 사용하여 ?를 채웁니다.
		*/
		pstmt.setString(1,"danmuji");
		pstmt.setString(2,"54321");
		pstmt.setString(3,"단무지");
		pstmt.setString(4,"danmuji@naver.com");
				
		/*
		-?값을 모두 입력했다면 sql문의 종류에 따라
		executeQuery(),executeUpdate()를 호출합니다.
		- stmt와는 달리 매개값으로 sql을 전달하지 않습니다.
		*/
		
		int rn = pstmt.executeUpdate();
		
		if(rn==1){
			out.println("<h3>회원정보 입력 성공!</h3>");
			
		}else{
			out.println("<h3>회원정보 입력 실패!</h3>");
		}
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(conn!=null) conn.close();
			if(pstmt!=null) pstmt.close();			
		} catch(Exception e2) {
			e2.printStackTrace();
		}
	}
%>
