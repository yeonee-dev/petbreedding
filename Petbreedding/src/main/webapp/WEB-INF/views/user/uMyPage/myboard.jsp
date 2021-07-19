<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/user/myPageAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/user/uMyPage/myboard.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/paging.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
<div class="wrapper">    
  <jsp:include page="../../common/header.jsp" />
  <section class="section">
  		<jsp:include page="../myPageAside.jsp"/>
	  	<div class="myboardhead">
	        <h1>내가 쓴 글</h1>
	        <table class="myboard">
	            <thead>
	            <tr>
	              <th scope="cols" width="250px">
	              	<input type="checkbox"  value='selectall' onclick='selectAll(this)' />전체선택
	              </th>
	              <th scope="cols"  width="1700px">제목</th>
	              <th scope="cols" width="200px">작성일</th>
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
		            <c:forEach items="${myList}" var="myList" varStatus="status" >
		            	<tr>
			              <td class="chBtn"><input type="checkbox" name="board" value="${myList.boNum }"></td>
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
        </div>
	    <!-- 페이징 시작-->
		<div class="page_wrap">
			<div class="page_nation">
				<c:if test="${paging.startPage != 1 }">
					<a class="arrow prev" href="${path}/myboard?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}&cl_num=${client.cl_num}">이전</a> 
				</c:if>
				<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
					<c:choose>
						<c:when test="${p == paging.nowPage }">
							<b>${p }</b>
						</c:when>
						<c:when test="${p != paging.nowPage }">
							<a href="${path}/myboard?nowPage=${p }&cntPerPage=${paging.cntPerPage}&cl_num=${client.cl_num}">${p}</a>
						</c:when>
					</c:choose>
				</c:forEach>
				<c:if test="${paging.endPage != paging.lastPage}">
					<a class="arrow next" href="${path}/myboard?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}&cl_num=${client.cl_num}">다음</a>
				</c:if>
			</div>
		</div>
		<!-- 페이징 끝! -->
    </section>
   <jsp:include page="../../common/footer.jsp" />
    </div>
    <script src="${path}/resources/js/user/uBoard/service.js"></script>    
</body>
</html>