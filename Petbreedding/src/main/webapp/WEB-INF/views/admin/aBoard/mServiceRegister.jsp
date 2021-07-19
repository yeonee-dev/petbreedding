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
<link href="${path}/resources/css/bPartner/bBoard/bQnaWrite.css" rel="stylesheet">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../mheader.jsp" />
		<section class="section">
		<jsp:include page="../mAside.jsp"/>
			<div class="bContent">
					
			<c:choose>
				<c:when test="${type eq 1}">
				<!-- 글쓰기 -->
					<form action="/petbreedding/msRegister" method="post" enctype="multipart/form-data">
						<input type="hidden" name="updAnnNum" value="${updAnnNum}">
		                <div class="qnaFile">
							<label>고객구분</label>	            
		       	            <select class="selectBox" name="mServiceSelect">
			                    <option value="0">전체</option>
			                    <option value="1">회원</option>
			                    <option value="2">사업자</option>
		               		</select>
			            </div>
		                <div class="qnatitle">
		            		<label id="h1">제목</label>
		                   <input id="title" type="text" name="mServiceTitle" placeholder="공지사항 제목을 입력해주세요">
		                </div>
		
						<input type="hidden" name="userType" value="2">
			            <div class="qnacontent">
			                <textarea id="content" placeholder="공지사항 내용을 작성해주세요" name="mServiceCont"></textarea>
			            </div>
			            
			            <div class="qnabtn">
				            <input type="submit" value="글등록" id="successbtn" class="basicBtn">
			            </div>
					</form>
				</c:when>
				
				<c:otherwise>
					<!-- 글 수정 -->
					
					<form action="/petbreedding/msModify" method="post">
						<input type="hidden" name="updAnnNum" value="${updAnnNum}">
		                <div class="qnaFile">
							<label>고객구분</label>	            
		       	            <select class="selectBox" name="mServiceSelect">
			                    <option value="0">전체</option>
			                    <option value="1">회원</option>
			                    <option value="2">사업자</option>
		               		</select>
			            </div>
		                <div class="qnatitle">
		            		<label id="h1">제목</label>
		                   <input id="title" type="text" name="mServiceTitle" value="${updAnnTitle}">
		                </div>
		
						<input type="hidden" name="userType" value="2">
			            <div class="qnacontent">
			                <textarea id="content" name="mServiceCont">${updAnnCont}</textarea>
			            </div>
			            
			            <div class="qnabtn">
				            <input type="submit" value="글수정" id="successbtn" class="basicBtn">
			            </div>
					</form>
					
					
				</c:otherwise>
			</c:choose>
		            
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	
</body>
</html>