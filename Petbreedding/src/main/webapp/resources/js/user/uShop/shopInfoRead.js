document.addEventListener("DOMContentLoaded", function() {

    var mySwiper = new Swiper('.swiper-container', {
        slidesPerView: 4,
        slidesPerGroup: 4,
        observer: true,
        observeParents: true,
        spaceBetween: 24,
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
        breakpoints: {
            1280: {
                slidesPerView: 3,
                slidesPerGroup: 3,
            },
            720: {
                slidesPerView: 1,
                slidesPerGroup: 1,
            }
        }
    });
    
});

$("#upToDate").on("click", function() {
	var type = 0;
	reviewInit(bpId, path, type, 1);
});

$("#ascendingStar").on("click", function() {
	var type = 1;
	
	reviewInit(bpId, path, type, 1);
});
$("#descendingStar").on("click", function() {
	var type = 2;
	
	reviewInit(bpId, path, type, 1);
});



// 문의하기 버튼 클릭 시 채팅으로 연결
function openchatwin(inbpId,inshopName,inbpType) {

	var bp_id = inbpId;
	var shopName = inshopName;
	var bp_type = inbpType;
	var url = '/petbreedding/chat?shopName='+shopName+'&bp_id='+bp_id+'&bp_type='+bp_type;
	window.open(url, '_blank', 'width=555px, height=700px');
}


function reviewInit(bpId, path, type, p) {
	
	$.ajax({
		url: "rList"
		,type: "get"
		,contentType : "application/json; charset:UTF-8"
		,data: {bp_id : bpId, type : type, p : p}
		,dataType: 'json'
		,success: function(json) {
			var div = "";
			var page = "";
			var jsonLength = Object.keys(json).length;
			if(jsonLength > 0 && json.list != null && json.list != "") {
				$.each(json.list, function(index, item) {
					var revVal = item.revVal;
					div += "<div class='review'>"
						+ "<div class='reviewWord'>"
						+ "<div class='star_img'>";
						switch(revVal) {
						case 1:
							div += "<i class='fas fa-star rate'></i>";
							break;
						case 2:
							div += "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>";
							break;
						case 3:
							div += "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>";
							break;
						case 4:
							div += "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>";
							break;
						case 5:
							div += "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>"
								+ "<i class='fas fa-star rate'></i>";
							break;
						}
					div += "<span class='reviewScore'>"+item.revVal+".0</span>"
						+ "</div>"
						// 별점 끝
						+ "<div class='reviewCon'>"
						+ "<p>"+item.revCont+"</p>"
						+ "</div>"
						// 리뷰 내용 끝
						+ "<div class='reviewInfo'>"
						+ "<span>"+item.clNickName+"</span>"
						+ "<span class='reviewDate'>"+item.revDate+" 방문</span>"
						+ "</div>"
						// 고객 닉네임, 방문날짜 끝
						+ "</div>";
						// reviewWord 끝
					if(item.revImg == "none") {
					div += "<div class='review_imgBox'>"
						+ "<img class='review_img' src='"+path+"/resources/images/logoForChat.png'>"
						+ "</div>"
						+ "</div>";
					} else {
					div	+= "<div class='review_imgBox'>"
						+ "<img class='review_img' src='"+path+"/resources/uploadFile/review/"+item.revImg+"'>"
						+ "</div>"
						+ "</div>";
					}
						
					if(item.revComment != null) {
						div += "<div class='reply'>"
							+ "<div class='replyCon'>"
							+ "<p>"+item.revComment.revcCont+"</p>"
							+ "</div>"
							+ "<div class='replyInfo'>"
							+ "<span>"+shopName+"</span>"
							+ "<span class='replyDate'>"+item.revComment.revcDate+"</span>"
							+ "</div>"
							+ "</div>";
					} else {
						
					}

				});
				
				//	페이징 시작
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
//				페이징 끝
				
			} else {
				div += "<div class='review'>";
				div += "<p>리뷰가 없습니다.</p>";
				div += "</div>";
				page = "";
			}
			$("#reviewArea").html(div);
			$("#page_nation").html(page);
			
			$(".clickNum").on("click", function() {
				var p = $(this).text();
				reviewInit(bpId, path, type, p);
			});
			
		}
		,error : function(request, status, error) {
			alert("code: " + request.status + "\n" + "message: "
					+ request.responseText + "\n" + "error: "
					+ error);
		}
	});
}



