<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bShop/bFaceChat.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />
		<section class="section">
             	<jsp:include page="../bAside.jsp" />
	        <div class="bContent">
               <div class="backImg">
                   <img src="${path}/resources/images/faceChatImg.png">
                   
                   <p>화상채팅하러가기</p>
                   <!-- Rounded switch -->
                   <label class="switch">
                       
                       <input type="checkbox">
                       <span class="slider round"></span>
                   </label>
               </div>
            </div> 	
       	</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	
	<!-- script -->
    <script type="text/javascript" src="${path}/resources/js/bPartner/bAside.js"></script>
</body>
</html>