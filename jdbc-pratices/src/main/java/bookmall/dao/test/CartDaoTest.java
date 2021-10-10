package bookmall.dao.test;

import java.util.List;
import java.util.Vector;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.vo.BookVO;
import bookmall.vo.CartVO;
import bookmall.vo.CategoryVO;
import bookmall.vo.memberVO;

public class CartDaoTest {
	static CategoryVO vo = null;
	static CategoryDao dao = null;
	
	public static void main(String[] args) {
		//insertTest();
		findTest();
	}

	private static void findTest() {
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
		
	}

	private static void insertTest() {
		vo = null;
		dao = new CategoryDao();

		vo = new CategoryVO();
		vo.setCategory("IT");
		dao.insert(vo);
	
		
	}

}
