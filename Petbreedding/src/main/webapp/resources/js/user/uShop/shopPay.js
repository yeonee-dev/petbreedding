var name = $("#name").text();
var tel = $("#tel").text();
var total_price = $("#totalPrice").text();
total_price = total_price.replace(/,/g, "");
total_price = parseInt(total_price);
var email = $("#email").text();
var har_rnum = $("#har_rnum").val();


$("#reservation_btn").click(function() {
	var pay_price = $("#payMoney").text();
	pay_price = pay_price.replace(/,/g, "");
	pay_price = parseInt(pay_price);
	console.log(pay_price);
	if($("#agreeInfo1").is(":checked") == true){
		var IMP = window.IMP; // 생략가능
		IMP.init('imp92318493');
		// 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
		// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
		IMP.request_pay({
			pg : 'payco', // version 1.1.0부터 지원.
			/*
			 * 'kakao':카카오페이, html5_inicis':이니시스(웹표준결제) 'nice':나이스페이 'jtnet':제이티넷
			 * 'uplus':LG유플러스 'danal':다날 'payco':페이코 'syrup':시럽페이 'paypal':페이팔
			 */

			pay_method : 'card',
			/*
			 * 'samsung':삼성페이, 'card':신용카드, 'trans':실시간계좌이체, 'vbank':가상계좌,
			 * 'phone':휴대폰소액결제
			 */
			merchant_uid : 'merchant_' + new Date().getTime(),
			/*
			 * merchant_uid에 경우 https://docs.iamport.kr/implementation/payment 위에
			 * url에 따라가시면 넣을 수 있는 방법이 있습니다. 참고하세요. 나중에 포스팅 해볼게요.
			 */
			name : '주문명:결제테스트',
			// 결제창에서 보여질 이름
			amount : '100',
			// 가격
			buyer_email : email,
			buyer_name : name,
			buyer_tel : tel,
			// buyer_addr: '서울특별시 강남구 삼성동',
			// buyer_postcode: '123-456',
			m_redirect_url : 'successPay'
		/*
		 * 모바일 결제시, 결제가 끝나고 랜딩되는 URL을 지정 (카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로
		 * callback함수로 결과가 떨어짐)
		 */
		}, function(rsp) {
			console.log(rsp);
			if (rsp.success) {
				var msg = '결제가 완료되었습니다.';
				
				
				var pay_num = rsp.imp_uid; 

				if(har_rnum.substring(0,3) == "HAR"){
					//Har_pay에 저장하게하기
					$.ajax({
						url : "harPay",
						data : {
							card_num : pay_num,
							har_rnum : har_rnum,
							pay_price : pay_price,
							total_price : total_price
						},
						type : "post",
						success : function(data) {
							console.log(data);
							console.log("성공");
							updateSuccess();
							updatePoint();
							location.href = '/petbreedding/successPay';
						},
						error : function(jqxhr, textStatus, errorThrown) {
							console.log("ajax 처리 실패");
						}
					});
				}else if(har_rnum.substring(0,3) == "HOS"){
					//Hos_pay에 저장하게하기
					$.ajax({
						url : "hosPay",
						data : {
							card_num : pay_num,
							hos_rnum : har_rnum,
							pay_price : pay_price,
							total_price : total_price
						},
						type : "post",
						success : function(data) {
							console.log(data);
							console.log("성공");
							updateSuccess();
							updatePoint();
							location.href = '/petbreedding/successPay';
						},
						error : function(jqxhr, textStatus, errorThrown) {
							console.log("ajax 처리 실패");
						}
					});
				}
				

			} else {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
			}
			

		});
	
	}else{
		alert("이용동의에 모두 체크해주세요.");
		return false;
	}
	
});

function updateSuccess(){
	//har_rnum으로 결제완료로 업데이트 시켜주기
	if(har_rnum.substring(0,3) == "HAR"){
		$.ajax({
			url:"harRevUp",
			type:"GET",
			data:{har_rnum:har_rnum}
		});
	}else if(har_rnum.substring(0,3) == "HOS"){
		$.ajax({
			url:"hosRevUp",
			type:"GET",
			data:{hos_rnum:har_rnum}
		});
	}

}

function updatePoint(){
	var exp_point = $("#pointArea").val();
	var exp_from = $("#exp_from").val();
	var cl_num = $("#cl_num").val();
	var exp_Id = $("#exp_Id").val();
	
	if(exp_point >0){
		$.ajax({
			url:"myPoint",
			type:"GET",
			data:{
				clNum:cl_num,
				expFrom : exp_from,
				expId : exp_Id,
				expPoint : exp_point
			}
		});
	}
	
}




