package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CategoryVO;

public class CategoryDao implements Getconn {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = null;
	ResultSet rs = null;
	
	//insert
	public void insert(CategoryVO vo) {
		System.out.println("CategoryDao insert() 실행");
		
		try {
			conn = Getconn.getconnection();
			
			//SQL 준비
			sql = "insert into category values (null, ? )";
			pstmt = conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, vo.getCategory());
			
			//SQL 실행
			pstmt.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//select
	public List<CategoryVO> findall() {
		
		System.out.println("Category findall() 실행");
		
		List<CategoryVO> list = new ArrayList<CategoryVO>();
		
		try {
			conn = Getconn.getconnection();
			
			//sql 준비
			
			sql = "select no,category from category";
			pstmt = conn.prepareStatement(sql);
			//바인딩
			
			
			//실행
			rs = pstmt.executeQuery();	
			
			while(rs.next()) {
				CategoryVO vo = new CategoryVO();
				vo.setNo(rs.getInt(1));
				vo.setCategory(rs.getString(2));
				
				list.add(vo);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
}
