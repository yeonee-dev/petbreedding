var boNum = $("#boUpdBoNum").val();
var closeBtn = $("#closeBtnUpdComment");
var cl_num = $("#cl_num").val();
var userType = $("#userType").val();
console.log(userType);
$(function(){
	$.ajax({
		url: 'bocList'
		,type: 'get'
		,contentType : "application/json; charset:UTF-8"
		,data: {boNum: boNum}
		,dataType: 'json'
		,success: function(json) {
			var div = "";
			var bocMoal = "";
			var jsonLength = Object.keys(json).length;
			console.log(json);
			console.log(jsonLength);
			if(jsonLength > 0) {
				
				$.each(json, function(index, item) {
					div += "<div class='rArea'>";
					div += "<div class='replyArea'>";
					div += "<div class='replyUserInfo'>";
					div += "<p class='replyNickName'>"+item.clNickName+"</p>";
					div += "<p class='replyCon'>"+item.coCont+"</p>";
					div += "</div>";
					div +=  "<div>";
					div += "<p class='replyTime'>"+item.coDate+"</p>";
					if(item.clNum == cl_num){
						div +=  "<div class='replyUpdDel'>";
						div +=  "<p name='"+item.coNum+"' class='fboCommentUpdBtn'>수정</p>";
						div += "<p id='"+item.coNum+"' class='fboCommentDelBtn'>삭제</p>";
						div +=  "</div>";
					}
					else if(userType != "" && userType != null) {
						div +=  "<div class='replyUpdDel adDelBox'>";
						div += "<p id='"+item.coNum+"' class='fboCommentDelBtn adDelComment'>삭제</p>";
						div +=  "</div>";
					}
					div += "</div>";
					div += "</div>";
					div += "</div>";
						
				});
				
				$("#replyContainer").html(div);
				
				
				//리스트 잘라서 5개만 보여주기
				$(".rArea").slice(0,5).show();
		          //총 데이터 갯수가 5개가 초과하면 더보기 버튼 추가
	            var moreBtn = "";
	            moreBtn += "<div class='moreBox'>";
	            moreBtn += "<button class='basicBtn' id='moreBtn'> 더보기</button>";
	            moreBtn += "</div>";
	            if(jsonLength > 5 ){
						$("#replyContainer").append(moreBtn);				
					} 
				
				//	댓글 삭제 버튼 클릭
				$(".fboCommentDelBtn").click(function() {
					console.log("댓글 삭제 클릭 됨");
					var coIdVar = $(this).attr("id");	//	클릭된 행의 id
					$("#goTOPay_comment").attr("name", coIdVar);
					getCommentModal();
				});
				
				//	댓글 수정 버튼 클릭
				$(".fboCommentUpdBtn").click(function() {
					console.log("댓글 수정 클릭 됨")
					var coIdVar = $(this).attr("name");	//	클릭된 행의 id
					var replyCon = $(this).parent().parent().prev().find('.replyCon').text();
					$("#replyUpdCont").val(replyCon);
					$("#goTOPay_updComment").attr("name", coIdVar);
					console.log("replyCon : "+ replyCon);
					getUpdCommentModal();
				});
				
			}else {
				div += "<div class='replyArea'>"
				div	+= "<p>작성된 댓글이 없습니다.</p>";
				div	+= "</div>";
			}
			

			
		}
		
		,error : function(request, status, error) {
			alert("code: " + request.status + "\n"
					+ "message: "
					+ request.responseText + "\n"
					+ "error: " + error);
		}
		
	});
});
	
//더보기
$(document).on("click","#moreBtn",function(){
	
	console.log("들어왔슈");
	hiddenLikes = $(".rArea").filter(function(){
		return $(this).css('display') == 'none';
	});
	count = hiddenLikes.length;
	if(count == 0){
		$("#moreBtn").css("display","none");
		alert("더 이상 항목이 없습니다.");
	}else{
		$(hiddenLikes).slice(0,5).show();
	}
});

$("#bocSubmitBtn").click(function() {
	var queryString = $("#bocFrm").serialize();
	console.log(queryString);
	
	$.ajax({
		url: 'bocWrite'
		,type: 'post'
		,data: queryString
		,success: function() {
			location.reload();
		}
		,error : function(request, status, error) {
			alert("code: " + request.status + "\n"
					+ "message: "
					+ request.responseText + "\n"
					+ "error: " + error);
		}
		
	});
});

//자유 게시판 댓글 삭제
$("#goTOPay_comment").bind("click", function() {
	var CoNumVar = $(this).attr("name");
	console.log(CoNumVar);
	
	$.ajax({
		url: "bcdelete"
		,type: "get"
		,data: {co_num : CoNumVar, bo_num : boNum}
		,success: function() {
//			commentListInit(boNum);
			location.reload();
		}
		,error : function(request, status, error) {
			alert("code: " + request.status + "\n"
					+ "message: "
					+ request.responseText + "\n"
					+ "error: " + error);
			closeModal();
		}
	});
	
	

});


//	자유 게시판 댓글 수정
$("#goTOPay_updComment").bind("click", function() {
	var CoNumVar = $(this).attr("name");
	var updContText = $("#replyUpdCont").val();
	$.ajax({
		url: "bcupdate"
		,type: "get"
		,data: {co_num : CoNumVar, contVal : updContText}
		,success: function() {
//			commentListInit(boNum);
			location.reload();
		}
		,error : function(request, status, error) {
			alert("code: " + request.status + "\n"
					+ "message: "
					+ request.responseText + "\n"
					+ "error: " + error);
		}
	});

});

$(".closeBtn").on("click",function(){
	$(".bg").remove();
	$(".cModal").css("display","none");
});
