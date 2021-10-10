package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrderbookDao;
import bookmall.vo.OrderbookVO;

public class OrderbookDaoTest {

	public static void main(String[] args) {
		//insertTest();
		
		findall();
	}

	private static void findall() {
		List<OrderbookVO> oblist = new OrderbookDao().findall();
		for(OrderbookVO vo : oblist) {
			System.out.println(vo);
		}
		
		
	}

	private static void insertTest() {
		int no = 2;
		new OrderbookDao().insert(no);
	}

}
