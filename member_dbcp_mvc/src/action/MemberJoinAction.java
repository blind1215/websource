package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import domain.MemberVO;
import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberserviceImpl;

@AllArgsConstructor
public class MemberJoinAction implements Action {
	
	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberVO member = new MemberVO();
		
		member.setUserid(request.getParameter("userid"));
		member.setPassword(request.getParameter("password"));
		member.setPassword(request.getParameter("confirm_password"));
		member.setName(request.getParameter("name"));
		member.setGender(request.getParameter("gender"));
		member.setEmail(request.getParameter("email"));
		
		MemberService service = new MemberserviceImpl(); //con ,dao 
		boolean result = service.registerMember(member);
		
		if(!result) {
			path = "view/joinForm.jsp";
		}
		
		return new ActionForward(path, true);
	}

}
