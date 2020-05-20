<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% for (int i=0;i<3;i++){ %>
 <h2>이클립스와 톰캣으로 JSP파일 랜더링하기~~</h2>
 <p>
  안녕하세요. 오늘은 5월 21일 수요일입니다.
  <i>스크립트릿 연습을 하고 있습니다.</i>
 </p>
<% } %>

<h2>구구단 2단 </h2>
<%
	for(int hang=1;hang<=9;hang++){
		//out.print메서드는 브라우저에 출력을 실행하는 메서드앱
		out.print("2 x "+hang+" = "+ (2*hang)+"<br/>");
		
	}


%>
<!-- 반복문과 조건문을 이용하여 구구단 홀수단(3,5,7,9)을 출력해보세요 -->
<% 
for(int dan=2;dan<=9;dan++){
	if(dan %2 !=0){
		out.println("<h2>구구단 "+ dan + "단 </h2><hr/>");
		for(int hang=1;hang<=9;hang++){
			out.println(dan+" x "+hang
					+" = "+(dan*hang)+"<br/>");
			
		}
		
	}
	
	
}


%>


</body>
</html>
