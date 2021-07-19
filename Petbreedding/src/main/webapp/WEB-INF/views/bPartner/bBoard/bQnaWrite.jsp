<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bAside.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bBoard/bQnaWrite.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />
		<section class="section">
			<jsp:include page="../bAside.jsp" />
			<div class="bContent">
			<form action="/petbreedding/maWrite" method="post" enctype="multipart/form-data">
				<input type="hidden" name="user_num" value="${user_num}">
                <div class="qnatitle">
            		<label id="h1">제목</label>
                   <input id="title" type="text" name="myAskTitle" placeholder="글 제목을 입력해주세요">
                </div>
                <div class="qnaFile">
					<label>첨부파일</label>	            
	            	<input type="file" id="realInput" name="myAskImg" accept=".jpg, .png" >
	            </div>
				<input type="hidden" name="userType" value="2">
	            <div class="qnacontent">
	                <textarea id="content" placeholder="1:1문의내용을 작성해주세요" name="myAskCont"></textarea>
	            </div>
	            
	            <div class="qnabtn">
		            <input type="submit" value="글등록" id="successbtn" class="basicBtn">
	            </div>
			</form>
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	<script type="text/javascript" src="${path}/resources/js/bPartner/bAside.js"></script>
</body>
</html>