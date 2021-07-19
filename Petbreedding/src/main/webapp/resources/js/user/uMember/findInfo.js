var getCheck= RegExp(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,12}$/); 

//아이디 찾기
$("#findIdBtn").on("click",function(){
	
	var formData = $("#searchIdFrm").serialize();
	
	$.ajax({
		url : "findId",
		type : "post",
		data : formData,
		success : function(data){
			if(data != null){
				$("#searchId").css("display","none");
				$("#findId").css("display","block");
				$("#foundEmail").text(data);
			}else{	
				$("#noId").text("일치하는 정보가 없습니다.");
				$("#noId").css("color","red");
			}
		},
		error : function(){
			console.log("실패");
		}
	});
});






//비밀번호 찾기
$("#findPwdBtn").on("click",function(){
	
	var formData = $("#searchPwdFrm").serialize();
	var email = $("#sendEmail").val();
	
	$.ajax({
		url : "findPwd",
		type : "post",
		data : formData,
		success : function(data){
			if(data == 1){
				$("#searchPwd").css("display","none");
				$("#findPwd").css("display","block");
				$("#haveEmail").val(email);
			}else{	
				$("#noPwd").text("일치하는 정보가 없습니다.");
				$("#noPwd").css("color","red");
			}
		},
		error : function(){
			console.log("실패");
		}
	});
});

//비밀번호 변경
$("#changePwd").on("click",function(){
	
	var formData = $("#newPwdBox").serialize();
	
	if($("#pw_check").text()=="사용가능한 비밀번호입니다." && $("#pw_check2").text()=="비밀번호가 일치합니다."){
		$.ajax({
			url : "changePwd",
			type : "post",
			data : formData,
			success : function(data){
				if(data == 1){
					$("#modal").css("display","none");
					alert("비밀번호가 변경되었습니다!");
				}else{	
					alert("비밀번호 변경실패!");
				}
			},
			error : function(){
				console.log("실패");
			}
		});
	}else{
		$("#pw_check2").text("정보를 다시 확인해주세요.");
		$("#pw_check2").css("color","red");
	}
	
	
});

//비밀번호 유효성 체크
$("#pwd").blur(function(){
	var pwd = $("#pwd").val();
	if(pwd == "null" || pwd == ""){
		$("#pw_check").text("필수 정보입니다.");
		$("#pw_check").css("color","red");
		$("#pw_check").css("height","30px");
	}else if(!getCheck.test(pwd)){
		$("#pw_check").text("비밀번호는 영문,숫자,특수문자(!@$%^&* 만 허용)를 조합하여 8~12자로 구성하세요.");
		$("#pw_check").css("color","red");
		$("#pw_check").css("height","30px");
		$("#pw_check").css("font-size","13px");
	}else{
		$("#pw_check").text("사용가능한 비밀번호입니다.");
		$("#pw_check").css("color","green");
		$("#pw_check").css("height","30px");
	}	
});

//비밀번호 값 확인
$("#pwdCheck").blur(function(){
	var pwdCheck = $("#pwdCheck").val();
	var pwd = $("#pwd").val();

	if(pwdCheck == "null" || pwdCheck == ""){
		$("#pw_check2").text("필수 정보입니다.");
		$("#pw_check2").css("color","red");
		$("#pw_check2").css("height","20px");
	}else if(pwd != pwdCheck ){
		$("#pw_check2").text("비밀번호가 일치하지 않습니다.");
		$("#pw_check2").css("color","red");
		$("#pw_check2").css("height","20px");
	}else{
		$("#pw_check2").text("비밀번호가 일치합니다.");
		$("#pw_check2").css("color","green");
		$("#pw_check2").css("height","20px");
	}	
});
