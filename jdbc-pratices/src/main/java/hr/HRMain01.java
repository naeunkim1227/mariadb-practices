package hr;

import java.util.List;
import java.util.Scanner;

public class HRMain01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름>");
		String name = scanner.nextLine();
		
		EmployeeDAO dao = new EmployeeDAO();
		List<EmployeeVO> result = dao.findByName(name);
		
		for(EmployeeVO vo : result) {
			System.out.println(vo.getEmp_no() + ":" + vo.getFirstName() + ":" + vo.getLastName() + ":" + vo.getHireDate());
		}
		
		scanner.close();
		
	}

}
