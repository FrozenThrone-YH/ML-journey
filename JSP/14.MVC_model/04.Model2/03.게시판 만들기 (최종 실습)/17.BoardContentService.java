package kr.co.koo.izone.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.koo.izone.board.model.BoardDAO;
import kr.co.koo.izone.board.model.BoardVO;

public class BoardContentService implements IBoardService {

	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO dao = BoardDAO.getInstance();
		String bId = request.getParameter("bId");
		
		//dao메서드를 통해 선택된 게시물 정보를 select해서 리턴 받으세요.
		//request객체에 조회된 게시글 정보를 저장하세요. EL 변수 : "content"
		BoardVO contents = dao.getBoardContent(bId);
		request.setAttribute("contents",contents);

	}

}
