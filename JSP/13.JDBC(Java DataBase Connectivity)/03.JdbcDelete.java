package kr.co.hee.jdbc.basic;

import java.sql.*;
import java.util.Scanner;

public class JdbcDelete {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("삭제할 회원의 ID를 입력하세요 : ");
		System.out.print("> ");
		
		String id = sc.next();
		
		String uid = "jsp"; //root 
		String upw = "jsp"; //mysql로 해도 된다. 내가 관리자니까
		String url = "jdbc:mysql://localhost:3306/jsp_practice"; 
		
		Connection conn = null;
		Statement stmt = null;
		
		String sql = "DELETE FROM member WHERE id='"+ id + "'";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			stmt = conn.createStatement();
			int resultNum = stmt.executeUpdate(sql);
			
			if (resultNum ==1) {
				System.out.println("회원ID: "+id+"이(가) 정상적으로 삭제되었습니다.");
			} else {
				System.out.println("삭제에 실패했습니다. ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try{
				conn.close(); stmt.close(); sc.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}
