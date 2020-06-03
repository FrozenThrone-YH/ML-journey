package kr.co.koo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//*.do -> do로 끝나는 것은 내가 다 받겠다.
// 그럼 어떻게 login.do와 join.do를 어떻게 구분하나?
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("get요청발생!");
		
		String uri = request.getRequestURI();
		System.out.println("요청 uri: " + uri);
		String conPath = request.getContextPath();
		System.out.println("컨텍스트 경로: "+conPath);
		String com = uri.substring(conPath.length());
		System.out.println("uri - conPath:"+ com);
		
		if(com.equals("/join.do")) {
			System.out.println("회원가입 요청이 들어옴!");
		} else if(com.equals("/login.do")) {
			System.out.println("로그인 요청이 들어옴!");
		} else if(com.equals("/update.do")) {
			System.out.println("정보수정 요청이 들어옴!");
		} else if(com.equals("/delete.do")) {
			System.out.println("회원탈퇴 요청이 들어옴!");
		} 
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		doGet(request, response);
	}

}
