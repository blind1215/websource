<%@page import="domain.UserVO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//index.jsp에서 넘긴 값 가져오기

	//UserVO vo=(UserVO)request.getAttribute("vo");
%>    


<%@include file="header.jsp" %>
<div class="container">
	  <form action="" method="post">
	   <div class="form-group">
    <label for="userName">번호</label>
    <input type="text" class="form-control" name="no" id="no"  autofocus readonly value="${vo.noo}">
    </div>
	   <div class="form-group">
    <label for="userName">이름</label>
    <input type="text" class="form-control" name="userName" id="userName" readonly value="${vo.username}">
    </div>
  
  <div class = "form-group">
  <button type="button" class="btn btn-primary">수정</button>
<button type="button" class="btn btn-danger">삭제</button>
</div>
</form>
</div>
<%

%>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script>
$(function(){
	
	let form = $("form");
	//수정버튼을 클릭하면 update.jsp로 이동
	$(".btn-primary").click(function(){
		$(form).attr("action","update.do");
		$(form).submit();
		
	})
	//삭제버튼을 클릭하면 deletePro.jsp
	$(".btn-danger").click(function() {
		$(form).attr("action","delete.do");
		$(form).submit();
	})
})
</script>
</body>
</html>