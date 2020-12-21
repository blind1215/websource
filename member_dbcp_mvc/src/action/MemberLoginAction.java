package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.MemberVO;
import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberserviceImpl;

@AllArgsConstructor
public class MemberLoginAction implements Action {
	
	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("current_password"); //login의 name 가져오기
		
		MemberService service = new MemberserviceImpl();
		MemberVO member = service.login(userid, password);
		
		HttpSession session = request.getSession();
		session.setAttribute("login", member);
		
		
		return new ActionForward(path,true);// 세션은 리다렉트로 : 아무렇게나 보내도 상관없음 
	}

}
