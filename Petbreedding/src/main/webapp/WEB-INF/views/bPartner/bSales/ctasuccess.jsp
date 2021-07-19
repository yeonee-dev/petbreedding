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
             <div class="finishedPage">
                <div class="pageContent">
                    <h1>결제가 완료되었습니다.</h1>
                    <p>정상적으로 결제가 완료되었습니다.</p>
                    <p>이용해주셔서 감사합니다.</p>
                    <button id="goRev"><a href="cta">내 울트라콜 확인하기</a></button>
                </div>
            </div>
		</section>
	<jsp:include page="../../common/footer.jsp" />		
</div>
</body>
</html>