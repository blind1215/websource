<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    String[] dinner=request.getParameterValues("dinner");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h4> 당신이 선택한 저녁메뉴는</h4>
  <ul>
  <% 
  for(String d: dinner) {
	  out.print("<li>" + d + "</li>");
	  }
  %>
  </ul>
</body>
</html>