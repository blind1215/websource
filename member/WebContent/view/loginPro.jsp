<%@page import="member.MemberVO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//loginForm.jsp에서 넘긴 값 가져오기
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String password = request.getParameter("current_password"); //login의 name 가져오기
	
	
	//db작업하기
	
	MemberDAO dao = new MemberDAO();
	MemberVO member=dao.isLogin(userid, password);
	
	
	//존재하는 사용자라면 loginForm.jsp로 이동
	if(member!=null){ //로그인 작업 => 현재 정보를 session에 담기
		session.setAttribute("login", member);//내가 지정한 이름을 따옴표안에 그다음이 담을정보
		
	}else{
		out.print("<script>alert('아이디와 비밀번호를 확인해 주세요');</script>");
	}
	//response.sendRedirect("loginForm.jsp"); 
	//해도되지만 이걸 놔두면 스크립트가 사용되도록 허용되지 않음 
	//그렇기 때문에 윗경고창이 안뜸 그렇기때문에 같은 스크립트안 아래로 사용함
	out.print("<script>");
	out.print("location.href='loginForm.jsp';");
	out.print("</script>"); 
	
%>