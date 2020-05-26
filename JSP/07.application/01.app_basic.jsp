<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%

		int count = 0;
		if(application.getAttribute("visit")!=null){
			count = (Integer)application.getAttribute("visit");
		}
		count++;

		application.setAttribute("visit",count);
%>


<!-- session_welcome.jsp에서 <%@ include file="/../Application/app_basic.jsp"%> 로 땡겨올수 있다. 
 그러면 방문자 페이지수가 계속 누적된다. 
session은 웹브라우저를 닫으면 기록이 사라지지만,
application은 브라우저를 닫고 다시 접속해도 서버가 살아있으면 기록이 살아있다. -->
