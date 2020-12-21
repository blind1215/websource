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
	//영역 개체에 값 담기
	//page유효범위 : 현재 페이지만 가능
	//request 유효범위 : 클라이언트의 요청이 처리되는 동안 유효 
	//				  포워드를 시키는 경우 여러 개의 페이지에서도 동일한
	//				  request가 사용됨 
	pageContext.setAttribute("pageScope","pageValue");//페이지영역에 담음
	request.setAttribute("requestScope","requesteBalue"); //리퀘스트영역에 담음
	pageContext.forward("attributeTest5.jsp");
%>
<%-- pageValue = <%=pageContext.getAttribute("pageScope") %>
requestValue = <%=request.getAttribute("requestScope") %> --%>
</body>
</html>