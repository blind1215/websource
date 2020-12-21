package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserVO;
import service.UserService;
import service.UserserviceImpl;

public class UserSelectAction implements Action {
	
	private String path;
	
	public UserSelectAction(String path) {
		this.path=path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		
		UserService service =new UserserviceImpl();
		UserVO user=service.getUser(no);
		
		request.setAttribute("vo", user);
		
		return new ActionForward(path,false);
	}

}
