<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션 해제
	session.invalidate();
	//loginForm.jsp 이동
	//스크립트가 나올것이 없기때문에 굳이 스크립트로 보낼필요가없음 
	/* out.print("<script>");
	out.print("location.href='loginForm.jsp';");
	out.print("</script>"); */
	response.sendRedirect("loginForm.jsp");

%>