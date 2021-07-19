<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/myPageAside.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/uMyPage/myNotice.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />
		<section class="section">
			<jsp:include page="../myPageAside.jsp" />
			<div class="mcontent">
			<c:if test="${not empty noticeList }">
			<c:forEach items="${noticeList }" var="n" varStatus="status">
			<!-- 예약시  -->
			<c:if test="${n.notCon eq 'a1' }">
			<div class="noticewrap">
				<div class="topWrap">
				<div class="clockWrap"><i class="far fa-clock"></i></div><div class="dateWrap">${n.notTime }</div>
				</div>
				<div class="conWrap" onClick="connectWindow('${n.notCon}', '${n.refNum}');">
					<div class="imgWrap">
					<img src="${path}/resources/uploadFile/shop/${n.shopImg}">
					</div>
					<div class="shopNameWrap">${n.shopName }</div>&nbsp;&nbsp;<div class="msgWrap"> 예약 되었습니다.</div>
					<a class="cancleM" onClick="deleteNotice('${n.notNum}');"><i class="far fa-times-circle"></i></a>
				</div>
			</div>
			</c:if>
			<!-- 결제시 -->
			<c:if test="${n.notCon eq 'a2' }">
			<div class="noticewrap">
				<div class="topWrap">
				<div class="clockWrap"><i class="far fa-clock"></i></div><div class="dateWrap">${n.notTime }</div>
				</div>
				<div class="conWrap" onClick="connectWindow('${n.notCon}', '${n.refNum}');">
					<div class="imgWrap">
					<img src="${path}/resources/uploadFile/shop/${n.shopImg}">
					</div>
					<div class="shopNameWrap">${n.shopName }</div>&nbsp;&nbsp;<div class="msgWrap"> 예약이 확정되었습니다.</div>
					<a class="cancleM" onClick="deleteNotice('${n.notNum}');"><i class="far fa-times-circle"></i></a>
				</div>
			</div>
			</c:if>
			<!-- 읽지 않은 채팅이 있을 시 -->
			<c:if test="${n.notCon eq 'a3' }">
			<div class="noticewrap">
				<div class="topWrap">
				<div class="clockWrap"><i class="far fa-clock"></i></div><div class="dateWrap">${n.notTime }</div>
				</div>
				<div class="conWrap">
					<div class="imgWrap">
					<img src="${path}/resources/uploadFile/shop/${n.shopImg}">
					</div>
					<div class="shopNameWrap">${n.shopName }</div>&nbsp;&nbsp;<div class="msgWrap"> 읽지 않은 메시지가 있습니다.</div>
					<a class="cancleM" onClick="deleteNotice('${n.notNum}');"><i class="far fa-times-circle"></i></a>
				</div>
			</div>
			</c:if>
			<!-- 내 글에 댓글 달렸을 때 -->
			<c:if test="${n.notCon eq 'a4' }">
			<div class="noticewrap">
				<div class="topWrap">
				<div class="clockWrap"><i class="far fa-clock"></i></div><div class="dateWrap">${n.notTime }</div>
				</div>
				<div class="conWrap" onClick="connectWindow('${n.notCon}', '${n.refNum}');">
					<div class="imgWrap">
					<img src="${path}/resources/images/logo-square.png">
					</div>
					<div class="shopNameWrap">${n.boTitle }</div>&nbsp;&nbsp;<div class="msgWrap"> 에 새 댓글이 있습니다.</div>
					<a class="cancleM" onClick="deleteNotice('${n.notNum}');"><i class="far fa-times-circle"></i></a>
				</div>
			</div>
			</c:if>
			<!-- 1:1 문의에 답변이 달렸을 때 -->
			<c:if test="${n.notCon eq 'a5' }">
			<div class="noticewrap">
				<div class="topWrap">
				<div class="clockWrap"><i class="far fa-clock"></i></div><div class="dateWrap">${n.notTime }</div>
				</div>
				<div class="conWrap" onClick="connectWindow('${n.notCon}', '${n.refNum}');">
					<div class="imgWrap">
					<img src="${path}/resources/images/logo-square.png">
					</div>
					<div class="shopNameWrap">${n.qnaTitle }</div>&nbsp;&nbsp;<div class="msgWrap"> 문의하신 문의글에 대한 답변입니다.</div>
					<a class="cancleM" onClick="deleteNotice('${n.notNum}');"><i class="far fa-times-circle"></i></a>
				</div>
			</div>
			</c:if>
			<!-- 포인트 적립시 -->
			<c:if test="${n.notCon eq 'a6' }">
			<div class="noticewrap">
				<div class="topWrap">
				<div class="clockWrap"><i class="far fa-clock"></i></div>&nbsp;&nbsp;<div class="dateWrap">${n.notTime }</div>
				</div>
				<div class="conWrap" onClick="connectWindow('${n.notCon}', '${n.refNum}');">
					<div class="imgWrap">
					<img src="${path}/resources/images/logo-square.png">
					</div>
					<div class="shopNameWrap">${n.refNum }</div>&nbsp;&nbsp;<div class="msgWrap"> 리뷰 작성으로 포인트가 적립되었습니다.</div>
					<a class="cancleM" onClick="deleteNotice('${n.notNum}');"><i class="far fa-times-circle"></i></a>
				</div>
			</div>
			</c:if>
			<!-- 포인트 사용시 -->
			<c:if test="${n.notCon eq 'a7' }">
			<div class="noticewrap">
				<div class="topWrap">
				<div class="clockWrap"><i class="far fa-clock"></i></div><div class="dateWrap">${n.notTime }</div>
				</div>
				<div class="conWrap" onClick="connectWindow('${n.notCon}', '${n.refNum}');">
					<div class="imgWrap">
					<img src="${path}/resources/images/logo-square.png">
					</div>
					<div class="shopNameWrap">${n.refNum }</div>&nbsp;&nbsp;<div class="msgWrap"> 결제로 포인트를 사용했습니다.</div>
					<a class="cancleM" onClick="deleteNotice('${n.notNum}');"><i class="far fa-times-circle"></i></a>
				</div>
			</div>
			</c:if>
			<!-- 예약 취소시 -->
			<c:if test="${n.notCon eq 'a8' }">
			<div class="noticewrap">
				<div class="topWrap">
				<div class="clockWrap"><i class="far fa-clock"></i></div><div class="dateWrap">${n.notTime }</div>
				</div>
				<div class="conWrap" onClick="connectWindow('${n.notCon}', '${n.refNum}');">
					<div class="imgWrap">
					<img src="${path}/resources/uploadFile/shop/${n.shopImg}">
					</div>
					<div class="shopNameWrap">${n.shopName }</div>&nbsp;&nbsp;<div class="msgWrap"> 예약 취소 되었습니다.</div>
					<a class="cancleM" onClick="deleteNotice('${n.notNum}');"><i class="far fa-times-circle"></i></a>
				</div>
			</div>
			</c:if>
			</c:forEach>
			</c:if>
			<c:if test="${empty noticeList }">
				<div class="textWrapNolist">도착한 알림이 없습니다.</div>
			</c:if>
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	<!-- 알림 삭제 모달 -->
	<div id="cancel-modal" class="modal">
		<div class="cancel-content">
			<p class="boldtext">해당 알림을<br>삭제 하시겠습니까?</p>
			<div class="btn">
				<button class="basicBtn" id="yesCalncle">네</button>
				<button class="basicBtn" id="noCalncle">아니오</button>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="${path}/resources/js/user/uMyPage/myNotice.js"></script>
</html>