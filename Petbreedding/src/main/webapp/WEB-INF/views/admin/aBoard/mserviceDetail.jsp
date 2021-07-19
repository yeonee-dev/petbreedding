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
<link href="${path}/resources/css/admin/aBoard/mserviceDetail.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/admin/aBoard/mservice.css" rel="stylesheet" type="text/css">
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
						<c:when test="${csDetail.annType eq 0}">
							<p>[전체]</p>
						</c:when>
						<c:when test="${csDetail.annType eq 1}">
							<p>[회원]</p>
						</c:when>
						<c:otherwise>
							<p>[사업자]</p>
						</c:otherwise>
					</c:choose>
					<p>${csDetail.annTitle}</p>
					<p>작성자 : ${csDetail.adminId}</p>
					<p>작성일 : ${csDetail.annDate}</p>
				</div>
				
				<div class="con">
					<p>
						${csDetail.annCont}
					</p>
				</div>
				
				
				<div class="conbtn">
				    <button class="basicBtn" id="listBtn">목록</button>
				    <button class="basicBtn" id="delBtn">삭제</button>
				    <form id="msUpdFrm">
					    <button class="basicBtn" id="updeteBtn">수정</button>
					    <input type="hidden" name="updAnnTitle" value="${csDetail.annTitle}">
					    <input type="hidden" name="updAnnCont" value="${csDetail.annCont}">
					    <input type="hidden" name="updAnnNum" value="${csDetail.annNum}">
				    </form>
				</div>

			</div>
		</section>
	<jsp:include page="../../common/footer.jsp" />
	
		<!-- MODAL -->
		<div id="my_modal">
		   <a class="modal_close_btn"><i class="fas fa-times" id="closeBtn"></i></a>
		   <div id="locCon">
		       <h1>삭제하시겠습니까?</h1>
		       <button id="goTOPay" name="${csDetail.annNum}">바로 삭제할게요</button>
		        <button id="nextTime">다음에 할게요</button>
		    </div>
		</div>
		
	</div>
	<script type="text/javascript" src="${path}/resources/js/admin/mAside.js"></script>
	<script type="text/javascript" src="${path}/resources/js/admin/aBoard/mserviceDetail.js"></script>	 
</body>
</html>