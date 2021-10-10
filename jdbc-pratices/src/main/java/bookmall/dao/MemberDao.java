package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.memberVO;

public class MemberDao implements Getconn{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	//insert
	public void insert(memberVO vo) {
		System.out.println("MemberDao insert 메서드 실행");
		
		try {
			conn = Getconn.getconnection();
			
			//sql작성
			sql = "insert into member values (null,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			//바인딩
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPhone_number());
			pstmt.setString(4, vo.getPassword());
			
			//sql 실행
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//select
	public List<memberVO> findall() {
		
		System.out.println("MemberDao findall() 실행");
		List<memberVO> list = new ArrayList<memberVO>();
		
		try {
			conn = Getconn.getconnection();
			
			//sql 구문 작성
			sql = "select name,email,phone_number, password from member";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				memberVO vo = new memberVO();
				vo.setName(rs.getString(1));
				vo.setEmail(rs.getString(2));
				vo.setPhone_number(rs.getString(3));
				vo.setPassword(rs.getString(4));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	} 
	
	
}
