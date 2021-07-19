<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/myPageAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/user/uMyPage/myzzim.css" rel="stylesheet" type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"	rel="stylesheet">
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../../common/header.jsp" />
	 <section class="section">
	 <jsp:include page="../myPageAside.jsp"/>
	 <input type="hidden" id="cl_num" value="${client.cl_num}">
	 <div class="myzzimhead">
        <h1>찜 목록</h1>
	        <div class="zzimlist">
					<!-- 찜목록은 ajax -->
	        </div>
			<div class="myzzimrow">
			</div>
     </div>
	 </section>
	 
	 <!--TOPBTN-->
     <a id="MOVE_TOP_BTN" href="#"><i class="fas fa-arrow-up"></i></a>
	 
	<jsp:include page="../../common/footer.jsp" />
	<!-- script -->
    <script src="${path}/resources/js/user/uMyPage/myzzim.js"></script>
    <script type="text/javascript" src="${path}/resources/js/common/topBtn.js"></script>
	</div>
</body>
</html>
	
	
	