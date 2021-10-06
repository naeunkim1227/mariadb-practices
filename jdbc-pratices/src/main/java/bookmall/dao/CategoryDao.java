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

	public void insert(CategoryVO vo) {
		System.out.println("CategoryDao insert() 실행");
		
		try {
			conn = Getconn.getconnection();
			
			//SQL 준비
			sql = "insert into category values (null, ? )";
			pstmt = conn.prepareStatement(sql);
			System.out.println("1. sql 구문 작성 완료");
			
			//바인딩
			pstmt.setString(1, vo.getCategory());
			System.out.println("2. sql 바인딩 완료");
			
			//SQL 실행
			pstmt.executeUpdate();
			System.out.println("3. sql 실행 완료");
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public List<CategoryVO> findallCte() {
		
		System.out.println("Category findallcategory 메소드 실행");
		
		List<CategoryVO> list = new ArrayList<CategoryVO>();
		
		try {
			conn = Getconn.getconnection();
			
			//sql 준비
			
			sql = "select no,category from category";
			pstmt = conn.prepareStatement(sql);
			System.out.println("1. sql 구문 작성 완료");
			//바인딩
			
			
			//실행
			rs = pstmt.executeQuery();	
			System.out.println("3. sql 실행 완료");
			
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
