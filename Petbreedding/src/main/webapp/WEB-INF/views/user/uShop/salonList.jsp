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
<link href="${path}/resources/css/user/uShop/shopList.css" rel="stylesheet" type="text/css" >
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">    
		<jsp:include page="../../common/header.jsp" />
		
		<section class="section">
            <h1>미용실</h1>
            <div class="nowLocation">
                <span>경기</span><span>></span><span>고양</span><a href="#" id="Loc"><i class="fas fa-map-marker-alt loc" ></i></a>
            </div>
            <hr id="storeLine">
            <div class="selectOpt">
                <input type="radio" checked id="popular" name="selectOpt"><label for="popular">인기순</label>
                <input type="radio" id="distance" name="selectOpt"><label for="distance">거리순</label>
                <input type="radio" id="rating" name="selectOpt"><label for="rating">별점순</label>
            </div>
            <div class="ultraS">
                <small id="ultra_ad">울트라콜 광고<i class="fas fa-ad"></i></small>
                <ul>
                    <div class="ultraStore">                     
                        <li class="ultraList">
                            <div class="ultraList_inner">
                                <div class="ultraList_img_area"><a href="#"><img src="http://placehold.it/150x100"></a></div>
                                <div class="ultraList_title_area"><a href="#">쿨펫 동물병원</a></div>
                                <div class="ultraList_info_area"><a href="#">가위컷 전문 미용실입니다.</a></div>
                                <div class="ultraList_etc_area">
                                    <a href="#">리뷰<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><small>999+</small></a>
                                    <a href="#">구매건수<small>999+</small></a>
                                    <a href="#">찜하기<small>999+</small></a>
                                </div>
                                <div class="ultraList_button">
                                    <a href="storeInfoRead.html" class="goList">정보보기</a>
                                </div>
                            </div>                                                            
                        </li>
                    </div>
                </ul>
            </div>
            <div class="storeS">
            	<c:forEach items="${salonList}" var="item">
            	
                <ul>
                    <div class="Store">                     
                        <li class="storeList">
                            	
                            <div class="storeList_inner">
                                <div class="storeList_img_area"><a href="#"><img src="http://placehold.it/150x100"></a></div>
                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
                                <div class="storeList_info_area"><a href="#">${item.shopMInfo }</a></div>
                                <div class="storeList_etc_area">
                                    <a href="#">리뷰<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><small>999+</small></a>
                                    <a href="#">구매건수<small>999+</small></a>
                                    <a href="#">찜하기<small>999+</small></a>
                                </div>
                                <form class="frmShopInfo" >
	                                <%-- <input type="hidden" value="${item.bpId }" name="bpId"> --%>
	                                <div class="storeList_button">
	                                	BPID: ${item.bpId }
                                    	<a href="shopPage?bpId=${item.bpId }"  class="goList">정보보기</a>
                                	</div>
                                </form>
                                <script>
<%--                                 $(".storeList_button").click("on", function(){
                                	var frm = $(this).parent(".frmShopInfo");
                                	frm.action = "<%=request.getContextPath()%>/shopPage";
                                	frm.method = "post";
                                	frm.submit();
                                	return true;
                                }); --%>
                                </script>
                            </div>                                                            
                        </li>
                    </div>
                </ul>
                </c:forEach>
            </div>
            <!--TOPBTN-->
            <a id="MOVE_TOP_BTN" href="#"><i class="fas fa-arrow-up"></i></a>
        </section>
	
		<jsp:include page="../../common/footer.jsp" />	
		
		 <!-- MODAL -->
        <div id="my_modal">
            <p>주소 검색</p>
            <a class="modal_close_btn"><i class="fas fa-times" id="closeBtn"></i></a>
            <div id="locCon">
                <select name="" class="select"  onchange="categoryChange(this)">
                    <option value="" disabled="disabled" selected>시·도</option>
                    <option value="a">서울특별시</option>
                    <option value="b">부산광역시</option>
                    <option value="c">대구광역시</option>
                    <option value="d">인천광역시</option>
                    <option value="e">광주광역시</option>
                    <option value="f">대전광역시</option>
                    <option value="g">울산광역시</option>
                    <option value="h">세종특별자치시</option>
                    <option value="i">경기도</option>
                    <option value="j">강원도</option>
                    <option value="k">충청북도</option>
                    <option value="l">충청남도</option>
                    <option value="m">전라북도</option>
                    <option value="n">전라남도</option>
                    <option value="o">경상북도</option>
                    <option value="p">경상남도</option>
                    <option value="q">제주특별자치도</option>
                </select>
                <select id="chooseLoc">
                    <option value="" disabled="disabled">시·군·구</option>
                </select>
                <button id="changeLoc">확인</button>
            </div>
        </div>
		
		
	</div>
	
	 <!-- script -->
     <script type="text/javascript" src="${path}/resources/js/user/uShop/shopList.js"></script>
     <script type="text/javascript" src="${path}/resources/js/common/topBtn.js"></script>
</body>
</html>