package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DinnerServlet
 */
@WebServlet("/DinnerServlet")
public class DinnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//받아오기
		String[] dinner = request.getParameterValues("dinner");
		
		//출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title> 저녁메뉴 </title></head>");
		out.print("<body><h2> 재료가있는 두가지중 하나만고르시오 </h2>");
		out.print("<ul>");
		for(String d:dinner) {
			out.print("<li>"+ d +"</li>");
			
		}
		out.print("</ul></body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
