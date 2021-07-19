<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedthing::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css//user/uShop/shopInfoRead.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/paging.css" rel="stylesheet" type="text/css" >
<script src="https://kit.fontawesome.com/aca84cf3fb.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<!-- 지도 api -->
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ffd90e8fd83a8d1b7acd8b168a81415f&libraries=services"></script>

<!-- Swiper -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>
</head>
<body>
	<div class="wrapper">    
		<jsp:include page="../../common/header.jsp" />
			<section class="section">
            <div class="store_area">
            	<input type="hidden" value="${client.cl_num}" id="cl_num" />
            	<c:if test="${shopType eq 0 }">
            	<input type="hidden" value="${shopInfo.harNum}" id="har_num" />
            	</c:if>
            	<c:if test="${shopType eq 1 }">
            	<input type="hidden" value="${shopInfo.hosNum}" id="hos_num" />
            	</c:if>
            <!-- 매장 타입이 0이면 미용실 -->
            <!-- 매장 타입이 1이면 동물병원 -->

                <div class="store_info_article">
                	<c:forEach var="shopImgList" items="${shopImgList }" varStatus="status">
                    <div class="store_img">
                    	<c:if test="${empty shopImgList.shopImg}">
                    		<img  onerror="this.src='${path}/resources/images/logoForChat.png'" src="http://placehold.it/400x400">
                    	</c:if>
                    	<c:if test="${!empty shopImgList.shopImg}">
                        <img  onerror="this.src='${path}/resources/images/logoForChat.png'" src="${path}/resources/uploadFile/shop/${shopImgList.shopImg }" style="width:400px; height: 400px;">
                        </c:if>
                    </div>
                    </c:forEach>
                    <div class="store_name">
                        <h1>${shopInfo.shopName }</h1>
                    </div>
                    <div class="store_tel"><i class="fas fa-phone-alt"></i><span>${shopInfo.shopTel }</span></div>
                    <div class="store_info">
                        <p>${shopInfo.shopMInfo }</p>
                    </div>
                    <div class="store_btn">
                        <a href="#" id="goChat" class="sBtn" onclick="openchatwin('${bp_id}','${shopInfo.shopName}','${shopType }')">문의하기</a>
                        <c:if test="${empty client }">
                        	<a href="${path}/uLogin" id="goRev" class="sBtn" >예약하기</a>
                        </c:if>
						<c:if test="${!empty client }">
                        	<c:if test="${shopType eq 0 }">
		                       <a href="${path}/shopReservation?har_num=${shopInfo.harNum}&&cl_num=${client.cl_num}" id="goRev" class="sBtn" >예약하기</a>                                            	
                        	</c:if>
							<c:if test="${shopType eq 1 }">
		                       <a href="${path}/shopHosReservation?hos_num=${shopInfo.hosNum}&&cl_num=${client.cl_num}" id="goRev" class="sBtn" >예약하기</a>                                            	
                        	</c:if>
                        </c:if>
                        <c:if test="${empty client }">
                        	<a id="zzim" onclick="noCLient()">
	                        	<i class="far fa-heart" id="heartOff"></i>
	                        	<i class="fas fa-heart" id="heartOn"></i>
                        	</a>
                        </c:if>
                      
                       <c:if test="${!empty client }">
                         <a id="zzim">
                        	<i class="far fa-heart" id="heartOff"></i>
                        	<i class="fas fa-heart" id="heartOn"></i>
                        </a>
                       </c:if>
                    </div>
                </div> <!--store_info_article-->
                <div class="swiper-container store_menu_article ">
                
                <c:if test="${shopType eq 0}">
					<p>스타일<span>(${fn:length(menuList)})</span></p>
                    <div class="swiper-wrapper store_menues">
                     <c:forEach var="menuList " items="${menuList }" varStatus="status">
                            <div class="menu_box swiper-slide">
                                <a href="#">
                                    <p class="menu_item"><c:out value="${menuList[status.index].style_name }"/></p>
                                    <small class="menu_time">${menuList[status.index].style_time }분 소요</small>
                                    <p class="menu_price">${menuList[status.index].price }원</p>
                                </a>
                            </div>
                      </c:forEach>
                    </div>
                    <div class="swiper-button-next"></div>
                    <div class="swiper-button-prev"></div>
                </c:if> 
                
               <c:if test="${shopType eq 1}">
					<p>진료<span>(${fn:length(menuList)})</span></p>
                    <div class="swiper-wrapper store_menues">
                     <c:forEach var="menuList " items="${menuList }" varStatus="status">
                            <div class="menu_box swiper-slide">
                                <a href="#">
                                    <p class="menu_item"><c:out value="${menuList[status.index].medName }"/></p>
                                    <small class="menu_time">	</small>
                                    <p class="menu_price">${menuList[status.index].medPrice }원</p>
                                </a>
                            </div>
                      </c:forEach>
                    </div>
                    <div class="swiper-button-next"></div>
                    <div class="swiper-button-prev"></div>               
                </c:if>
                
                   
                </div><!--store_menu_article-->
                
                <div class="store_review_article ">
                    <p>예약자 리뷰<span>(${revCount})</span></p>
                    <div class="reviewsBox">
                        <div class="avgStar">
                        	<c:if test="${revValAvg >= 5.00 }">
                        		<i class="fas fa-star rate"></i>
	                            <i class="fas fa-star rate"></i>
	                            <i class="fas fa-star rate"></i>
	                            <i class="fas fa-star rate"></i>
	                            <i class="fas fa-star rate"></i>
                        	</c:if>
                        	<c:if test="${revValAvg < 5.00 and revValAvg >= 4.5}">
                        		<i class="fas fa-star rate"></i>
	                            <i class="fas fa-star rate"></i>
	                            <i class="fas fa-star rate"></i>
	                            <i class="fas fa-star rate"></i>
	                            <i class="fas fa-star-half-alt rate"></i>
                        	</c:if>
                        	<c:if test="${revValAvg < 4.50 and revValAvg >= 4.0}">
                        		<i class="fas fa-star rate"></i>
	                            <i class="fas fa-star rate"></i>
	                            <i class="fas fa-star rate"></i>
	                            <i class="fas fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
                        	</c:if>
                        	<c:if test="${revValAvg < 4.00 and revValAvg >= 3.50}">
                        		<i class="fas fa-star rate"></i>
	                            <i class="fas fa-star rate"></i>
	                            <i class="fas fa-star rate"></i>
	                            <i class="fas fa-star-half-alt rate"></i>
	                            <i class="far fa-star rate"></i>
                        	</c:if>
                        	<c:if test="${revValAvg < 3.50 and revValAvg >= 3.00}">
                        		<i class="fas fa-star rate"></i>
	                            <i class="fas fa-star rate"></i>
	                            <i class="fas fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
                        	</c:if>
                        	<c:if test="${revValAvg < 3.00 and revValAvg >= 2.50}">
                        		<i class="fas fa-star rate"></i>
	                            <i class="fas fa-star rate"></i>
	                            <i class="fas fa-star-half-alt rate"></i>
	                            <i class="far fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
                        	</c:if>
                        	<c:if test="${revValAvg < 2.50 and revValAvg >= 2.00}">
                        		<i class="fas fa-star rate"></i>
	                            <i class="fas fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
                        	</c:if>
                        	<c:if test="${revValAvg < 2.0 and revValAvg >= 1.50}">
                        		<i class="fas fa-star rate"></i>
	                            <i class="fas fa-star-half-alt rate"></i>
	                            <i class="far fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
                        	</c:if>
                        	<c:if test="${revValAvg < 1.50 and revValAvg >= 1.00}">
                        		<i class="fas fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
                        	</c:if>
                        	<c:if test="${revValAvg < 1.00 and revValAvg >= 0.50}">
                        		<i class="fas fa-star-half-alt rate"></i>
	                            <i class="far fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
                        	</c:if>
                        	<c:if test="${empty revValAvg}">
                        		<i class="far fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
	                            <i class="far fa-star rate"></i>
                        	</c:if>
                        	<c:if test="${!empty revValAvg  }">
	                            <span class="rateScore">${revValAvg}/5.00</span>
                        	</c:if>
                        	<c:if test="${empty revValAvg  }">
	                            <span class="rateScore">0.00/5.00</span>
                        	</c:if>
                        </div>
                        <div class="reviewOpt">
