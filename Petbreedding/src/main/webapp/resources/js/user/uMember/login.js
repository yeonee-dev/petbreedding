/**
 * 
 */
$(function() {
	$("#searchIdPw").click(function() {
		$("#modal").show();
	});

	$("#modalExit").click(function() {
		$('#modal').hide();
	});
});

$("#loginBtn").on("click", function() {

	console.log("들어옴");
	var dataString = $("#loginFrm").serialize();

	$.ajax({
		url : "member/doLoginU",
		type : "POST",
		data : dataString,
		success : function(data) {
			if (data == "/uLogin") {
				$("#errorText").text("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");

			} else if (data == "/") {
				location.href = "/petbreedding/";
			} else {
				alert("에러");
			}
		},
		error : function(error) {
			$("#errorText").text("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
		}
	});

	return false;

});

$("#bPwd").keydown(function (key) {
	 
    if(key.keyCode == 13){//키가 13이면 실행 (엔터는 13)
    	var dataString = $("#loginFrm").serialize();

    	$.ajax({
    		url : "member/doLoginU",
    		type : "POST",
    		data : dataString,
    		success : function(data) {
    			if (data == "/uLogin") {
    				$("#errorText").text("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");

    			} else if (data == "/") {
    				location.href = "/petbreedding/";
    			} else {
    				alert("에러");
    			}
    		},
    		error : function(error) {
    			$("#errorText").text("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
    		}
    	});
    	
    	return false;
    }

});


//카카오톡
$(document).ready(function(){
		Kakao.init('b2612abb65e5e0ec8f032250bf0aaa8f'); 
		Kakao.isInitialized(); 
	});
function loginWithKakao() { 
	Kakao.Auth.authorize({ 
		redirectUri: 'http://localhost:8090/petbreedding/kakaoLogin' 
	}); }

