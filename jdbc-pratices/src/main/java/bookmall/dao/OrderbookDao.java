package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.OrderbookVO;

public class OrderbookDao implements Getconn{
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = null;
	ResultSet rs = null;
	
	public void insert(int no) {
		List list = new ArrayList();
		System.out.println("OrderbookDao insert() 실행");
		try {
			conn = Getconn.getconnection();
			
			sql = "select a.no, d.no, c.count, d.price from bookmall.order a "
					+ "join member b on a.member_no = b.no join cart c on b.no = c.member_no "
					+ "join book d on c.book_no = d.no where a.no = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderbookVO vo = new OrderbookVO();
				vo.setOrder_no(rs.getInt(1));
				vo.setBook_no(rs.getInt(2));
				vo.setOrder_book_count(rs.getInt(3));
				vo.setOrder_book_price(rs.getInt(4));
				
				list.add(vo);
			}
			
			String sql2 = "insert into order_book(order_no,book_no,order_book_cnt,order_book_price) "
					+ "values (? ,? , ?, ?)";
			
			Connection conn2 = Getconn.getconnection();
			
			PreparedStatement pstmt2 = conn2.prepareStatement(sql2);
			
			OrderbookVO vo3 = new OrderbookVO();
			for(int i=0;i<list.size();i++) {
				OrderbookVO vo2 = new OrderbookVO();
				vo2 = (OrderbookVO) list.get(i);
				
				pstmt2.setInt(1, vo2.getOrder_no());
				pstmt2.setInt(2, vo2.getBook_no());
				pstmt2.setInt(3, vo2.getOrder_book_count());
				pstmt2.setInt(4, vo2.getOrder_book_price());
			}
			
			pstmt2.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public List<OrderbookVO> findall(){
		List<OrderbookVO> list = new ArrayList<OrderbookVO>();
		System.out.println("OrderbookDao findall() 실행");
		try {
			conn = Getconn.getconnection();
			
			sql = "select order_no,book_no,order_book_cnt, order_book_price from order_book";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderbookVO vo  = new OrderbookVO();
				vo.setOrder_no(rs.getInt(1));
				vo.setBook_no(rs.getInt(2));
				vo.setOrder_book_count(rs.getInt(3));
				vo.setOrder_book_price(rs.getInt(4));
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
}
