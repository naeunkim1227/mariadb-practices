package bookmall.main;

import java.util.List;
import java.util.Vector;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrderDao;
import bookmall.dao.OrderbookDao;
import bookmall.vo.BookVO;
import bookmall.vo.CartVO;
import bookmall.vo.CategoryVO;
import bookmall.vo.OrderVO;
import bookmall.vo.OrderbookVO;
import bookmall.vo.memberVO;

public class BookMall {

	public static void main(String[] args) {
		
		//Categry table
		CategoryVO cvo = null;
		
		//Categry table -  insert
		
		cvo = new CategoryVO();
		cvo.setCategory("인문");
		new CategoryDao().insert(cvo);
		
		
		//Categry table - findall
		cvo = new CategoryVO();
		System.out.println("=======================카테고리 목록=========================");
		List<CategoryVO> clist =  new CategoryDao().findall();
		for(CategoryVO vo : clist) {
			System.out.println("카테고리 : " + vo.getCategory());

		}
		
		//////////////////////////////////////////////////////////////////
		//Book table
		BookVO bvo = null;
		
		//Book table - insert
		
		bvo = new BookVO();
		bvo.setCategory_no(1);
		bvo.setPrice(26800);
		bvo.setTitle("이것이 땡땡땡이다");
		new BookDao().insert(bvo);
		
		
		//Book table - findall
		bvo = new BookVO();
		System.out.println("=======================책리스트=============================");
		List<BookVO> blist = new BookDao().findAll();
		for(BookVO vo : blist) {
			System.out.println("카테고리 : " + vo.getCategory() + " / 책명 :" + vo.getTitle() + " / 가격 : " + vo.getPrice());
		}
		
		/////////////////////////////////////////////////////////////////
		//Member table
		memberVO mvo = null;
		
		//Member table - insert
		
		mvo = new memberVO();
		
		mvo.setEmail("eeeedddi@daum.net");
		mvo.setName("크롱2");
		mvo.setPassword("1234");
		mvo.setPhone_number("010-1234-4568");
		new MemberDao().insert(mvo);
		
		
		//Member table - findall
		mvo = new memberVO();
		System.out.println("=======================회원리스트===========================");
		List<memberVO> mlist = new MemberDao().findall();
		for(memberVO vo : mlist) {
			System.out.println("회원명 : " + vo.getName() + " / 이메일 :" + vo.getEmail() + " / 전화번호 : " + vo.getPhone_number() + " / 비밀번호 : " + vo.getPassword() );
		}
 		
		///////////////////////////////////////////////////////////////
		//Order table
		OrderVO ovo = null;
		
		//Order table - insert
		ovo = new OrderVO();
		
		ovo.setAddress("부산시 진구2");
		ovo.setMember_no(3);
		ovo.setOrder_money(40000);
		new OrderDao().insert(ovo);
		
		
		//Order table - findall
		Vector alllist1 = new OrderDao().findall();
		
		List<memberVO> mlist1 =  (List<memberVO>) alllist1.get(0);
		List<OrderVO> olist1 = (List<OrderVO>) alllist1.get(1);
		System.out.println("=======================주문 리스트=============================");
		for(int i=0;i<mlist1.size();i++) {
			memberVO mvo1 = mlist1.get(i);
			OrderVO ovo1 = olist1.get(i);
			
			System.out.println("주문 번호 : " + ovo1.getNo() + " / 주문자 : " + mvo1.getName() + " / 주소 : " + ovo1.getAddress() + " / 주문 금액 : " + ovo1.getOrder_money());
		}
		
		///////////////////////////////////////////////////////////////
		//Cart table
		CartVO cavo = null;
		
		//Cart table - insert
		cavo = new CartVO();
		cavo.setBook_no(3);
		cavo.setMember_no(2);
		cavo.setCount(2);
		new CartDao().insert(cavo);
		
		
		//Cart table - findall
		Vector alllist  = new CartDao().findall();
		List<memberVO> mlist2 = (List<memberVO>)alllist.get(0);
		List<BookVO> blist2 = (List<BookVO>) alllist.get(1);
		List<CartVO> clist2 = (List<CartVO>) alllist.get(2);
		
		System.out.println("=======================장바구니 리스트=============================");
		for(int i=0;i<clist2.size();i++){ 
			memberVO mvo2 = (memberVO)(mlist2.get(i));
			BookVO bvo2 = (BookVO)(blist2.get(i));
			CartVO cvo2 = (CartVO)(clist2.get(i));
			
		System.out.println("회원이름 : " + mvo2.getName() +  " / 책 번호 : " + bvo2.getNo() + " / 책 이름 : " + bvo2.getTitle() + " / 수량 : " + cvo2.getCount() + " / 가격 : " + bvo2.getPrice());
			
		}
		///////////////////////////////////////////////////////////////
		//Order_book table
		//insert
		int orderno = 3;
		new OrderbookDao().insert(orderno);
		
		//findall
		List<OrderbookVO> oblist = new OrderbookDao().findall();
		System.out.println("=======================주문 책 리스트=============================");
		for(OrderbookVO vo : oblist) {
			System.out.println(vo);
		}
		
	}

}
