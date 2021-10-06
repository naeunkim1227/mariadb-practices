package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.BookVO;
import bookmall.vo.CategoryVO;

public class CartDaoTest {
	static CategoryVO vo = null;
	static CategoryDao dao = null;
	
	public static void main(String[] args) {
		//insertTest();
		findTest();
	}

	private static void findTest() {
		List<CategoryVO> list = new CategoryDao().findallCte();
		for(CategoryVO vo : list) {
			System.out.println(vo);
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
