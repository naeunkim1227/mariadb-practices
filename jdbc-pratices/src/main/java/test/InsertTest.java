package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args) {
		insert("영업");
		insert("개발");
		insert("기획");
	
		
	}

	private static boolean insert(String name) {
		boolean result = false;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//1. JDBC 드라이버 로드
			Class.forName("org.mariadb.jdbc.Driver");
		
			//2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/employees?charset=utf8";
			conn= DriverManager.getConnection(url, "hr" , "hr");
			//url, 아이디, 비밀번호
			
			System.out.println("연결성공");
			
			//3.statement 생성
			stmt = conn.createStatement();
			
			//4. SQL실행
			String sql = "insert into dept values (null , '" + name + "')";
			int count = stmt.executeUpdate(sql);
			
			//count가 1일때 true로 변경
			result = count == 1;
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패" + e);
		}catch (SQLException e) {
			System.out.println("SQL 예외 발생 error:" + e);
		}finally {
			
			//clean up 자원정리
			try {
				stmt.close();
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return result;
		
	}

}
