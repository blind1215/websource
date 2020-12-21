package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserserviceImpl;

public class UserInsertAction implements Action {
	
	private String path;
	
	public UserInsertAction(String path) {
		this.path=path; //list.do
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// request.getParameter()
		//add.jsp에서 사용자 입력값 가져오기
		String userName = request.getParameter("userName");
		String birthYear =request.getParameter("birthYear");
		String addr = request.getParameter("addr");
		String mobile = request.getParameter("mobile");
		
		//Service에게 일 시키기
		UserService service = new UserserviceImpl();
		boolean insertFlag =service.insertUser(userName, birthYear, addr, mobile);
		
		if(!insertFlag) {
			path = "add.jsp";
		}
		
		//작업결과에 따라 페이지 이동 방식 결정 - sendRedirect(
		
		return new ActionForward(path, true);
	}

}
