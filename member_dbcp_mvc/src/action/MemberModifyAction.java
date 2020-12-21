package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.MemberVO;
import lombok.AllArgsConstructor;
import persistence.MemberDAO;
import service.MemberService;
import service.MemberserviceImpl;


@AllArgsConstructor
public class MemberModifyAction implements Action {
	
	private String path;
	
	

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String current_password = request.getParameter("current_password");
		String new_password = request.getParameter("new_password");
		String confirm_password = request.getParameter("confirm_password");
		
		MemberService service = new MemberserviceImpl();//con1개,dao생성됨
		
		HttpSession session = request.getSession();
		MemberVO vo=(MemberVO)session.getAttribute("login");
		
		//현재 비밀번호가 일치하는지 확인 => isLogin(userid,password)
		MemberVO info = service.login(vo.getUserid(), current_password); //확인해버리고 con을 닫음 
		
		//일치한다면 변경/세션해제/
		if(info!=null) { //서비스는 로그인 쓰고 연결을 닫았기때문에 새로운 객체를 생성해서 service1로 새로 연결을 열었다 닫음
			MemberService service1 = new MemberserviceImpl();//다시 con을 여는 작업을한거임
			// 비밀번호 새로운 걸 안 보내고 기존걸 보내서...안된건 아니니까 세션 해제는 하고 loginForm 으로 움직였던 거에요
			boolean result = service1.updateMember(vo.getUserid(),new_password);
			if(result) {
				session.invalidate();
			}
			
		}else { //실패하면
			path="view/modifyForm.jsp";
		}
		
		
		return new ActionForward(path, true);
	}

}
