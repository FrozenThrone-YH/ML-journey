package kr.co.koo.izone.board.model;

import java.sql.*;
import java.util.*;
import javax.sql.DataSource;
import javax.naming.*;

public class BoardDAO {
	
	//싱글톤 패턴을 사용하여 DAO클래스 설계.
	//커넥션 연동을 생성자에서 처리. 
	private static BoardDAO dao = new BoardDAO();
	private DataSource ds;
	
	private BoardDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}

}
