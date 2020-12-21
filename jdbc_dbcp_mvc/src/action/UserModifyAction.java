package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserserviceImpl;

public class UserModifyAction implements Action {
	
	private String path;

	public UserModifyAction(String path) {
		super();
		this.path = path;
	}


	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		String addr = request.getParameter("addr");
		String mobile = request.getParameter("mobile");
		
		
		//서비스 일시키기
		UserService service = new UserserviceImpl();
		boolean flag=service.updateUser(no, addr, mobile);
		
		if(!flag) { // 수정페이지
			path = "update.do";
			
		}
		return new ActionForward(path,true);
	}

}
