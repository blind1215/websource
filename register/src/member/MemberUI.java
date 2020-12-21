package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberUI {

	public static void main(String[] args) {
		boolean isStop = false; // 반복문을 종료 
		
		Scanner sc = new Scanner(System.in); // 키보드에서 입력을 받기 위해 사용
		MemberConsoleUtil util = new MemberConsoleUtil(); //콘솔에생성하고 받고 
		List<Member> list = new ArrayList<Member>();
		
		
		do {
			System.out.println("===== 회원가입 프로그램 =====");
			System.out.println("1. 회원등록");
			System.out.println("2. 회원목록보기");
			System.out.println("3. 회원정보수정");
			System.out.println("4. 회원정보삭제");
			System.out.println("5. 프로그램종료");
			System.out.print("메뉴번호 : ");
			//사용자한테 번호 입력받기
			int menu = sc.nextInt();
			
			
			//메뉴번호에 따라 출력문 제시 
			switch (menu) {
			case 1://회원등록
				Member member = util.getNewmember(sc);
				list.add(member);
				util.printAddSuccessMessage(member);
				break;
			case 2:
				util.printMemberList(list);
				break;
			case 3:
				member=util.getUpdateMember(sc, list);
				if(member==null) {
					util.printModifyFailMessage();
				}else {
					util.printModifySuccessMessage(member);
				}
				break;
			case 4:
				member= util.removeMember(sc, list);
				if(member==null) {
					util.printRemoveFailMessage();
				}else {
					util.printRemoveSuccessMessage();
				}
							
				break;
			case 5://프로그램 종료
				System.out.println("프로그램 종료");
				isStop = true;
				break;
			default:
				System.out.println("사용할 서비스의 번호를 확인해주세요 ");
				break;
			}
			
		}while(!isStop);
	}

}
