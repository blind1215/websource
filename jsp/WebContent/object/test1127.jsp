<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id=request.getParameter("id");
	String password=request.getParameter("password");
	String password2=request.getParameter("password2");
	String name=request.getParameter("name");
	String sex=request.getParameter("sex");
	String email=request.getParameter("email");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h3> 가입정보 </h3>
 <h4>아이디 : <%=id %></h4>
 <h4>비밀번호 : <%=password %></h4>
 <h4>비밀번호 확인 : <%=password2 %></h4>
 <h4>이름 : <%=name %></h4>
 <h4>성별 : <%=sex %></h4>
 <h4>이메일 : <%=email%></h4>
 <h3>가입을 축하합니다</h3>
</body>
</html>