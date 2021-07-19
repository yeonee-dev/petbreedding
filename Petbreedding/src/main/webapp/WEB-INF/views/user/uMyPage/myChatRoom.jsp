<%@page import="kh.com.petbreedding.BP.model.vo.BPartner"%>
<%@page import="kh.com.petbreedding.client.model.vo.Client"%>
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
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/uMyPage/myChatRoom.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.1/sockjs.js"></script>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
</head>
<body>
<input type="hidden" id="rid" value="${id }">
<input type="hidden" id="chatId" value="${chatId }">
<input type="hidden" id="user" value="${user }">
	<div class="closebtn">
			<a href="#" onclick="javascript:top.window.close()">닫기</a>
	</div>
	<div class="col-12 row justify-content-center align-items-center my-5 ">
		<img src="${path}/resources/images/logo-resize.png" class="img-fluid" />
	</div>
	<c:if test="${user eq 'user'}">
	<% Client client = (Client)session.getAttribute("client");
		String email = client.getEmail(); %>
	<div class="col-12 bInfo">
		<div class="col-10 bInfoinner" onclick="openshopwin('${bp_id }','${bp_type }')">
			${shopName }
		</div>
	</div>
	<!-- 채팅 내용 -->
	<div class="col-12">
		<div class="col-11" id="chatArea">
			<div id="chatMessageArea">
			<c:if test="${not empty chatlist }">
			<c:forEach items="${chatlist }" var="c" varStatus="status">
				<c:if test="${c.cl_num eq c.mSender }">
				<div class="col-12 row dMessageO">
				<div class="col-2 dMessage my">
				<div class="dNick">${nickName}</div></div><br>
					<div class="col-10 dConO my">
					<div class="col-12 dConI mycolor">
					<span>
					${c.mContent}</span></div>
					<div class = "col-12 dTimeO"><br>
					<div>${c.mSendTime }</div></div>
					</div></div><br><br><br><br>
				</c:if>
				<c:if test="${c.cl_num ne c.mSender }">
					<div class="col-12 row dMessageO">
					<div class="col-2 dMessage U">
					<div class="dNick">${shopName}</div></div><br>
					<div class="col-10 dConO U">
					<div class="col-12 dConI Ucolor">
					<span>
					${c.mContent}</span></div>
					<div class="col-12 dTimeO"><br>
					<div>${c.mSendTime }</div></div>
					</div></div><br><br><br><br>
				</c:if>
			</c:forEach>
			</c:if>
			</div>
		</div>
	</div>
	<!-- 채팅 입력창 -->
	<div class="col-12 inputchatwrap">
		<div class="col-12 textwrap">
			<textarea class="form-control" placeholder="내용을 입력해주세요" id="message" rows="4" cols="35"></textarea>
			<input type="hidden" id="sender" value="${cl_num }">
			<input type="hidden" id="senderName" value="${nickName }">		
			<input type="hidden" id="receiver" value="${bp_id }">
			<input type="hidden" id="email" value="<%=email %>">
			<input type="hidden" id="cl_num" value="${cl_num }">
			<input type="hidden" id="bp_id" value="${bp_id }">
			<button type="button" id="sendBtn" class="basicBtn">전송</button>
		</div>
	</div>
	</c:if>
	
	<c:if test="${user ne 'user'}">
	<% BPartner bp = (BPartner)session.getAttribute("bP");
		String email = bp.getBp_email(); %>
	<div class="col-12 bInfo">
		<div class="col-10 bInfoinner">
			${nickName }
		</div>
	</div>
	<!-- 채팅 내용 -->
	<div class="col-12">
		<div class="col-11" id="chatArea">
			<div id="chatMessageArea">
			<c:if test="${not empty chatlist }">
			<c:forEach items="${chatlist }" var="c" varStatus="status">
				<c:if test="${c.bp_id ne c.mSender }">
				<div class="col-12 row dMessageO">
				<div class="col-2 dMessage U">
				<div class="dNick">${nickName}</div></div><br>
					<div class="col-10 dConO U">
					<div class="col-12 dConI Ucolor">
					<span>
					${c.mContent}</span></div>
					<div class = "col-12 dTimeO"><br>
					<div>${c.mSendTime }</div></div>
					</div></div><br><br><br><br>
				</c:if>
				<c:if test="${c.bp_id eq c.mSender }">
					<div class="col-12 row dMessageO">
					<div class="col-2 dMessage my">
					<div class="dNick">${shopName}</div></div><br>
					<div class="col-10 dConO my">
					<div class="col-12 dConI mycolor">
					<span class="my">
					${c.mContent}</span></div>
					<div class="col-12 dTimeO"><br>
					<div>${c.mSendTime }</div></div>
					</div></div><br><br><br><br>
				</c:if>
			</c:forEach>
			</c:if>
			</div>
		</div>
	</div>
	<!-- 채팅 입력창 -->
	<div class="col-12 inputchatwrap">
		<div class="col-12 textwrap">
			<textarea class="form-control" placeholder="내용을 입력해주세요" id="message" rows="4" cols="35"></textarea>
			<input type="hidden" id="sender" value="${bp_id }">
			<input type="hidden" id="senderName" value="${shopName }">		
			<input type="hidden" id="receiver" value="${cl_num }">
			<input type="hidden" id="email" value="<%=email %>">
			<input type="hidden" id="cl_num" value="${cl_num }">
			<input type="hidden" id="bp_id" value="${bp_id }">
			<button type="button" id="sendBtn" class="basicBtn">전송</button>
		</div>
	</div>
	</c:if>
</body>
<script type="text/javascript" src="${path}/resources/js/user/uMyPage/myChatRoom.js"></script>
</html>