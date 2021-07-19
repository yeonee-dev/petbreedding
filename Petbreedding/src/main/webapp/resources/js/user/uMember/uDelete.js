$("#yes").on("click",function(){
	var cl_num = $("#cl_num").val();
	
	$.ajax({
		url: "uDeleteDo",
		type : "POST",
		data : {cl_num : cl_num},
		success : function(data){
			if(data >0){
				alert("정상적으로 탈퇴처리 되었습니다.");
				location.href = "/petbreedding/";
			}else{
				alert("오류가 발생했습니다. 관리자에게 문의해주세요.");
				
			}
		},
		error : function(error){
			alert("오류가 발생했습니다. 관리자에게 문의해주세요.");
		}
	});
	
	
	
});