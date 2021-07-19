<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bSales/cta.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bAside.css" rel="stylesheet" type="text/css" >
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="wrapper">
    <jsp:include page="../bheader.jsp" />
        <section class="section">
        <jsp:include page="../../bPartner/bAside.jsp" />
        	
        	<div id="bContent" class="bContent">
	        	<form class="ctaFrm">
		            <div class="viewBox">
			            <p class="viewText fs20">울트라콜</p>
		                <span class="viewText views fs20">잔여 조회수</span>
		                <c:choose>
		                <c:when test="${cta.CTA_NUMBER > 0}">
		                <span class="viewText views fs24">
		                		${cta.CTA_NUMBER} 회
		                </span>
		                </c:when>
		                <c:otherwise>
		                		<span class="viewText views fs24">
		                		0회
		                		</span>
		                </c:otherwise>
		            </c:choose>
		            </div>
		            <article class="aContainer">
		               
		               <c:forEach var="list" items="${list }">
		                <div class="aBox">
		                    <div>
		                        <p class="fs20">${list.CM_TYPE}회</p>
		                        <ul>
		                            <li class="CTA_inst mt10">
		                                <span>최상단 노출</span>
		                            </li>
		                            <li class="CTA_inst mt10">
		                                <span>울트라콜은 차감 방식으로 진행됩니다.</span>
		                            </li>
		                            <li class="CTA_inst mt10">
		                                <span>고객에 따라, 때에 따라 내 점포가 보일 수도 있고 안보일 수도 있습니다.</span>
		                            </li>
		                        </ul>
		                    </div>
		    
		                    <div>
		                        <p class=" price fs20">${list.PRICE}원</p>
		                        <button class="basicBtn CTAPayBtn">
		                        <a href="ctapay?CM_TYPE=${list.CM_TYPE}">
		                        	결제하기</a></button>
		                    </div>
		                </div>
		                </c:forEach>
		            </article>
		    
	        	</form>
        	</div>
        </section>
         <jsp:include page="../../common/footer.jsp" />
    </div>
    
    <!-- script -->
    <script src="https://kit.fontawesome.com/6a57affb8e.js"></script>
    <script type="text/javascript" src="${path}/resources/js/bPartner/bAside.js"></script>
</body>
</html>