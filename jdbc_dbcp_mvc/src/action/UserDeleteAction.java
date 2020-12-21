package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserserviceImpl;

public class UserDeleteAction implements Action {
	
	private String path;

	public UserDeleteAction(String path) {
		super();
		this.path = path;
	}



	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		
		UserService service = new UserserviceImpl();
		boolean flag = service.deleteUser(no);
		
		if(!flag ) {
			path = "select.do";
		}
		
		
		return new ActionForward(path,true);
	}

}
