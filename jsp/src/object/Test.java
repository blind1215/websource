package object;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//받기
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String email=request.getParameter("email");
		
		//출력
		response.setContentType("test/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		out.print("<html><head><title> 가입정보확인</title></head>" );
		out.print("<body> <h3> 가입정보 </h3>");
		out.print("<h4>아이디 : "+id +"</h4>");
		out.print("<h4>비밀번호 : " +password + "</h4>"); 
		out.print("<h4>비밀번호확인 : " +password2 + "</h4>"); 
		out.print("<h4>이름 : " +name + "</h4>"); 
		out.print("<h4>성별 : " +sex + "</h4>"); 
		out.print("<h4>이메일 : " +email + "</h4>"); 
		out.print("<h3>가입을 축하합니다</h3>");
		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
