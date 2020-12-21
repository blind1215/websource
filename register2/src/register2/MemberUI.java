package register2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberUI {

	public static void main(String[] args) {
		boolean stop = false;
		Scanner sc = new Scanner(System.in);
		MemberConsoleUtil util = new MemberConsoleUtil();
		List<Member> list = new ArrayList<Member>();
		
		do {
			System.out.println("===== 회원관리 프로그램 =====");
			System.out.println("1. 회원등록 ");
			System.out.println("2. 회원목록보기");
			System.out.println("3. 회원정보수정");
			System.out.println("4. 회원정보삭제");
			System.out.println("5. 프로그램 종료");
			System.out.print("메뉴번호 :");
			int menu = sc.nextInt();
			
			switch (menu) {
			case 1://등록하기
				Member member=util.getNewmember(sc);
				list.add(member);
				util.printAddSuccessMessage(member);
				break;
			case 2://목록보기
				//util.prin
				break;
			case 3://정보수정
				
				break;
			case 4://정보삭제
				
				break;
			case 5://프로그램 종료
				System.out.println("시스템을 종료합니다.");
				stop = true;
				break;

			default:
				System.out.println("사용할 서비스의 번호를 확인해주세요 ");
				break;
			}
		
		} while(!stop);
		

	}

}
