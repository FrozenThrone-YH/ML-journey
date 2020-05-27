<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%-- errorpage true이면 내장 객체 exception.을 사용할 수 있다. --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>
		요청 처리 과정에서 문제가 발생했습니다. <br/>
		빠른 시간내에 문제를 해결하겠습니다. ㅠㅠ <br/>
		<strong>잠시만</strong> 기다려 주세요!!!
	</p>
	<p>
		<%-- page isErrorPage="true"를 해야만 쓸 수 있다. 
		Excepttion의 e가 exception. 이라고 보면 된다. --%>

		에러 원인 : <em><%=exception.getMessage() %></em>
	</p>

</body>
</html>
