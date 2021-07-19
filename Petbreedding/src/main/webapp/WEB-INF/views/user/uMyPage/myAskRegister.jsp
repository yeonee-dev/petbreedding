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
<link href="${path}/resources/css/user/myPageAside.css"	rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bBoard/bQnaWrite.css" rel="stylesheet" type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />
        <section class="section">
        <jsp:include page="../myPageAside.jsp" />
        <div class="mcontent">
  			<form action="/petbreedding/maWrite" method="post" enctype="multipart/form-data" style="padding-top: 80px;">
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
	            
	            <div class="qnabtn" id="qnabtn">
		            <input type="submit" value="글등록" id="successbtn" class="basicBtn">
	            </div>
			</form>
            </div>
        </section>
		<jsp:include page="../../common/footer.jsp" />
		</div>
</body>
</html>		
		
		
		
		