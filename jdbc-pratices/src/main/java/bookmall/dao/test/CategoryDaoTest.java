package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVO;

public class CategoryDaoTest {

	public static void main(String[] args) {
		//insertTest();
		findallTest();
		
	}

	private static void insertTest() {
		CategoryVO vo =  new CategoryVO();
		CategoryDao dao = new CategoryDao();
		
		vo.setCategory("수학");
		dao.insert(vo);
	}

	private static void findallTest() {
		CategoryVO cvo = new CategoryVO();
		System.out.println("=======================카테고리 목록=========================");
		List<CategoryVO> clist =  new CategoryDao().findall();
		
		for(CategoryVO vo : clist) {
			System.out.println("카테고리 : " + vo.getCategory());

		}
	}


}
