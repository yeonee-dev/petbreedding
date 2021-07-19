window.onload = function() {
	$.ajax({
		url : "/petbreedding/notification.do",
		type : "POST",
		success : function(data){
			if(data!=0){				
				var notice = "<div class='notice' onclick='redirect();'><img src='/petbreedding/resources/images/logo-square.png'>&nbsp;&nbsp;<div class='noticetext'>읽지 않은 알림이"+data+"개 있습니다!</div></div>"
				$('body').append(notice);
				var alarm = new Audio("/petbreedding/resources/video/notification.mp3");
				alarm.play();
			}
		},
		error : function(error){
			alert("오류 발생")
		}
	})
}

function redirect() {
	location.href="/petbreedding/noticelist";
}