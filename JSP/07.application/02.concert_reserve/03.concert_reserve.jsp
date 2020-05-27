<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%

	if(session.getAttribute("auth_pass")==null){
		response.sendRedirect("concert_auth.jsp");
	}
	
	List<String> list = new ArrayList<>();
	if(application.getAttribute("complete_list") != null){
		list = (List<String>)application.getAttribute("complete_list");	
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--가운데 정렬할 박스하나 만들기 : div --%> 
	<div align="center">
		<h2>콘서트 좌석 예매</h2>
		<h4>예매할 좌석을 체크한 후 예약 버튼을 눌러주세요 </h4>
		
	</div>
	<hr/>
	<form action="concert_reserve_check.jsp">
	
	<p align="center">
		<strong>좌석 배치도</strong>
		<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<%for (char c='A';c<='Z';c++) {%>
			<small><%=c %></small>&nbsp;&nbsp;
		<%} %><br/>
		
		<% for (int r=1;r<=3;r++) {%>
			<%=r %>
			<% for(char c='A';c<='Z';c++){ %>
				<%-- list는 확정 예약 정보가 들어있는 배열이고, 거기에  c가 있다면
				이미 선점 된 것이므로 막아줘야 한다. --%> 
				<% if (list.contains(c + "-" + r)) {%>
				<input type="checkbox" name="seat" value="<%=c %>-<%=r %>" disabled/>
				<%} else { %>
				<input type="checkbox" name="seat" value="<%=c %>-<%=r %>"/>
				<%} %>
			<%} %>
			<br/>
		<%} %><br/>
		<% for (int r=4;r<=6;r++) {%>
			<%=r %>
			    <% for(char c='A';c<='Z';c++){ %>
				<% if (list.contains(c + "-" + r)) {%>
				<input type="checkbox" name="seat" value="<%=c %>-<%=r %>" disabled/>
				<%} else { %>
				<input type="checkbox" name="seat" value="<%=c %>-<%=r %>"/>
				<%} %>
			<%} %>
			<br/>
		<%} %><br/><br/>
		
		<input type="submit" value="예약">&nbsp;
		<input type="reset" value="재설정">&nbsp;
	</p>
	
	</form>


</body>
</html>
