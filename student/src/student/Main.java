package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean end=false;
		Scanner sc = new Scanner(System.in);
		StudentUtil util =new StudentUtil();
	
		
		List<Student> list = new ArrayList<Student>(); 
		
		do {		
			System.out.println("--------- <학생 정보 관리 프로그램> ----------");
			System.out.println("1. 학생정보 입력");
			System.out.println("2. 학생정보 전체 조회");
			System.out.println("3. 학생정보 개별 조회");
			System.out.println("4. 프로그램 종료");
			System.out.print("선택 :");
			int menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				Student student = util.getNewStudent(sc);
				list.add(student);
				util.SuccessMessage(student);
				break;
			case 2:
				util.printStudentList(list);
				break;
			case 3:
				student = util.info(sc, list);		
				break;
			case 4:
				System.out.println("프로그램을 종료");
				end = true;
				break;
			}
			
			
			
			
		}while(!end);

	}

}
