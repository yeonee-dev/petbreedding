var chk1 = $("#agreeInfo2").is(":checked");
var chk2 = $("#agreeInfo3").is(":checked");
var chk3 = $("#agreeInfo4").is(":checked");
//이용동의 체크여부 확인
$("#agreeInfo1").on("click",function(){
    var chk = $(this).is(":checked");
    if(chk){
        $(".agreeAll").prop('checked', true);
    } else {
        $(".agreeAll").prop('checked', false);
    }
});

$(".agreeAll").on("click", function(){
    var allchk = $("input:checkbox[class=agreeAll]:checked").length;
    if(allchk != 3){
        $("#agreeInfo1").prop('checked',false);
    }else{
        console.log("allchk : " + allchk);
        $("#agreeInfo1").prop('checked',true); 
    }
});


$("#pointAll").on("click",function(){
    var usingPoint = $("#nowPoint").text();
    if($("#pointAll").is(':checked') == true){
    	$("#pointArea").val(usingPoint).change();   
    }else if($("#pointAll").is(':checked') == false){
    	$("#pointArea").val("0").change();  
		$(".usePoint").text("0").change();
    }
});

//총결제 금액 뿌리기 
var total = $("#totalPrice").text();
$(function(){
	$("#payMoney").html(total);
});


//포인트 사용시 결제금액 변화
$("#pointArea").on("propertychange change keyup paste input oninput ",function(){
	var using = $("#pointArea").val();	
	// 전체 콤마 제거
	const number = total.replace(/,/g, "");
	const number2 = using.replace(/,/g, "");
	
	var nowPoint = $("#nowPoint").text();
	$(".usePoint").text(using);

	nowPoint = nowPoint*1;
	using = using*1;
	console.log("using : "+ using);
	console.log("nowPoint : "+ nowPoint);
	if(nowPoint < using){
		alert("보유 포인트보다 더 큰 금액은 입력하실 수 없습니다.");
		$("#pointArea").val("");
		$(".usePoint").text("0");
		$("#pointAll").prop('checked', false);
		return false;
	}else{
		var pay = 0;
		pay = number - number2;
		pay = pay.toLocaleString();
		$("#payMoney").text(pay);
	}
	
	
});