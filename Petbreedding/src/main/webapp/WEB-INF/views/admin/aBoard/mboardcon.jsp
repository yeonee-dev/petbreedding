<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/admin/mAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/admin/aBoard/mboard.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../mheader.jsp" />
		<section class="section" id="mboardSection">
			<jsp:include page="../mAside.jsp"/>
			<div class="mContent">
		        <div class="conhead">
			       	<c:choose>
						<c:when test="${mAsk.qnaType eq 1}">
						<p>[회원]</p>
						</c:when>
						<c:otherwise>
						<p>[사업자]</p>
						</c:otherwise>
					</c:choose>
					<p>${mAsk.qnaCont}</p>
					<p>작성자 : ${mAsk.qnaWr}</p>
					<p>작성일 : ${mAsk.qnaDate}</p>
				</div>
				
				<div class="conimg">
					<c:choose>
						<c:when test="${mAsk.qnaImg eq 'none'}">
						    <div style="width:400px; height:300px;"></div>
						</c:when>
						<c:otherwise>
							<img src="${path}/resources/uploadFile/myAsk/${mAsk.qnaImg}">
						</c:otherwise>
					</c:choose>
				</div>
				<div class="conbtn">
				    <button class="basicBtn" id="listBtn">목록</button>
				    <button class="basicBtn" id="delBtn">삭제</button>
				</div>
				<div id="replyArea" class="reply">
				</div>
			</div>
		</section>
	<jsp:include page="../../common/footer.jsp" />
	
	<!-- MODAL -->
	<div id="my_modal">
	   <a class="modal_close_btn"><i class="fas fa-times" id="closeBtn"></i></a>
	   <div id="locCon">
	       <h1>삭제하시겠습니까?</h1>
	       <button id="goTOPay" name="${mAsk.qnaNum}">바로 삭제할게요</button>
	        <button id="nextTime">다음에 할게요</button>
	    </div>
	</div>
	
	<!-- MODAL COMMENT -->
	<div id="my_modal_comment">
	   <a class="modal_close_btn"><i class="fas fa-times" id="closeBtn_comment"></i></a>
	   <div id="locCon_comment">
	       <h1>삭제하시겠습니까?</h1>
	       <button id="goTOPay_comment">바로 삭제할게요</button>
	        <button id="nextTime_comment">다음에 할게요</button>
	    </div>
	</div>
	
	<!-- MODAL COMMENT UPDATE -->
	<div id="my_modal_updComment">
		<a class="modal_close_btn" id="closeModalBtn"><i class="fas fa-times" id="closeBtnUpdComment"></i></a>
		<div id="locCon_updComment">
			<h1 class="bocUpdTitle">수정하시겠습니까?</h1>
			<input type="text" id="replyUpdCont" name="getBocCont">
			<button id="goTOPay_updComment">바로 수정할게요</button>
			<button id="nextTime_updComment">다음에 할게요</button>
			<input type="hidden" id="coIdVar">
	    </div>
	</div>
	
	
	</div>	 
	<script type="text/javascript">
		console.log("스크립트 시작");
		var qnaNum= '${mAsk.qnaNum}';
		maCommentInit(qnaNum);
		
		function maCommentInit(qnaNum) {
			console.log("조회 함수 들어옴");
			console.log(qnaNum);
			$.ajax({
				
				url: 'macList',
				type:'get',
				contentType : "application/json; charset:UTF-8",
				data: {qna_num: qnaNum },
				dataType: 'json',
				success: function(json) {
					var div = "";
					var jsonLength = Object.keys(json).length;
					console.log(json);
					console.log(jsonLength);
					if(jsonLength > 0) {
						
							
					$.each(json, function(index, item) {
					
// 						$("#maCommentText").hide();
// 						$("#maCommentBtn").hide();
							
							div +=	
									"<div class='maCommentUpdDelFrm'>"
									+"<div class='replyCont'>"
									+item.qnacCont
									+"</div>"
									+"<div>"
									+"<button class='basicBtn upDelBtn' id='maCommentUpBtn' name='"+item.qnacNum+"'>댓글수정</button>"
									+"<button class='basicBtn upDelBtn' id='maCommentDelBtn' name='"+item.qnacNum+"'>댓글삭제</button>"
									+"</div>"
									+"</div>";
									

						});
					} else {
						div += "<form id='maCommentFrm' class='maCommentFrm'>"
							+"<textarea id='maCommentText' name='maCommentText'></textarea>"
							+"<button class='basicBtn' id='maCommentBtn'>등록</button>"
							+"<input type='hidden' value='"+qnaNum+"' name='qna_num'>"
							+"</form>";
							
					}
					
					$("#replyArea").html(div);
					
					//	댓글 삭제 버튼 클릭
					$("#maCommentDelBtn").on("click", function() {
						console.log("댓글 삭제 클릭 됨")
						var qnacNumVar = $(this).attr("name");	//	클릭된 행의 name
						console.log(qnacNumVar);
						$("#goTOPay_comment").attr("name", qnacNumVar);
						getCommentModal();
					});
					
					//	댓글 등록 버튼 클릭
					$("#maCommentBtn").on("click", function() {
						macWrite();
					});
					
					//	댓글 수정 버튼 클릭
					$("#maCommentUpBtn").on("click", function() {
						console.log("댓글 수정 클릭 됨");
						var qnacNumVar = $(this).attr("name");	// 클릭된 행의 name
						console.log(qnacNumVar);
						$("#goTOPay_updComment").attr("name", qnacNumVar);
						getUpdCommentModal();
					});
					
					},
					
					error : function(request, status, error) {
					alert("code: " + request.status + "\n" + "message: "
							+ request.responseText + "\n" + "error: "
							+ error);
				}
			});
			
			console.log("함수 댓글 조회 함수 끝");
		}
		
		function macWrite() {
			console.log("[세훈] @문의사항 댓글 등록 ajax 들어왔음");
			var queryString = $("#maCommentFrm").serialize();
			console.log(queryString);
			$.ajax({
				url: 'macWrite',
				type: 'post',
				data: queryString,
				success: function() {
					maCommentInit(qnaNum);
				},
				
				error : function(request, status, error) {
					alert("code: " + request.status + "\n"
							+ "message: "
							+ request.responseText + "\n"
							+ "error: " + error);
				}
				
			});
			
		}
		
		$("#goTOPay_comment").on("click", function() {
			console.log("관리자 문의사항 댓글 삭제 들어옴");
			var qnacDelNum = $(this).attr("name");
			console.log(qnacDelNum);
			
			$.ajax({
				url: "macDelete"
				,type: "get"
				,data: {qnac_num : qnacDelNum, qna_num : qnaNum}
				,success: function() {
					maCommentInit(qnaNum);
				}
				,error : function(request, status, error) {
					alert("code: " + request.status + "\n"
							+ "message: "
							+ request.responseText + "\n"
							+ "error: " + error);
				}
			});
			
// 			$("#maCommentText").show();
// 			$("#maCommentBtn").show();
			
		});
		
		
		$("#goTOPay_updComment").on("click", function() {
			var qnacNum = $(this).attr("name");	//	조회 함수 진행할 때 바꿔준 name 가져오기
			var qnacCont = $("#replyUpdCont").val();
			console.log(qnacNum);
			console.log(qnacCont);
			
			$.ajax({
				url: "macUpdate"
				,type: "post"
				,data: {qnac_num : qnacNum, qnac_cont : qnacCont}
				,success: function() {
					maCommentInit(qnaNum);
				}
				,error : function(request, status, error) {
					alert("code: " + request.status + "\n"
							+ "message: "
							+ request.responseText + "\n"
							+ "error: " + error);
				}
			});
		});
	</script>
<script type="text/javascript" src="${path}/resources/js/admin/mAside.js"></script>
<script type="text/javascript" src="${path}/resources/js/admin/aBoard/mBoardCon.js"></script>
</body>
</html>