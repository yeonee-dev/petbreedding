$(document).ready(function() {
	
	// 웹소켓 연결
    connect();
    console.log("enterRoom");
    scrolldown();
        
    // enter 키 이벤트 - 전송
	$('#message').keyup(function(e) {
         if(e.keyCode == 13 && !e.shiftKey) {
 			sendMessage();
			$('#message').val('');
			event.preventDefault();
         }
    });
	
	// 전송 버튼 누르면 전송
	$('#sendBtn').click(function() {
		sendMessage();
		$('#message').val('');
	});
	
	// esc 키 이벤트 - 창 닫기
	$(window).keyup(function(e) {
        if(e.keyCode == 27) {
			this.close();
        }
   });

});
               
// 웹소켓
let sock;
 
// 입장 버튼을 눌렀을 때 호출되는 함수
function connect() {
    // 웹소켓 주소 및 객체 생성
	sock = new SockJS("http://localhost:8090/petbreedding/chat/");
	// 웹 소켓에 이벤트가 발생했을 때 호출될 함수 등록
	sock.onopen = onOpen;
	sock.onmessage = onMessage;
	sock.onclose = onClose;
 }
     
// 웹 소켓에 연결되었을 때 호출될 함수
function onOpen() {
	var chatId = $("#chatId").val();
	if(chatId==""&&chatId==null){
		chatId = 0;
	}
	// ENTER-CHAT 이라는 메세지를 보내어, Java Map에 session 추가
	message = {};
	message.chatId = chatId;
	message.mContent = "ENTER-CHAT";
	let jsonData = JSON.stringify(message);
	sock.send(jsonData);
};

function onMessage(evt) {
	console.log('온메시지 들어옴');
	var data = evt.data;
	console.log('data' + data);
	console.log(data);
	var obj = JSON.parse(data);
	console.log(obj)
	appendMessage(obj);
};
	
function onClose() {
	console.log('close');
//	var chatId = $("#chatId").val();
//	var user = $("#user").val();
//	var cl_num = $("#cl_num").val();
//	var bp_id = $("#bp_id").val();
//	if(user!='user'){
//		location.href = "/petbreedding/insertNoticeforChat.do?mReceiver="
//			+cl_num+"&chatId="+chatId+"&notPublisher="+bp_id;	
//	}
};


function sendMessage() {
	var msg = $("#message").val();
	if (msg != "") {
		message = {};
		message.mContent = $("#message").val();
		message.mSender = $("#sender").val();
		message.mSenderName = $("#senderName").val();
		message.mSenderemail = $("#email").val();
		message.mReceiver = $("#receiver").val();
		message.mSendTime = getTimeStamp();
		message.chatId = $("#chatId").val();
		message.cl_num = $("#cl_num").val();
		message.bp_id = $("#bp_id").val();
	}
	sock.send(JSON.stringify(message));
}

function getTimeStamp() {
	var d = new Date();
	var s = leadingZeros(d.getFullYear(), 4) + '-'
			+ leadingZeros(d.getMonth() + 1, 2) + '-'
			+ leadingZeros(d.getDate(), 2) + ' ' +

			leadingZeros(d.getHours(), 2) + ':'
			+ leadingZeros(d.getMinutes(), 2) + ':'
			+ leadingZeros(d.getSeconds(), 2);

	return s;
}

function leadingZeros(n, digits) {
	var zero = '';
	n = n.toString();

	if (n.length < digits) {
		for (i = 0; i < digits - n.length; i++)
			zero += '0';
	}
	return zero + n;
}

function appendMessage(msg) {
	var id = $("#rid").val();
	
	if (msg.mContent == '') {
		return false;
	} else {
		if(msg.mSenderemail == id){
		$("#chatMessageArea")
				.append(
						"<div class='col-12 row dMessageO'><div class='col-2 dMessage my'><div class='dNick'>"
								+ msg.mSenderName +"</div></div><br><div class='col-10 dConO my'><div class='col-12 dConI mycolor'><span>"
								+ msg.mContent + "</span></div><div class='col-12 dTimeO'><br><div>"
								+ msg.mSendTime + "</div></div></div></div><br><br><br><br>");
		} else {
			$("#chatMessageArea")
			.append(
					"<div class='col-12 row dMessageO'><div class='col-2 dMessage U'><div class='dNick'>"
							+ msg.mSenderName +"</div></div><br><div class='col-10 dConO U'><div class='col-12 dConI Ucolor'><span>"
							+ msg.mContent + "</span></div><div class='col-12 dTimeO'><br><div>"
							+ msg.mSendTime + "</div></div></div></div><br><br><br><br>");
		}
		scrolldown();
	}
	
}

//스크롤 쭉 내리기
function scrolldown(){
	var scHeight = $("#chatArea").prop('scrollHeight');
	$("#chatArea").animate({ scrollTop: scHeight }, "slow");	
}

// 채팅 창 내 매장명 클릭 시 매장 정보 페이지로 이동
function openshopwin(inbpId,inshopType) {
	var bpId = inbpId;
	var shopType = inshopType;
	var url = '/petbreedding/shopPage?bpId='+bpId+'&shopType='+shopType;
	window.open(url, '_blank');
}
