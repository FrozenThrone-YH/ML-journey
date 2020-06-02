<%@page import="kr.co.koo.izone.member.model.MemberDAO" %>
<%@page import="kr.co.koo.izone.member.model.MemberVO" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 요청 파라미터 처리 (입력된 id, pw)
	//login_modal.jspf 20번째줄 
	request.setCharacterEncoding("utf-8");
	//javascript에서 ajax로 비동기 통신할때 온 파라미터를 받는다.
	String id = request.getParameter("user_id");
	String pw = request.getParameter("user_pw");
	
	//2. 모델을 찾아 db연동 처리.memberDAO 활용  
	
	MemberDAO dao = MemberDAO.getInstance();
	int rn = dao.userCheck(id,pw);
	//빈문자열 생성
	String str ="";
	
	//3. db처리 결과에 따른 알림창 설정
	/*
	  1) 로그인 성공시 세션에 user_id, user_name이란 이름으로
	         로그인한 회원의 아이디와 이름을 저장 후 홈으로 안내.
      2) 존재하지 않는 회원일 경우 알림창으로 "존재하지 않는 ID입니다."
		 출력 후 뒤로 가기 실행 (history.back())
	  3) 비밀번호가 틀렸을 경우 알림창으로 "비밀번호가 틀렸습니다." 출력 후 
                  뒤로가기 실행.
	*/
	//로그인 성공여부만 체크하면, 회원정보는 어떻게 빼오지?
	//userCheck를 List로 return 해도 되는데,
	//로그인한 회원 정보를 가져오는 메서드를 가져오자(뒤를 생각해서)
	if (rn == MemberDAO.LOGIN_SUCCESS){
		
		MemberVO user = dao.getMemberInfo(id);
		session.setAttribute("user_id",id);
		session.setAttribute("user_name",user.getUserName());
		
		str = "LOGIN_OK";
	} else if (rn == MemberDAO.LOGIN_FAIL_PW){
		str = "NOT_PW";
	} else {
		str = "NOT_ID";
	}
	  out.print(str); //out객체 담으면 통신이 끝난다는 의미 
%>
