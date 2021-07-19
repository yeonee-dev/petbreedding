/**
 * 
 */
var cl_num = $("#cl_num").val();
//찜목록 뿌리기
$(function(){
	
	$.ajax({
		url: "myzzimList",
		type:"GET",
		data:{
			cl_num : cl_num
		},
		success:function(data){
			var html = "";
			
			$(".zzimlist").empty();
			if(data.length > 0){

				for(var i in data){
					
					html += "<div class='subdiv'>";	
					if(data[i].bp_type == 0){
						html += "<a href='shopPage?bpId="+data[i].hairSalon.bpId+"&shopType="+data[i].bp_type+"&y="+data[i].hairSalon.y+"&x="+data[i].hairSalon.x+"'}>";
					}else if(data[i].bp_type == 1){
						html += "<a href='shopPage?bpId="+data[i].hospital.bpId+"&shopType="+data[i].bp_type+"&y="+data[i].hairSalon.y+"&x="+data[i].hairSalon.x+"'}>";
					}
					html += "<div class='img'>";
					html += "<img src='/petbreedding/resources/uploadFile/shop/"+data[i].har_img+"' style='width:200px; height: 100px;'>";
					html += "</div>";
					html += "<div class='title'>";
					html += "<h1>"+data[i].hairSalon.shopName+"</h1><br>";
					html += "<p>"+data[i].hairSalon.shopMInfo+"</p>";
					html += "</div>";
					html += "</a>";
					html += "</div>";
					if(data[i].bp_type == 0){
						html += "<input type='hidden' class='har_num' value="+data[i].har_num+">";
					}else if(data[i].bp_type == 1){
						html += "<input type='hidden' class='hos_num' value="+data[i].hos_num+">";
					}
					html += "<div class='zzimdel'>";
					html += "<button class='zzimdelBtn basicBtn'>찜 해제</button>";
					html += "</div>";
				}	
				
				$(".zzimlist").append(html);
				html ="";
				
				//리스트 잘라서 5개만 보여주기
				console.log($(".subdiv").slice(0,5));
				$(".subdiv").slice(0,5).show();

	          //총 데이터 갯수가 5개가 초과하면 더보기 버튼 추가
               var moreBtn = "";
               moreBtn += "<button class='basicBtn' id='moreBtn'> 더보기</button>";
               if(data.length > 5 ){
					$(".myzzimrow").append(moreBtn);				
				} 
			
			}else{
				html += "<br><h3 id='notice'>찜한 매장이 없습니다.</h3>";
				$(".zzimlist").append(html);
				html = "";
			}

		}
	});
	
	
});

//더보기
$(document).on("click","#moreBtn",function(){
	
	console.log("들어왔슈");
	hiddenLikes = $(".subdiv").filter(function(){
		return $(this).css('display') == 'none';
	});
	count = hiddenLikes.length;
	if(count == 0){
		$("#moreBtn").css("display","none");
		alert("더 이상 항목이 없습니다.");
	}else{
		$(hiddenLikes).slice(0,5).show();
	}
});

//찜 해제
$(document).on("click",".zzimdelBtn",function(){
	var har_num = $(this).parent().prev('.har_num').val();
	var hos_num = $(this).parent().prev('.hos_num').val();
	
	if(har_num != null){
		$.ajax({
			url: "delLikes",
			type:"GET",
			data:{
				cl_num : cl_num,
				har_num : har_num
			},
			success:function(data){
				console.log("성공!");
				location.reload();
			}
		});
	}else if(hos_num != null){
		$.ajax({
			url: "delLikes",
			type:"GET",
			data:{
				cl_num : cl_num,
				hos_num : hos_num
			},
			success:function(data){
				console.log("성공!");
				location.reload();
			}
		});
	}
		
});
