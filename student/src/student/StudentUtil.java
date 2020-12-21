package student;

import java.util.List;
import java.util.Scanner;

public class StudentUtil {
	
	public Student getNewStudent(Scanner sc) {
		
		System.out.println("---- 새로운 학생 정보 입력 ----");
		System.out.print("학 번 : ");
		int classNum = sc.nextInt();
		
		System.out.print("이 름 : ");
		String name = sc.next();
		
		System.out.print("학 년 : ");
		int year = sc.nextInt();
		
		System.out.print("주 소 : ");
		String addr = sc.nextLine();
		
		sc.next();
		
		System.out.print("생일(예시 : 05/11) : ");
		String birthday = sc.nextLine();
		
		
		
		

		return new Student(classNum, year, name, addr, birthday);
		
		
	}
	
	public void SuccessMessage(Student student) {
		System.out.println(student.getName() + " 학생 정보가 입력되었습니다.");
	}
	
	public void printStudentList(List<Student> list) {
		System.out.println("----- 학생 정보 보기 -----");
		System.out.println("학 번 \t 이 름 \t 학 년 \t ");
		System.out.println("----------------------");
		
		for(Student student:list) {
			System.out.printf("%3d",student.getClassNum());
			System.out.printf("%7s",student.getName());
			System.out.printf("%7d",student.getYear());
			System.out.println();
		}
	}
	public Student  info(Scanner sc ,List<Student> list) {
		System.out.print("검색하고자 하는 학생의 학번을 입력하세요");
		int classNum = sc.nextInt();
		
		Student student = null;
		for(int i = 0 ; i<list.size();i++) {
			student = list.get(i);
			if(student.getClassNum() == classNum) {
				System.out.println("---- 학생 개별 정보 보기 ----");
				System.out.println("이름 : "+student.getName());
				System.out.println("학년 : "+student.getYear());
				System.out.println("주소 : "+student.getAddr()); 
				//위에 scanner받는부분 next()로 받으면 떠요 대신 띄어쓰기가안돼요
				//이상태에선 주소부분이 안뜹니다 ㅠ
				System.out.println("생일 : "+student.getBirthday());
				
				return student;
		
		}
	} 
	return null;
	}


}
