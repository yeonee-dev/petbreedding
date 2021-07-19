/**
 * 
 */

$(function() {
	var userNum = $("#bpId").val();
	console.log(userNum);
	$(".pointline").click(function() {
		var idVar = $(this).attr("id");
		console.log(idVar);
		goDetail(idVar);
	});
	
	$("#myAskBtn").click(function() {
		var userNum = $(this).attr("name");
		console.log(userNum);
		location.href = "/petbreedding/bQna/writeFrm?user_num="+userNum+"";
	});

});

function goDetail(value){
	console.log(value);
	location.href = "/petbreedding/bQnaDetail?qna_num="+value+"";
}