package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;

public class DeleteAction implements Action {
	
	private String path;
	
	public DeleteAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.getParameter
		String name = request.getParameter("name");
		System.out.println("delete action : "+name);
		
		MemberService service = new MemberServiceImpl();
		service.deleteMember(name); //true or false
		
		// 어디로 갈것인지? (~~~.jps or ~~~.do) / 어떤 방식으로 갈 것인지 (forward / sendRedirect)
		//ActionForward
		return new ActionForward(path,true);
		
	}
}
