package bookmall.main;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVO;

public class BookMall {

	public static void main(String[] args) {
		
		
		//카테고리 insert
		CategoryVO cvo = new CategoryVO();
		cvo.setCategory("소설");
		new CategoryDao().insert(cvo);
		
		//카테고리 findall
		
		
		System.out.println("=======회원리스트======");
		

	}

}
