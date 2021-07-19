var name =  $("#name").text();
var tel =   $("#tel").text();
var type =  $("#CM_TYPE").text();
var price =   $("#price").text();
var email = $("#email").text();
var cmcode = $("#CM_CODE").val();
var bpid =  $("#BP_ID").val();
price = parseInt(price);
console.log(name);
console.log(tel);
console.log(type);
console.log(price);
console.log(email);
console.log(cmcode);
console.log(bpid);


$("#check_module").click(function () {
	if($("#agrs1").is(":checked") == true){
var IMP = window.IMP; // 생략가능
IMP.init('imp92318493');
// 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
IMP.request_pay({
pg: 'payco', // version 1.1.0부터 지원.
/*
'kakao':카카오페이,
html5_inicis':이니시스(웹표준결제)
'nice':나이스페이
'jtnet':제이티넷
'uplus':LG유플러스
'danal':다날
'payco':페이코
'syrup':시럽페이
'paypal':페이팔
*/
pay_method: 'card',
/*
'samsung':삼성페이,
'card':신용카드,
'trans':실시간계좌이체,
'vbank':가상계좌,
'phone':휴대폰소액결제
*/
merchant_uid: 'merchant_' + new Date().getTime(),
/*
merchant_uid에 경우
https://docs.iamport.kr/implementation/payment
위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
참고하세요.
나중에 포스팅 해볼게요.
*/
name: '주문명:결제테스트',
//결제창에서 보여질 이름
amount: '100',
//가격
buyer_email: email,
buyer_name: name,
buyer_tel: tel,
//buyer_addr: '서울특별시 강남구 삼성동',
//buyer_postcode: '123-456',
m_redirect_url: 'successCta'
/*
모바일 결제시,
결제가 끝나고 랜딩되는 URL을 지정
(카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
*/
}, function (rsp) {
console.log(rsp);
if (rsp.success) {
var msg = '결제가 완료되었습니다.';
location.href = 'successCta';
paysuceess();


} else {
var msg = '결제에 실패하였습니다.';
msg += '에러내용 : ' + rsp.error_msg;
}




});
	}else{
		alert("이용동의에 모두 체크해주세요.");
		return false;
	}

/*ajax*/


});

function paysuceess() {
	$.ajax({
	    url:"ctapaydata",
	    data:{BP_ID: bpid,
	    	  CM_CODE : cmcode, 
	    	  CM_TYPE : type
	    },
	    type:"post",
	    success:function(data){
	        console.log(data);
	        console.log("성공");
	        insertcount();
	        
	    },
	    error:function(jqxhr, textStatus, errorThrown){
	        console.log("ajax 처리 실패");
	    }
	});
	
	function updatecount() {
		$.ajax({
		    url:"updatemycta",
		    data:{BP_ID: 1,
		    	  CM_CODE : cmcode 	
		    },
		    type:"post",
		    success:function(data){
		        console.log(data);
		        console.log("성공");
		        
		    },
		    error:function(jqxhr, textStatus, errorThrown){
		        console.log("ajax 처리 실패");
		    }
		});
		
		function insertcount() {
			$.ajax({
			    url:"insertmycta",
			    //TODO
			    data:{BP_ID: 1,
			    	CTA_NUMBER : cmcode 	
			    },
			    type:"post",
			    success:function(data){
			        console.log(data);
			        console.log("성공");
			        
			    },
			    error:function(jqxhr, textStatus, errorThrown){
			        console.log("ajax 처리 실패");
			    }
			});
		}
	}
}