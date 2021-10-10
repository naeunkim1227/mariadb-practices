package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.mariadb.jdbc.internal.com.send.authentication.OldPasswordPlugin;

import bookmall.vo.OrderVO;
import bookmall.vo.memberVO;

public class OrderDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	
	//insert
	public void insert(OrderVO vo) {
		
		System.out.println("OrderDao insert() 실행");
		
		try {
			conn = Getconn.getconnection();

			sql = "insert into bookmall.order values (null,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getNo());
			pstmt.setInt(2, vo.getOrder_money());
			pstmt.setString(3, vo.getAddress());
			pstmt.setInt(4, vo.getMember_no());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//select
	public Vector findall(){
		Vector alllist = new Vector();
		List<OrderVO> olist = new ArrayList<OrderVO>();
		List<memberVO> mlist = new ArrayList<memberVO>();
		
		try {
			System.out.println("OrderDao findall() 실행");
			conn = Getconn.getconnection();
			
			sql = "select a.no,a.address,a.order_money, a.member_no ,b.name "
					+ "from bookmall.order a join member b on a.member_no = b.no";
			
			pstmt =conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				OrderVO ovo = new OrderVO();
				memberVO mvo = new memberVO();
				
				ovo.setNo(rs.getInt(1));
				ovo.setAddress(rs.getString(2));
				ovo.setOrder_money(rs.getInt(3));
				ovo.setMember_no(rs.getInt(4));
				mvo.setName(rs.getString(5));
				
				olist.add(ovo);
				mlist.add(mvo);
			}
			
			alllist.add(mlist);
			alllist.add(olist);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alllist;
	}
	
	
}
