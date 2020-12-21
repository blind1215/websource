<%@page import="exam.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--User user = new User(); --%>
<jsp:useBean id="user" class="exam.User"/> 
<%--id는 변수명 ->밑에서 name에 들어감 value 는 set에 넣어준거 
property get/set name 이부분 name--%>
<h1>
<%--user.getName() --%>
	<jsp:setProperty property="name" name="user" value="홍길동"/>
	<jsp:getProperty property="name" name="user"/>
</h1>
</body>
</html>