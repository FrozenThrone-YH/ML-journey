<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%

		int count = 0;
		if(session.getAttribute("visit")!=null){
			count = (Integer)session.getAttribute("visit");
		}
		count++;

		session.setAttribute("visit",count);
%>

<!-- session_welcome.jsp에서 <%@ include file="/../Application/app_basic.jsp"%> 로 땡겨올수 있다. 
 그러면 방문자 페이지수가 계속 누적된다. -->
