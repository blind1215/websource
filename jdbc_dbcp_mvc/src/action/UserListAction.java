package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserVO;
import service.UserService;
import service.UserserviceImpl;

public class UserListAction implements Action {
	
	private String path;
	
	public UserListAction(String path) {
		super();
		this.path = path; //list.jsp
	}



	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//request.getParameter - >x
		//서비스한테 일 시키기 
		UserService service = new UserserviceImpl();
		List<UserVO> list = service.getUserList();
		
		//이동방식 결정한 후 이동하기 ActionForward 객체 생성 
		request.setAttribute("list", list);
		return new ActionForward(path, false);
	}

}
