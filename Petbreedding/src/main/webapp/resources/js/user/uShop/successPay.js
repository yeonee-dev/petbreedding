/**
 * 
 */
var cl_num = $("#cl_num").val();
$("#goRev").on("click", function(){
	location.href="/petbreedding/mypage?cl_num="+cl_num+"";
});