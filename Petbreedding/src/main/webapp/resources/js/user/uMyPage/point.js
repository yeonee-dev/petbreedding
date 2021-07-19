/**
 * 
 */
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
$(function(){
	currentDay();
	$("#popular").trigger("click");
});
//3개월 클릭시
$("#popular").on("click",function(){
	var clNum = $("#cl_num").val();
	$.ajax({
		url:"pointDate",
		type:"POST",
		data:{clNum : clNum},
		success:function(data){
			successPrint(data);
		}
		
	})
});
//6개월 클릭시
$("#distance").on("click",function(){
	var clNum = $("#cl_num").val();
	$.ajax({
		url:"pointDate2",
		type:"POST",
		data:{clNum : clNum},
		success:function(data){
			successPrint(data);
		}
		
	})
});
//12개월 클릭시
$("#rating").on("click",function(){
	var clNum = $("#cl_num").val();
	$.ajax({
		url:"pointDate3",
		type:"POST",
		data:{clNum : clNum},
		success:function(data){
			successPrint(data);
		}
		
	})
});

//날짜 조회
$("#changeDate").on("click",function(){
	$("#popular").prop("checked",false);
	var clNum = $("#cl_num").val();
	var expDate = $("#start").val();
	var expDate2 = $("#end").val();
	$.ajax({
		url:"pointDate4",
		type:"POST",
		data:{
			clNum : clNum,
			expDate : expDate,
			expDate2 : expDate2
		},
		success:function(data){
			successPrint(data);
		}
		
	})
});



function successPrint(data){
	var html = "";
	
	$(".pointtable").empty();
	console.log("data " + data);
	if(data != null && data != ""){
		console.log("data null아님 ");
		for(var i in data){
			console.log("data " + data[i]);
			html += "<tr class='pointline'>";
			
			if(data[i].pointNum == 'PO1'){
				html += "<td class='pred'><div class='circlep'>"+data[i].expType+"</div></td>";
				html += "<td>"+data[i].expDate+"</td>";
				html += "<td>"+data[i].expFrom+"</td>";
				html += "<td class='pred'>-"+data[i].expPoint+"p</td>";
			}else if(data[i].pointNum == 'PO2'){
				html += "<td class='pgreen'><div class='circleg'>"+data[i].expType+"</div></td>";
				html += "<td>"+data[i].expDate+"</td>";
				html += "<td>"+data[i].expFrom+"</td>";
				html += "<td class='pgreen'>"+data[i].currPoint+"p</td>";
			}else if(data[i].pointNum == 'PO3' || data[i].pointNum == 'PO4'){
				html += "<td class='pgreen'><div class='circleg'>"+data[i].expType+"</div></td>";
				html += "<td>"+data[i].expDate+"</td>";
				html += "<td>"+data[i].expFrom+"</td>";
				html += "<td class='pgreen'>"+data[i].expPoint+"p</td>";
			}
			html += "</tr>";
		}

		$(".pointtable").append(html);
		html = "";
		
		//리스트 잘라서 5개만 보여주기
		$(".pointline").slice(0,4).show();
		
		$(".divmore").empty();
		
		//총 데이터 갯수가 5개가 초과하면 더보기 버튼 추가
        var moreBtn = "";
        moreBtn += "<button id='moreBtn'> 더보기</button>";
        if(data.length > 4 ){
				$(".divmore").append(moreBtn);				
			} 
        
        
	}else{
		$(".divmore").empty();
		console.log("else 아니냐구~");
		console.log("html : "+ html);
		html += "<tr class='pointline' style= 'display:block'>";
		html += "<td id='notice'><p>해당 기간의 포인트 내역이 없습니다.</p></td>";
		html += "</tr>";
		console.log("html : "+ html);
		$(".pointtable").append(html);
		html = "";
	}
}

//더보기
$(document).on("click","#moreBtn",function(){
	
	hiddenLikes = $(".pointline").filter(function(){
		return $(this).css('display') == 'none';
	});
	count = hiddenLikes.length;
	if(count == 0){
		$("#moreBtn").css("display","none");
		alert("더 이상 항목이 없습니다.");
	}else{
		$(hiddenLikes).slice(0,4).show();
	}
});