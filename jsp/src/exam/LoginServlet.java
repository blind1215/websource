package exam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//loginPro.jsp 에서 했던 작업과 동일
		request.setCharacterEncoding("utf-8");
		String userid=request.getParameter("userid");
		String userpwd=request.getParameter("userpwd");
		
		LoginDTO login = new LoginDTO(userid,userpwd); // 객제생성 봉지에 아이디랑 패스워드를 담았음
		
		HttpSession session = request.getSession();//서블릿은 바로 세션을 가져올수없고 이렇게 선언해줘야함
		session.setAttribute("login",login);
		
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
