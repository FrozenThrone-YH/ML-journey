<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>    
<%
	//예매가 확정된 좌석정보를 저장할 리스트
	//예약 한번 하고 나면 지역변수 list가 없어진다. 정보를 어디엔가에 백업을 시켜놔야 한다. 
	//브라우저를 닫아도 남아 있을 수 있도록 application에 저장한다. 
	List<String> list = new ArrayList<>();
	
	//예약을 할 때마다 빈 리스트가 계속 갱신되므로 
	//리스트 정보가 있으면, 그 리스트 정보로 갱신시킨다. 
	//null값이 아니면 한번이라도 리스트가 만들어진 것. 
	if (application.getAttribute("complete_list") != null){
		list = (List<String>)application.getAttribute("complete_list");
	}


	//사용자가 예매를 희망하는 좌석정보가 들어있는 배열
	String[] seat = request.getParameterValues("seat");
	
	//예약 선점여부를 확인할 로직
	//예약 확정 전에 임시로 좌석정보를 저장할 리스트 
	List<String> temp = new ArrayList<>();
	
	//몇자리를 예약할 수 있는지의 여뷰를 체크할 변수.
	int count=0;
	for(String s : seat){
		//중복된 예약이 있을 경우 break
		if(list.contains(s)){
			break;
		} else {
			temp.add(s);
			count++;
		}
	}
	//선점이 하나도 안되고 다 임시 리스트에 들어가있는 상황
	if (count==seat.length){
		//addAll()메서드는 리스트 내부에 리스트 객체들을 전부 추가하는 메서드입니다.
		list.addAll(temp);
	}
	
	application.setAttribute("complete_list",list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h2>콘서트 예매 처리 결과</h2>
	<p>
		선택한 좌석 <br>
		<%
			for (String s : seat){
				out.println("<b>["+s+"]<b/>");
				
			}
		
		%>
		<br>가 예매 신청되었습니다.
	</p>
	<p>
		예매 신청 결과 : <%= (count == seat.length) ? "성공" : "실패" %>
		<br>
		<% if(count != seat.length) {%>
			예매하고자 하는 좌석이 이미 선정되었습니다. 
		
		<%} %>
		<br>
		<a href="concert_reserve.jsp">추가 예매하기</a>

</div>



</body>
</html>
