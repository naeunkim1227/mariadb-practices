package bookmall.dao.test;

import java.util.List;
import java.util.Vector;

import bookmall.dao.OrderDao;
import bookmall.vo.OrderVO;
import bookmall.vo.memberVO;

public class OrderDaoTest {

	public static void main(String[] args) {
		// insertTest();
		findallTest();

	}

	private static void insertTest() {
		OrderVO ovo = new OrderVO();

		ovo.setAddress("부산시 진구2");
		ovo.setMember_no(3);
		ovo.setOrder_money(40000);
		ovo.setOrder_no(3);
		new OrderDao().insert(ovo);

	}

	private static void findallTest() {
		Vector alllist1 = new OrderDao().findall();
		
		List<memberVO> mlist1 =  (List<memberVO>) alllist1.get(0);
		List<OrderVO> olist1 = (List<OrderVO>) alllist1.get(1);
		System.out.println("=======================주문 리스트=============================");
		for(int i=0;i<mlist1.size();i++) {
			memberVO mvo1 = mlist1.get(i);
			OrderVO ovo1 = olist1.get(i);
			
			System.out.println("주문 번호 : " + ovo1.getOrder_no() + " / 주문자 : " + mvo1.getName() + " / 주소 : " + ovo1.getAddress() + " / 주문 금액 : " + ovo1.getOrder_money());
		}

	}

}
