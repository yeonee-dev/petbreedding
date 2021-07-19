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
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/uBoard/bwrite.css" rel="stylesheet" type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>

<!-- CKEDITOR -->
<script src="https://cdn.ckeditor.com/ckeditor5/28.0.0/classic/ckeditor.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />
        <section class="section">
           	<h1>자유게시판 글 작성</h1>
            
            <c:choose>
            	<c:when test="${type eq 1}">
            		<!-- 글 등록으로 이미지 넘어가는지 확인 중 -->
	           		<form action="bwrite" method="post" enctype="multipart/form-data">
		   				<div class="qnatitle">
			              <label>제목</label>
			              <input type="text" name="boTitle" placeholder="글 제목을 입력해주세요" id="bWriteTitle">
		                </div>
			            <div class="qnacontent">
			                <textarea name="boContent" id="editor"></textarea>
			            </div> 
						<div id="btnBox" class="btnBox">
				            <a href="fboardlist"><input type="button" value="취소" id="successbtn" class="basicBtn"></a>
				            <input type="submit" value="글등록" id="successbtn" class="basicBtn">
			            </div>    
	            	</form>
            	</c:when>
            	<c:otherwise>
   		           	<form action="bwrite" method="post" enctype="multipart/form-data">
		   				<div class="qnatitle">
			            	<label>제목</label>
			            	<input type="text" name="boTitle" value="${boUpdBoTitle}">
		                </div>
			            <div class="qnacontent">
			                <textarea name="boContent" id="editor">${boUpdBoCont}</textarea>
			            </div> 
						<div id="btnBox">
				            <a href="fboardlist"><input type="button" value="취소" id="successbtn" class="basicBtn"></a>
				            <input type="submit" value="글등록" id="successbtn" class="basicBtn">
				            <input type="hidden" name="boUpdBoNum" value="${boUpdBoNum}">
			        	</div>    
	            	</form>
            	</c:otherwise>
            </c:choose>	
           	
        </section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	<!-- script -->
     <script type="text/javascript" src="${path}/resources/js/user/uBoard/bwriter.js"></script>
</body>
</html>