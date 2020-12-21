package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.DeleteAction;
import action.InsertAction;

/**
 * Servlet implementation class FrontContrller
 */
@WebServlet("*.do") // select.do, insert.do , modify.do ~~~
public class FrontContrller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String requestURI = request.getRequestURI(); // /pattern/update.do
		String contextPath = request.getContextPath(); // /patter
		String cmd = requestURI.substring(contextPath.length()); //   /update.do

		ActionFactory factory = ActionFactory.getInstance();
		Action action = factory.action(cmd);
	
		ActionForward af = null;
		try {
			af=action.execute(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(af.isRedirct()) {//true => sendRedirect방식 
			response.sendRedirect(af.getPath());
		}else {//false = > forward
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
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
