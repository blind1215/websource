<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//select.jsp에서 넘긴 값 가져오기(no)
	request.setCharacterEncoding("utf-8");
	String no = request.getParameter("no");
	
	//DB작업 - no에 해당하는 사람 정보 가져오기
	
	
	Connection con =null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try{
		//1.드라이버 로드
		Class.forName("oracle.jdbc.OracleDriver");
		//연결문자열 생성
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="javaDB";
		String password="12345";
		//커넥션
		con = DriverManager.getConnection(url,user,password);
		if(con!=null){
			String sql = "select * from userTBL where no=?";
			/* String sql = "select no, username,addr,mobile from userTBL where no=?"; */
			//sql구문 전송
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(no));
			//sql 실행
			rs=pstmt.executeQuery();
			if(rs.next()){
				int no1 = rs.getInt("no");
				String userName =  rs.getString("userName");
				int birthYear = rs.getInt( "birthYear");
				String addr = rs.getString("addr");
				String mobile = rs.getString("mobile");
	//가져온 정보를 form 안에 보여주기 




%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<style>
	.container{
		margin-top: 30px;
	}

</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">JDBC</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">User 조회 <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="add.jsp">User 추가</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="update.jsp">User 수정</a>
      </li>
   	  <li class="nav-item">
        <a class="nav-link" href="delete.jsp">User 삭제</a>
      </li>
    </ul>
  </div>
</nav><!-- nav 종료 -->
<div class="container"><!-- 다시 해봐용!! -->
	  <form action="updatePro.jsp" method="post">
	   <div class="form-group">
    <label for="userName">번호</label>
    <input type="text" class="form-control" name="no" id="no"  autofocus readonly value="<%=no%>" >
    </div>
	   <div class="form-group">
    <label for="userName">이름</label>
    <input type="text" class="form-control" name="userName" id="userName" readonly value="<%=userName %>">
    </div>
  <div class="form-group">
    <label for="birthYear">태어난해</labl>
    <input type="text" class="form-control" name="birthYear" id="birthYear" readonly value="<%=birthYear%>" >
  </div>
  <div class="form-group">
    <label for="addr">주소</label>	
    <input type="text" class="form-control" name="addr" id="addr" placeholder="변경 주소를 입력하세요" required>
  </div>
   <div class="form-group">
    <label for="mobile">모바일</label>
    <input type="text" class="form-control" name="mobile" id="mobile" placeholder="변경 전화번호를 입력하세요" required>
    </div>
  <div class = "form-group">
  <button type="submit" class="btn btn-primary">수정</button>
<button type="button" class="btn btn-secondary">취소</button>
</div>
</form>
</div>
<%
	} //if
		}//if
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			rs.close();
			pstmt.close();
			con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>

</script>
</body>
</html>