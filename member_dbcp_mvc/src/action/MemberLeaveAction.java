package action;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.MemberVO;
import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberserviceImpl;

@AllArgsConstructor
public class MemberLeaveAction implements Action {
	
	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String userid =request.getParameter("userid");
		String password = request.getParameter("current_password");
		
		MemberService service = new MemberserviceImpl();//con, dao가져옴
		boolean result=service.leaveMember(userid, password);
		
		if(!result) {//실패하면 일로가고
			path ="view/leaveForm.jsp";
		}else {//성공하면 인발리데이트로 날림 
			HttpSession session = request.getSession();
			session.invalidate();
		}
		
		
		
		return new ActionForward(path,true) ;
	}

}
