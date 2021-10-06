package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bookmall.vo.BookVO;

public class BookDao implements Getconn {
	
	public void insert(BookVO vo) {
		System.out.println("BookDao insert() 실행");
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = Getconn.getconnection();
			
			//SQL 준비
			String sql = "insert into book values (null, ? , ? , ?)";
			pstmt = conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getCategory_no());
			
			//SQL 실행
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void findAll() {
		
	}

		
	
	
}
