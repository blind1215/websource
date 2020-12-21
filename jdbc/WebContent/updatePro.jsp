<%@page import="jdbc.UserDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//update.jsp에서 넘긴값 가져와서 수정 후
	request.setCharacterEncoding("utf-8");
	int no = Integer.parseInt(request.getParameter("no"));
	String addr = request.getParameter("addr");
	String mobile = request.getParameter("mobile");
	
	UserDAO dao = new UserDAO();
	
	int result = dao.updateUser(no, addr, mobile);
	
	if(result>0){
		response.sendRedirect("index.jsp");
	}
	
	//성공하면 index.jsp
	//update 테이블명 set addr=수정값, mobile=수정값
	//where no 12




%>