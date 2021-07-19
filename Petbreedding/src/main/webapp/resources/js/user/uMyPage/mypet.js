//삭제  누르면 모달창 띄움
$(".cancleM").on("click",function(){
	$("#cancel-modal").css("display","block");
});


$("#noCalncle").on("click",function(){
	$("#cancel-modal").css("display","none");
});


	

	//삭제
$("#yesCalncle").on("click",function(){
	
	var pet_num = $("#pet_num").val();
//	
	$.ajax({
		url: "deletepet",
		type : "POST",
		data : {pet_num : pet_num},
		success : function(data){
			if(data > 1){
				console.log(data);
				alert("처리안됨");
				
			}else{
				alert("정상적으로 삭제되었습니다");
				location = "petlist";
			}
		},
		error : function(error){
			alert("오류가 발생했습니다. 관리자에게 문의해주세요.");
		}
	});
})
	
	
