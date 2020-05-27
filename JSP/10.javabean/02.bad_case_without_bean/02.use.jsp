<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

# 아이디 : <%= request.getAttribute("user_id") %>
# 패스워드 : <%= request.getAttribute("user_pw") %>
# 이름 : <%= request.getAttribute("user_name") %>
# 이메일 : <%= request.getAttribute("user_email") %>

</body>
</html>
