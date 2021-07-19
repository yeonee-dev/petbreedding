function openbchatwin(inchatId,innickName, inshopName, inclNum) {

	var chatId = inchatId;
	var nickName = innickName;
	var shopName = inshopName;
	var cl_num = inclNum;
	var url = '/petbreedding/bchat?chatId='+chatId+'&nickName='+nickName
			+'&shopName='+shopName+'&cl_num='+cl_num;
	window.open(url, '_blank', 'width=555px, height=700px');
	
	// 페이지 열면 새로고침 하여 안읽은 메시지 수 확인
	setTimeout("location.reload()", 300);

}

function deleteChat(inchatId) {
	event.stopPropagation();
	
	var chatId = inchatId;
	
	$("#deleteMsg-modal").css("display", "block");
	
	// 취소를 누르면 취소
	$("#noDelete").on("click", function() {
		$("#deleteMsg-modal").css("display", "none");
	});
	
	// 확인을 누르면 삭제(로 보이게) 진행
	$("#yesDelete").on("click", function() {
		$.ajax({
			url : "bchatdelete.do",
			type : "POST",
			data : { chatId, chatId },
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
		$("#deleteMsg-modal").css("display", "none");
		setTimeout("location.reload()", 300);
	});
}

$(document).ready(function() {
	// 1분에 한번씩 새로고침으로 신규 채팅 체크
	setTimeout("location.reload()", 60000);
});