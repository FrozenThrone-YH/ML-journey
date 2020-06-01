<%@page import="kr.co.koo.izone.member.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//login_modal.jspf의 91번째줄에서 타고 들어온다.
	//form_tag 마지막은 177번째 줄
	
	String userId = request.getParameter("userId");
	MemberDAO dao = MemberDAO.getInstance();
	
	//있으면 true, 없으면 false
	boolean flag = dao.confirmId(userId);
	out.println(flag);
	if (flag){
%>
	<script>
		alert("아이디가 중복됨.");
		history.back();
	</script>
<%} else {%>
	<script>
		alert("아이디가 사용가능!.");
		history.back();
	</script>
<%}%>
