<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet"	type="text/css">
<link href="${path}/resources/css/common/header.css" rel="stylesheet"	type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet"	type="text/css">
<link href="${path}/resources/css/user/myPageAside.css"	rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/uMyPage/myReservationList.css"	rel="stylesheet" type="text/css">
<link	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css"	rel="stylesheet" />
<script src="https://kit.fontawesome.com/aca84cf3fb.js"	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />
		<section class="section">
			<jsp:include page="../myPageAside.jsp" />
			<div class="mcontent">
				<input type="hidden" id="cl_num" value="${client.cl_num }">
				<div class="point">
					<p class="ptitle">보유포인트</p>
					<p class="ptitle">결제대기</p>
					<p class="ptitle">결제완료</p>
					<p class="ptitle">이용완료</p>
					<br>
					<c:if test="${empty point or point eq -1}">
						<p class="presult">0P</p>
					</c:if>
					<c:if test="${!empty point and (point ne -1)}">
						<p class="presult">${point}P</p>
					</c:if>
					<p class="presult">${status0 }</p>
					<p class="presult presultth">${status1 }</p>
					<p class="presult presultend">${status2}</p>
				</div>
				<br>
				<p class="pageTitle">예약 확인/조회</p>
				<br>
				<hr>
				<table class="rtable">
					<tr>
						<td class="tdstart">기간별 조회</td>
						<td><input type="date" id="start">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="date" id="end"></td>
						<td class="tdend" ><button type="button" class="basicBtn rbutton" id="searchDate">조회하기</button></td>
					</tr>
				</table>
				<hr>
				<br> <br>
				<table class="rtable rlist">
					<!-- 예약 조회한 값이 들어옴 -->
				</table>
				<div class="divmore"></div>

		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	<!-- 리뷰 작성 모달창 -->
	<div id="modalRe" class="modalRe-Overlay">
		<div id="modalRe-Win">
			<form id="frmReviewInput" enctype="multipart/form-data">
				<a class="modal_close_btn"><i class="fas fa-times fa-lg"></i></a> <br><br>
				<div class="select">
					<span class="text">별점을 선택해주세요</span><span class="downArrow"></span>
					<ul class="option-list">
						<li class="option" value="5"><img src="${path}/resources/images/5.png">&nbsp;&nbsp;아주 만족해요</li>
						<li class="option" value="4"><img src="${path}/resources/images/4.png">&nbsp;&nbsp;만족해요</li>
						<li class="option" value="3"><img src="${path}/resources/images/3.png">&nbsp;&nbsp;보통이에요</li>
						<li class="option" value="2"><img src="${path}/resources/images/2.png">&nbsp;&nbsp;조금 아쉬워요</li>
						<li class="option" value="1"><img src="${path}/resources/images/1.png">&nbsp;&nbsp;많이 아쉬워요</li>
					</ul>
					
					<input type="number" id="selectedVal" name="selectedVal" style="display:none"  readonly>
					<input type="file" id="reviewImg" name="reviewImg" multiple="multiple" accept=".jpg, .jpeg, .png" style="display:none">
					<input type="hidden" name="har_num" id="for_value_har_num" >
					<input type="hidden" name="har_name" id="for_value_har_name" >
					<input type="hidden" name="har_rname" id="for_value_har_rnum" >
					<!-- hidden에 미용실 번호 담음 from js파일 -->
<%-- 						<input type="hidden" name="harNum" value="${myRev.har_num}"> --%>
				</div>
				<br>
				<textarea placeholder="리뷰내용을 작성해주세요" id="revCont" name="revCont" rows="15" cols="37"></textarea>
				<br><br>
				<span id="imgUpBtn" class="btnAddFile"><i class="fa fa-camera fa-2x"></i></span>
				<button id="regBtn" class="basicBtn btnReCom">등록하기</button>
				<br>
			</form>
		</div>
	</div>
	<!-- 모달 끝! -->
	<script src="${path}/resources/js/user/uMyPage/myReservationList.js"></script>
</body>
</html>