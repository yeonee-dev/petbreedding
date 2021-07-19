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
<link href="${path}/resources/css/admin/aBoard/mboard.css" rel="stylesheet" type="text/css" >
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
                <h1>문의 게시판</h1>
                <div class="select">
                    <select id="selectQnaType">
                        <option value="0">전체</option>
                        <option value="1">회원</option>
                        <option value="2">사업자</option>
                    </select>

                </div>
                <div class="select2">
                    <select id="selectQnaChk">
                        <option value="0">대기</option>
                        <option value="1">완료</option>
                    </select>
                </div>

            </div>
            <div class="mboardrow">
                <table class="myboard">
                    <thead>
                    <tr>
                      <th scope="cols" width="200px">구분</th>
                      <th scope="cols"  width="1400px">제목</th>
                      <th scope="cols" width="200px">작성자</th>
                      <th scope="cols" width="200px">작성일</th>
                      <th scope="cols" width="200px">상태</th>
                    </tr>
                    </thead>
                    <tbody id="myAskBox">
                    	<c:forEach items="${myAskList}" var="mList">
		                    <tr id="${mList.qnaNum}" class="mTr">
			                    <c:choose>
			                   		<c:when test="${mList.qnaType eq 1}">
				                    	<td>[회원]</td>
			                   		</c:when>
			                   		<c:otherwise>
			                   			<td>[사업자]</td>
			                   		</c:otherwise>
		                    	</c:choose>
			                    	
			                    <td>${mList.qnaTitle }</td>
			                    <td>${mList.qnaWr }</td>
			                    <td>${mList.qnaDate }</td>
			                    
			                    <c:choose>
			                   		<c:when test="${mList.qnaChk eq 0}">
				                   		<td><button class="basicBtn" id="waitBtn">답변대기</button></td>
			                   		</c:when>
			                   		<c:otherwise>
			                   			<td><button class="basicBtn" id="successBtn">답변완료</button></td>
			                   		</c:otherwise>
		                    	</c:choose>
			                   
		                    </tr>
						</c:forEach>
                    </tbody>
                    <tbody id="myAskBoxAjax"></tbody>
                  </table>
            </div>
            
   	    <!-- 페이징 시작-->
		<div id="page_wrap" class="page_wrap">
			<div id="page_nation_ajax" class="page_nation"></div>
			<div id="page_nation" class="page_nation">
				<c:if test="${paging.startPage != 1 }">
					<a class="arrow prev" href="${path}/mboard?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">이전</a> 
				</c:if>
				<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
					<c:choose>
						<c:when test="${p == paging.nowPage }">
							<b>${p }</b>
						</c:when>
						<c:when test="${p != paging.nowPage }">
							<a href="${path}/mboard?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p}</a>
						</c:when>
					</c:choose>
				</c:forEach>
				<c:if test="${paging.endPage != paging.lastPage}">
					<a class="arrow next" href="${path}/mboard?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">다음</a>
				</c:if>
			</div>
		</div>
		<!-- 페이징 끝! -->
    	</div>
	  </section>
	<jsp:include page="../../common/footer.jsp" />
	</div>
	
<script type="text/javascript">
var paging = '${paging}';
console.log(paging);
</script>
<script type="text/javascript" src="${path}/resources/js/admin/mAside.js"></script>
<script type="text/javascript" src="${path}/resources/js/admin/aBoard/mBoard.js"></script>
</body>
</html>
	