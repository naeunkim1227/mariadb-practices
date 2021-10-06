package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bookmall.vo.memberVO;

public class MemberDao implements Getconn{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	public void insert(memberVO vo) {
		System.out.println("MemberDao insert 메서드 실행");
		
		try {
			conn = Getconn.getconnection();
			
			//sql작성
			sql = "insert into member values (null,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			System.out.println("1. sql 작성");

			//바인딩
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPhone_number());
			pstmt.setString(4, vo.getPassword());
			System.out.println("2. 바인딩 완료");
			
			//sql 실행
			pstmt.executeUpdate();
			System.out.println("3. sql 실행");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<memberVO> findmember() {
		
		System.out.println("MemberDao findmember메서드 실행");
		List<memberVO> list = null;
		
		try {
			//sql 구문 작성
			sql = "select name,emiail,phone_number, password from member";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//sql 실행
		
		
		
		
		
		
		
		
		return list;
	} 
	
	
}
