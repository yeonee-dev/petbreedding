
// placing objects inside variables
var content = $('.bContent');
var sidebar = $('.bAside');
var bmenu = $('.bMenu');
var bSideMenu = $('.bSideMenu');
// get content and sidebar height in variables
var getContentHeight = content.outerHeight();
var getSidebarHeight = sidebar.outerHeight();

// check if content height is bigger than sidebar
if ( getContentHeight > getSidebarHeight ) {
	sidebar.css('min-height', getContentHeight);
    bmenu.css('min-height', getContentHeight);
    bSideMenu.css('min-height', getContentHeight);
}

// check if sidebar height is bigger than content
if ( getSidebarHeight > getContentHeight ) {
	content.css('min-height', getSidebarHeight);
    bmenu.css('min-height', getSidebarHeight);
    bSideMenu.css('min-height', getSidebarHeight);
}



//제휴 취소 신청 누르면 모달창 띄움
$("#cancleM").on("click",function(){
	$("#cancel-modal").css("display","block");
});


$("#noCalncle").on("click",function(){
	$("#cancel-modal").css("display","none");
});


$("#yesCalncle").on("click",function(){
	var bp_Id = $("#bp_Id").val();
	
	$.ajax({
		url: "bDeleteDo",
		type : "POST",
		data : {bp_Id : bp_Id},
		success : function(data){
			if(data >0){
				alert("정상적으로 탈퇴신청처리 되었습니다.");
				location.href = "/petbreedding/bIndex";
			}else{
				alert("오류가 발생했습니다. 관리자에게 문의해주세요.");
				
			}
		},
		error : function(error){
			alert("오류가 발생했습니다. 관리자에게 문의해주세요.");
		}
	});
	
	
	
});