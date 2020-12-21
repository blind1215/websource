
<%@page import="domain.UserVO"%>
<%@page import="persistence.UserDAO"%>
<%@page import="java.util.List"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %> 
<%
	List<UserVO> list= (List<UserVO>)request.getAttribute("list");

%>
<div class="container">
	<table>
	<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">이름</th>
      <th scope="col">태어난 해</th>
      <th scope="col">주소</th>
      <th scope="col">모바일</th>
    </tr>
  </thead>
  <tbody>
<%
	
	for(UserVO vo:list){
		
%>
	<tr>
		<td><%=vo.getNo()%></td>
		<td><a href="select.jsp?no=<%=vo.getNo()%>"><%=vo.getUsername()%></a></td>
		<td><%=vo.getBirthyear()%></td>
		<td><%=vo.getAddr()%></td>
		<td><%=vo.getMobile()%></td>
	</tr>
<%	
	}
%>    
  </tbody>
</table>
	</table>
</div>
</body>
</html>