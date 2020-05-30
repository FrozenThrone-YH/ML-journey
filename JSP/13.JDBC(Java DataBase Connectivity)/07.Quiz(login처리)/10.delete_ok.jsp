<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("user_id");

	String url = "jdbc:mysql://localhost:3306/jsp_practice";
	String uid = "jsp";
	String upw = "jsp";
	
	Connection conn = null;
    Statement stmt = null;

	String sql = "DELETE FROM users WHERE id='" + id + "'";

	//삭제 성공시 login_form.jsp로 실패시 login_welcome.jsp 리다이렉팅.
	try {
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(url, uid, upw);
         stmt = conn.createStatement();
         int rn = stmt.executeUpdate(sql);
         
         if(rn == 1) {
            session.invalidate();
            response.sendRedirect("login_form.jsp");
         }else {
            response.sendRedirect("login_welcome.jsp");
         }
               
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if(conn!=null) conn.close();
            if(stmt!=null) stmt.close();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
%>





