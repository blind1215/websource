package action;

import java.security.Provider.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserVO;
import service.UserService;
import service.UserserviceImpl;

public class UserUpdateAction implements Action {
	
	private String path;

	public UserUpdateAction(String path) {
		super();
		this.path = path;
	}



	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//입력된값 가져오기
		int no = Integer.parseInt(request.getParameter("no"));
		
		UserService service =new UserserviceImpl();
		UserVO user=service.getUser(no);
		
		request.setAttribute("vo", user);
		
		return new ActionForward(path,false);
		
		
		
	
		
		
	
	}

}
