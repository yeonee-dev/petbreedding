var totalCheckbox = $("input[name=bP]").length;
var checkedBox = $("input[name=bP]:checked").length;

//전체선택시
$("#checkall").on("click", function(){
	
	if ($("#checkall").prop("checked") == false) {
		$("input[name=bP]").prop("checked", false);		
	} else {
		$("input[name=bP").prop("checked", true);		
	}
});

//하나라도 해지 or 각각 checkbox 눌러서
$(".inputBox").on("click", function(){
	checkedBox = $("input[name=bP]:checked").length;
	if(totalCheckbox>checkedBox){
		$("#checkall").prop("checked", false);	
	}else if(totalCheckbox == checkedBox){
		$("#checkall").prop("checked", true);
	}
});

//승인 대기 게시판

//승인버튼 눌렀을때  //사업자번호로 체크
$("#confirmBP").on("click",function(){

	var arr = [];
	$("input[name=bP]:checked").each(function(item){
		arr.push($(this).parent().next().next().next().html());
	});
	var allData = {"bp_num" : arr};
	
	$.ajax({
		url : "confirmBP",
		type : "POST",
		data : {arr : arr},
		success : function(data){
			if(data > 0){
				alert("승인 처리가 완료되었습니다.");
				location.reload();
			}else{
				alert("승인처리 오류");
			}
		},
		error: function(){
			console.log("에러");
		}
		
	});
});


//거절버튼 눌렀을때  //사업자번호로 체크
$("#refuseBP").on("click",function(){

	var arr = [];
	$("input[name=bP]:checked").each(function(item){
		arr.push($(this).parent().next().next().next().html());
	});
	var allData = {"bp_num" : arr};
	
	$.ajax({
		url : "refuseBP",
		type : "POST",
		data : {arr : arr},
		success : function(data){
			if(data > 0){
				alert("승인 거절이 완료되었습니다.");
				location.reload();
			}else{
				alert("승인 거절처리 오류");
			}
		},
		error: function(){
			console.log("에러");
		}
		
	});
});


//제휴 취소 대기 게시판

//승인버튼 눌렀을때  //사업자번호로 체크
$("#deleteBP").on("click",function(){

	var arr = [];
	$("input[name=bP]:checked").each(function(item){
		arr.push($(this).parent().next().next().next().html());
	});
	var allData = {"bp_num" : arr};
	
	$.ajax({
		url : "deleteBP",
		type : "POST",
		data : {arr : arr},
		success : function(data){
			if(data > 0){
				alert("제휴 취소 처리가 완료되었습니다.");
				location.reload();
			}else{
				alert("제휴 취소 처리 오류");
			}
		},
		error: function(){
			console.log("에러");
		}
		
	});
});

//취소 눌렀을때  //사업자번호로 체크
$("#backBP").on("click",function(){

	var arr = [];
	$("input[name=bP]:checked").each(function(item){
		arr.push($(this).parent().next().next().next().html());
	});
	var allData = {"bp_num" : arr};
	
	$.ajax({
		url : "backBP",
		type : "POST",
		data : {arr : arr},
		success : function(data){
			if(data > 0){
				alert("제휴 취소가 정상 철회되었습니다.");
				location.reload();
			}else{
				alert("취소처리 오류");
			}
		},
		error: function(){
			console.log("에러");
		}
		
	});
});