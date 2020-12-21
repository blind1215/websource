<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션에 담아놓은 장바구니 리스트를 가져오기
	//String product=(String)session.getAttribute("product");

	//왼쪽 부분이 잘 못되어서 그랬네요!!
	ArrayList<String> proList=(ArrayList<String>)session.getAttribute("proList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--장바구니 리스트 보여주기 --%>
<%
	out.print("<ul>");
	for(String product : proList) {
		out.print("<li>"+product+"</li>");
	}
	out.print("</ul>");

%>
<%-- <h3> 현재 장바구니에는<%=product%>입니다 </h3> --%>
<a href="cart.html">상품선택 페이지</a>
<a href="cartRemove.jsp">장바구니 비우기</a>
</body>
</html>