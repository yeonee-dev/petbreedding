<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/myPageAside.css"	rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/uMyPage/myAsk.css" rel="stylesheet"	type="text/css">
<link href="${path}/resources/css/common/paging.css" rel="stylesheet" type="text/css" >
<script src="https://kit.fontawesome.com/aca84cf3fb.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		var userNum = "${user_num}";
		console.log(userNum);
		$(".pointline").click(function() {
			var idVar = $(this).attr("id");
			console.log(idVar);
			goDetail(idVar);
		});
		
		$("#myAskBtn").click(function() {
			location.href = "/petbreedding/maWriteForm?user_num="+userNum+"";
		});
		
		function goDetail(value){
			console.log(value);
			location.href = "/petbreedding/mypage/askdetail?qna_num="+value+"";
		}
	});
</script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />
		<section class="section">
			<jsp:include page="../myPageAside.jsp" />
			<div class="mcontent">
				<p class="pageTitle">1:1 문의 내역 <p>
					<button id="myAskBtn" class="basicBtn">1:1문의하기</button>
					<table class="asktable">
					<br><br><br>
					<tr class="pointline">
						<th>글번호</th>
						<th>제목</th>
						<th>작성일</th>
						<th>답변여부 </th>
					</tr>
					
					<c:forEach items="${myAskList}" var="list">
					<tr id="${list.qnaNum}" class="pointline">
						<td>${list.qnaNum}</td>
						<td>${list.qnaTitle}</td>
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

				</table>
			</div>
			
		    <!-- 페이징 시작-->
			<div class="page_wrap">
				<div class="page_nation">
					<c:if test="${paging.startPage != 1 }">
						<a class="arrow prev" href="${path}/mypage/ask?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}&user_num=${user_num}">이전</a> 
					</c:if>
					<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
						<c:choose>
							<c:when test="${p == paging.nowPage }">
								<b>${p }</b>
							</c:when>
							<c:when test="${p != paging.nowPage }">
								<a href="${path}/mypage/ask?nowPage=${p }&cntPerPage=${paging.cntPerPage}&user_num=${user_num}">${p}</a>
							</c:when>
						</c:choose>
					</c:forEach>
					<c:if test="${paging.endPage != paging.lastPage}">
						<a class="arrow next" href="${path}/mypage/ask?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}&user_num=${user_num}">다음</a>
					</c:if>
				</div>
			</div>
			<!-- 페이징 끝! -->		
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
</body>
</html>