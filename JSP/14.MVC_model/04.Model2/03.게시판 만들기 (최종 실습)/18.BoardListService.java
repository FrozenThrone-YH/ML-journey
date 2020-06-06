package kr.co.koo.izone.board.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.koo.izone.board.model.BoardDAO;
import kr.co.koo.izone.board.model.BoardVO;

public class BoardListService implements IBoardService{
	
	public void execute(HttpServletRequest request,HttpServletResponse Response) {
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> articles = dao.getBoardArticles();
		//List를 request객체에 담아 포워드로 넘긴다. 
		request.setAttribute("articles",articles);
	
	}

}
