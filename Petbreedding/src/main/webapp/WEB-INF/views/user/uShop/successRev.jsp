<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petverything::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/user/uShop/successPay.css" rel="stylesheet" type="text/css" >
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
<div class="wrapper">    
		<jsp:include page="../../common/header.jsp" />
			<section class="section">
			<p><span><a href="index.html">홈</a>></span><span><a href="salon.html">쿨펫미용실</a>></span><span><a href="salonReservation.html">예약하기</a>></span>결제하기</p>
             <div class="finishedPage">
                <div class="pageContent">
                	<input type="hidden" id="cl_num" value="${client.cl_num }">
                    <h1>예약이 완료되었습니다.</h1>
                    <p>정상적으로 예약이 완료되었습니다.</p>
                    <p>이용해주셔서 감사합니다.</p>
                    <button id="goRev">예약 내역 확인하러 가기</button>
                </div>
            </div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
		
		 <script type="text/javascript" src="${path}/resources/js/user/uShop/successPay.js"></script>
</div>
</body>
</html>