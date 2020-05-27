<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <% 
    //사용한 입력한 인증번호
    String code = request.getParameter("code");
    
    //랜덤으로 생성된 인증번호값
    String aCode = (String)session.getAttribute("auth_code");
    
    //concert_auth.jsp에서 만든 인증번호 코드는 지역변수라서 
    //페이지를 넘어올 수 없다. 인증번호는 session에 담는 것이 좋다. 
    if(code.equals(aCode)){
    	
    	session.setAttribute("auth_pass",true);
    	response.sendRedirect("concert_reserve.jsp");
    } else{
 %>
    	<script type="text/javascript">
    		alert("인증코드가 일치하지 않습니다. 다시 인증해주세요");
    		history.back();
    	</script>
   <%}%>
