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
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bAside.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bBoard/bFAQ.css" rel="stylesheet" type="text/css">
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
				<h1>자주 묻는 질문</h1>
				<c:forEach items="${list }" var="list">
					<div>
						<div class="title">
							<span class="down"><i class="fas fa-angle-down"></i></span>
							<span class="up" ><i class="fas fa-angle-up"></i></span>
							<br>
							<span class="subject">${list.of_title }</span>
						</div>
						<div class="content">
							<br>
							${list.of_cont }
						</div>
					</div>
				</c:forEach>
				<hr>
				
				<!-- 페이징 시작-->
			<div class="page_wrap">
				<div class="page_nation">
					<c:if test="${paging.startPage != 1 }">
						<a class="arrow prev" href="${path}/fboardlist?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">이전</a> 
					</c:if>
					<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
						<c:choose>
							<c:when test="${p == paging.nowPage }">
								<b>${p }</b>
							</c:when>
							<c:when test="${p != paging.nowPage }">
								<a href="${path}/fboardlist?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p}</a>
							</c:when>
						</c:choose>
					</c:forEach>
					<c:if test="${paging.endPage != paging.lastPage}">
						<a class="arrow next" href="${path}/fboardlist?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">다음</a>
					</c:if>
				</div>
			</div>
			<!-- 페이징 끝! -->  
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	<!-- script -->
	<script type="text/javascript" src="${path}/resources/js/bPartner/bAside.js"></script>
	<script type="text/javascript" src="${path}/resources/js/bPartner/bBoard/bNotice.js"></script>
</body>
</html>