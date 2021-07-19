/**
 * 
 */

$(".mTr").click(function() {
	var idVar = $(this).attr("id");
	console.log(idVar);
	goDetail(idVar);
});


$("#selectQnaType").on("change", function() {
	var qnaType = $(this).val();
	var selectQnaChk = $("#selectQnaChk");
	var qnaChk = selectQnaChk.val();
	
	console.log(qnaType);
	console.log(qnaChk);
	
	mboardInit(qnaType, qnaChk, 1);
});

$("#selectQnaChk").on("change", function() {
	var qnaChk = $(this).val();
	var selectQnaType = $("#selectQnaType");
	var qnaType = selectQnaType.val();
	
	console.log(qnaType);
	console.log(qnaChk);
	
	mboardInit(qnaType, qnaChk, 1);
});


function goDetail(value){
	console.log(value);
	location.href = "/petbreedding/mboardcon?qna_num="+value+"";
}

function mboardInit(qnaType, qnaChk, p) {
	console.log("ajax 함수 진입")
	console.log(qnaType);
	console.log(qnaChk);
	
	$("#myAskBox").hide();
	$("#page_nation").hide();
	
	
	$.ajax({
		url: "mboardAjax"
		,type: "get"
		,data: {qnaType: qnaType, qnaChk : qnaChk, p : p}
		,dataType: "json"
		,success: function(json) {
			var div = "";
			var page = "";
			var jsonLength = Object.keys(json).length;
			
			console.log(json);
			console.log(p);
			console.log(paging);
			
				
				$.each(json.list, function(index, item) {
					
						div += "<tr id='"+item.qnaNum+"' class='mTr'>";
						
						if(item.qnaType == 1) {
							div += "<td>[회원]</td>";
						} else {
							div += "<td>[사업자]</td>";
						}
						
						div += "<td>"+item.qnaTitle+"</td>"
						+ "<td>"+item.qnaWr+"</td>"
						+ "<td>"+item.qnaDate+"</td>";
						
						if(item.qnaChk == 0) {
							div += "<td><button class='basicBtn' id='waitBtn'>답변대기</button></td>";
						} else {
							div += "<td><button class='basicBtn' id='successBtn'>답변완료</button></td>";
						}
						
				});
				
				page += "<div id='page_nation' class='page_nation'>";
				
				if(json.paging.startPage != 1) {
					page += "<a class='arrow prev clickNum'>이전</a>";
				}
				
				for(var i = json.paging.startPage; i <=  json.paging.endPage; i++) {
					if(i == json.paging.nowPage) {
						page += "<b>"+i+"</b>";
					} else if(i != json.paging.nowPage) {
						page += "<a class='clickNum'>"+i+"</a>";
					}
				}
				
				if(json.paging.endPage != json.paging.lastPage) {
					page += "<a class='arrow next clickNum'>다음</a>";
				}
				
				page += "</div>"
					 + "</div>";
				
				
				$("#myAskBoxAjax").html(div);
				$("#page_nation_ajax").html(page);
				
				
				$(".clickNum").on("click", function() {
					var p = $(this).text();
					console.log(p);
					mboardInit(qnaType, qnaChk, p);
				});
				
				$(".mTr").click(function() {
					var idVar = $(this).attr("id");
					console.log(idVar);
					goDetail(idVar);
				});
				
			
			
		}
	
		,error : function(request, status, error) {
			alert("code: " + request.status + "\n" + "message: "
					+ request.responseText + "\n" + "error: "
					+ error);
		}
		
	});
}
