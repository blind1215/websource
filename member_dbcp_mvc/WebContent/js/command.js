/**
 * 버튼클릭
 */
$(function(){
	//logout 클릭시 logoutPro.jsp
	$("#logout").click(function(){//메뉴.js 에 만들어놓은 j쿼리에 로그아웃button에 id 지정해논값 가져옴
		location.href='logoutPro.jsp';
	
	})
	$("#modify").click(function(){
		location.href='modifyForm.jsp';
	})
	$("#leave").click(function(){
		location.href='leaveForm.jsp';
	})
})

