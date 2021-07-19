<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bMember/bWait.css" rel="stylesheet" type="text/css" >
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
<div class="wrapper">   
	<jsp:include page="../bheader.jsp"></jsp:include>
	<section class="section">
             <div class="waitingPage">
                <div class="pageContent">
                    <h1>승인절차가 진행 중입니다.</h1>
                    <p>승인 확인 절차가 진행중입니다. 평균 승인 소요기간은 2-3일 입니다.</p>
                    <p>빠른 시일내로 승인처리 해드리겠습니다. 불편을 드려 죄송합니다.</p>
                    <p>문의 사항은 1577-0123로 연락주시면 빠르게 답변해드리겠습니다.</p>
                    <button id="logout" onclick="location.href='${path}/blogout'">로그아웃</button>
                </div>
            </div>
	</section>
	<jsp:include page="../../common/footer.jsp" />
</div>

</body>
</html>