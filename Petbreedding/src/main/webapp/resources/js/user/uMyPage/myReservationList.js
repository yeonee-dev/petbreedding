var modal = document.getElementById("modalRe");
var modalReWin = document.getElementById("modalRe-Win");
var btnReWr = document.getElementById("btnReWr")
var selectedEle = document.getElementById("selectedVal");


$(function(){
	currentDay();
	$("#searchDate").trigger("click");
	
	
});
function currentDay(){
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth() + 1;    //1월이 0으로 되기때문에 +1을 함.
    var date = now.getDate();

    month = month >=10 ? month : "0" + month;
    date  = date  >= 10 ? date : "0" + date;
     // ""을 빼면 year + month (숫자+숫자) 됨.. ex) 2018 + 12 = 2030이 리턴됨.

    var today = ""+year+"-" + month+"-" + date;
    
    $("#start").val(today);
    $("#end").val(today);
}

$("#imgUpBtn").on("click", function() {
	$("#reviewImg").trigger("click");
});

$("#reviewImg").on("change",function(){
	var fileName = $("#reviewImg").val();
    $("#imgUpBtn i").append("<small id='fileName'>" +fileName +"</small>");
});





function onClickSelect (e) {
	const isActive = e.currentTarget.className.indexOf("active") !== -1;
	if (isActive) {
		e.currentTarget.className = "select";
		document.querySelector(".downArrow").innerHTML = "";
	} else {
		e.currentTarget.className = "select active";
		document.querySelector(".downArrow").innerHTML += "&#9660;"
	}
}

function onClickOption(e) {
	const selectedValue = e.currentTarget.innerHTML;
	document.querySelector(".text").innerHTML = selectedValue;
	selectedEle.value = e.currentTarget.value;
    console.log(selectedEle.value);
    console.log(typeof(selectedEle.value));
}
// modal 창 열기
function modalOn(har_num, har_name, har_rnum) {
	modal.style.display = "flex";
	$("#for_value_har_num").val(har_num);	// param == har_num (미용실 번호)
	$("#for_value_har_name").val(har_name);	// param == har_num (미용실 이름)
	$("#for_value_har_rnum").val(har_rnum);	// param == har_rnum (예약번호)
	
}
//modal 창 닫기
function modalOff() {
	modal.style.display = "none";
}
var closeBtn = modal.querySelector(".modal_close_btn")
closeBtn.addEventListener("click", function() {
	modalOff();
});

document.querySelector(".select").addEventListener("click", onClickSelect);
	
	var optionList = document.querySelectorAll(".option");
	for (var i = 0; i < optionList.length; i++) {
		var option = optionList[i];
		option.addEventListener("click", onClickOption);
}

$("#regBtn").on("click", function() {
	modalOff(); //modal 창 닫기
    $("#frmReviewInput").attr("action", "rwrite");
    $("#frmReviewInput").attr("method", "POST");
    $("#frmReviewInput").submit();
});


