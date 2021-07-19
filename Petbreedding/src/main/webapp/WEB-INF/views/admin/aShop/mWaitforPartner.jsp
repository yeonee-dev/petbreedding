<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link href="${path}/resources/css/common/reset.css" type="text/css" rel="stylesheet">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css"  type="text/css" rel="stylesheet">
<link href="${path}/resources/css/admin/mAside.css"  type="text/css" rel="stylesheet">
<link href="${path}/resources/css/admin/aShop/mWaitforPartner.css"  type="text/css" rel="stylesheet">
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../mheader.jsp" />
		<section class="section">
			<jsp:include page="../mAside.jsp" />
			<div class="mContent">
			<h1>제휴 승인 대기</h1>
				<table>
					<tr>
						<th><input type="checkbox" id="checkall">&nbsp;&nbsp;전체선택</th>
						<th>사업자 분류</th>
						<th>이름</th>
						<th>사업자 번호</th>
						<th>연락처</th>
						<th>상태</th>
					</tr>
					<c:if test="${empty bP}">
					<tr>
						<td colspan="6">처리할 데이터가 없습니다.</td>
					</tr>
					</c:if>
					<c:forEach items="${bP}" var="bP">
						<tr class="checkTR">
							<td class="inputBox">
								<input type="checkbox" class="checkBox" name="bP">
							</td>
							<c:if test="${bP.bp_type eq 0}">
								<td>미용</td>
							</c:if>
							<c:if test="${bP.bp_type eq 1}">
								<td>병원</td>
							</c:if>
							<td>${bP.bp_name}</td>
							<td>${bP.bp_num}</td>
							<td>${bP.bp_tel}</td>
							<c:if test="${bP.bp_aprve eq 0}">
								<td>대기</td>
							</c:if>
						</tr>			
					</c:forEach>
				</table>
				<br>
				<div class="partnerbtns">
					<button class="basicBtn" id="confirmBP">승인</button>
					<button class="basicBtn" id="refuseBP">거절</button>
				</div>
				<br><br><br><br>
				<!-- 페이징 시작-->
				
				<div class="page_wrap">
					<div class="page_nation">
						<c:if test="${paging.startPage != 1 }">
							<a class="arrow prev" href="${path}/mwaitList?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">이전</a> 
						</c:if>
						<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
							<c:choose>
								<c:when test="${p == paging.nowPage }">
									<b>${p }</b>
								</c:when>
								<c:when test="${p != paging.nowPage }">
									<a href="${path}/mwaitList?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p}</a>
								</c:when>
							</c:choose>
						</c:forEach>
						<c:if test="${paging.endPage != paging.lastPage}">
							<a class="arrow next" href="${path}/mwaitList?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">다음</a>
						</c:if>
					</div>
				</div>
				<!-- 페이징 끝! -->
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	<!-- script -->
	<script type="text/javascript" src="${path}/resources/js/admin/mAside.js"></script>
	<script type="text/javascript" src="${path}/resources/js/admin/aShop/mWaitforPartner.js"></script>
</body>
</html>