<%@page import="book1.BookVO"%>
<%@page import="book1.BookDAO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<% 
		request.setCharacterEncoding("utf-8");
		
		String criteria = request.getParameter("criteria");
		String keyword = request.getParameter("keyword");
		
		/* out.print("criteria "+criteria+"<br>");
		out.print("keyword "+keyword); */
		
		//db작업
		//forward - searchAll.jsp 로 이동
		BookDAO dao = new BookDAO();
		List<BookVO> list = dao.bookSearch(criteria, keyword);
		request.setAttribute("list", list);
		pageContext.forward("../searchAll.jsp");

%>