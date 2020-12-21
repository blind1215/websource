package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String requestURI = request.getRequestURI(); // 전체의주소
		String contextPath = request.getContextPath(); // 뒷주소
		String cmd = requestURI.substring(contextPath.length()); //앞단짜른 마지막 ~~~.do
		
		MemberActionFactory factory = MemberActionFactory.getInstace();//하나의 인스턴스만 가지고 공유
		Action action = factory.action(cmd);
		
		ActionForward af =null;
		//member_dbcp_mvc/login.do
		try {
			af=action.execute(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(af.isRedirect()) {
			response.sendRedirect(af.getPath());
		}else {
			//http://localhost:8080/member_dbcp_mvc/view/loginForm.jsp
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
