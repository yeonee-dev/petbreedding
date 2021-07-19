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
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/uBoard/fboardcont.css" rel="stylesheet" type="text/css">

<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />
		<section class="section">
			<input type="hidden" value="${client.cl_num }" id="cl_num">
			<input type="hidden" value="${userType}" id="userType">
			<div class="bheader">

				<c:if test="${empty board}">
					<h1>정보를 찾을 수 없습니다.</h1>
				</c:if>

					
					<div class="title"><h2>${board.boTitle}</h2></div>
							
					<div class="writer">작성자 : ${board.clNickName}</div>
					<div class="regdate">작성일 : ${board.boDate}</div>
					<div class="count">조회수: ${board.boView}</div>
					
			</div>


			<div class="bcon">
				<div class="con">${board.boCont}</div>
				
				<div class="btnBox">
					<button class="backbtn basicBtn" onClick="history.back()">목록</button>
					<c:if test="${board.clNum eq client.cl_num }">
						<button id="fboardDelBtn" class="delbtn basicBtn">삭제</button>
						<button id="fboardUpdBtn" class="modifybtn basicBtn">수정</button>
					</c:if>
					<form id="form1">
						<input type="hidden" id="boUpdBoNum" name="boNum" value="${board.boNum}">
						<input type="hidden" id="boUpdBoTitle" name="boTitle" value="${board.boTitle}">
						<input type="hidden" id="boNone" name="boCont" value='${board.boCont}'>
					</form>						
				</div>
			</div>
			<div class="reply">
				<p>댓글(${board.bocChk})</p>
				
				<form id="bocFrm">
					<div class="replycon">
						<c:if test="${empty client }">
							<input type="text" id="replyCont" placeholder="로그인 후 입력 가능합니다." readonly name="getBocCont">
							<input type="button" id="bocNoneBtn" class="basicBtn" value="등록">
						</c:if>
						<c:if test="${!empty client }">
							<input type="text" id="replyCont" name="getBocCont">
							<input type="button" id="bocSubmitBtn" class="basicBtn" value="등록">
						</c:if>
						<input type="button" id="bocUpdateBtn" class="basicBtn" value="수정">
						<input type="hidden" value="${board.boNum}" name="getBoNum">
					</div>
				</form>
				
				<div id="replyContainer"></div>
				
				
			</div>
	        <!--TOPBTN-->
        	<a id="MOVE_TOP_BTN" href="#"><i class="fas fa-arrow-up"></i></a>
			
		</section>
		<jsp:include page="../../common/footer.jsp" />
		
		<!-- MODAL POSTING -->
		 <div id="my_modal" class="cModal">
		    <a class="modal_close_btn"><i class="fas fa-times" id="closeBtn"></i></a>
		    <div id="locCon">
		        <h1>삭제하시겠습니까?</h1>
		        <button id="goTODel" name="${board.boNum}"  class="yesBtn">네</button>
		        <button id="nextTime" class="closeBtn">아니오</button>
		    </div>
		</div>
		
		
		<!-- MODAL COMMENT -->
		<div id="my_modal_comment" class="cModal">
		   <a class="modal_close_btn" id="closeModalBtn"><i class="fas fa-times" id="closeBtnComment"></i></a>
		   <div id="locCon_comment">
		       <h1>삭제하시겠습니까?</h1>
		       <button id="goTOPay_comment" class="yesBtn">네</button>
		        <button id="nextTime_comment" class="closeBtn">아니오</button>
		        <input type="hidden" id="coIdVar">
		    </div>
		</div>
		
		<!-- MODAL COMMENT UPDATE -->
		<div id="my_modal_updComment" class="cModal">
			<a class="modal_close_btn" id="closeModalBtn"><i class="fas fa-times" id="closeBtnUpdComment"></i></a>
			<div id="locCon_updComment">
				<h1 class="bocUpdTitle">댓글 수정</h1>
				<input type="text" id="replyUpdCont" name="getBocCont">
				<button id="goTOPay_updComment" class="yesBtn">수정</button>
				<button id="nextTime_updComment" class="closeBtn">취소</button>
				<input type="hidden" id="coIdVar">
		    </div>
		</div>

	</div>
	
	<script type="text/javascript" src="${path}/resources/js/user/uBoard/fComment.js"></script>
	<script type="text/javascript" src="${path}/resources/js/user/uBoard/fboardcon.js"></script>
	<script type="text/javascript" src="${path}/resources/js/common/topBtn.js"></script>
</body>
</html>