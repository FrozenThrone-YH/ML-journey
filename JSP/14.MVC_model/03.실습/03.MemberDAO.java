package kr.co.koo.izone.member.model;

import java.sql.*;
import java.util.*;
import javax.sql.DataSource;
import javax.naming.*;

public class MemberDAO {

	//싱글톤 패턴 
	private static MemberDAO dao = new MemberDAO();
	private DataSource ds;
	
	private MemberDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDAO getInstance() {
		if(dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}
	
	//ID 중복확인을 하는 메서드 선언.
	public boolean confirmId(String id){
		
		boolean flag = false;
		
		String sql = "SELECT user_id FROM izone_member WHERE user_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//결과가 true면 database에 있다는 것이니까
				//중복이다.
				flag = true;
			} else {
				//결과가 false면 database에 없다. 
				flag = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Jdbcutil.close(conn);
			Jdbcutil.close(pstmt);
			Jdbcutil.close(rs);
		}
		return flag;
	}
	
}