//조회하기 눌렀을떄
$("#searchDate").on("click",function(){
	var cl_num = $("#cl_num").val();
	var res_date = $("#start").val();
	var res_date2 = $("#end").val();
	
	if((res_date == null || res_date =="") && (res_date2 == null || res_date2 =="")){
		alert("조회하실 날짜를 입력해주세요!");
		return false;
	}else{
		$.ajax({
			url:"mypage2",
			type:"GET",
			data :{
				cl_num : cl_num,
				res_date : res_date,
				res_date2 : res_date2,
			},
			success: function(data){
				
				$(".rlist").empty();
				
				var tr = "";
				tr += "<tr id='rListHead'>";
				tr += "<td>예약일</td>";
				tr += "<td>예약정보</td>";
				tr += "<td colspan='2'>상태</td>";
				tr += "</tr>";
				
				$(".rlist").append(tr);
				 
 
				if(data.length>0){//데이터가 있으면
					
		          for(var i in data){//데이터를 하나씩 뽑아냄
		          //i번째 data 중 key가 id인 것의 value
		            var $res_date = data[i].res_date;
		          //i번째 data 중 key가 name인 것의 value
		            var $har_name = data[i].har_name; 
		            var $res_status = data[i].res_status;
		            var res_status;
		            var $har_rnum = data[i].har_rnum;
		            var $har_num = data[i].har_num;
		            var $res_chk = data[i].res_chk;
		            if($res_status == 0){
		            	res_status = "결제대기";
		            }else if($res_status == 1){
		            	res_status = "결제완료";
		            }else if($res_status == 2){
		            	res_status = "이용완료";
		            	
		            }else if($res_status == 3){
		            	res_status = "이용취소";
		            }
		            var param = "'"+$har_rnum+"'";  // 예약번호
		            var param_har_num = '"'+$har_num+'"';  // 미용실번호
		            var param_har_name = '"'+$har_name+'"';  // 미용실이름
		            var param_har_rname = '"'+$har_rnum+'"';  // 예약 번호
		            
		            var td = "";
		            //td += '<tr onclick="goDetail('+param+')">'; // 리뷰 작성 버튼과 겹치기 때문에 onClick 보다 우선 순위가 더 낮은 id를 통해 페이지 이동
		            td += "<tr id="+param+" class='resInfoBox' style='display:none;'>";
		            td += "<td>"+$res_date+"</td>";
		            td += "<td>"+$har_name+"</td>";
		            if(res_status == "이용완료"){
		            	 td += "<td>"+res_status+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		            	 
		            	 if($res_chk == 0) {
		            		 td += "<button onClick='modalOn("+param_har_num+", "+param_har_name+", "+param_har_rname+"); return true;' type='button' class='basicBtn review btnReWr'>리뷰작성</button>"
			            	 +"</td>";
		            	 } else {
		            		 td += "<button type='button' id='reviewDone' class='basicBtn review'>작성완료</button>"
				            	+"</td>";
		            	 }
		            	 

		            }else{
		            	 td += "<td>"+res_status+"</td>";
//		            	 td += "<td>"+res_status+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
//		            	 "<button type='button' id='reviewDone' class='basicBtn review'>작성완료</button>"
//		            	 +"</td>";
		            }
		            td += "</tr>";

		            $(".rlist").append(td);


		            $(".resInfoBox").click(function() {
		            	var idVar = $(this).attr("id");	//	클릭된 행의 id
		            	var th = $(this).find('.btnReWr');	//	클릭된 행의 리뷰 작성 버튼
		            	
		            	if(th.length < 1) {	//	버튼이 있는 행은 길이가 1, 없는 행은 길이가 0이므로 1보다 작으면 goDetail 함수를 실행해서 상세페이지로 이동
		            		goDetail(idVar);
		            	}
		            });
		             	
		          }
		          
		          //리스트 잘라서 5개만 보여주기
		          $(".resInfoBox").slice(0,5).show();

		          
		          $(".divmore").empty();
		          
		          //총 데이터 갯수가 5개가 초과하면 더보기 버튼 추가
	               var moreBtn = "<button type='button' id='btnmore' onclick='clickMore()'>더보기</button>"; 
	               if(data.length > 5 ){
						$(".divmore").append(moreBtn);				
					} 

		         }else{
		        	 var td = "";
		        	 td += "<tr>";
		        	 td += "<td colspan='4'>해당 기간에 예약하신 내역이 없습니다.</td>";
		        	 td += "</tr>";
		        	 $(".rlist").append(td);
		         } 
				
			}
		});
	}
	
	
});

//더보기 버튼 눌렀을시
function clickMore(){
	console.log("들어왔슈");
	hiddenComment = $(".resInfoBox").filter(function(){
		return $(this).css('display') == 'none';
	});
	count = hiddenComment.length;
	if(count == 0){
		$("#btnmore").css("display","none");
		alert("더 이상 항목이 없습니다.");
	}else{
		$(hiddenComment).slice(0,5).show();
	}
}


//상세보기페이지 진입
function goDetail(value){
	
	if(value.substring(0,3) == "HAR"){
		har_rnum = value;
		location.href = "/petbreedding/revdetail?har_rnum="+har_rnum+"";
	}else if(value.substring(0,3) == "HOS"){
		hos_rnum = value;
		location.href = "/petbreedding/revdetail2?hos_rnum="+hos_rnum+"";
	}
	var har_rnum ="";
	var hos_rnum = "";
}



