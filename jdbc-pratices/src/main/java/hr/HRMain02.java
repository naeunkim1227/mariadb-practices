package hr;

import java.util.List;
import java.util.Scanner;

public class HRMain02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("salary[min max]>");
		
		int minSalary = scanner.nextInt();
		int maxSalary = scanner.nextInt();
		
		EmployeeDAO dao = new EmployeeDAO();
		List<EmployeeVO> result = dao.findBySalary(minSalary, maxSalary);
		
		for(EmployeeVO vo : result) {
			System.out.println("[emp_no: " + vo.getEmp_no() + " / name : " + vo.getFirstName() + " "+   vo.getLastName() + " / Salary: " + vo.getSalary() + "]");
		}
		
		scanner.close();
		
	}

}
