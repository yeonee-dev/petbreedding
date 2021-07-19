//1:1문의하기 
$("#1and1").on("click",function(){
	var bp_id = $("#bpId").val();
	var shopName = $("#shopName").val();
	var url = '/petbreedding/chat?bp_id='+bp_id+'&shopName='+shopName;
	window.open(url, '_blank', 'width=555px, height=700px');
});

//결제하기 
$("#pay").on("click",function(){
	var har_rnum =$("#har_rnum").val();
	var cl_num = $("#cl_num").val();
	if(har_rnum.substring(0,3) == "HAR"){
		location.href="/petbreedding/shopPayment?har_rnum="+har_rnum+"&cl_num="+cl_num+"";
	}else if(har_rnum.substring(0,3) == "HOS"){
		location.href = "/petbreedding/shopHosPayment?hos_rnum="+har_rnum+"&cl_num="+cl_num+"";
	}
});

//취소하기
$("#goCancle").on("click",function(){
	var cl_num = $("#cl_num").val();
	var har_rnum =$("#har_rnum").val();
	var hos_rnum = "";
	
	if(har_rnum.substring(0,3) == "HAR"){
		har_rnum = $("#har_rnum").val();
		$.ajax({
			url: "cancleRev",
			type:"POST",
			data:{har_rnum : har_rnum},
			success:function(data){
				canclePoint();
		        location.href="/petbreedding/mypage?cl_num="+cl_num+"";
			}
		});
	}else if(har_rnum.substring(0,3) == "HOS"){
		$.ajax({
			url: "cancleRev2",
			type:"POST",
			data:{hos_rnum : har_rnum},
			success:function(data){
				canclePoint();
		        location.href="/petbreedding/mypage?cl_num="+cl_num+"";
			}
		});
	}

	
});

function canclePoint(){
	var cl_num = $("#cl_num").val();
	var expId = $("#exp_Id").val();
	var expFrom = $("#shopName").val();
	var exp_date = $("#exp_date").val();
	$.ajax({
		url: "myPointCancle",
		type:"POST",
		data:{
			clNum : cl_num,
			expId : expId,
			expFrom : expFrom,
			expDate : exp_date
		},
		success:function(data){
	        location.href="/petbreedding/mypage?cl_num="+cl_num+"";
		}
	});
}

//모달
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
    $("#nextTime").on("click",function(){
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

//Element 에 style 한번에 오브젝트로 설정하는 함수 추가
Element.prototype.setStyle = function (styles) {
    for (var k in styles) this.style[k] = styles[k];
    return this;
};
document.getElementById('cancle').addEventListener('click', function () {
    // 모달창 띄우기
    modal('my_modal');
});

