<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bAside.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bBoard/bQna.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/paging.css" rel="stylesheet" type="text/css" >
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />
		<section class="section">
			<jsp:include page="../bAside.jsp" />
			<div class="bContent">
				<input type="hidden" id="bpId" value="${bP.bp_Id}">
				<h1>1:1 문의 내역</h1>
					<button id="myAskBtn" class="basicBtn" name="${user_num}">1:1문의하기</button>
				<table class="asktable">
					<br>
					<br>
					<br>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성일</th>
						<th>답변여부</th>
					</tr>
					<c:if test="${!empty bQnaList }">
					<c:forEach items="${bQnaList}" var="list">
					<tr id="${list.qnaNum}" class="pointline">
						<td>${list.qnaNum}</td>
						<td><a>${list.qnaTitle}</a></td>
						<td>${list.qnaDate}</td>
						<c:choose>
							<c:when test="${list.qnaChk eq 0}">
								<td>N</td>
							</c:when>
							<c:otherwise>
								<td>Y</td>
							</c:otherwise>
						</c:choose>
					</tr>
					</c:forEach>
					</c:if>
					<c:if test="${empty bQnaList }">
						<tr class="pointline">
							<td colspan='4'>문의하신 내역이 없습니다.</td>
						</tr>
					</c:if>
				</table>
				
				<!-- 페이징 시작-->
				<div class="page_wrap">
					<div class="page_nation">
						<c:if test="${paging.startPage != 1 }">
							<a class="arrow prev" href="${path}/bQna?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}&user_num=${user_num}">이전</a> 
						</c:if>
						<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
							<c:choose>
								<c:when test="${p == paging.nowPage }">
									<b>${p }</b>
								</c:when>
								<c:when test="${p != paging.nowPage }">
									<a href="${path}/bQna?nowPage=${p }&cntPerPage=${paging.cntPerPage}&user_num=${user_num}">${p}</a>
								</c:when>
							</c:choose>
						</c:forEach>
						<c:if test="${paging.endPage != paging.lastPage}">
							<a class="arrow next" href="${path}/bQna?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}&user_num=${user_num}">다음</a>
						</c:if>
					</div>
				</div>
				<!-- 페이징 끝! -->
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	
	<script type="text/javascript" src="${path}/resources/js/bPartner/bAside.js"></script>
	<script type="text/javascript" src="${path}/resources/js/bPartner/bBoard/bQna.js"></script>
</body>
</html>