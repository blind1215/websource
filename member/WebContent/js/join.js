/**
 * joinForm.jsp 유효성 검증
 */

$(function(){
	$("#joinform").validate({
		//규칙정의 - 아이디 5~12자리 - 영어대소문자,숫자,특수문자 허용
		//비밀번호는 8~15자리 - 영어대소문자, 숫자, 특수문자 허용
		//비밀번호 확인 - 이전 비밀번호와 동일
		//이름: 2~4자리 허용
		//성별: 무조건 하나 선택
		//이메일: 이메일 검증
		rules:{
			userid:{
				required:true,
				validId:true
			},
			password:{
				required:true,
				validPwd:true
			},
			confirm_password:{
				required:true,
				validPwd:true,
				equalTo:"#password"
			},
			name:{
				required:true,
				rangelength:[2,4]
			},
			gender:{
				required:true
			},
			email:{
				required:true,
				email:true
			}
		
		},
		//메세지 주기
		messages : {
			userid:{
				required:"아이디는 필수 속성입니다."
			},
			password:{
				required:"비밀번호는 필수 속성입니다."
			},
			confirm_password:{
				required:"비밀번호확인은 필수 속성입니다.",
				equalTo:"이전과 다릅니다.비밀번호를 다시 확인해주세요 ."
			},
			name:{
				required:"이름은 필수 속성입니다.",
				rangelength:"이름은 2~4자리 사이입니다."
			},
			gender:{
				required:"성별을 선택해 주세요"
			},
			email:{
				required:"이메일은 필수 속성입니다."
			}
		},
		errorPlacement:function(error,element){
			$(element).closest("form").find("small[id='"+element.attr('id')+"']").append(error);
		},
		success:function(label){
			var name = label.attr('for');
			label.text(name+' is ok! ');
			
		}
	})

//검증 메소드 추가
$.validator.addMethod("validId",function(value){
	var regId = /(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$$%^*])[A-Za-z\d!@#$%^*]{5,12}$/;
	return regId.test(value); 
}, "아이디를 영대소문자,숫자,특수문자의 조합으로 5~12자리로 만들어주세요");
$.validator.addMethod("validPwd",function(value){
	var regPwd = /(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$$%^*])[A-Za-z\d!@#$%^*]{8,15}$/;
	return regPwd.test(value);
},"비밀번호를 영대소문자,숫자,특수문자의 조합으로 8~15자리로 만들어주세요");
$.validator.addMethod("email",function(value){
	var regemail = /(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return regemail.test(value);
},"이메일을 확인해 주세요");

})