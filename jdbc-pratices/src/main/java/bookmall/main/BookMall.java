package bookmall.main;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.vo.BookVO;
import bookmall.vo.CategoryVO;
import bookmall.vo.memberVO;

public class BookMall {

	public static void main(String[] args) {
		
		//Categry table
		CategoryVO cvo = null;
		
		//Categry table -  insert
		/*
		cvo = new CategoryVO();
		cvo.setCategory("과학");
		new CategoryDao().insert(cvo);
		*/
		
		//Categry table - findall
		cvo = new CategoryVO();
		List<CategoryVO> clist =  new CategoryDao().findallCte();
		for(CategoryVO vo : clist) {
			System.out.println(vo);
		}
		
		//////////////////////////////////////////////////////////////////
		//Book table
		BookVO bvo = null;
		
		//Book table - insert
		/*
		bvo = new BookVO();
		bvo.setCategory_no(1);
		bvo.setPrice(26800);
		bvo.setTitle("이것이 우분투 리눅스다");
		new BookDao().insert(bvo);
		*/
		
		//Book table - findall
		bvo = new BookVO();
		List<BookVO> blist = new BookDao().findAll();
		for(BookVO vo : blist) {
			System.out.println(vo);
		}
		
		/////////////////////////////////////////////////////////////////
		//Member table
		memberVO mvo = null;
		
		//Member table - insert
		mvo = new memberVO();
		
		mvo.setEmail("qwerty@daum.net");
		mvo.setName("김길동");
		mvo.setPassword("1234");
		mvo.setPhone_number("010-1234-4568");
		new MemberDao().insert(mvo);
		
		
		//Member table - findall
		
		///////////////////////////////////////////////////////////////
		//Order table

		//Order table - insert
		
		//Order table - findall
		
		///////////////////////////////////////////////////////////////
		//Cart table
		
		//Cart table - insert
		
		//Cart table - findall
		///////////////////////////////////////////////////////////////
		System.out.println("=======회원리스트======");
		

	}

}
