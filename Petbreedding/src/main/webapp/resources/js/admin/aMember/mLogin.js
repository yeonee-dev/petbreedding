/**
 * 
 */

$("#loginBtn").on("click", function() {

	var dataString = $("#loginFrm").serialize();
	
	$.ajax({
		url : "member/doLoginM",
		type : "POST",
		data : dataString,
		success : function(data) {
			if (data == "/mLogin") {
				$("#errorText").text("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
			} else if (data == "/mClient") {
				location.href = "/petbreedding/mClient";
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
    		url : "member/doLoginM",
    		type : "POST",
    		data : dataString,
    		success : function(data) {
    			if (data == "/mLogin") {
    				$("#errorText").text("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
    			} else if (data == "/mClient") {
    				location.href = "/petbreedding/mClient";
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