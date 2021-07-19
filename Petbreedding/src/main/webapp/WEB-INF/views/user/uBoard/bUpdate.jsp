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
<link href="${path}/resources/css/user/uBoard/qna.css" rel="stylesheet" type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>

<!-- CKEDITOR -->
<script src="https://cdn.ckeditor.com/ckeditor5/28.0.0/classic/ckeditor.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />
        <section class="section">
           	<h1>자유게시판 글 수정</h1>
            
           	<form action="bupdate" method="post" enctype="multipart/form-data">
   				<div class="qnatitle">
	            	<label>제목</label>
	            	<input type="text" name="boTitle" value="${boUpdBoTitle}">
                </div>
	            <div class="qnacontent">
	                <textarea name="boContent" id="editor">${boUpdBoCont}</textarea>
	            </div> 
				<div id="btnBox">
		            <input type="button" value="취소" id="browseBtn" class="basicBtn">
		            <input type="submit" value="글수정" id="successbtn" class="basicBtn">
		            <input type="hidden" name="boUpdBoNum" value="${boUpdBoNum}">
	        	</div>    
           	</form>

        </section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	<!-- script -->
     <script type="text/javascript" src="${path}/resources/js/user/uBoard/bwriter.js"></script>
</body>
</html>