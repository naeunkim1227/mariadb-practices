package bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookshop.vo.AuthorVO;
import bookshop.vo.BookVO;


public class BookDAO {
	
	public boolean insert(BookVO vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			//3. SQL 준비
			String sql = "insert into book values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			//4. 바인딩(binding)
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getStatus());
			pstmt.setLong(3, vo.getAuthorNo());
			
			//5. SQL 실행
			int count = pstmt.executeUpdate();
			
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// clean up
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}

		return conn;
	}

	public void update(Long no, String status) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			//3. SQL 준비
			String sql = "update book set status=? where no=?";
			pstmt = conn.prepareStatement(sql);
			
			//4. 바인딩(binding)
			pstmt.setString(1, status);
			pstmt.setLong(2, no);
			
			
			//5. SQL 실행
			int count = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// clean up
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public List<BookVO> findAll() {
		List<BookVO> result = new ArrayList<BookVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn= getConnection();
			//url, 아이디, 비밀번호
			
			System.out.println("연결성공");
			
			//3.SQL문 준비
			String sql = "select a.no, a.title, a.status, b.name from book a, author b "
					+ "where a.author_no = b.no "
					+ "order by no desc";
			pstmt = conn.prepareStatement(sql);
			
			//4.바인딩
			
			//5. SQL실행
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				Long no = rs.getLong(1);
				String titleString = rs.getString(2);
				String status = rs.getString(3);
				String authorName = rs.getString(4);
				
				BookVO vo = new BookVO();
				vo.setAuthorName(authorName);
				vo.setNo(no);
				vo.setStatus(status);
				vo.setTitle(titleString);
				
				result.add(vo);
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
		
		
		
		return result;
	}

}