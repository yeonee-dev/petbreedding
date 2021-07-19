<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/admin/mAside.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/admin/aBoard/mservice.css" rel="stylesheet"
	type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../mheader.jsp" />
		<section class="section">
			<jsp:include page="../mAside.jsp" />
			<div class="mContent">
				<div class="mboardhead">
					<div class="conhead">
						<p>[회원]</p>
						<p>[발표] 5월 5주차 무료 초대권 당첨자 발표</p>
						<p>작성자 : 또비언니</p>
						<p>작성일 : 2021-06-15</p>
						<p>조회수 : 20</p>
					</div>
					<div class="con">
						<p>
							안녕하세요. 펫 브리띵 팀입니다 <br>
							<br> 금주 무료 초대권 당첨자를 발표합니다.<br>
							<br> 김x지(12****)<br> 이*훈(ab***)<br> 박*자(tt****)<br>
							위 3분은 펫브리띵 (petbreeding @ gmail.com)으로 06월 15일까지 연락주세요.



						</p>

					</div>
					<div class="conbtn">
						<button class="basicBtn" id="listBtn">목록</button>
						<button class="basicBtn" id="updeteBtn">수정</button>
						<button class="basicBtn" id="delBtn">삭제</button>

					</div>


				</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	<script type="text/javascript"
		src="${path}/resources/js/admin/mAside.js"></script>
</body>
</html>