<!--                             <input type="checkbox" id="checkPhoto"><label for="checkPhoto">사진리뷰만 보기</label> 미구현 기능--> 
                            <div class="checkOpts">
                                <span id="upToDate" class="checkOpt">최신순</span>
                                <span id="ascendingStar" class="checkOpt">별점 높은 순</span>
                                <span id="descendingStar" class="checkOpt">별점 낮은 순</span>
                            </div>
                        </div> 
                        <hr> 
                        <div class="reviews">
							<div id="reviewArea"></div>
                        </div>
                        
                    	<!-- 페이징 시작-->
						<div id="page_wrap" class="page_wrap">
							<div id="page_nation" class="page_nation">
							</div>
						</div>
						<!-- 페이징 끝! -->
                                                            
                    </div>            
                </div> <!--store_review_article-->
                <div class="store_map_article ">
                    <p>오시는길</p>
                    <div class="storeMapBox">
                        <div class="mapFrame">
                            <div id="map" class="mapBox">
                            </div>
                        </div>
                        <div class="storeInfo">
                            <p>${shopInfo.shopName }</p>
                            <p>전화번호 : ${shopInfo.shopTel }</p>
                            <p>주소: ${shopInfo.shopAddr }</p>
                            <input type="hidden" id="shopAddr" value="${shopInfo.shopAddr }">
                        </div>
                    </div>
                </div>
            </div><!--store_area-->
            
            <!--TOPBTN-->
            <a id="MOVE_TOP_BTN" href="#"><i class="fas fa-arrow-up"></i></a>
        
        </section>
	
		
		<jsp:include page="../../common/footer.jsp" />	
	</div>
	
	 <!-- script -->
     <script type="text/javascript" src="${path}/resources/js/user/uShop/shopInfoRead.js"></script>
     <script type="text/javascript" src="${path}/resources/js/user/uMyPage/Likes.js"></script>
     <script type="text/javascript" src="${path}/resources/js/common/topBtn.js"></script>
     <script type="text/javascript" src="${path}/resources/js/common/map.js"></script>
   	 <script type="text/javascript">
		 var bpId = '${shopInfo.bpId}';
		 var path = '${pageContext.request.contextPath}';
		 var shopName = '${shopInfo.shopName }';
		 var type = 0;
		 var p = 1;
		 
		 console.log(shopName);
		 console.log(type);
		 console.log(p);
		 
		 reviewInit(bpId, path, type, p);
	 </script>
</body>
</html>