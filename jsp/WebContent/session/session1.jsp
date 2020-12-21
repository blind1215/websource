<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//세선: 클라이언트와 서버간의 접속 유지
	//	   클라이언트가 서버쪽에 세션을 요청하면 서버측은 식별자(세션ID) 부여
%>
<h2>세션 주요 정보 </h2>
<ul>
	<li>세션 Id(유일식별자) :  <%=session.getId() %>)</li>
	<li>세션 유효 시간 : <%=session.getMaxInactiveInterval() %>초</li>
<%
	//시작: 1970년 1월 1일 0시 이후
	//세션 생성시간 구하기 
	long millsecond = session.getCreationTime();
	Date time =new Date(millsecond);

%> 
	<li>세션 생성 시간(밀리세컨드) : <%=millsecond %></li>
<%
	SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd a h:mm:ss");
%>	
	<li>세션 생성 시간 : <%=format.format(time) %></li>
</ul>
</body>
</html>