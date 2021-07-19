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
<link href="${path}/resources/css/user/uMember/uDelete.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/user/myPageAside.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="wrapper">
        <jsp:include page="../../common/header.jsp" />

        <section class="section">
        <jsp:include page="../myPageAside.jsp" />
        <input type="hidden" value="${client.cl_num}" id="cl_num">
			<div class="uContent">
				<div id="delete">
		            <div id="locCon">
		                <h1>정말 탈퇴하시겠습니까?</h1>
		                <p>포인트와 작성했던 글, 댓글들이 전부 삭제됩니다.</p>
		                <button id="yes" class="basicBtn">네</button>
		            </div>
		        </div>	
		    </div>
        </section>

        <jsp:include page="../../common/footer.jsp" />
    </div>   
    
    <!-- script -->
    <script type="text/javascript" src="${path}/resources/js/user/uMember/uDelete.js"></script>
    <script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
</body>
</html>