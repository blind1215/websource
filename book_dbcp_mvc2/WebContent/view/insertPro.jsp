<%@page import="persistence.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//insert.jsp에서 사용자가 넘긴 값 가져오기
	
	
	
	//DB작업 해주기
	BookDAO dao = new BookDAO();
	
	//결과에 따라 페이지 이동
	//성공하면 index로 
	if(result==0){
		response.sendRedirect("../index.jsp?tab=insert");
	}else{
		response.sendRedirect("selectPro.jsp");
	}


%>
