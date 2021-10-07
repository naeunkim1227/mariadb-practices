package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.BookVO;

public class BookDao implements Getconn {
	static Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = null;
	ResultSet rs = null;
	
	// insert 
	public void insert(BookVO vo) {
		try {
			conn = Getconn.getconnection();
			
			//SQL 준비
			sql = "insert into book values (null, ? , ? , ?)";
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
	
	//select
	public List<BookVO> findAll() {
		List<BookVO> list = new ArrayList<BookVO>();
		
		try {
			conn = Getconn.getconnection();
			
			sql = "select a.title, a.price, b.category "
					+ "from book a join category b on a.category_no = b.no";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookVO vo = new BookVO();
				vo.setTitle(rs.getString(1));
				vo.setPrice(rs.getInt(2));
				vo.setCategory(rs.getString(3));
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	//update
	public static void updateBook() {
		
		try {
			conn = Getconn.getconnection();
			
			//sql
			sql = "update book set ";
			"update dept set name=? where no=?"
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
		
	
	
}
