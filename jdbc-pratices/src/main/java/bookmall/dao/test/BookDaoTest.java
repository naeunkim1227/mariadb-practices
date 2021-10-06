package bookmall.dao.test;

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
	
	public void findall() {
		
	}
}
