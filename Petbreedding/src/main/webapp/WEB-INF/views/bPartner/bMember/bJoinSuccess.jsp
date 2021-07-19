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
<link href="${path}/resources/css/bPartner/bMember/bJoinSuccess.css" rel="stylesheet" type="text/css" >
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
<div class="wrapper">   
	<jsp:include page="../bheader.jsp"></jsp:include>
	<section class="section">
             <div class="finishedPage">
                <div class="pageContent">
                    <h1>정상적으로 문의가 신청되었습니다.</h1>
                    <p>담당자가 1~2일 내로 등록하신 연락처로 연락드리겠습니다.</p>
                    <p>감사합니다.</p>
                    <button>확인</button>
                </div>
            </div>
	</section>
	<jsp:include page="../../common/footer.jsp" />
</div>
</body>
</html>