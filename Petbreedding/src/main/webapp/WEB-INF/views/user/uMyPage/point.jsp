<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet"	type="text/css">
<link href="${path}/resources/css/common/header.css" rel="stylesheet"	type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet"	type="text/css">
<link href="${path}/resources/css/user/myPageAside.css"	rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/uMyPage/point.css"	rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/aca84cf3fb.js"	crossorigin="anonymous"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />
		<section class="section">
			<jsp:include page="../myPageAside.jsp" />
			<div class="mcontent">
				
					<input type="hidden" value="${client.cl_num }" id="cl_num">
					<div class="point">
	                    <p class="ptitle">보유포인트</p>
	                    <br>
	                    <c:if test="${empty currPoint or currPoint eq -1}">
	                    	<p class="presult">0P</p>
	                    </c:if>
	                    <c:if test="${!empty currPoint and (currPoint ne -1)}">
	                    	<p class="presult">${currPoint}P</p>
	                    </c:if>
	                </div>
	                <br>
	                <div class="selectOpt">
	                    <input type="radio" checked id="popular" name="selectOpt" class="selDate"><label for="popular">최근 3개월</label>
	                    <input type="radio" id="distance" name="selectOpt" class="selDate"><label for="distance">최근 6개월</label>
	                    <input type="radio" id="rating" name="selectOpt" class="selDate"><label for="rating">최근 1년</label>
	                </div>
	                <div class="timetblP">
	                    <span>기간별 조회</span>&nbsp;&nbsp;&nbsp;
	                    <span><input type="date" id="start">&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;<input type="date" id="end"></span>
	                    <span>&nbsp;&nbsp;<button type="button" class="basicBtn" id="changeDate">조회하기</button></span>
	                </div>
	                <br><br><br><br>
	                <table class="pointtable">
	                   
	                </table>
	                <div class="divmore">
	                </div>
	               
            </div>
            
            <!--TOPBTN-->
        	<a id="MOVE_TOP_BTN" href="#"><i class="fas fa-arrow-up"></i></a>
        </section>
        <jsp:include page="../../common/footer.jsp"/>
    </div>
    
    <!-- script -->
    <script src="${path}/resources/js/user/uMyPage/point.js"></script>
    <script type="text/javascript" src="${path}/resources/js/common/topBtn.js"></script>
</body>
</html>