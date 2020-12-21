<%@page import="jdbc.UserDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.sun.jdi.request.InvalidRequestStateException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//add.jsp에서 사용자 입력값 가져오기
	request.setCharacterEncoding("utf-8");
	String userName = request.getParameter("userName");
	String birthYear =request.getParameter("birthYear");
	String addr = request.getParameter("addr");
	String mobile = request.getParameter("mobile");
	
	//db작업 DAO로 뺐음 DAO가 일을하도록 시킨다
	//그럴러면 객체를 생성해야한다  - DB 작업 시키기
	UserDAO dao = new UserDAO();
	int result=dao.insert(userName, birthYear, addr, mobile);
	
	
	if(result>0){
		response.sendRedirect("index.jsp");
		
		
	}else {
		response.sendRedirect("add.jsp");
	}

%>
