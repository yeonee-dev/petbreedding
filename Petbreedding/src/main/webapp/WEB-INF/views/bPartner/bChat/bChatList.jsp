<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bAside.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/uMyPage/myChatList.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bChat/bChatList.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<section class="section">
			<jsp:include page="../bheader.jsp" />
			<jsp:include page="../bAside.jsp" />
			<div class="bContent">
			<div class="tabmenu">
					<ul>
						<li id="tab1" class="btnCon">
						<input type="radio" name="tabmenu" checked id="tabmenu1" class="Tmenu">
						<label for="tabmenu1">전체</label>
						<div class="tabCon">
							<c:if test="${not empty Roomlist }">
							<c:forEach items="${Roomlist }" var="r" varStatus="status">
							<table onClick="openbchatwin('${r.chatId }','${r.nickName}', '${r.shopName }', '${r.cl_num }');">
								<tr>
									<td rowspan="2"><img src="${path}/resources/images/logoForChat.png"></td>
									<td>${r.nickName }</td>
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
						</div>
						</li>
						<li id="tab2" class="btnCon">
						<input type="radio" name="tabmenu" id="tabmenu2" class="Tmenu">
						<c:if test="${countUnread ne 0 }"><div class="topCount countwrap blink">${countUnread}</div></c:if><label for="tabmenu2">읽지 않은 메시지</label>
						<div class="tabCon">
						<c:if test="${not empty unreadList }">
						<c:forEach items="${unreadList }" var="u" varStatus="status">
						<table onClick="openbchatwin('${u.chatId }','${u.nickName}', '${u.shopName }', '${u.cl_num }');">
							<tr>
								<td rowspan="2"><img src="${path}/resources/images/logoForChat.png"></td>
								<td>${u.nickName }</td>
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
	<div id="deleteMsg-modal" class="modal">
	<div class="cancel-content">
		<p class="boldtext">대화를 지우시겠습니까?</p> 
		<p class="text">
		<br>
		기존의 모든 대화가 삭제됩니다.<br><br></p>
		<div class="btn">
			<button class="basicBtn" id="yesDelete">네</button>
			<button class="basicBtn" id="noDelete">아니오</button>
		</div>
	</div>
</body>
<script type="text/javascript" src="${path}/resources/js/bPartner/bAside.js"></script>
<script type="text/javascript" src="${path}/resources/js/bPartner/bChat/bChatList.js"></script>
</html>