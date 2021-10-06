package bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookshop.vo.AuthorVO;

public class AuthorDAO {
	
	private Connection getconnection() throws SQLException{
		Connection conn = null;
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		}

		return conn;
	}
	
	
	
	public boolean insert(AuthorVO vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn= getconnection();
			//url, 아이디, 비밀번호
			
			System.out.println("연결성공");
			
			//3.SQL문 준비
			String sql = "insert into author values (null , ?)";
			pstmt = conn.prepareStatement(sql);
			
			//4.바인딩
			pstmt.setString(1, vo.getName());
			
			//5. SQL실행
			int count = pstmt.executeUpdate();
			
			//count가 1일때 true로 변경
			result = count == 1;
		
		} catch (SQLException e) {
			System.out.println("SQL 예외 발생 error:" + e);
		}finally {
			
			//clean up 자원정리
			try {
				pstmt.close();
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

	public List<AuthorVO> findAll() {
		
		List<AuthorVO> list = new ArrayList<AuthorVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn= getconnection();
			//url, 아이디, 비밀번호
			
			System.out.println("연결성공");
			
			//3.SQL문 준비
		
			String sql = "select * from author";
			pstmt = conn.prepareStatement(sql);
			
			//4.바인딩
			
			//5. SQL실행
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				Long empNo = rs.getLong(1);
				String firstName = rs.getString(2);
				System.out.println(empNo + " : "+ firstName);
			}
		
		} catch (SQLException e) {
			System.out.println("SQL 예외 발생 error:" + e);
		}finally {
			
			//clean up 자원정리
			try {
				pstmt.close();
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return list;
	}
	
	
}
