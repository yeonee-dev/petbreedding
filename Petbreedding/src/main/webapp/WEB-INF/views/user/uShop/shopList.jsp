<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="shopType" value="${param.shopType}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/user/uShop/shopList.css" rel="stylesheet" type="text/css" >
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
</head>
<body>
   <div class="wrapper">    
      <jsp:include page="../../common/header.jsp" />
      
      <section class="section">
      
      <c:if test="${shopType eq 1}">
      <!-- 동물병원 -->
      
      <h1>동물병원</h1>
      
      		<!-- 동물병원 위치 및 검색 키워드 표시 -->
      		
      			           
            <c:if test="${!empty keyword}">
            <div class="nowLocation">
                <span>
                <c:if test="${!empty searchLoc1 }">
                <i class="fas fa-map-marked-alt" style="color: #ff9914;"></i> ${searchLoc1 } ${searchLoc2 } 
				<br><br>
				</c:if>
                <c:if test="${empty searchLoc1 }">
                <i class="fas fa-map-marked-alt" style="color: #ff9914;"></i> 위치를 설정하지 않았습니다.
				<br><br>
				</c:if>
				<i class="fas fa-store" style="color: #4dbbff;" ></i> ${keyword }
				</span>
            </div>
            </c:if>
            
            <c:if test="${empty keyword}">
            <div class="nowLocation">
            	<c:if test="${!empty searchLoc1 }">
                <span> ${searchLoc1 } > ${searchLoc2 }</span><a href="#" id="Loc"><i class="fas fa-map-marker-alt loc" ></i></a>
                </c:if>
                <c:if test="${empty searchLoc1 }">
                <span> 위치를 설정해 주세요 </span><a href="#" id="Loc"><i class="fas fa-map-marker-alt loc" ></i></a>
                </c:if>
			</div>
            </c:if>
            

            <!-- 동물병원 위치 및 검색 키워드 표시 끝~~!! -->
            
             <!-- 동물병원 위치 설정 및 키워드 검색 결과 -->
             
             	<c:if test="${!empty keywordHosListNew }">
            
            <hr id="storeLine">
			
			<div id="keywordHosListNew">
			
			
			<div class="storeS">
            <c:forEach items="${keywordHosListNew}" var="item" varStatus="status" >
                <ul>
                    <div class="Store">                      
                       <li class="storeList">
                       
                            <div class="storeList_inner">
                                <div class="storeList_img_area"><a href="#"><img  onerror="this.src='${path}/resources/images/logoForChat.png'" src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
                                <div class="storeList_etc_area">
                                    <a href="#">리뷰<small> 
                                    <c:if test="${!empty keyword_new_revAvg[status.index]}">
                                            <i class="fas fa-star rate"></i>&nbsp;${keyword_new_revAvg[status.index] }
                                    </c:if>
                                    <c:if test="${empty keyword_new_revAvg[status.index]}">
                                            <i class="fas fa-star rate"></i>&nbsp;0.0
                                    </c:if>
                                    <c:if test="${!empty keyword_new_revCount[status.index] }">
                                       &nbsp;(${keyword_new_revCount[status.index]}+)
                                    </c:if>
                                    <c:if test="${empty keyword_new_revCount[status.index]}">
                                    &nbsp;(0)
                                    </c:if>
                                    </small>
                                    </a>
                                  <a href="#">찜하기 <small> ${keyword_new_count[status.index]}</small></a>
                                </div>
                                 <form class="frmShopInfo" >
                                 <div class="storeList_button">
                                    <a href="../../shopPage?bpId=${item.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
                                </div>
                               </form>
                            </div>                                                            
                        </li>
                    </div>
                </ul>
                </c:forEach>
                </div>
                           <!-- 페이징 시작-->
                           
				            <div class="page_wrap">
				               <div class="page_nation">
				                  <c:if test="${hos_keyword_paging.startPage != 1 }">
				                     <a class="arrow prev" href="${path}/shopList/search/keyword?shopType=${shopType}&nowPage=${hos_keyword_paging.startPage - 1 }&cntPerPage=${hos_keyword_paging.cntPerPage}&keyword=${hos_keyword }&selectlocCon=${searchLoc1}&selectChooseLoc=${searchLoc2}">이전</a> 
				                  </c:if>
				                  <c:forEach begin="${hos_keyword_paging.startPage }" end="${hos_keyword_paging.endPage }" var="p">
				                     <c:choose>
				                        <c:when test="${p == hos_keyword_paging.nowPage }">
				                           <b>${p }</b>
				                        </c:when>
				                        <c:when test="${p != hos_keyword_paging.nowPage }">
				                           <a href="${path}/shopList/search/keyword?shopType=${shopType}&nowPage=${p }&cntPerPage=${hos_keyword_paging.cntPerPage}&keyword=${hos_keyword }&selectlocCon=${searchLoc1}&selectChooseLoc=${searchLoc2}">${p}</a>
				                        </c:when>
				                     </c:choose>
				                  </c:forEach>
				                  <c:if test="${hos_keyword_paging.endPage != hos_keyword_paging.lastPage}">
				                     <a class="arrow next" href="${path}/shopList/search/keyword?shopType=${shopType}&nowPage=${hos_keyword_paging.endPage+1 }&cntPerPage=${hos_keyword_paging.cntPerPage}&keyword=${hos_keyword }&selectlocCon=${searchLoc1}&selectChooseLoc=${searchLoc2}">다음</a>
				                  </c:if>
				               </div>
				            </div>
          			  <!-- 페이징 끝! -->
               </div>
           
           
           
           
           
           
           
            </c:if>
             
             <!-- 동물병원 위치 설정 및 키워드 검색 결과 끝~ -->
           
           
           
           
           
           
           <!-- 동물병원 전체 리스트 페이지 -->
           
           
           <c:if test="${empty  keywordHosListNew && empty  hosListLocNew && empty  hosListLocLike && empty hosListLocRev && empty keyword}">
		<hr id="storeLine">
            <div class="selectOpt">
                <input type="radio" id="newRadio" name="selectOpt" value="new"  onclick="window.location.href='${path}/shopList/all/new?shopType=${shopType}&orderBy=new';"><label for="newRadio">최신순</label>
                <input type="radio" id="likeRadio"  name="selectOpt" value="like"   onclick="window.location.href='${path}/shopList/all/likes?shopType=${shopType}&orderBy=like';"><label for="likeRadio">인기순</label>
                 <input type="radio" id="revRadio" name="selectOpt"value="rev" onclick="window.location.href='${path}/shopList/all/review?shopType=${shopType}&orderBy=rev';"><label for="revRadio">별점순</label>
            </div>
        </c:if>
         
         <c:if test="${!empty hosListLocNew || !empty hosListLocLike || !empty hosListLocRev }"> 
			<hr id="storeLine">
            <div class="selectOpt">
                <input type="radio" id="newLocRadio" name="selectOpt" value="new" onclick="window.location.href='${path}/shopList/search/new?selectlocCon=${searchLoc1 }&selectChooseLoc=${searchLoc2 }&shopType=1&orderBy=new'"><label for="newLocRadio">최신순</label>
                <input type="radio" id="likeLocRadio"  name="selectOpt" value="like" onclick="window.location.href='${path}/shopList/search/like?selectlocCon=${searchLoc1 }&selectChooseLoc=${searchLoc2 }&shopType=1&orderBy=like'"><label for="likeLocRadio">인기순</label>
                 <input type="radio" id="revLocRadio" name="selectOpt" value="rev" onclick="window.location.href='${path}/shopList/search/rev?selectlocCon=${searchLoc1 }&selectChooseLoc=${searchLoc2 }&shopType=1&orderBy=rev'"><label for="revLocRadio">별점순</label>
            </div>
            </c:if>
            
            
            
        	
        	<c:if test="${!empty ctaHos}">
			 <div class="ultraS">
                   <c:forEach var="cta" items="${ctaHos}" varStatus="status">
                   <c:if test="${cta.cta_number > 0 }">
                <small id="ultra_ad">울트라콜 광고<i class="fas fa-ad"></i></small>
                <ul>
                    <div class="ultraStore">                     
                        <li class="ultraList">
                            <div class="ultraList_inner">
                                <div class="ultraList_img_area"><a href="#"><img  onerror="this.src='${path}/resources/images/logoForChat.png'" src="${path}/resources/uploadFile/shop/${cta.shopMImg }" width="150px" height="100"></a></div>
                                <div class="ultraList_title_area"><a href="#">${cta.shopName}</a></div>
                                <div class="ultraList_info_area"><a href="#">${cta.shopAddr}</a></div>
                                <div class="ultraList_etc_area">
                                    <a href="#">리뷰<small> 
                                    <c:if test="${!empty cta_revAvg[status.index]}">
                                            <i class="fas fa-star rate"></i>&nbsp;(${cta_revAvg[status.index]})
                                       </c:if>
                                    <c:if test="${empty cta_revAvg[status.index]}">
                                            <i class="fas fa-star rate"></i>&nbsp;(0.0)
                                       </c:if>
                                    <c:if test="${!empty cta_revCount[status.index] }">
                                       &nbsp;(${cta_revCount[status.index]}+)
                                    </c:if>
                                    <c:if test="${empty cta_revCount[status.index]}">
                                    &nbsp;(0)
                                    </c:if>
                                    </small>
                                    </a>
                                    <a href="#">찜하기 <small> ${cta_count[status.index]}</small></a>
                                </div>
                                <div class="ultraList_button">
                                    <a href="../../shopPage?bpId=${cta.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
                                </div>
                            </div>                                                            
                        </li>
                   </div>
                </ul>
                   </c:if>
            </c:forEach>
            </div>
           </c:if> 
            
            
            <c:if test="${empty keywordHosListNew && empty allHosListNew && empty allHosListLike && empty allHosListRev && empty hosListLocRev && empty hosListLocLike && empty hosListLocNew}">
            <br><br><br>
            <h1 style="text-align: center;">검색 결과가 없습니다.</h1>
            </c:if>
           
           
           
           	<!-- 동물병원 전체 리스트 페이지 최신순 정렬 -->
	           	
	           	<c:if test="${!empty allHosListNew }">
			
	           <div id="allHosListNew" class="newList">
	           
	                       
		           <div class="storeS">
		            <c:forEach items="${allHosListNew}" var="item" varStatus="status" >
		                <ul>
		                    <div class="Store">                      
		                       <li class="storeList">
		                       
		                            <div class="storeList_inner">
		                                <div class="storeList_img_area"><a href="#"><img  onerror="this.src='${path}/resources/images/logoForChat.png'" src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
		                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
		                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
		                                <div class="storeList_etc_area">
		                                    <a href="#">리뷰<small> 
		                                    <c:if test="${!empty new_revAvg[status.index] }">
		                                     <i class="fas fa-star rate"></i>&nbsp;${new_revAvg[status.index] }
		                                    </c:if>
		                                    <c:if test="${empty new_revAvg[status.index] }">
		                                     <i class="fas fa-star rate"></i>&nbsp;0.0
		                                    </c:if>
		                                    <c:if test="${!empty new_revCount[status.index] }">
		                                       &nbsp;(${new_revCount[status.index]}+)
		                                    </c:if>
		                                    <c:if test="${empty new_revCount[status.index]}">
		                                    &nbsp;(0)
		                                    </c:if>
		                                    </small>
		                                    </a>
		                                  <a href="#">찜하기 <small> ${new_count[status.index]}</small></a>
		                                </div>
		                                 <form class="frmShopInfo" >
		                                 <div class="storeList_button">
		                                    <a href="../../shopPage?bpId=${item.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
		                                </div>
		                               </form>
		                            </div>                                                            
		                        </li>
		                    </div>
		                </ul>
		                </c:forEach>
		                </div>
		                        <!-- 페이징 시작-->
					            <div class="page_wrap">
					               <div class="page_nation">
					                  <c:if test="${all_new_paging.startPage != 1 }">
					                     <a class="arrow prev" href="${path}/shopList/all/new?shopType=${shopType}&nowPage=${all_new_paging.startPage - 1 }&cntPerPage=${all_new_paging.cntPerPage}&orderBy=new">이전</a> 
					                  </c:if>
					                  <c:forEach begin="${all_new_paging.startPage }" end="${all_new_paging.endPage }" var="p">
					                     <c:choose>
					                        <c:when test="${p == all_new_paging.nowPage }">
					                           <b>${p }</b>
					                        </c:when>
					                        <c:when test="${p != all_new_paging.nowPage }">
					                           <a href="${path}/shopList/all/new?shopType=${shopType}&nowPage=${p }&cntPerPage=${all_new_paging.cntPerPage}&orderBy=new">${p}</a>
					                        </c:when>
					                     </c:choose>
					                  </c:forEach>
					                  <c:if test="${all_new_paging.endPage != all_new_paging.lastPage}">
					                     <a class="arrow next" href="${path}/shopList/all/new?shopType=${shopType}&nowPage=${all_new_paging.endPage+1 }&cntPerPage=${all_new_paging.cntPerPage}&orderBy=new">다음</a>
					                  </c:if>
					               </div>
					            </div>
	          			  <!-- 페이징 끝! -->
		           </div>
		</c:if>
           	
           	<!-- 동물병원 전체 리스트 페이지 최신순 정렬 끝-->
           	
           	
           	
           	
           	
           	
           	<!-- 동물병원 전체 리스트 페이지 인기순 정렬 -->
           	
           	  <c:if test="${!empty allHosListLike }">
            
            <div id="allHosListLike" class="likeList">
            			    
	            <div class="storeS" >
	              <c:forEach items="${allHosListLike}" var="item" varStatus="status" >
	                <ul>
	                    <div class="Store">                      
	                       <li class="storeList">
	                       
	                            <div class="storeList_inner">
	                                <div class="storeList_img_area"><a href="#"><img  onerror="this.src='${path}/resources/images/logoForChat.png'" src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
	                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
	                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
	                                <div class="storeList_etc_area">
	                                    <a href="#">리뷰<small> 
	                                   <c:if test="${!empty like_revAvg[status.index] }">
	                                     <i class="fas fa-star rate"></i>&nbsp;${like_revAvg[status.index] }
	                                    </c:if>
	                                    <c:if test="${empty like_revAvg[status.index] }">
	                                     <i class="fas fa-star rate"></i>&nbsp;0.0
	                                    </c:if>
	                                    <c:if test="${!empty like_revCount[status.index] }">
	                                       &nbsp;(${like_revCount[status.index]}+)
	                                    </c:if>
	                                    <c:if test="${empty like_revCount[status.index]}">
	                                    &nbsp;(0)
	                                    </c:if>
	                                    </small>
	                                    </a>
	                                  <a href="#">찜하기 <small> ${item.likes}</small></a>
	                                </div>
	                                 <form class="frmShopInfo" >
	                                 <div class="storeList_button">
	                                    <a href="../../shopPage?bpId=${item.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
	                                </div>
	                               </form>
	                            </div>                                                            
	                        </li>
	                		</ul>
	                </c:forEach>
	          			  </div>
	          			    <!-- 페이징 시작-->
				            <div class="page_wrap">
				               <div class="page_nation">
				                  <c:if test="${all_hos_likes_paging.startPage != 1 }">
				                     <a class="arrow prev" href="${path}/shopList/all/likes?shopType=${shopType}&nowPage=${all_hos_likes_paging.startPage - 1 }&cntPerPage=${all_likes_page.cntPerPage}&orderBy=like">이전</a> 
				                  </c:if>
				                  <c:forEach begin="${all_hos_likes_paging.startPage }" end="${all_hos_likes_paging.endPage }" var="p">
				                     <c:choose>
				                        <c:when test="${p == all_hos_likes_paging.nowPage }">
				                           <b>${p }</b>
				                        </c:when>
				                        <c:when test="${p != all_hos_likes_paging.nowPage }">
				                           <a href="${path}/shopList/all/likes?shopType=${shopType}&nowPage=${p }&cntPerPage=${all_hos_likes_paging.cntPerPage}&orderBy=like">${p}</a>
				                        </c:when>
				                     </c:choose>
				                  </c:forEach>
				                  <c:if test="${all_hos_likes_paging.endPage != all_hos_likes_paging.lastPage}">
				                     <a class="arrow next" href="${path}/shopList/all/likes?shopType=${shopType}&nowPage=${all_hos_likes_paging.endPage+1 }&cntPerPage=${all_hos_likes_paging.cntPerPage}&orderBy=like">다음</a>
				                  </c:if>
				               </div>
				            </div>
          			  <!-- 페이징 끝! -->
                    </div>
                    
                    </c:if>
           	
           	
           	<!-- 동물병원 전체 리스트 페이지 인기순 정렬 끝-->
           	
           	
           	
           	
           	
           	
           	<!-- 동물병원 전체 리스트 페이지 별점순 정렬 -->
           	
           	<c:if test="${!empty allHosListRev }">
            
            <div  id="revList" class="revList">
            	
             <div class="storeS" >
               <c:forEach items="${allHosListRev}" var="item" varStatus="status" >
                <ul>
                    <div class="Store">                      
                       <li class="storeList">
                       
                            <div class="storeList_inner">
                                <div class="storeList_img_area"><a href="#"><img  onerror="this.src='${path}/resources/images/logoForChat.png'" src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
                                <div class="storeList_etc_area">
                                    <a href="#">리뷰<small> 
                                    <c:if test="${!empty item.avgRevVal}">
                                            <i class="fas fa-star rate"></i>&nbsp;${item.avgRevVal}
                                       </c:if>
                                    <c:if test="${empty item.avgRevVal}">
                                            <i class="fas fa-star rate"></i>&nbsp;0.0
                                       </c:if>
                                    
                                    <c:if test="${!empty rev_revCount[status.index] }">
                                       &nbsp;(${rev_revCount[status.index]}+)
                                    </c:if>
                                    <c:if test="${empty rev_revCount[status.index]}">
                                    &nbsp;(0)
                                    </c:if>
                                    </small>
                                    </a>
                                  <a href="#">찜하기 <small> ${rev_count[status.index]}</small></a>
                                </div>
                                 <form class="frmShopInfo" >
                                 <div class="storeList_button">
                                    <a href="../../shopPage?bpId=${item.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
                                </div>
                               </form>
                            </div>                                                            
                        </li>
                    </div>
                </ul>
                </c:forEach>
          		</div>
                <!-- 페이징 시작-->
				            <div class="page_wrap">
				               <div class="page_nation">
				                  <c:if test="${all_rev_page.startPage != 1 }">
				                     <a class="arrow prev" href="${path}/shopList/all/review?shopType=${shopType}&nowPage=${all_rev_page.startPage - 1 }&cntPerPage=${all_rev_page.cntPerPage}&orderBy=rev">이전</a> 
				                  </c:if>
				                  <c:forEach begin="${all_rev_page.startPage }" end="${all_rev_page.endPage }" var="p">
				                     <c:choose>
				                        <c:when test="${p == all_rev_page.nowPage }">
				                           <b>${p }</b>
				                        </c:when>
				                        <c:when test="${p != all_rev_page.nowPage }">
				                           <a href="${path}/shopList/all/review?shopType=${shopType}&nowPage=${p }&cntPerPage=${all_rev_page.cntPerPage}&orderBy=rev">${p}</a>
				                        </c:when>
				                     </c:choose>
				                  </c:forEach>
				                  <c:if test="${all_rev_page.endPage != all_rev_page.lastPage}">
				                     <a class="arrow next" href="${path}/shopList/all/review?shopType=${shopType}&nowPage=${all_rev_page.endPage+1 }&cntPerPage=${all_rev_page.cntPerPage}&orderBy=rev">다음</a>
				                  </c:if>
				               </div>
				            </div>
          			  <!-- 페이징 끝! -->
          		</div>
          		
          		</c:if>
           	
           	<!-- 동물병원 전체 리스트 페이지 별점순 정렬 끝-->
           
           
           <!-- 동물병원 전체 리스트 페이지 끝~~ -->
           
           
           <!-- 동물병원 위치 검색 결과 -->
           
           	
	           <!-- 동물병원 위치 검색 결과 최신순 정렬 -->
	           
           <c:if test="${!empty hosListLocNew }">
			
			
			<div id="hosListLocNew" class="listLocNew">
			
			
			<div class="storeS">
            <c:forEach items="${hosListLocNew}" var="item" varStatus="status" >
                <ul>
                    <div class="Store">                      
                       <li class="storeList">
                       
                            <div class="storeList_inner">
                                <div class="storeList_img_area"><a href="#"><img  onerror="this.src='${path}/resources/images/logoForChat.png'" src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
                                <div class="storeList_etc_area">
                                    <a href="#">리뷰<small> 
                                    <c:if test="${!empty loc_new_revAvg[status.index]}">
                                            <i class="fas fa-star rate"></i>&nbsp;${loc_new_revAvg[status.index] }
                                    </c:if>
                                    <c:if test="${empty loc_new_revAvg[status.index]}">
                                            <i class="fas fa-star rate"></i>&nbsp;0.0
                                    </c:if>
                                    <c:if test="${!empty loc_new_revCount[status.index] }">
                                       &nbsp;(${loc_new_revCount[status.index]}+)
                                    </c:if>
                                    <c:if test="${empty loc_new_revCount[status.index]}">
                                    &nbsp;(0)
                                    </c:if>
                                    </small>
                                    </a>
                                  <a href="#">찜하기 <small> ${loc_new_count[status.index]}</small></a>
                                </div>
                                 <form class="frmShopInfo" >
                                 <div class="storeList_button">
                                    <a href="../../shopPage?bpId=${item.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
                                </div>
                               </form>
                            </div>                                                            
                        </li>
                    </div>
                </ul>
                </c:forEach>
                </div>
                           <!-- 페이징 시작-->
				            <div class="page_wrap">
				               <div class="page_nation">
				                  <c:if test="${loc_new_paging.startPage != 1 }">
				                     <a class="arrow prev" href="${path}/shopList/search/new?shopType=${shopType}&nowPage=${loc_new_paging.startPage - 1 }&cntPerPage=${loc_new_paging.cntPerPage}&orderBy=new">이전</a> 
				                  </c:if>
				                  <c:forEach begin="${loc_new_paging.startPage }" end="${loc_new_paging.endPage }" var="p">
				                     <c:choose>
				                        <c:when test="${p == loc_new_paging.nowPage }">
				                           <b>${p }</b>
				                        </c:when>
				                        <c:when test="${p != loc_new_paging.nowPage }">
				                           <a href="${path}/shopList/search/new?shopType=${shopType}&nowPage=${p }&cntPerPage=${loc_new_paging.cntPerPage}&orderBy=new">${p}</a>
				                        </c:when>
				                     </c:choose>
				                  </c:forEach>
				                  <c:if test="${loc_new_paging.endPage != loc_new_paging.lastPage}">
				                     <a class="arrow next" href="${path}/shopList/search/new?shopType=${shopType}&nowPage=${loc_new_paging.endPage+1 }&cntPerPage=${loc_new_paging.cntPerPage}&orderBy=new">다음</a>
				                  </c:if>
				               </div>
				            </div>
          			  <!-- 페이징 끝! -->
               </div>
               </c:if>
	           <!-- 동물병원 위치 검색 결과 최신순 정렬 끝~~ -->
	           	
	           <!-- 동물병원 위치 검색 결과 인기순 정렬 -->
	           
	           <c:if test="${!empty hosListLocLike }">
			<div id="harListLocLike" class="listLocLike">
			
				
				<div class="storeS">
	            <c:forEach items="${hosListLocLike}" var="item" varStatus="status" >
	                <ul>
	                    <div class="Store">                      
	                       <li class="storeList">
	                       
	                            <div class="storeList_inner">
	                                <div class="storeList_img_area"><a href="#"><img  onerror="this.src='${path}/resources/images/logoForChat.png'" src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
	                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
	                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
	                                <div class="storeList_etc_area">
	                                    <a href="#">리뷰<small> 
	                                    <c:if test="${!empty loc_like_revAvg[status.index]}">
	                                            <i class="fas fa-star rate"></i>&nbsp;${loc_like_revAvg[status.index] }
	                                       </c:if>
	                                    <c:if test="${empty loc_like_revAvg[status.index]}">
	                                            <i class="fas fa-star rate"></i>&nbsp;0.0
	                                       </c:if>
	                                    <c:if test="${!empty loc_like_revCount[status.index] }">
	                                       &nbsp;(${loc_like_revCount[status.index]}+)
	                                    </c:if>
	                                    <c:if test="${empty loc_like_revCount[status.index]}">
	                                    &nbsp;(0)
	                                    </c:if>
	                                    </small>
	                                    </a>
	                                  <a href="#">찜하기 <small> ${loc_like_count[status.index]}</small></a>
	                                </div>
	                                 <form class="frmShopInfo" >
	                                 <div class="storeList_button">
	                                    <a href="../../shopPage?bpId=${item.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
	                                </div>
	                               </form>
	                            </div>                                                            
	                        </li>
	                    </div>
	                </ul>
	                </c:forEach>
	                </div>
                           <!-- 페이징 시작-->
				            <div class="page_wrap">
				               <div class="page_nation">
				                  <c:if test="${loc_like_paging.startPage != 1 }">
				                     <a class="arrow prev" href="${path}/shopList/search/like?shopType=${shopType}&nowPage=${loc_like_paging.startPage - 1 }&cntPerPage=${loc_like_paging.cntPerPage}&orderBy=like">이전</a> 
				                  </c:if>
				                  <c:forEach begin="${loc_like_paging.startPage }" end="${loc_like_paging.endPage }" var="p">
				                     <c:choose>
				                        <c:when test="${p == loc_like_paging.nowPage }">
				                           <b>${p }</b>
				                        </c:when>
				                        <c:when test="${p != loc_like_paging.nowPage }">
				                           <a href="${path}/shopList/search/like?shopType=${shopType}&nowPage=${p }&cntPerPage=${loc_like_paging.cntPerPage}&orderBy=like">${p}</a>
				                        </c:when>
				                     </c:choose>
				                  </c:forEach>
				                  <c:if test="${loc_like_paging.endPage != loc_like_paging.lastPage}">
				                     <a class="arrow next" href="${path}/shopList/search/like?shopType=${shopType}&nowPage=${loc_like_paging.endPage+1 }&cntPerPage=${loc_like_paging.cntPerPage}&orderBy=like">다음</a>
				                  </c:if>
				               </div>
				            </div>
          			  <!-- 페이징 끝! -->
               </div>
               </c:if>
               
	           <!-- 동물병원 위치 검색 결과 인기순 정렬 끝~~ -->
	           
	           	
	           	
	           <!-- 동물병원 위치 검색 결과 별점순 정렬 -->
	           
	            <c:if test="${!empty hosListLocRev }">
               
			<div id="hosListLocRev" class="listLocRev">
			
			
			<div class="storeS">
            <c:forEach items="${hosListLocRev}" var="item" varStatus="status" >
                <ul>
                    <div class="Store">                      
                       <li class="storeList">
                       
                            <div class="storeList_inner">
                                <div class="storeList_img_area"><a href="#"><img  onerror="this.src='${path}/resources/images/logoForChat.png'" src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
                                <div class="storeList_etc_area">
                                    <a href="#">리뷰<small> 
                                    <c:if test="${!empty item.avgRevVal}">
                                            <i class="fas fa-star rate"></i>&nbsp;${item.avgRevVal }
                                    </c:if>
                                    <c:if test="${empty item.avgRevVal}">
                                            <i class="fas fa-star rate"></i>&nbsp; 0.0
                                    </c:if>
                                    <c:if test="${!empty loc_rev_revCount[status.index] }">
                                       &nbsp;(${loc_rev_revCount[status.index]}+)
                                    </c:if>
                                    <c:if test="${empty loc_rev_revCount[status.index]}">
                                    &nbsp;(0)
                                    </c:if>
                                    </small>
                                    </a>
                                  <a href="#">찜하기 <small> ${loc_rev_count[status.index]}</small></a>
                                </div>
                                 <form class="frmShopInfo" >
                                 <div class="storeList_button">
                                    <a href="../../shopPage?bpId=${item.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
                                </div>
                               </form>
                            </div>                                                            
                        </li>
                    </div>
                </ul>
                </c:forEach>
                </div>
                           <!-- 페이징 시작-->
				            <div class="page_wrap">
				               <div class="page_nation">
				                  <c:if test="${loc_rev_paging.startPage != 1 }">
				                     <a class="arrow prev" href="${path}/shopList/all?shopType=${shopType}&nowPage=${loc_rev_paging.startPage - 1 }&cntPerPage=${loc_like_paging.cntPerPage}&orderBy=rev">이전</a> 
				                  </c:if>
				                  <c:forEach begin="${loc_rev_paging.startPage }" end="${loc_rev_paging.endPage }" var="p">
				                     <c:choose>
				                        <c:when test="${p == loc_rev_paging.nowPage }">
				                           <b>${p }</b>
				                        </c:when>
				                        <c:when test="${p != loc_rev_paging.nowPage }">
				                           <a href="${path}/shopList/all?shopType=${shopType}&nowPage=${p }&cntPerPage=${loc_rev_paging.cntPerPage}&orderBy=rev">${p}</a>
				                        </c:when>
				                     </c:choose>
				                  </c:forEach>
				                  <c:if test="${loc_rev_paging.endPage != loc_rev_paging.lastPage}">
				                     <a class="arrow next" href="${path}/shopList/all?shopType=${shopType}&nowPage=${loc_like_paging.endPage+1 }&cntPerPage=${loc_like_paging.cntPerPage}&orderBy=rev">다음</a>
				                  </c:if>
				               </div>
				            </div>
          			  <!-- 페이징 끝! -->
               </div>               
               </c:if>
	           
	           <!-- 동물병원 위치 검색 결과 별점순 정렬 끝~~ -->
           
           
           
           <!-- 동물병원 위치 검색 결과 끝~~-->
            
   	 <!-- 동물병원 리스트 끝 ~ -->        
     </c:if>
            <!--TOPBTN-->
            <a id="MOVE_TOP_BTN" href="#"><i class="fas fa-arrow-up"></i></a>
            
            
            
            
            
            
            
            
            
                <!-- ************************
                
              														   미용실
                 
                 
                  **************************** -->
                  
                  
                  
                  
                  
                  
                
            <c:if test="${shopType eq 0}">
            
            <h1>미용실</h1>
            
            <!-- 미용실 키워드 검색 및 위치 설정 부분 -->
            
	            <c:if test="${!empty keyword}">
	            <div class="nowLocation">
	                <span>
	                <c:if test="${!empty searchLoc1 }">
	                <i class="fas fa-map-marked-alt" style="color: #ff9914;"></i> ${searchLoc1 } ${searchLoc2 } 
					<br><br>
					</c:if>
	                <c:if test="${empty searchLoc1 }">
	                <i class="fas fa-map-marked-alt" style="color: #ff9914;"></i> 위치를 설정하지 않았습니다.
					<br><br>
					</c:if>
					<i class="fas fa-store" style="color: #4dbbff;" ></i> ${keyword }
					</span>
	            </div>
	            </c:if>
	            
	              <c:if test="${empty keyword}">
	            <div class="nowLocation">
	            	<c:if test="${!empty searchLoc1 }">
	                <span> ${searchLoc1 } > ${searchLoc2 }</span><a href="#" id="Loc"><i class="fas fa-map-marker-alt loc" ></i></a>
	                </c:if>
	                <c:if test="${empty searchLoc1 }">
	                <span> 위치를 설정해 주세요 </span><a href="#" id="Loc"><i class="fas fa-map-marker-alt loc" ></i></a>
	                </c:if>
				</div>
	            </c:if>
            
            <!-- 미용실 키워드 검색 및 위치 설정 부분 끝~~ -->
            
            <!-- 미용실 위치 설정 및 키워드 검색 결과 -->
            
            <c:if test="${!empty keywordHarListNew }">
            
            <hr id="storeLine">
			
			<div id="keywordHarListNew">
			
			
			<div class="storeS">
            <c:forEach items="${keywordHarListNew}" var="item" varStatus="status" >
                <ul>
                    <div class="Store">                      
                       <li class="storeList">
                       
                            <div class="storeList_inner">
                                <div class="storeList_img_area"><a href="#"><img  onerror="this.src='${path}/resources/images/logoForChat.png'" src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
                                <div class="storeList_etc_area">
                                    <a href="#">리뷰<small> 
                                    <c:if test="${!empty keyword_new_revAvg[status.index]}">
                                            <i class="fas fa-star rate"></i>&nbsp;${keyword_new_revAvg[status.index] }
                                    </c:if>
                                    <c:if test="${empty keyword_new_revAvg[status.index]}">
                                            <i class="fas fa-star rate"></i>&nbsp;0.0
                                    </c:if>
                                    <c:if test="${!empty keyword_new_revCount[status.index] }">
                                       &nbsp;(${keyword_new_revCount[status.index]}+)
                                    </c:if>
                                    <c:if test="${empty keyword_new_revCount[status.index]}">
                                    &nbsp;(0)
                                    </c:if>
                                    </small>
                                    </a>
                                  <a href="#">찜하기 <small> ${keyword_new_count[status.index]}</small></a>
                                </div>
                                 <form class="frmShopInfo" >
                                 <div class="storeList_button">
                                    <a href="../../shopPage?bpId=${item.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
                                </div>
                               </form>
                            </div>                                                            
                        </li>
                    </div>
                </ul>
                </c:forEach>
                </div>
                           <!-- 페이징 시작-->
                           
				            <div class="page_wrap">
				               <div class="page_nation">
				                  <c:if test="${keyword_paging.startPage != 1 }">
				                     <a class="arrow prev" href="${path}/shopList/search/keyword?shopType=${shopType}&nowPage=${keyword_paging.startPage - 1 }&cntPerPage=${keyword_paging.cntPerPage}&keyword=${keyword }&selectlocCon=${searchLoc1}&selectChooseLoc=${searchLoc2}">이전</a> 
				                  </c:if>
				                  <c:forEach begin="${keyword_paging.startPage }" end="${keyword_paging.endPage }" var="p">
				                     <c:choose>
				                        <c:when test="${p == keyword_paging.nowPage }">
				                           <b>${p }</b>
				                        </c:when>
				                        <c:when test="${p != keyword_paging.nowPage }">
				                           <a href="${path}/shopList/search/keyword?shopType=${shopType}&nowPage=${p }&cntPerPage=${keyword_paging.cntPerPage}&keyword=${keyword }&selectlocCon=${searchLoc1}&selectChooseLoc=${searchLoc2}">${p}</a>
				                        </c:when>
				                     </c:choose>
				                  </c:forEach>
				                  <c:if test="${keyword_paging.endPage != keyword_paging.lastPage}">
				                     <a class="arrow next" href="${path}/shopList/search/keyword?shopType=${shopType}&nowPage=${keyword_paging.endPage+1 }&cntPerPage=${keyword_paging.cntPerPage}">다음</a>
				                  </c:if>
				               </div>
				            </div>
          			  <!-- 페이징 끝! -->
               </div>
           
           
           
           
           
           
           
            </c:if>
           
           

			

		
		
		<!--  ************** 미용실 전체 리스트 페이지 ************************** -->
		<c:if test="${empty  keywordHarListNew && empty  harListLocNew && empty  harListLocLike && empty harListLocRev && empty keyword}">
		<hr id="storeLine">
            <div class="selectOpt">
                <input type="radio" id="newRadio" name="selectOpt" value="new"  onclick="window.location.href='${path}/shopList/all/new?shopType=${shopType}&orderBy=new';"><label for="newRadio">최신순</label>
                <input type="radio" id="likeRadio"  name="selectOpt" value="like"   onclick="window.location.href='${path}/shopList/all/likes?shopType=${shopType}&orderBy=like';"><label for="likeRadio">인기순</label>
                 <input type="radio" id="revRadio" name="selectOpt"value="rev" onclick="window.location.href='${path}/shopList/all/review?shopType=${shopType}&orderBy=rev';"><label for="revRadio">별점순</label>
            </div>
        </c:if>
         
         <c:if test="${!empty harListLocNew || !empty harListLocLike || !empty harListLocRev }"> 
			<hr id="storeLine">
            <div class="selectOpt">
                <input type="radio" id="newLocRadio" name="selectOpt" value="new" onclick="window.location.href='${path}/shopList/search/new?selectlocCon=${searchLoc1 }&selectChooseLoc=${searchLoc2 }&shopType=${shopType}&orderBy=new'"><label for="newLocRadio">최신순</label>
                <input type="radio" id="likeLocRadio"  name="selectOpt" value="like" onclick="window.location.href='${path}/shopList/search/like?selectlocCon=${searchLoc1 }&selectChooseLoc=${searchLoc2 }&shopType=${shopType}&orderBy=like'"><label for="likeLocRadio">인기순</label>
                 <input type="radio" id="revLocRadio" name="selectOpt" value="rev" onclick="window.location.href='${path}/shopList/search/rev?selectlocCon=${searchLoc1 }&selectChooseLoc=${searchLoc2 }&shopType=${shopType}&orderBy=rev'"><label for="revLocRadio">별점순</label>
            </div>
            </c:if>
            
            
            
        	
        	<c:if test="${!empty ctaHar}">
			 <div class="ultraS">
             <c:forEach var="cta" items="${ctaHar}" varStatus="status">
             <c:if test="${cta.cta_number > 0 }">
                <small id="ultra_ad">울트라콜 광고<i class="fas fa-ad"></i></small>
                <ul>
                    <div class="ultraStore">                     
                        <li class="ultraList">
                            <div class="ultraList_inner">
                                <div class="ultraList_img_area"><a href="#"><img  onerror="this.src='${path}/resources/images/logoForChat.png'" src="${path}/resources/uploadFile/shop/${cta.shopMImg }" width="150px" height="100"></a></div>
                                <div class="ultraList_title_area"><a href="#">${cta.shopName}</a></div>
                                <div class="ultraList_info_area"><a href="#">${cta.shopAddr}</a></div>
                                <div class="ultraList_etc_area">
                                    <a href="#">리뷰<small> 
                                    <c:if test="${!empty cta_revAvg[status.index]}">
                                            <i class="fas fa-star rate"></i>&nbsp;(${cta_revAvg[status.index]})
                                       </c:if>
                                    <c:if test="${empty cta_revAvg[status.index]}">
                                            <i class="fas fa-star rate"></i>&nbsp;(0.0)
                                       </c:if>
                                    <c:if test="${!empty cta_revCount[status.index] }">
                                       &nbsp;(${cta_revCount[status.index]}+)
                                    </c:if>
                                    <c:if test="${empty cta_revCount[status.index]}">
                                    &nbsp;(0)
                                    </c:if>
                                    </small>
                                    </a>
                                    <a href="#">찜하기 <small> ${cta_count[status.index]}</small></a>
                                </div>
                                <div class="ultraList_button">
                                    <a href="../../shopPage?bpId=${cta.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
                                </div>
                            </div>                                                            
                        </li>
                   </div>
                </ul>
                   </c:if>
            </c:forEach>
            </div>
           </c:if> 
            
            
            <c:if test="${empty keywordHarListNew && empty allShopListNew && empty allShopListLike && empty allHarListRev && empty harListLocRev && empty harListLocLike && empty harListLocNew}">
            <br><br><br>
            <h1 style="text-align: center;">검색 결과가 없습니다.</h1>
            </c:if>
            
		<c:if test="${!empty allShopListNew }">
		
           <!-- 미용실 전체 리스트 최신순 정렬 -->
           <div id="newList" class="newList">
           
                       
	           <div class="storeS">
	            <c:forEach items="${allShopListNew}" var="item" varStatus="status" >
	                <ul>
	                    <div class="Store">                      
	                       <li class="storeList">
	                       
	                            <div class="storeList_inner">
	                                <div class="storeList_img_area"><a href="#"><img  onerror="this.src='${path}/resources/images/logoForChat.png'" src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
	                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
	                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
	                                <div class="storeList_etc_area">
	                                    <a href="#">리뷰<small> 
	                                    <c:if test="${!empty new_revAvg[status.index] }">
	                                     <i class="fas fa-star rate"></i>&nbsp;${new_revAvg[status.index] }
	                                    </c:if>
	                                    <c:if test="${empty new_revAvg[status.index] }">
	                                     <i class="fas fa-star rate"></i>&nbsp;0.0
	                                    </c:if>
	                                    <c:if test="${!empty new_revCount[status.index] }">
	                                       &nbsp;(${new_revCount[status.index]}+)
	                                    </c:if>
	                                    <c:if test="${empty new_revCount[status.index]}">
	                                    &nbsp;(0)
	                                    </c:if>
	                                    </small>
	                                    </a>
	                                  <a href="#">찜하기 <small> ${new_count[status.index]}</small></a>
	                                </div>
	                                 <form class="frmShopInfo" >
	                                 <div class="storeList_button">
	                                    <a href="../../shopPage?bpId=${item.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
	                                </div>
	                               </form>
	                            </div>                                                            
	                        </li>
	                    </div>
	                </ul>
	                </c:forEach>
	                </div>
	                        <!-- 페이징 시작-->
				            <div class="page_wrap">
				               <div class="page_nation">
				                  <c:if test="${all_new_paging.startPage != 1 }">
				                     <a class="arrow prev" href="${path}/shopList/all/new?shopType=${shopType}&nowPage=${all_new_paging.startPage - 1 }&cntPerPage=${all_new_paging.cntPerPage}&orderBy=new">이전</a> 
				                  </c:if>
				                  <c:forEach begin="${all_new_paging.startPage }" end="${all_new_paging.endPage }" var="p">
				                     <c:choose>
				                        <c:when test="${p == all_new_paging.nowPage }">
				                           <b>${p }</b>
				                        </c:when>
				                        <c:when test="${p != all_new_paging.nowPage }">
				                           <a href="${path}/shopList/all/new?shopType=${shopType}&nowPage=${p }&cntPerPage=${all_new_paging.cntPerPage}&orderBy=new">${p}</a>
				                        </c:when>
				                     </c:choose>
				                  </c:forEach>
				                  <c:if test="${all_new_paging.endPage != all_new_paging.lastPage}">
				                     <a class="arrow next" href="${path}/shopList/all/new?shopType=${shopType}&nowPage=${all_new_paging.endPage+1 }&cntPerPage=${all_new_paging.cntPerPage}&orderBy=new">다음</a>
				                  </c:if>
				               </div>
				            </div>
          			  <!-- 페이징 끝! -->
	           </div>
	</c:if>

            
            
            
            <!-- 미용실 전체 리스트 인기순 정렬 -->
            
            <c:if test="${!empty allShopListLike }">
            
            <div id="likeList" class="likeList">
            			    
	            <div class="storeS" >
	              <c:forEach items="${allShopListLike}" var="item" varStatus="status" >
	                <ul>
	                    <div class="Store">                      
	                       <li class="storeList">
	                       
	                            <div class="storeList_inner">
	                                <div class="storeList_img_area"><a href="#"><img  onerror="this.src='${path}/resources/images/logoForChat.png'" src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
	                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
	                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
	                                <div class="storeList_etc_area">
	                                    <a href="#">리뷰<small> 
	                                   <c:if test="${!empty like_revAvg[status.index] }">
	                                     <i class="fas fa-star rate"></i>&nbsp;${like_revAvg[status.index] }
	                                    </c:if>
	                                    <c:if test="${empty like_revAvg[status.index] }">
	                                     <i class="fas fa-star rate"></i>&nbsp;0.0
	                                    </c:if>
	                                    <c:if test="${!empty like_revCount[status.index] }">
	                                       &nbsp;(${like_revCount[status.index]}+)
	                                    </c:if>
	                                    <c:if test="${empty like_revCount[status.index]}">
	                                    &nbsp;(0)
	                                    </c:if>
	                                    </small>
	                                    </a>
	                                  <a href="#">찜하기 <small> ${item.likes}</small></a>
	                                </div>
	                                 <form class="frmShopInfo" >
	                                 <div class="storeList_button">
	                                    <a href="../../shopPage?bpId=${item.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
	                                </div>
	                               </form>
	                            </div>                                                            
	                        </li>
	                		</ul>
	                </c:forEach>
	          			  </div>
	          			                 <!-- 페이징 시작-->
				            <div class="page_wrap">
				               <div class="page_nation">
				                  <c:if test="${all_likes_page.startPage != 1 }">
				                     <a class="arrow prev" href="${path}/shopList/all/likes?shopType=${shopType}&nowPage=${all_likes_page.startPage - 1 }&cntPerPage=${all_likes_page.cntPerPage}&orderBy=like">이전</a> 
				                  </c:if>
				                  <c:forEach begin="${all_likes_page.startPage }" end="${all_likes_page.endPage }" var="p">
				                     <c:choose>
				                        <c:when test="${p == all_likes_page.nowPage }">
				                           <b>${p }</b>
				                        </c:when>
				                        <c:when test="${p != all_likes_page.nowPage }">
				                           <a href="${path}/shopList/all/likes?shopType=${shopType}&nowPage=${p }&cntPerPage=${all_likes_page.cntPerPage}&orderBy=like">${p}</a>
				                        </c:when>
				                     </c:choose>
				                  </c:forEach>
				                  <c:if test="${all_likes_page.endPage != all_likes_page.lastPage}">
				                     <a class="arrow next" href="${path}/shopList/all/likes?shopType=${shopType}&nowPage=${all_likes_page.endPage+1 }&cntPerPage=${all_likes_page.cntPerPage}&orderBy=like">다음</a>
				                  </c:if>
				               </div>
				            </div>
          			  <!-- 페이징 끝! -->
                    </div>
                    
                    </c:if>
                    
                    <!-- 미용실 인기순 정렬 끝 -->
                    
                    
                    
            
            <!-- 미용실 전체 리스트 별점순 정렬 -->
            
            <c:if test="${!empty allHarListRev }">
            
            <div  id="revList" class="revList">
            	
             <div class="storeS" >
               <c:forEach items="${allHarListRev}" var="item" varStatus="status" >
                <ul>
                    <div class="Store">                      
                       <li class="storeList">
                       
                            <div class="storeList_inner">
                                <div class="storeList_img_area"><a href="#"><img  onerror="this.src='${path}/resources/images/logoForChat.png'" src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
                                <div class="storeList_etc_area">
                                    <a href="#">리뷰<small> 
                                    <c:if test="${!empty item.avgRevVal}">
                                            <i class="fas fa-star rate"></i>&nbsp;${item.avgRevVal}
                                       </c:if>
                                    <c:if test="${empty item.avgRevVal}">
                                            <i class="fas fa-star rate"></i>&nbsp;0.0
                                       </c:if>
                                    
                                    <c:if test="${!empty rev_revCount[status.index] }">
                                       &nbsp;(${rev_revCount[status.index]}+)
                                    </c:if>
                                    <c:if test="${empty rev_revCount[status.index]}">
                                    &nbsp;(0)
                                    </c:if>
                                    </small>
                                    </a>
                                  <a href="#">찜하기 <small> ${rev_count[status.index]}</small></a>
                                </div>
                                 <form class="frmShopInfo" >
                                 <div class="storeList_button">
                                    <a href="../../shopPage?bpId=${item.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
                                </div>
                               </form>
                            </div>                                                            
                        </li>
                    </div>
                </ul>
                </c:forEach>
          		</div>
                <!-- 페이징 시작-->
				            <div class="page_wrap">
				               <div class="page_nation">
				                  <c:if test="${all_rev_page.startPage != 1 }">
				                     <a class="arrow prev" href="${path}/shopList/all/review?shopType=${shopType}&nowPage=${all_rev_page.startPage - 1 }&cntPerPage=${all_rev_page.cntPerPage}&orderBy=rev">이전</a> 
				                  </c:if>
				                  <c:forEach begin="${all_rev_page.startPage }" end="${all_rev_page.endPage }" var="p">
				                     <c:choose>
				                        <c:when test="${p == all_rev_page.nowPage }">
				                           <b>${p }</b>
				                        </c:when>
				                        <c:when test="${p != all_rev_page.nowPage }">
				                           <a href="${path}/shopList/all/review?shopType=${shopType}&nowPage=${p }&cntPerPage=${all_rev_page.cntPerPage}&orderBy=rev">${p}</a>
				                        </c:when>
				                     </c:choose>
				                  </c:forEach>
				                  <c:if test="${all_rev_page.endPage != all_rev_page.lastPage}">
				                     <a class="arrow next" href="${path}/shopList/all/review?shopType=${shopType}&nowPage=${all_rev_page.endPage+1 }&cntPerPage=${all_rev_page.cntPerPage}&orderBy=rev">다음</a>
				                  </c:if>
				               </div>
				            </div>
          			  <!-- 페이징 끝! -->
          		</div>
          		
          		</c:if>
          		<!-- 미용실 별점순 정렬 끝 -->
          		
          		           
           <!-- 미용실 위치 검색 결과  --> 
           
  
            
            <!-- 미용실 위치 검색 최신순 정렬 -->
			
			<c:if test="${!empty harListLocNew }">
			
			
			<div id="harListLocNew" class="listLocNew">
			
			
			<div class="storeS">
            <c:forEach items="${harListLocNew}" var="item" varStatus="status" >
                <ul>
                    <div class="Store">                      
                       <li class="storeList">
                       
                            <div class="storeList_inner">
                                <div class="storeList_img_area"><a href="#"><img  onerror="this.src='${path}/resources/images/logoForChat.png'" src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
                                <div class="storeList_etc_area">
                                    <a href="#">리뷰<small> 
                                    <c:if test="${!empty loc_new_revAvg[status.index]}">
                                            <i class="fas fa-star rate"></i>&nbsp;${loc_new_revAvg[status.index] }
                                    </c:if>
                                    <c:if test="${empty loc_new_revAvg[status.index]}">
                                            <i class="fas fa-star rate"></i>&nbsp;0.0
                                    </c:if>
                                    <c:if test="${!empty loc_new_revCount[status.index] }">
                                       &nbsp;(${loc_new_revCount[status.index]}+)
                                    </c:if>
                                    <c:if test="${empty loc_new_revCount[status.index]}">
                                    &nbsp;(0)
                                    </c:if>
                                    </small>
                                    </a>
                                  <a href="#">찜하기 <small> ${loc_new_count[status.index]}</small></a>
                                </div>
                                 <form class="frmShopInfo" >
                                 <div class="storeList_button">
                                    <a href="../../shopPage?bpId=${item.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
                                </div>
                               </form>
                            </div>                                                            
                        </li>
                    </div>
                </ul>
                </c:forEach>
                </div>
                           <!-- 페이징 시작-->
				            <div class="page_wrap">
				               <div class="page_nation">
				                  <c:if test="${loc_new_paging.startPage != 1 }">
				                     <a class="arrow prev" href="${path}/shopList/search/new?shopType=${shopType}&nowPage=${loc_new_paging.startPage - 1 }&cntPerPage=${loc_new_paging.cntPerPage}&orderBy=new">이전</a> 
				                  </c:if>
				                  <c:forEach begin="${loc_new_paging.startPage }" end="${loc_new_paging.endPage }" var="p">
				                     <c:choose>
				                        <c:when test="${p == loc_new_paging.nowPage }">
				                           <b>${p }</b>
				                        </c:when>
				                        <c:when test="${p != loc_new_paging.nowPage }">
				                           <a href="${path}/shopList/search/new?shopType=${shopType}&nowPage=${p }&cntPerPage=${loc_new_paging.cntPerPage}&orderBy=new">${p}</a>
				                        </c:when>
				                     </c:choose>
				                  </c:forEach>
				                  <c:if test="${loc_new_paging.endPage != loc_new_paging.lastPage}">
				                     <a class="arrow next" href="${path}/shopList/search/new?shopType=${shopType}&nowPage=${loc_new_paging.endPage+1 }&cntPerPage=${loc_new_paging.cntPerPage}&orderBy=new">다음</a>
				                  </c:if>
				               </div>
				            </div>
          			  <!-- 페이징 끝! -->
               </div>
               </c:if>
               
               <!-- 미용실 위치 검색 최신순 정렬 끝 -->
               
               
               
			
			
			
			<!-- 미용실 위치 검색 인기순 정렬 -->
			
			
			<c:if test="${!empty harListLocLike }">
			<div id="harListLocLike" class="listLocLike">
			
				
				<div class="storeS">
	            <c:forEach items="${harListLocLike}" var="item" varStatus="status" >
	                <ul>
	                    <div class="Store">                      
	                       <li class="storeList">
	                       
	                            <div class="storeList_inner">
	                                <div class="storeList_img_area"><a href="#"><img  onerror="this.src='${path}/resources/images/logoForChat.png'" src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
	                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
	                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
	                                <div class="storeList_etc_area">
	                                    <a href="#">리뷰<small> 
	                                    <c:if test="${!empty loc_like_revAvg[status.index]}">
	                                            <i class="fas fa-star rate"></i>&nbsp;${loc_like_revAvg[status.index] }
	                                       </c:if>
	                                    <c:if test="${empty loc_like_revAvg[status.index]}">
	                                            <i class="fas fa-star rate"></i>&nbsp;0.0
	                                       </c:if>
	                                    <c:if test="${!empty loc_like_revCount[status.index] }">
	                                       &nbsp;(${loc_like_revCount[status.index]}+)
	                                    </c:if>
	                                    <c:if test="${empty loc_like_revCount[status.index]}">
	                                    &nbsp;(0)
	                                    </c:if>
	                                    </small>
	                                    </a>
	                                  <a href="#">찜하기 <small> ${loc_like_count[status.index]}</small></a>
	                                </div>
	                                 <form class="frmShopInfo" >
	                                 <div class="storeList_button">
	                                    <a href="../../shopPage?bpId=${item.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
	                                </div>
	                               </form>
	                            </div>                                                            
	                        </li>
	                    </div>
	                </ul>
	                </c:forEach>
	                </div>
                           <!-- 페이징 시작-->
				            <div class="page_wrap">
				               <div class="page_nation">
				                  <c:if test="${loc_like_paging.startPage != 1 }">
				                     <a class="arrow prev" href="${path}/shopList/search/like?shopType=${shopType}&nowPage=${loc_like_paging.startPage - 1 }&cntPerPage=${loc_like_paging.cntPerPage}&orderBy=like">이전</a> 
				                  </c:if>
				                  <c:forEach begin="${loc_like_paging.startPage }" end="${loc_like_paging.endPage }" var="p">
				                     <c:choose>
				                        <c:when test="${p == loc_like_paging.nowPage }">
				                           <b>${p }</b>
				                        </c:when>
				                        <c:when test="${p != loc_like_paging.nowPage }">
				                           <a href="${path}/shopList/search/like?shopType=${shopType}&nowPage=${p }&cntPerPage=${loc_like_paging.cntPerPage}&orderBy=like">${p}</a>
				                        </c:when>
				                     </c:choose>
				                  </c:forEach>
				                  <c:if test="${loc_like_paging.endPage != loc_like_paging.lastPage}">
				                     <a class="arrow next" href="${path}/shopList/search/like?shopType=${shopType}&nowPage=${loc_like_paging.endPage+1 }&cntPerPage=${loc_like_paging.cntPerPage}&orderBy=like">다음</a>
				                  </c:if>
				               </div>
				            </div>
          			  <!-- 페이징 끝! -->
               </div>
               </c:if>
               
               
               
               <!-- 미용실 위치 결과 검색 별점순 정렬 -->
               
             <c:if test="${!empty harListLocRev }">
               
			<div id="harListLocRev" class="listLocRev">
			
			
			<div class="storeS">
            <c:forEach items="${harListLocRev}" var="item" varStatus="status" >
                <ul>
                    <div class="Store">                      
                       <li class="storeList">
                       
                            <div class="storeList_inner">
                                <div class="storeList_img_area"><a href="#"><img  onerror="this.src='${path}/resources/images/logoForChat.png'" src="${path}/resources/uploadFile/shop/${item.shopMImg }" width="150px" height="100"></a></div>
                                <div class="storeList_title_area"><a href="#">${item.shopName }</a></div>
                                <div class="storeList_info_area"><a href="#">${item.shopAddr }</a></div>
                                <div class="storeList_etc_area">
                                    <a href="#">리뷰<small> 
                                    <c:if test="${!empty item.avgRevVal}">
                                            <i class="fas fa-star rate"></i>&nbsp;${item.avgRevVal }
                                    </c:if>
                                    <c:if test="${empty item.avgRevVal}">
                                            <i class="fas fa-star rate"></i>&nbsp; 0.0
                                    </c:if>
                                    <c:if test="${!empty loc_rev_revCount[status.index] }">
                                       &nbsp;(${loc_rev_revCount[status.index]}+)
                                    </c:if>
                                    <c:if test="${empty loc_rev_revCount[status.index]}">
                                    &nbsp;(0)
                                    </c:if>
                                    </small>
                                    </a>
                                  <a href="#">찜하기 <small> ${loc_rev_count[status.index]}</small></a>
                                </div>
                                 <form class="frmShopInfo" >
                                 <div class="storeList_button">
                                    <a href="../../shopPage?bpId=${item.bpId }&shopType=${shopType}"  class="goList">정보보기</a>
                                </div>
                               </form>
                            </div>                                                            
                        </li>
                    </div>
                </ul>
                </c:forEach>
                </div>
                           <!-- 페이징 시작-->
				            <div class="page_wrap">
				               <div class="page_nation">
				                  <c:if test="${loc_rev_paging.startPage != 1 }">
				                     <a class="arrow prev" href="${path}/shopList/all?shopType=${shopType}&nowPage=${loc_rev_paging.startPage - 1 }&cntPerPage=${loc_like_paging.cntPerPage}&orderBy=rev">이전</a> 
				                  </c:if>
				                  <c:forEach begin="${loc_rev_paging.startPage }" end="${loc_rev_paging.endPage }" var="p">
				                     <c:choose>
				                        <c:when test="${p == loc_rev_paging.nowPage }">
				                           <b>${p }</b>
				                        </c:when>
				                        <c:when test="${p != loc_rev_paging.nowPage }">
				                           <a href="${path}/shopList/all?shopType=${shopType}&nowPage=${p }&cntPerPage=${loc_rev_paging.cntPerPage}&orderBy=rev">${p}</a>
				                        </c:when>
				                     </c:choose>
				                  </c:forEach>
				                  <c:if test="${loc_rev_paging.endPage != loc_rev_paging.lastPage}">
				                     <a class="arrow next" href="${path}/shopList/all?shopType=${shopType}&nowPage=${loc_like_paging.endPage+1 }&cntPerPage=${loc_like_paging.cntPerPage}&orderBy=rev">다음</a>
				                  </c:if>
				               </div>
				            </div>
          			  <!-- 페이징 끝! -->
               </div>               
               </c:if>
               <!-- 미용실 위치 검색 별점순 정렬 끝  -->
               
               
               
               
               
               
               
               
               </c:if>
               
               
			
			
			
          		
    
            
        </section>
   
      <jsp:include page="../../common/footer.jsp" />   
      
      
   </div>
   
        <!-- MODAL -->
       <form action="${path}/shopList/search/new">
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
	        
	        <c:if test="${shopType eq 1}">
	        <input type="hidden" name="shopType" value="1">
	        </c:if>
	        <c:if test="${shopType eq 0}">
	        <input type="hidden" name="shopType" value="0">
	        </c:if>
	        <input type="hidden" name="orderBy" value="new">
        
     	</form> 
   
   
   
    <!-- script -->
     <script type="text/javascript" src="${path}/resources/js/user/uShop/shopList.js"></script>
     <script type="text/javascript" src="${path}/resources/js/common/topBtn.js"></script>
     <script type="text/javascript" src="${path}/resources/js/common/map.js"></script>
</body>
</html>