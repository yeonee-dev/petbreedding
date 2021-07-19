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
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/main.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
</head>

<body>
	<div class="container">
        <video  class="containerV" width="100%" height="auto" autoplay loop muted controls>
            <source src="${path}/resources/video/dog1.mp4" type="video/mp4">대체 텍스트
        </video>
		
    </div>
	<div class="wrapper">    
		<jsp:include page="header.jsp" />
		<section class="section">
           <div class="tabmenu">
               <ul>
                   <li id="tab1" class="btnCon">
                       <input type="radio" name="tabmenu" checked id="tabmenu1" class="Tmenu">
                       <label for="tabmenu1">동물병원</label>
                        <div class="tabCon">
                        <form action="shopList/search/keyword" method="get">
                       <div class="nowLocation" id="nowLocation1">
               			 <span> 위치를 선택해 주세요. </span> <span></span> <span></span> <a href="#" id="Loc1"><i class="fas fa-map-marker-alt loc" ></i></a>
            			</div>
                        <!-- <div id="map1"></div> -->
                            <input name="keyword" type="text" class="tabInput" placeholder="찾으시는 동물병원을 입력해주세요.">
                             <input name="shopType" type="hidden" value="1"/>
                             <input name="selectlocCon" id="selectlocCon1" value="" type="hidden" />
                             <input name="selectChooseLoc" id="selectChooseLoc1" value="" type="hidden" />
                            <button class="searchB"><i class="fas fa-search SRB"></i></button>
                            </form>
                        </div>
                    </li>
                   <li id="tab2" class="btnCon">
                       <input type="radio" name="tabmenu" id="tabmenu2"  class="Tmenu">
                       <label for="tabmenu2">미용실</label>
                        <div class="tabCon">
                        <form action="shopList/search/keyword" method="get">
	                       <div class="nowLocation" id="nowLocation0">
	               			 <span> 위치를 선택해 주세요. </span> <span></span> <span></span> <a href="#" id="Loc2"><i class="fas fa-map-marker-alt loc" ></i></a>
	            			</div>
	            			<!-- <div id="map0"></div> -->
	                             <input name="keyword" type="text" class="tabInput" placeholder="찾으시는 미용실을 입력해주세요.">
	                             <input name="shopType" type="hidden" value="0"/>
	                             <input name="selectlocCon" id="selectlocCon0" value="" type="hidden" />
                            	 <input name="selectChooseLoc" id="selectChooseLoc0" value="" type="hidden" />
	                             <button type="submit" class="searchB"><i class="fas fa-search SRB"></i></button>
                        </form>
                        </div>  
                    </li>
               </ul>
           </div>
        </section>
        <footer class="footer">
		    <div class="footMenu">
		        <ul>
		            <li><a href="Uinfo.html">펫브리띵 소개</a></li>
		            <li><a href="#">이용약관</a></li>
		            <li><a href="#">개인정보취급방침</a></li>
		            <li><a href="business.html">제휴문의</a></li>
		            <li><a href="UcustomerService">공지사항</a></li>
		            <li><a href="UQnA.html">자주묻는질문</a></li>
		        </ul>
	    	</div>
		   <div class="footMenu2">
		        <p>(주)펫브리띵</p>
		        <p>서울특별시 중구 남대문로 120 대일빌딩 2F, 3F</p>
		        <p>사업자등록번호 : 123-01-12345</p>
		        <p>Copyright &COPY; 2021 PetbreeddingInstitute All Right Reserved</p>
		    </div>
		</footer>
	</div>

       <!-- MODAL -->
        <div id="my_modal">
            <p>주소 검색</p>
            <a class="modal_close_btn"><i class="fas fa-times" id="closeBtn"></i></a>
            <div id="locCon">
                <select name="selectlocCon" class="select"  onchange="categoryChange(this)">
                    <option value="" disabled="disabled" selected>시·도</option>
                    <option value="서울">서울특별시</option>
                    <option value="부산">부산광역시</option>
                    <option value="대구">대구광역시</option>
                    <option value="인천">인천광역시</option>
                    <option value="광주">광주광역시</option>
                    <option value="대전">대전광역시</option>
                    <option value="울산">울산광역시</option>
                    <option value="세종특별자치시">세종특별자치시</option>
                    <option value="경기">경기도</option>
                    <option value="강원도">강원도</option>
                    <option value="충북">충청북도</option>
                    <option value="충남">충청남도</option>
                    <option value="전북">전라북도</option>
                    <option value="전남">전라남도</option>
                    <option value="경북">경상북도</option>
                    <option value="경남">경상남도</option>
                    <option value="제주특별자치도">제주특별자치도</option>
                </select>
                <select name="selectChooseLoc" id="chooseLoc">
                    <option value="" disabled="disabled">시·군·구</option>
                </select>
                <button id="changeLoc">확인</button>
            </div>
        </div>
        

    <!-- script -->
     <script type="text/javascript" src="${path}/resources/js/common/index.js"></script>
	<script type="text/javascript" src="${path}/resources/js/common/indexMap.js"></script>
</body>


</html>