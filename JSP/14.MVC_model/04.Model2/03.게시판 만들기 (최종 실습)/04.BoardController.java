package kr.co.koo.izone_board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.izone")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request,response);
	}
	
	private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get방식이든 post방식이든 어떤 요청이 와도 doRequest로 온다.
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		
		//controller가 안내해줄UI페이지의 경로 정보를 담을 변수.
		String viewPage = null;
		
		if(uri.equals("/izone/board/Blist.izone")) {
			viewPage = "/board/board_list.jsp";
		}
		
		//주소를 가리기 위해서 forwarding 한다.<강제이동>
		//<jsp:forward page=""로 했었음>
		RequestDispatcher dp = request.getRequestDispatcher(viewPage);
		//request와 response를 그대로 보내준다. 
		dp.forward(request, response);
	}

}
