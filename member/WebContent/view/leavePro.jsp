<%@page import="member.MemberVO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//leaveForm.jsp에서 넘긴 값 가져오기
	request.setCharacterEncoding("utf-8");
	String userid =request.getParameter("userid");
	String password = request.getParameter("current_password");
	
	
	
	//db작업
	MemberDAO dao = new MemberDAO();
	//비밀번호가 맞아서 탈퇴가 되는 경우-세션해제, index 페이지로 이동
	int result = dao.leaverMember(userid, password);
	if(result>0){
		session.invalidate();
		response.sendRedirect("../index.jsp");
	}else{
	//비밀번호가 틀리는경우 - leaveForm.jsp로 이동
	response.sendRedirect("leaveForm.jsp");
	}


%>