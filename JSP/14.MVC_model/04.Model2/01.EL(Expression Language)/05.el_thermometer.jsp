<%@page import="ko.co.koo.el.Thermometer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    
    /*
    - EL태그로 자바의 객체를 활용하려면 request,session,application내장객체에
    자바의 객체를 저장시켜야 합니다.
    */
    
    //Thermometer를 t로 저장시킨다.
    //request 동안 t로 사용할 수 있다. 
    request.setAttribute("t",new Thermometer());
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- el에서 객체 메서드 호출 시 매개값으로 문자열을 전달할때는
홑따옴표 사용 --%>
${t.setDegrees('서울', 22.5)}
서울 온도 : 섭씨${t.getDegrees('서울')}도 // 화씨 ${t.change('서울')}도
${t.setDegrees('알레스카', 19.8)}
알레스카 온도 : 섭씨${t.getDegrees('알레스카')}도//화씨 ${t.change('알레스카')}도


</body>
</html>
