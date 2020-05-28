<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");	
%>


<%@ page import="kr.co.koo.jspbasic.user.userBean" %>
<jsp:useBean id="user" class="kr.co.koo.jspbasic.user.userBean" scope="request"/>

<%-- 
	* 파라미터의 이름과 자바빈 클래스의 멤버 변수명이 일치할 경우
	엑션태그 setProperty의 속성 property값을 *로 지정하면
	자동으로 파라미터값을 읽어서 자바빈 클래스 변수에 저장합니다.
	bean_form에서 4개를 넘겼다. 그 4개가 멤버 변수랑 일치하면 가능
 --%>
<jsp:setProperty name="user" property="*"/>

<jsp:forward page="bean_use_action_tag.jsp" />
