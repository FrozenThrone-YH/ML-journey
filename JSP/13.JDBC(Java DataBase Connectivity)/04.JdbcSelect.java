package kr.co.hee.jdbc.basic;

import java.sql.*;

public class JdbcSelect {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jsp_practice";
		String uid = "jsp";
		String upw = "jsp"; 
		
		String sql ="SELECT * FROM member";
		
		Connection conn=null;
		Statement stmt = null;
		ResultSet rs = null; //select 문에서만 사용하는 객체.
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,uid,upw);
			stmt = conn.createStatement();
			
			//select는 표가 뜨니까 결과값이 있다. 
			//결과값을 어딘가에 담아서 리턴해줘야 한다. 
			//return type이 ResultSet이다. 
			rs = stmt.executeQuery(sql);
			
			//rs.next();를하면 첫번째 row가 조회된다. (커서라고 생각하면 된다.) 
			//rs.getString("column 명을 주면 여기서는 id ") id를 얻을 수 있다. 
			//만약 int로 지정되어 있으면 rs.getInt()를 하면 된다. 
			//한번더 rs.next();를 하면 다음 row로 간다. 
			//만약 다음줄이 없다면 false를 return 한다. 
			
			/*
			 * select쿼리문의 실행결과 데이터가 한 줄이라도 존재한다면
			 * rs.next()메서드는 true를 리턴하며, 해당 행을 지목합니다. 
			 */
			System.out.println("==================================================");
			//다음줄에 데이터가 없으면 rs.next()는 false가 뜨기 때문에 
			//데이터가 없으면 while문은 종료 
			while (rs.next()) {
			/*
			 * select의 실행 결과의 컬럼 레코드를 읽어오려면
			 * getString(),getInt()등의 메서드를 사용합니다.
			 * 해당 메서드의 매개값으로 읽어올 테이블의 컬럼명을 지정합니다. 
			 */
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			String email = rs.getString("email");
			
			System.out.printf("# 아이디 : %s, # 비번 : %s, # 이름 : %s, # 이메일 : %s\n",id,pw,name,email);}
			System.out.println("==================================================");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); stmt.close(); rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
