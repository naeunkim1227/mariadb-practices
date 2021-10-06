package bookshop.dao.test;

import java.util.List;

import bookshop.dao.AuthorDAO;
import bookshop.vo.AuthorVO;

public class AuthorDaoTest {

	public static void main(String[] args) {
		// insertTest();
		findAllTest();
	}

	private static void findAllTest() {
		List<AuthorVO> list = new AuthorDAO().findAll();
		for(AuthorVO vo : list) {
			System.out.println(vo);
		}
	}

	private static void insertTest() {
		AuthorVO vo = null;
		AuthorDAO dao = new AuthorDAO();
		
		vo = new AuthorVO();
		vo.setName("스테파니메이어");
		dao.insert(vo);
		
		vo = new AuthorVO();
		vo.setName("조정래");
		dao.insert(vo);
		
		vo = new AuthorVO();
		vo.setName("김동인");
		dao.insert(vo);

		vo = new AuthorVO();
		vo.setName("김난도");
		dao.insert(vo);

		vo = new AuthorVO();
		vo.setName("천상병");
		dao.insert(vo);

		vo = new AuthorVO();
		vo.setName("조정래");
		dao.insert(vo);

		vo = new AuthorVO();
		vo.setName("원수연");
		dao.insert(vo);
	}

}