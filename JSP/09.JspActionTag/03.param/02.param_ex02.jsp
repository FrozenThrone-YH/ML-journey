<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%-- 여기에 올때 parameter가 2개가 왔다. --%>
    <% request.setCharacterEncoding("utf-8"); %>
    
    
    <%-- ex02 page에서 ex03페이지로 넘기는데, 넘길때 nick:멍멍이를 추가해서 
    3개를 보낸다.  --%>
    
    <jsp:forward page="param_ex03.jsp">
    	<jsp:param name="nick" value="멍멍이" />
    </jsp:forward>
    
    
    <%-- 결과 페이지는 ex02 page로 된다. --%>
