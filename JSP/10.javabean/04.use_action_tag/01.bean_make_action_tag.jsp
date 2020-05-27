<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.co.koo.jspbasic.user.userBean" %>
<jsp:useBean id="user" class="kr.co.koo.jspbasic.user.userBean" scope="request"/>
<%-- id는 변수명, class는 사용할 클래스명을 import처럼 주소까지 scope는 
request는 request위임때까지만, session, application을 사용할 수 있다. 
page를 하면 다음 페이지에서 nullpointer가 뜬다. --%>

    <%


	user.setId(request.getParameter("id"));
	user.setPw(request.getParameter("pw"));
	user.setName(request.getParameter("name"));
	user.setEmail(request.getParameter("email"));


%>

<jsp:forward page="bean_use_action_tag.jsp" />
