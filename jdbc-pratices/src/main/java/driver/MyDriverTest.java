package driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//드라이버 원리 이해 실습
public class MyDriverTest {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			
			//1. JDBC Driver 로딩
			Class.forName("driver.MyDriver");
			
			//2. 연결
			String url = "jdbc:mydb://127.0.0.1:2204/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			//3.연결 성공
			System.out.println("4- 연결 성공 : " + conn );
			
		
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("SQL error : " + e);
		}finally {
				try {
					if(conn != null) {
					conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}

}
