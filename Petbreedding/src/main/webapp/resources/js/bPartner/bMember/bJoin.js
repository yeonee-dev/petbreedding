var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
var getCheck= RegExp(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,12}$/); 
var getPhone = RegExp(/^[0-9]{2,3}[0-9]{3,4}[0-9]{4}/);
var getbNum = RegExp(/^[0-9]{3}-[0-9]{2}-[0-9]{5}/);

//아이디 중복 및 유효성 검사 (1 = 중복 / 0 != 중복)
$("#email").blur(function(){
	var bp_email = $("#email").val();
	$.ajax({
		url : "checkBemail",
		type : "post",
		data : {bp_email : bp_email},
		success : function(data){
			if(data == 1){
				//1: 중복시
				$("#id_check").text("사용중이거나 탈퇴한 이메일입니다.");
				$("#id_check").css("color","red");
			}else{	
				if(bp_email == "null" || bp_email == ""){
					$("#id_check").text("필수 정보입니다.");
					$("#id_check").css("color","red");
				}else if(!getMail.test(bp_email)){
					$("#id_check").text("형식에 맞게 입력해주세요.");
					$("#id_check").css("color","red");
				}else{
					$("#id_check").text("사용가능한 이메일입니다.");
					$("#id_check").css("color","green");
				}	
			}
		},
		error : function(){
			console.log("실패");
		}
	});
});

//비밀번호 유효성 체크
$("#pwd").blur(function(){
	var bp_pwd = $("#pwd").val();
	if(bp_pwd == "null" || bp_pwd == ""){
		$("#pw_check").text("필수 정보입니다.");
		$("#pw_check").css("color","red");
	}else if(!getCheck.test(bp_pwd)){
		$("#pw_check").text("비밀번호는 영문,숫자,특수문자(!@$%^&* 만 허용)를 조합하여 8~12자로 구성하세요.");
		$("#pw_check").css("color","red");
	}else{
		$("#pw_check").text("사용가능한 비밀번호입니다.");
		$("#pw_check").css("color","green");
	}	
});

//비밀번호 값 확인
$("#pwdCheck").blur(function(){
	var pwdCheck = $("#pwdCheck").val();
	var pwd = $("#pwd").val();

	if(pwdCheck == "null" || pwdCheck == ""){
		$("#pw_check2").text("필수 정보입니다.");
		$("#pw_check2").css("color","red");
	}else if(pwd != pwdCheck ){
		$("#pw_check2").text("비밀번호가 일치하지 않습니다.");
		$("#pw_check2").css("color","red");
	}else{
		$("#pw_check2").text("비밀번호가 일치합니다.");
		$("#pw_check2").css("color","green");
	}	
});


//사업자번호 중복 및 유효성 검사 (1 = 중복 / 0 != 중복)
$("#bNum").blur(function(){
	var bp_num = $("#bNum").val();
	console.log("bp_num : "+ bp_num);
	$.ajax({
		url : "checkBNum",
		type : "post",
		data : {bp_num : bp_num},
		success : function(data){
			if(data == 1){
				//1: 중복시
				$("#bNum_check").text("사용중인 사업자 번호입니다.");
				$("#bNum_check").css("color","red");
			}else{	
				if(bp_num == "null" || bp_num == ""){
					$("#bNum_check").text("XXX-XX-XXXXX 형식으로 입력해주세요.");
					$("#bNum_check").css("color","red");
				}else if(!getbNum.test(bp_num)){
					$("#bNum_check").text("XXX-XX-XXXXX 형식으로 입력해주세요.");
					$("#bNum_check").css("color","red");
				}else{
					$("#bNum_check").text("사용가능한 사업자 번호입니다.");
					$("#bNum_check").css("color","green");
				}	
			}
		},
		error : function(){
			console.log("실패");
		}
	});
});



//휴대폰번호 유효성 체크  중복체크
$("#hpConfirm").on("click",function(){
	var bp_tel = $("#hp").val();
	
	$.ajax({
		url : "checkBHp",
		type : "post",
		data : {bp_tel: bp_tel},
		success : function(data){
			if(data == 1){
				//1: 중복시
				$("#hp2_check").text("이미 등록된 휴대폰 번호입니다.");
				$("#hp2_check").css("color","red");
			}else{	
				if(bp_tel == "null" || bp_tel == ""){
					$("#hp2_check").text("필수 정보입니다.");
					$("#hp2_check").css("color","red");
				}else if(!getPhone.test(bp_tel)){
					$("#hp2_check").text("형식에 맞게 입력해주세요.");
					$("#hp2_check").css("color","red");
				}else if(bp_tel.length>12){
					$("#hp2_check").text("형식에 맞게 입력해주세요.");
					$("#hp2_check").css("color","red");
				}else{
					$("#hp2_check").text("");
					 alert("인증번호를 발송했습니다.");
				    $("#hpConfirm").css("display","none");
				    $("#hpConfirm2").css("display","inline-block");
				    checkHp();
				}	
			}
		},
		error : function(){
			console.log("실패");
		}
	});
});


function checkHp(){
	var bp_tel = $("#hp").val();
	$.ajax({
		url: "Bphone",
		type : "post",
		data : {bp_tel : bp_tel},
		success : function(data){
			console.log("인증번호 : "+ data);
			$("#hpConfirm2").on("click",function(){
			    if($("#hp2").val() == null || $("#hp2").val() == ""){
			        $("#hp2_check").text("인증번호를 입력해주세요");
			        $("#hp2_check").css("color","red");
			        $("#hp2").focus();
			        return false;
			    }else if($("#hp2").val() == data){
			    	 $("#hp2_check").text("인증번호가 확인되었습니다");
    			     $("#hp2_check").css("color","green");
			    }
			});						    			
		}
		,error : function(data){
			console.log("error : "+ data);
		}
	
});
}
;


//회원가입
$("#submitBtn").on("click",function(){
	
	var dataString = $(".joinFrm").serialize();
	
	console.log("dataString : "+ dataString);
	
	if($("#hp2_check").text()== "인증번호가 확인되었습니다" && $('input:radio[name=checkShop]').is(':checked')){
		$.ajax({
			url:"bPartner/bJoin",
			type:"POST",
			data: dataString,
			success: function(data){
				console.log("data : "+ data);
				if(data > 0){
					alert("회원가입되었습니다. 로그인페이지로 이동합니다.");
					location.href="/petbreedding/bLogin";
				}else {
					alert("회원가입 실패");
					return false;
				}
			},
			error : function(error){
				console.log(error);
				alert("안되버림");
			}
		});
	}else{
		alert("모든 정보를 확인해주세요");
	}
	
	return false;
   
});

