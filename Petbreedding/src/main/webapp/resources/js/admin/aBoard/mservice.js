/**
 * 
 */

$("#selectAnnType").on("change", function() {
	var annType = $(this).val();
	mserviceInit(annType, 1);
});


$(".goDetailRow").click(function() {
	var idVar = $(this).attr("id");
	console.log(idVar);
	
	goDetail(idVar);

});

function goDetail(value){
	console.log(value);
	location.href = "/petbreedding/mserviceDetail?ann_num="+value+"";
}

function mserviceInit(annType, p) {
	console.log(annType);
	console.log(p);

	$("#mserviceBox").hide();
	$("#page_nation").hide();
	
	$.ajax({
		url: "mserviceAjax"
		,type: "post"
		,data: {annType : annType, p : p}
		,dataType: "json"
		,success: function(json) {
			var div = "";
			var page = "";
			var jsonLength = Object.keys(json).length;
			
			console.log(json);
			console.log(p);
			
			$.each(json.list, function(index, item) {
				div += "<tr id='"+item.annNum+"' class='goDetailRow'>";
				
				if(item.annType == 0) {
					div += "<td>[전체]</td>";
				} else if(item.annType == 1) {
					div += "<td>[회원]</td>";
				} else {
					div += "<td>[사업자]</td>";
				}
				
				div += "<td>"+item.annTitle+"</td>"
					+ "<td>"+item.annDate+"</td>"
					+ "</tr>";
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
			
			$("#mserviceBox_ajax").html(div);
			$("#page_nation_ajax").html(page);
			
			$(".clickNum").on("click", function() {
				var p = $(this).text();
				console.log(p);
				mserviceInit(annType, p);
			});
			
			$(".goDetailRow").click(function() {
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