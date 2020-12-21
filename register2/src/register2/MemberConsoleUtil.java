package register2;

import java.util.Scanner;

public class MemberConsoleUtil {
	
	public Member getNewmember(Scanner sc) {//등록시키기
		
		
		System.out.println("등록할 회원 정보를 입력하세요");
		System.out.print("아이디 :");
		int id = sc.nextInt();
		
		System.out.print("이름 :");
		String name = sc.next();
		
		System.out.print("주소 :");
		String addr =sc.next();
		
		System.out.print("이메일:");
		String email = sc.next();
		
		System.out.print("국가:");
		String nation = sc.next();
		
		System.out.print("나이:");
		int age = sc.nextInt();
		
		Member member = new Member(id, age, name, addr, nation, email);
		
		//return new Member(id, age, name, addr, nation, email);
		return member;
	}
	public void printAddSuccessMessage(Member member) {
		System.out.println(member.getName()+"님 등록성공하였습니다");
	}

	public void printModifySuccessMessage(Member member) {
		
	}
}
