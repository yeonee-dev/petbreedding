<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link type="text/css" rel="stylesheet"	href="${path}/resources/css/common/reset.css">
<link type="text/css" rel="stylesheet"	href="${path}/resources/css/bPartner/bheader.css">
<link type="text/css" rel="stylesheet"	href="${path}/resources/css/common/footer.css">
<link type="text/css" rel="stylesheet"	href="${path}/resources/css/bPartner/bAside.css">
<link type="text/css" rel="stylesheet"	href="${path}/resources/css/bPartner/bShop/bReview.css">
<link href="${path}/resources/css/common/paging.css" rel="stylesheet" type="text/css" >
<link	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css"	rel="stylesheet" />
<script src="https://kit.fontawesome.com/aca84cf3fb.js"	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />
		<section class="section">
			<jsp:include page="../bAside.jsp" />
			<div class="bContent">
				<h2>리뷰 목록 (총 ${brvCount}개)</h2>
				<br>
				<table>
				
					<tr class="pointline">
						<th>리뷰 번호</th>
						<th>상품명</th>
						<th>구매자 평점</th>
						<th colspan='2'>리뷰내용</th> 
					</tr>
					
					<c:forEach items="${brvList}" var="brItems">
						<tr class="pointline">
							<td>${brItems.revNum}</td>
							<td>가위컷</td>
							<c:choose>
								<c:when test="${brItems.revVal eq 1}">
									<td><img src="${path}/resources/images/1.png"></td>
								</c:when>
								<c:when test="${brItems.revVal eq 2}">
									<td><img src="${path}/resources/images/2.png"></td>
								</c:when>
								<c:when test="${brItems.revVal eq 3}">
									<td><img src="${path}/resources/images/3.png"></td>
								</c:when>
								<c:when test="${brItems.revVal eq 4}">
									<td><img src="${path}/resources/images/4.png"></td>
								</c:when>
								<c:when test="${brItems.revVal eq 5}">
									<td><img src="${path}/resources/images/5.png"></td>
								</c:when>
								<c:otherwise>
									
								</c:otherwise>
							</c:choose>
							
							<td>${brItems.revCont}</td>
							
							<c:if test="${brItems.comntChk eq 0}">
								<td><button class="basicBtn btnReply" name="${brItems.revNum}" id="${brItems.bpId}">답글쓰기</button></td>
							</c:if>
							<c:if test="${brItems.comntChk eq 1}">
								<td><button class="basicBtn btnReCom">작성완료</button></td>
							</c:if>
						</tr>
					</c:forEach>
					
				</table>
				<br> <br>
				<!-- 페이징 시작-->
				<div class="page_wrap">
					<div class="page_nation">
						<c:if test="${paging.startPage != 1 }">
							<a class="arrow prev" href="${path}/bReview?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">이전</a> 
						</c:if>
						<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
							<c:choose>
								<c:when test="${p == paging.nowPage }">
									<b>${p }</b>
								</c:when>
								<c:when test="${p != paging.nowPage }">
									<a href="${path}/bReview?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p}</a>
								</c:when>
							</c:choose>
						</c:forEach>
						<c:if test="${paging.endPage != paging.lastPage}">
							<a class="arrow next" href="${path}/bReview?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">다음</a>
						</c:if>
					</div>
				</div>
				<!-- 페이징 끝! -->
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	
	<!-- 리뷰 답글 작성 모달창 -->
	<div id="modalReply" class="modalRe-Overlay">
		<div id="modalReply-Win">
			<div class="Retitle">
				<div id="modalTitle">리뷰 상세 보기</div>
				<a class="modal_close_btn"><i class="fas fa-times fa-lg"></i></a>
			</div>
			<div class="reviewsection" id="reviewsection">
			</div>
			<div class="wrapbtn">
				<button class="basicBtn">이전 리뷰</button>
				<button class="basicBtn btnnext">다음 리뷰</button>
			</div>
			<br>
		</div>
	</div>
	<!-- 모달 끝! -->
	<script type="text/javascript">
	var modal = document.getElementById("modalReply");
	var modalReWin = document.getElementById("modalReply-Win");
	var btnReply = document.querySelectorAll(".btnReply");
	var closeBtn = modal.querySelector(".modal_close_btn")
	var path = '${pageContext.request.contextPath}';
	
	$(".btnReply").on("click", function() {
		var revNum = $(this).attr("name");
		console.log(revNum);
		console.log(path);
		modalInit(revNum, path);
		modal.style.display = "flex";
	});
	
	function modalInit(revNum, path) {
		$.ajax({
			url: "brmodal"
			,type: "post"
			,data: {rev_num : revNum}
			,dataType: 'json'
			,success: function(data) {
					console.log(data);
					if(data != null) {
						var div = "";
						
						div += "<div id='modalRetxt'>"
							+ "<img class='txtImg' src='"+path+"/resources/images/5.png'>&nbsp;&nbsp;"+data.revVal+".0"
							+ "<br>"
							+ "<p id='reTitle'>"+data.revCont+"</p>"
							+ "<br>"
							+ "<p>"+data.clNickName+"</p>"
							+ "<p id='reDate'>"+data.revDate+" 방문</p>"
							+ "</div>"
							+ "<div id='modalReImg'>"
							+ "<img id='modalReImgs' src='"+path+"/resources/uploadFile/review/"+data.revImg+"' style='width:100px; height:100px;' onerror='noImage()'>"
							+ "</div>"
							+ "<br>"
							+ "<br>"
							+ "<span>판매자 답글 작성</span>"
							+ "<form id='brevRegFrm'>"
							+ "<div class='replysection'>"
							+ "<div class='wraptextarea'>"
							+ "<textarea name='revcCont' rows='4' cols='35'></textarea>"
							+ "</div>"
							+ "<button id='brevRegBtn' class='basicBtn brevRegBtn'>답글 작성</button>"
							+ "<input type='hidden' name='revNumVal' value="+data.revNum+">"
							+ "<input type='hidden' name='revBpIdVal' value="+data.bpId+">"
							+ "</div>"
							+ "</form>";
							
						$("#reviewsection").html(div);
						
						$(".brevRegBtn").on("click", function() {
							console.log("frm 서밋 함수는 들어옴")
							$("#brevRegFrm").attr("action", "brwrite");
							$("#brevRegFrm").attr("method", "post");
							$("#brevRegFrm").submit();
						});
						
					} else {
						
						div += "데이터가 없습니다";
						$("#reviewsection").html(div);
						
					}
			}
			,error : function(request, status, error) {
				alert("code: " + request.status + "\n"
						+ "message: "
						+ request.responseText + "\n"
						+ "error: " + error);
			}
			
		});
	}
	
	closeBtn.addEventListener("click", function() {
		modal.style.display = "none";
	});
	
	function noImage() {
		   $("#modalReImgs").attr("src", "/petbreedding/resources/images/logo-square.png");  
	}
	
	
	</script>
	
	<script type="text/javascript" src="${path}/resources/js/bPartner/bAside.js"></script>
	<script src="${path}/resources/js/bPartner/bShop/bReview.js"></script>
</body>
</html>