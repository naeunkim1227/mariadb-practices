package bookmall.dao.test;

import java.util.List;

import bookmall.dao.MemberDao;
import bookmall.vo.memberVO;

public class MemberDaoTest {

	public static void main(String[] args) {
		//insertTest();
		findallTest();

	}

	private static void	insertTest() {
		memberVO mvo = new memberVO();
		
		mvo.setEmail("eeeedddi@daum.net");
		mvo.setName("크롱");
		mvo.setPassword("1234");
		mvo.setPhone_number("010-1234-4568");
		new MemberDao().insert(mvo);
	
	}

	private static void	findallTest() {
		memberVO mvo = new memberVO();
		System.out.println("=======================회원리스트===========================");
		List<memberVO> mlist = new MemberDao().findall();
		for(memberVO vo : mlist) {
			System.out.println("회원명 : " + vo.getName() + " / 이메일 :" + vo.getEmail() + " / 전화번호 : " + vo.getPhone_number() + " / 비밀번호 : " + vo.getPassword() );
		}	
	}

}
