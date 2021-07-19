// 모달
function modal(id) {
    var zIndex = 9999;
    var modal = document.getElementById(id);

    // 모달 div 뒤에 희끄무레한 레이어
    var bg = document.createElement('div');
    bg.setStyle({
        position: 'fixed',
        zIndex: zIndex,
        left: '0px',
        top: '0px',
        width: '100%',
        height: '100%',
        overflow: 'auto',
        // 레이어 색갈은 여기서 바꾸면 됨
        backgroundColor: 'rgba(0,0,0,0.4)'
    });
    document.body.append(bg);

    // 닫기 버튼 처리, 시꺼먼 레이어와 모달 div 지우기
    modal.querySelector('.modal_close_btn').addEventListener('click', function () {
        bg.remove();
        modal.style.display = 'none';
    });
    document.getElementById('nextTime').addEventListener('click', function () {
        bg.remove();
        modal.style.display = 'none';
    });

    modal.setStyle({
        position: 'fixed',
        display: 'block',
        boxShadow: '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)',

        // 시꺼먼 레이어 보다 한칸 위에 보이기
        zIndex: zIndex + 1,

        // div center 정렬
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        msTransform: 'translate(-50%, -50%)',
        webkitTransform: 'translate(-50%, -50%)'
    });
}
// Element 에 style 한번에 오브젝트로 설정하는 함수 추가
Element.prototype.setStyle = function (styles) {
    for (var k in styles) this.style[k] = styles[k];
    return this;
};
document.getElementById('cancleBtn').addEventListener('click', function () {
    // 모달창 띄우기
    modal('my_modal');
});


//미용실 결제취소
$("#goTOCancle").on("click",function(){
	
	var har_rnum = $("#har_rnum").val();
//	
	$.ajax({
		url: "bReservationCancle",
		type : "POST",
		data : {har_rnum : har_rnum},
		success : function(data){
			if(data != null){
				console.log(data);
				alert("정상적으로 이용 취소 되었습니다.");
				location = "bReservation";
				
			}else{
				alert("실패");
			}
		},
		
	});
})


// 병원 결제취소
$(".goTOCancle").on("click",function(){
	
	var hos_rnum = $("#hos_rnum").val();
//	
	$.ajax({
		url: "bReservationCancle",
		type : "POST",
		data : {hos_rnum : hos_rnum},
		success : function(data){
			if(data != null){
				console.log(data);
				alert("정상적으로 이용취소 되었습니다.");
				location = "bReservation";
				
			}else{
				alert("실패");
				console.log(data);
			}
			
		},
		error : function(error){
			alert("오류가 발생했습니다. 관리자에게 문의해주세요.");
		}
	});
})

// 1:1 채팅하기 버튼 클릭 시 채팅창 열기
$(".chatBtn").on("click", function(e) {
	var bp_id = $("#bpId").val();
	var shopName = $("#shopNameforOut").val();
	var cl_num = $("#cl_numforOut").val();
	var nickName = $("#nickNameforOut").val();
	var url = '/petbreedding/bchat?bp_id='+bp_id+'&shopName='+shopName+'&cl_num='+cl_num+'&nickName='+nickName;
	window.open(url, '_blank', 'width=555px, height=700px');
});

