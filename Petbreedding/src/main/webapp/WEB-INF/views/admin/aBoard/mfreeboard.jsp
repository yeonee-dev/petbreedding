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
<link href="${path}/resources/css/admin/mAside.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/admin/aBoard/mfreeboard.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/paging.css" rel="stylesheet" type="text/css" >
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../mheader.jsp" />
		<section class="section">
			<jsp:include page="../mAside.jsp" />
			<div class="mContent">
				<div class="mboardhead">
					<div class="myboardhead">
						<h1>자유게시판</h1>
						<table class="myboard">
							<thead>
								<tr>
									<th scope="cols" width="200px" id="allBtn"><input type="checkbox"
										value='selectall' onclick='selectAll(this)'>전체</th>
									<th scope="cols" width="1000px">제목</th>
									<th scope="cols" width="1000px">내용</th>
									<th scope="cols" width="200px">조회수</th>
								</tr>
							</thead>
							<tbody>
							<c:if test="${empty myList}">
					            <tr>
					              	<td colspan="4">작성하신 글이 없습니다.</td>
					            </tr>
	            			</c:if>
							<c:if test="${!empty myList}">
								<c:forEach items="${myList}" var="myList" varStatus="status">
									<tr class="checkTR">
										<td class="inputBox"><input type="checkbox" name="board" value="${myList.boNum }"></td>
										<td class="bTitle goDetail">${myList.boTitle }</td>
										<td>${myList.boDate }</td>
										<td>${myList.boView }</td>
									</tr>
								</c:forEach>
							</c:if>
							</tbody>
						</table>
					</div>
					<div class="myboardrow">
						<button class="basicBtn" id="deleteBoard">삭제</button>
						<input type="hidden" id="userType" value="${userType}">
					</div>
					
					
				</div>
				
				    <!-- 페이징 시작-->
					<div class="page_wrap">
						<div class="page_nation">
							<c:if test="${paging.startPage != 1 }">
								<a class="arrow prev" href="${path}/mfreeboard?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">이전</a> 
							</c:if>
							<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
								<c:choose>
									<c:when test="${p == paging.nowPage }">
										<b>${p}</b>
									</c:when>
									<c:when test="${p != paging.nowPage }">
										<a href="${path}/mfreeboard?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p}</a>
									</c:when>
								</c:choose>
							</c:forEach>
							<c:if test="${paging.endPage != paging.lastPage}">
								<a class="arrow next" href="${path}/mfreeboard?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">다음</a>
							</c:if>
						</div>
					</div>
					<!-- 페이징 끝! -->
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	<!-- script -->
	<script type="text/javascript" src="${path}/resources/js/admin/mAside.js"></script>
	<script type="text/javascript" src="${path}/resources/js/admin/aBoard/mfreeboard.js"></script>
</body>
</html>
