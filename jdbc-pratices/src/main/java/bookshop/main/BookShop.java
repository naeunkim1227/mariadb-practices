package bookshop.main;

import java.util.List;
import java.util.Scanner;

import bookshop.dao.BookDAO;
import bookshop.vo.BookVO;

public class BookShop {

	public static void main(String[] args) {
		displayBookInfo();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("대여하고 싶은 책의 번호를 입력하세요");
		
		Long no = scanner.nextLong();
		scanner.close();
		
		new BookDAO().update(no, "대여중");
		
		displayBookInfo();
	}

	private static void displayBookInfo() {
		System.out.println("****도서 정보 출력****");
		
		List<BookVO> list = new BookDAO().findAll();
		
		for(BookVO vo : list) {
			String.format("[%d] 제목:%s, 작가:%s, 대여유무:%s", vo.getNo(), vo.getTitle() , vo.getAuthorName(), vo.getStatus());
			System.out.println(list);
		}
		
		
	}

}
