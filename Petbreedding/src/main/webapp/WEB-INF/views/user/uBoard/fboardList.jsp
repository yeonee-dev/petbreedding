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
<link href="${path}/resources/css/user/uBoard/freeboard.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

</head>
<body>
	<div class="wrapper">    
		<jsp:include page="../../common/header.jsp" />
		<section class="section">
           
	    	<div class="bheader">
	        <h1>자유게시판</h1>
            	<form id="searchBoardFrm">
		            <div class="search-box">
	            		<input type="text" class="search-txt" name="keyword" placeholder="Type to search">
			            <input type="hidden" name="page" value="${currentPage}">
			            <span class="search-btn" onClick="searchBoard();">
			              <i class="fas fa-search"></i>
			            </span>
		        	</div><br><br>
	            </form>
	        </div>
	        <c:if test="${empty client }">
   				<div class="goLogin write">
			  	 <a href="uLogin"><button class="writebtn basicBtn">글쓰기</button></a>
				</div>
	        </c:if>
	        <c:if test="${!empty client }">
			<div class="write">
			   <a href="bwriteFrm?type=1"><button class="writebtn basicBtn">글쓰기</button></a>
			</div> 
	        </c:if>
			<c:if test="${listCount eq 0}">
				<h1>게시글이 없습니다.</h1>
			</c:if>
			
			<c:if test="${listCount ne 0}">
				<c:forEach items="${boardList }" var="blist">
					<div class="boardlist">
		            	<div class="subdiv">
		            		<c:choose>
		            			<c:when test="${blist.boImg eq null}">
			            	    	<div class="img"><a href="#"><img class="imgSize" src="${path }/resources/images/logo-square.png" width="150px" heigth="100px"></a></div>
			            	    </c:when>
		            			<c:otherwise>
			            	    	<div class="img"><a href="#"><img class="imgSize" src="${blist.boImg}"></a></div>
			            	    </c:otherwise>	
			                </c:choose>
			                <div class="title">
			                <a href="fboardcon?boNum=${blist.boNum}">
			                <p>${blist.boTitle}(${blist.bocChk})</p>
			                </a>
			                </div>
			                <div class="writer"><a href="fboardcon">${blist.clNickName}</a></div>
			                <div class="regdate"><a href="fboardcon">${blist.boDate}</a></div>
			                <div class="count"><a href="fboardcon">${blist.boView}</a></div>
		                </div>
		            </div>
				</c:forEach>
			
			</c:if>
			
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
			</section>
		<jsp:include page="../../common/footer.jsp" />
		<script type="text/javascript">
			function searchBoard() {
				$("#searchBoardFrm").attr('action', 'fboardlist')
				$("#searchBoardFrm").attr('method', 'get')
				$("#searchBoardFrm").submit();
				
			}
			$(".goLogin").on("click",function(){
				alert("로그인 후 이용가능합니다.");
			});
		</script>
    </div>
</body>
</html>