// 알림 클릭 이벤트
function connectWindow(innotCon, inRefNum) {
	var notCon = innotCon
	var RefNum = inRefNum;
	if(notCon=='a1'||notCon=='a2'||notCon=='a8'){
		if(RefNum.indexOf("hos")!=-1){
			location.href ="/petbreedding/revdetail2?hos_rnum="+RefNum;
		}else{
			location.href ="/petbreedding/revdetail?har_rnum="+RefNum;
		}
	}
	if(notCon=='a4'){
		location.href="/petbreedding/fboardcon?boNum="+RefNum;
	}
	if(notCon=='a5'){
		location.href="/petbreedding/mypage/askdetail?qna_num="+RefNum;
	}
	if(notCon=='a6'||notCon=='a7'){
		location.href="/petbreedding/point";
	}
	
}

// 알림 삭제
function deleteNotice(inNotNum) {
	event.stopPropagation();

	var notNum = inNotNum;

	$("#cancel-modal").css("display","block");

	// 취소시 모달 닫기
	$("#noCalncle").on("click",function(){
		$("#cancel-modal").css("display","none");
	});
	
	// 확인 시 알림 삭제 처리
	$("#yesCalncle").on("click",function(){
		$.ajax({
			url: "notdelete.do",
			type : "POST",
			data : { notNum : notNum },
			success : function(data){
				if(data>0){
					alert("해당 알림이 지워졌습니다.");
				}else{
					alert("오류가 발생했습니다. 관리자에게 문의해주세요.");
					
				}
			},
			error : function(error){
				alert("오류가 발생했습니다. 관리자에게 문의해주세요.");
			}
		});
		$("#cancel-modal").css("display", "none");
		setTimeout("location.reload()", 300);
	});
}