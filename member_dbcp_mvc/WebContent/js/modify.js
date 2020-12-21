/**
 * 
 */
$(function(){
	$("#modifyform").validate({
		rules:{
			current_password:{
				required:true,
				validPwd:true,
				
			},
			new_password:{
				required:true,
				validPwd:true,
				
			},
			confirm_password:{
				required:true,
				validPwd:true,
				equalTo:"#new_password"
			}
		},
		//메세지 주기
		messages : {
			current_password:{
				required:"현재 비밀번호를 입력해 주세요.",
				
			},
			new_password:{
				required:"새로운 비밀번호를 입력해 주세요.",
				
				
			},
			confirm_password:{
				required:"새로운 비밀번호를 입력해 주세요.",
				equalTo:"이전과 다릅니다.비밀번호를 다시 확인해주세요 ."
				
			}
		},
		errorPlacement:function(error,element){
			$(element).closest("form").find("small[id='"+element.attr('id')+"']").append(error);
			}
	})
})
$.validator.addMethod("validPwd",function(value){
	var regPwd = /(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$$%^*])[A-Za-z\d!@#$%^*]{8,15}$/;
	return regPwd.test(value);
},"비밀번호를 영대소문자,숫자,특수문자의 조합으로 8~15자리로 만들어주세요");
