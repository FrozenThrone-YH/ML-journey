/*
  * 데이터 베이스와 JAVA의 연결 순서
  1. JDBC 드라이버 로드
  2. 데이터베이스 Connection 객체 생성
  3. 쿼리문 실행을 위한 Statement 객체 생성.
  4. 쿼리문을 실행
  5. ResultSet객체를 통해 쿼리문 실행 결과값을 소비.
  6. Statement 객체 종료
  7. 데이터베이스 Connection 객체 종료 

*/


package kr.co.hee.jdbc.basic;

import java.sql.*;
import java.util.Scanner;

public class JdbcInsert {
	
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	System.out.println("# 회원정보 입력을 시작합니다.");
	System.out.println("* 아이디 : ");
	String id = sc.next();
	
	System.out.println("* 비밀번호 : ");
	String pw = sc.next();
	
	System.out.println("* 이름 : ");
	String name = sc.next();
	
	System.out.println("* 이메일 : ");
	String email = sc.next();
	
	//Insert문을 java로 구현한다. 
	//DB연동 순서
	//1. DB사용자 계정명과 암호, DB URL등 초기 데이터 변수를 설정
	String uid = "jsp";
	String upw = "jsp";
	String url = "jdbc:mysql://localhost:3306/jsp_practice"; 
	//데이터베이스도 URL을 통해 데이터 베이스들을 구분합니다. 
	//jsp_practice : create database 할때의 이름 
	
	//2. JDBC 커넥터 드라이버 호출
	//빨간줄이 뜨는 이유는? class에 throws가 있어서 예외처리를 해야한다. 
	Connection conn = null;
	Statement stmt = null;
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		//3. DB연동을 위한 클래스들의 객체를 생성.
		/*
		  # a - Connection 객체 
		   : DB와의 연결을 위한 객체. Connection객체를 생성하려면
		   직접 new연산자를 통해 객체를 생성할 수 없고(Connection은 interface이다)
		  DriverManager클래스가 제공하는 정적 메서드 
		  GetConnection()을 호출하여 객체를 생성합니다.
		  import java.sql.*;을 해줘야 한다.   
		  getConnection은 DB연동이 완료된 Connection 객체를 return한다. 
		 */
		conn = DriverManager.getConnection(url, uid, upw);
		
		/*
		  # b- Statement 객체;
		  	SQL문 실행을 위한 객체.
		  	Statement 객체는 Connection객체가 제공하는
		  	createStatement()메서드를 호출하여 생성합니다. (얘도 인터페이스라서 new로 못만든다.)
		 */
		stmt = conn.createStatement();
		
		/*
		  # c- SQL문 작성
		   SQL문은 String형태로 작성합니다.
		 */
		String sql = "INSERT INTO member VALUES"
				+ "('"+id+"','"+pw+"','"+name+"','"+email+"')";
		
		/*
		  # d - Statement객체를 통한 SQL문 실행
		  1. insert, update, delete명령일 경우 
		    executeUpdate()를 호출합니다.
		  2. select 명령일 경우 executeQuery()를 호출합니다. 
		  
		   ★ 이게 왜 나뉘어져있을까? 
		   : select는 조회결과를 알려준다. return 값이 다르다.  
		  3. executeUpdate는 실행 성공시 성공한 쿼리의 개수를, 실패시 0을 리턴합니다.
		 */
		
		int resultNum = stmt.executeUpdate(sql);
		if (resultNum ==1) {
			System.out.println("DB에 회원정보를 저장성공!");
		} else {
			System.out.println("DB에 회원정보 저장 실패! ");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		/*
		 4. DB연동 객체들 자원 반납
		  - 원활한 JDBC프로그래밍을 위해 사용한 자원들을 반납합니다.
		 */
		try{
			conn.close(); stmt.close(); sc.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	}
}
	

