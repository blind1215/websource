package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;

public class InsertAction implements Action {
	//생성자는 객체생성할때 무조건 호출 =>new 할 때 무조건 호출 
	//생성자 오버로딩
	//public InsertAction(){} =>default 생성자
	//public InsertAction(String name){} 
	//public InsertAction(String name,int bno){} 
	//클래스 안에 생성자가 하나도 없다면 컴파일러가 default 생성자를 자동으로 생성해줌
	private String path;
	public InsertAction(String path) {
		this.path =path;
	}
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ~Pro.jsp에서 했던 작업 
		// request.getParameter()
		String name = request.getParameter("name");
		System.out.println("insert_action name : "+name);
		
		//DB작업을 service에게 부탁 
		MemberService service = new MemberServiceImpl();
		service.insertMember(name); //인서트서비스에 만들어놓은것 
		
		//session,				request
		//sendRedirect(true),forward(false)
		return new ActionForward(path,true);
		
	}

}
