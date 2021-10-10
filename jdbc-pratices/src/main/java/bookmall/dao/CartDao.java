package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import bookmall.vo.BookVO;
import bookmall.vo.CartVO;
import bookmall.vo.memberVO;

public class CartDao {
 Connection conn = null;
 PreparedStatement pstmt = null;
 String sql = null;
 ResultSet rs = null;
 
 //insert
 public void insert(CartVO vo) {
	 System.out.println("CartDao ");
	 
	 try {
		 System.out.println("CartDao insert() 실행");
		conn = Getconn.getconnection();
		
		sql = "insert into cart values (null,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setLong(1, vo.getBook_no());
		pstmt.setLong(2, vo.getMember_no());
		pstmt.setLong(3, vo.getCount());
		
		pstmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 
 }
 
 //select
 public Vector findall(){
	 Vector alllist = new Vector();
	 List<CartVO> clist = new ArrayList<CartVO>();
	 List<memberVO> mlist = new ArrayList<memberVO>();
	 List<BookVO> blist = new ArrayList<BookVO>();
	 
	 try {
		conn = Getconn.getconnection();
		
		sql = "select a.member_no ,b.name,a.book_no ,c.title, a.count , c.price "
				+ "from cart a "
				+ "join member b on b.no = a.member_no "
				+ "join book c on a.book_no = c.no";
		
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			CartVO cvo = new CartVO();
			memberVO mvo = new memberVO();
			BookVO bvo = new BookVO();
			
			cvo.setMember_no(rs.getInt(1));
			mvo.setName(rs.getString(2));
			bvo.setNo(rs.getInt(3));
			bvo.setTitle(rs.getString(4));
			cvo.setCount(rs.getInt(5));
			bvo.setPrice(rs.getInt(6));
			
			mlist.add(mvo);
			blist.add(bvo);
			clist.add(cvo);
		}
			alllist.add(mlist);
			alllist.add(blist);
			alllist.add(clist);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return alllist;
 }
 
 
}
