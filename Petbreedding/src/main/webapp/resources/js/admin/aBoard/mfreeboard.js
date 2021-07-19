/**
 * 
 */

// myboard 전체선택
function selectAll(selectAll)  {
	console.log("전체선택 함수 들어옴");
    const checkboxes = document.getElementsByName('board');
    checkboxes.forEach((checkbox) => {
      checkbox.checked = selectAll.checked;
    });
  }

//boardDetail로 이동
$(".goDetail").on("click",function(){
	var boNum = $(this).prev().find('input').val();
	var userType = $("#userType").val();
	console.log(boNum);
	console.log(userType);
	location.href = "fboardcon?boNum="+boNum+"&userType="+userType+"";
});

//댓글삭제 눌렀을때 
$("#deleteCM").on("click",function(){
	var arr = [];
	$("input[name=board]:checked").each(function(item){
		arr.push($(this).val());
	});
	var allData = {"coNum" : arr};
	$.ajax({
		url : "mycdelete",
		type : "POST",
		data : {arr : arr},
		success : function(data){
			if(data > 0){
				alert("댓글이 삭제되었습니다.");
				location.reload();
			}else{
				alert("댓글삭제 오류");
			}
		},
		error: function(){
			console.log("에러");
		}
		
	});
});

//글삭제 눌렀을때 
$("#deleteBoard").on("click",function(){
	console.log("글 삭제 함수 들어옴");
	var arr = [];
	$("input[name=board]:checked").each(function(item){
		arr.push($(this).val());
	});
	var allData = {"coNum" : arr};
	$.ajax({
		url : "myBoarddelete",
		type : "POST",
		data : {arr : arr},
		success : function(data){
			if(data > 0){
				alert("글이 삭제되었습니다.");
				location.reload();
			}else{
				alert("글삭제 오류");
			}
		},
		error: function(){
			console.log("에러");
		}
		
	});
});