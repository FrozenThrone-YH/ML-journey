package kr.co.koo.izone_board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.koo.izone.board.model.BoardDAO;
import kr.co.koo.izone.board.service.IBoardService;

public class BoardDeleteService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bNum = request.getParameter("bId");
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteArticle(bNum);

	}

}
