package kr.co.koo.izone.board.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.co.koo.izone.board.model.BoardDAO;
import kr.co.koo.izone.board.model.BoardVO;

public class BoardWriteService implements IBoardService{

	public void execute(HttpServletRequest request,HttpServletResponse Response) {
		
		BoardDAO dao = BoardDAO.getInstance();
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		//DAO를 통해 DB로직 처리 
		dao.write(bName, bTitle, bContent);
	}
	
}
