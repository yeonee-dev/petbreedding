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
<link href="${path}/resources/css/admin/mAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/admin/aBoard/mOftenQnaWrite.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../mheader.jsp" />
		<section class="section">
			<jsp:include page="../mAside.jsp" />
			<div class="mContent">
			<form action="/petbreedding/oftenQnaWriteDo" method="post">
				<div class="qnaSelect">
					<label>고객구분</label>
                	<select name="oftenQnaType">
                		<option value="0">전체</option>
                		<option value="1">회원</option>
                		<option value="2">사업자</option>
                	</select>
	            </div>
                <div class="qnatitle">
            		<label id="h1">제목</label>
                   <input id="title" type="text" name="oftenQnaTitle" placeholder="글 제목을 입력해주세요">
                </div>
	            <div class="qnacontent">
	                <textarea id="content" placeholder="내용을 입력해주세요" name="oftenQnaCont"></textarea>
	            </div>
	            
	            <div class="qnabtn">
		            <input type="submit" value="글등록" id="successbtn" class="basicBtn">
	            </div>
			</form>
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	<script type="text/javascript" src="${path}/resources/js/admin/mAside.js"></script>
</body>
</html>