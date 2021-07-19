function openchatwin(inchatId,inshopName,inbpId,inbpType) {

	var chatId = inchatId;
	var shopName = inshopName;
	var bp_id = inbpId;
	var bp_type = inbpType;
	var url = '/petbreedding/chat?chatId='+chatId+'&shopName='+shopName+'&bp_id='+bp_id+'&bp_type='+bp_type;
	window.open(url, '_blank', 'width=555px, height=700px');

	// 페이지 열면 새로고침 하여 안읽은 메시지 수 확인
	setTimeout("location.reload()", 300);

}

function deleteChat(inchatId) {
	event.stopPropagation();
	
	var chatId = inchatId;
	
	$("#cancel-modal").css("display", "block");
	
	// 취소를 누르면 취소
	$("#noCalncle").on("click", function() {
		$("#cancel-modal").css("display", "none");
	});
	
	// 확인을 누르면 삭제(로 보이게) 진행
	$("#yesCalncle").on("click", function() {
		$.ajax({
			url : "chatdelete.do",
			type : "POST",
			data : { chatId : chatId },
			success : function(data) {
				if(data>0){
					alert("대화가 모두 삭제되었습니다!");
				}else{
					alert("오류가 발생했습니다. 관리자에게 문의해주세요.");
				}
			},
			error : function(error) {
				alert("오류가 발생했습니다. 관리자에게 문의해주세요.");
			}
		});
		$("#cancel-modal").css("display", "none");
		setTimeout("location.reload()", 300);
	});
}

$(document).ready(function() {
	// 1분에 한번씩 새로고침으로 신규 채팅 체크
	setTimeout("location.reload()", 60000);
});