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
<link href="${path}/resources/css/user/uMyPage/myChatList.css" rel="stylesheet" type="text/css">
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
				<div class="tabmenu">
					<ul>
						<li id="tab1" class="btnCon">
						<input type="radio" name="tabmenu" checked id="tabmenu1" class="Tmenu">
						<label for="tabmenu1">전체</label>
						<div class="tabCon">
							<c:if test="${not empty Roomlist }">
							<c:forEach items="${Roomlist }" var="r" varStatus="status">
							<table onClick="openchatwin('${r.chatId }','${r.shopName}','${r.bp_id}', '${r.bp_type}');">
								<tr>
									<td rowspan="2">
									<div class="imgwrap">
									    <img src="${path}/resources/uploadFile/shop/${r.mImg }">
									</div></td>
									<td>${r.shopName }</td>
									<td>${r.mSendTime }</td>
									<td rowspan="2"><a class="cancleM" onClick="deleteChat('${r.chatId }');"><i class="far fa-times-circle"></i></a></td>
								</tr>
								<tr>
									<td>${r.mContent }</td>
									<td colspan="2">
									<c:if test="${r.unreadCount ne 0 }"><div class="countwrap">${r.unreadCount }</div></c:if>
									</td>
								</tr>
							</table>
							</c:forEach>
							</c:if>
							<c:if test="${empty Roomlist }"><div class="textwrap">대화중인 상대가 없습니다.</div></c:if>
						</div>
						</li>
						<li id="tab2" class="btnCon">
						<input type="radio" name="tabmenu" id="tabmenu2" class="Tmenu">
						<c:if test="${countUnread ne 0 }"><div class="topCount countwrap blink">${countUnread}</div></c:if><label for="tabmenu2">읽지 않은 메시지</label>
						<div class="tabCon">
						<c:if test="${not empty unreadList }">
						<c:forEach items="${unreadList }" var="u" varStatus="status">
						<table onClick="openchatwin('${u.chatId }','${u.shopName}','${u.bp_id}', '${u.bp_type}');">
							<tr>
								<td rowspan="2"><div class="imgwrap">
												    <img src="${path}/resources/uploadFile/shop/${u.mImg }">
												</div></td>
								<td>${u.shopName }</td>
								<td>${u.mSendTime }</td>
								<td rowspan="2"><a class="cancleM" onClick="deleteChat('${r.chatId }');"><i class="far fa-times-circle"></i></a></td>
							</tr>
							<tr>
								<td>${u.mContent }</td>
								<td colspan="2">
								<c:if test="${u.unreadCount ne 0 }"><div class="countwrap">${u.unreadCount }</div></c:if>
								</td>
							</tr>
						</table>
						</c:forEach>
						</c:if>
						<c:if test="${empty unreadList }"><div class="textwrap">읽지 않은 메시지가 없습니다.</div></c:if>
						</div>
						</li>
					</ul>
				</div>
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	<!-- 대화 삭제 모달 -->
	<div id="cancel-modal" class="modal">
	<div class="cancel-content">
		<p class="boldtext">대화를 지우시겠습니까?</p> 
		<p class="text">
		<br>
		기존의 모든 대화가 삭제됩니다.<br><br></p>
		<div class="btn">
			<button class="basicBtn" id="yesCalncle">네</button>
			<button class="basicBtn" id="noCalncle">아니오</button>
		</div>
	</div>
</body>
<script type="text/javascript" src="${path}/resources/js/user/uMyPage/myChatList.js"></script>
</html>