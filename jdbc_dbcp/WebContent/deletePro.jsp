<%@page import="jdbc.UserDAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//select.jsp에서 넘긴 값 가져오기
	int no = Integer.parseInt(request.getParameter("no"));

	UserDAO dao = new UserDAO();
	
	int result = dao.deletUser(no);

	if(result>0){
		response.sendRedirect("index.jsp");	
	}else{
		response.sendRedirect("select.jsp");
	}
		
%>