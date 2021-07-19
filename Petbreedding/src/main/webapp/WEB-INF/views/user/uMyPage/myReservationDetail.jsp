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
<link href="${path}/resources/css/user/uMyPage/myReservationDetail.css"	rel="stylesheet" type="text/css">

<!-- 지도 api -->
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ffd90e8fd83a8d1b7acd8b168a81415f&libraries=services"></script>

<script src="https://kit.fontawesome.com/aca84cf3fb.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />
		<section class="section">
			<jsp:include page="../myPageAside.jsp" />
			<div class="mcontent">
			<div class="rborder r1 rOrderTitle">
                    <i class="far fa-check-circle"></i>
                    <c:forEach items="${myRev}" var="myRev">
                    <input type="hidden" value="${myRev.har_num }" id="exp_Id">
                    <input type="hidden" value="${myRev.har_rnum }" id="har_rnum">
                    <input type="hidden" value="${client.cl_num }" id="cl_num">
                    <input type="hidden" value="${myRev.hairSalon.bpId }" id="bpId">
                    <input type="hidden" value="${myRev.har_name }" id="shopName">
                    <input type="hidden" value="${myRev.res_date }" id="exp_date">
                    <c:if test="${myRev.res_status eq 0}">
						&nbsp;결제 대기					
					</c:if>
                    <c:if test="${myRev.res_status eq 1}">
						&nbsp;결제 완료						
					</c:if>
					<c:if test="${myRev.res_status eq 2}">
						&nbsp;이용 완료					
					</c:if>
					<c:if test="${myRev.res_status eq 3}">
						&nbsp;이용 취소						
					</c:if>
					</c:forEach>
                </div>
                <div class="rborder">
                	<c:forEach items="${myRev}" var="myRev">
                    <span id="rOrderNum">예약번호 ${myRev.har_rnum }</span>
                    <br><br>
                    <span class="rOrderTitle">${myRev.har_name }</span>
                    <br><br>
                    <table>
                        <tr>
                            <td>일정</td>
                            <td>${myRev.res_date }&nbsp;&nbsp;&nbsp;|&nbsp; ${myRev.res_time }</td>
                        </tr>
                        <tr>
                            <td>내역</td>
                            <td>${myRev.style.style_name }                            
	                           <c:if test="${!empty another }">
	                           	(+)${another }
	                           </c:if>      
                            </td>
                        </tr>
                    </table>
                    </c:forEach>
                    <br><br>
                    <c:forEach items="${myRev}" var="myRev">
	                    <c:if test="${myRev.res_status eq 0 or myRev.res_status eq 1}">
		                    <div class="buttons">
		                    <button type="button" class="basicBtn" id="1and1">1:1문의</button>&nbsp;&nbsp;&nbsp;&nbsp;
		                    <c:if test="${myRev.res_status eq 0 }">
		                    <button type="button" class="basicBtn" id="pay">결제하기</button>&nbsp;&nbsp;&nbsp;&nbsp;
		                    </c:if>
		                    <button type="button" class="basicBtn" id="cancle">취소하기</button>&nbsp;&nbsp;&nbsp;&nbsp;
		                    </div>
	                    </c:if>
                    </c:forEach>
                </div>
                <div class="rborder">
                    <span class="rOrderTitle">예약자 정보</span>
                    <br><br>
                    <table>
                    <c:forEach items="${myRev}" var="myRev">
                        <tr>
                            <td>예약자명</td>
                            <td>${myRev.client.name }</td>
                        </tr>
                        <tr>
                            <td>연락처</td>
                            <td>${myRev.client.tel }</td>
                        </tr>
                        <tr>
                            <td>이메일</td>
                            <td>${myRev.client.email }</td>
                        </tr> 
                    </c:forEach>
                    </table>
                </div>
                <div class="rborder">
                    <span class="rOrderTitle">반려견 정보</span>
                    <br><br>
                    <table>
                    <c:forEach items="${myRev}" var="myRev">
                     <tr>
                            <td>이름</td>
                            <td>${myRev.pet.pet_name }</td>
                        </tr>
                        <tr>
                            <td>나이</td>
                            <td>${myRev.pet.pet_birth }살</td>
                        </tr>
                        <tr>
                            <td>몸무게</td>
                            <td>${myRev.pet.pet_weight }kg</td>
                        </tr>
                     </c:forEach>
                    </table>
                </div>
                <div class="rborder">
                    <span class="rOrderTitle">결제 금액</span>
                    <span id="rOrderAmount">${totalPrice }원</span>
                </div>
                <div class="rborder dmap">
                    <p class="rOrderTitle">오시는 길</p>
                    <br>
                    <div class="mapFrame">
                        <div id="map" class="mapBox map">
                            </div>
                        </div>
                    <div class="rText">
                    	<c:forEach items="${myRev}" var="myRev">
                        <p class="rTextBold">업체명</p>
                        <p>${myRev.hairSalon.shopName }</p>
                        <p class="rTextBold" >주소</p>
                        <p>${myRev.hairSalon.shopAddr }</p>
                        <input type="hidden" id="shopAddr" value="${myRev.hairSalon.shopAddr }">
                        <p class="rTextBold">전화번호</p>
                        <p>${myRev.hairSalon.shopTel }</p>
                        </c:forEach>
                    </div>
                </div>
                
            </div>
        </section>
        <jsp:include page="../../common/footer.jsp"/>
        
        
        <!-- MODAL -->
         <div id="my_modal">
            <a class="modal_close_btn"><i class="fas fa-times" id="closeBtn"></i></a>
            <div id="locCon">
                <h1>취소하시겠습니까?</h1>
                <button id="goCancle">네</button>
                <button id="nextTime">아니오</button>
            </div>
        </div>	
    </div>
    
    
    <!-- script -->
    <script src="${path}/resources/js/user/uMyPage/myReservationDetail.js"></script>
    <script type="text/javascript" src="${path}/resources/js/common/map.js"></script>
</body>
</html>