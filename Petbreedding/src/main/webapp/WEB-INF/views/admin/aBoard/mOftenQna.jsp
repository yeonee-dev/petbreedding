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
<link href="${path}/resources/css/admin/aBoard/mOftenQna.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/paging.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../mheader.jsp" />
	 <section class="section">
	 <jsp:include page="../mAside.jsp"/>
	 <div class="mContent">
    
	 <div class="mboardhead">
                <h1>자주묻는질문</h1>
                <div class="select">
                    <select>
                        <option value="1">전체</option>
                        <option value="2">회원</option>
                        <option value="3">사업자</option>
                    </select>
                </div>
                <button id="myAskBtn" class="basicBtn" onclick = 'location.href="${path}/oftenQnaWrite"'>글 작성</button>
            </div>
            <div class="mboardrow">
                <table class="myboard">
                    <thead>
                    <tr>
                      <th scope="cols" width="200px">구분</th>
                      <th scope="cols"  width="1400px">제목</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list }" var="list">
	                    <tr class="mTr">
	                    <c:if test="${list. of_type eq 0}">
	                    	<td>[전체]</td>
	                    </c:if>
	                    <c:if test="${list. of_type eq 1}">
	                    	<td>[회원]</td>
	                    </c:if>
	                    <c:if test="${list. of_type eq 2}">
	                    	<td>[사업자]</td>
	                    </c:if>
                    	<td>${list.of_title }</td>
	                    </tr>
                    </c:forEach>
                    </tbody>
                  </table>
            </div>
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
	<script type="text/javascript" src="${path}/resources/js/admin/mAside.js"></script>
	<script type="text/javascript" src="${path}/resources/js/admin/aBoard/mBoard.js"></script>

	</body>
	</html>
	