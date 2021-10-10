package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVO;

public class BookDaoTest {

	public static void main(String[] args) {
		//insertTest();
		
		findall();
	}

	private static void insertTest() {
		BookVO vo = null;
		BookDao dao = new BookDao();
		
		vo = new BookVO();
		vo.setCategory_no(1);
		vo.setPrice(19400);
		vo.setTitle("바깥은 여름");
		dao.insert(vo);
	}
	
	public static void findall() {
		BookVO bvo = new BookVO();
		System.out.println("=======================책리스트=============================");
		List<BookVO> blist = new BookDao().findAll();
		for(BookVO vo : blist) {
			System.out.println("카테고리 : " + vo.getCategory() + " / 책명 :" + vo.getTitle() + " / 가격 : " + vo.getPrice());
		}
		
	}
}
