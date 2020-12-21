<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    int num1=Integer.parseInt(request.getParameter("num1"));
    int num2=Integer.parseInt(request.getParameter("num2"));
    
    int sum = num1+num2;
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> 첫번째숫자와 두번째 숫자의 합은 :  </h3> <%=sum %> <h3>입니다.</h3>

</body>
</html>