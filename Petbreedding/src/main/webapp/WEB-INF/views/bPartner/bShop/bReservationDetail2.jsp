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
<link href="${path}/resources/css/bPartner/bShop/bReservationDetail.css" rel="stylesheet" type="text/css" >
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />
		<section class="section">
	        <jsp:include page="../bAside.jsp" />
			<input type="hidden" id="bpIdforOut" value="${bp_id }">
	        <input type="hidden" id="shopNameforOut" value="${list2.hospital.shopName}">
			<input type="hidden" id="cl_numforOut" value="${list2.cl_num}">
	        <input type="hidden" id="nickNameforOut" value="${list2.client.name}">
	        <div class="bContent">
                <h1>예약 완료</h1>
                <div class="resInfo infoBox">
                    <table>
                        <tr class="infoTitle">예약 정보</tr>
                        <tr class="info">
                            <td>일정</td>
                            <td>${list2.hos_date} 오후 ${list2.hos_time}</td>
                        </tr>
                        <tr class="info">
                            <td>상품</td>
                            <td> ${list2.hospital.shopName}(+)${list2.medical.medName}</td>
                        </tr>
                        <input type="hidden" id="hos_rnum" value="${list2.hos_rnum}" placeholder="${list2.hos_rnum}">
            
                    </table>
                </div>
                <div class="clientInfo infoBox">
                    <table>
                        <tr class="infoTitle">예약자 정보</tr>
                        <tr class="info">
                            <td>예약자명</td>
                            <td>${list2.client.name}</td>
                        </tr>
                        <tr class="info">
                            <td>연락처</td>
                            <td>${list2.client.tel}</td>
                        </tr>
                        <tr class="info">
                            <td>이메일</td>
                            <td>${list2.client.email}</td>
                        </tr>
                    </table>
                </div>
                <div class="dogInfo infoBox">
                    <table>
                        <tr class="infoTitle">반려견 정보</tr>
                        <tr>
                            <td>${list2.pet.pet_name}</td>
                            <td>${list2.pet.pet_birth}</td>
                            <td>${list2.pet.pet_kind}</td>
                            <td>${list2.pet.pet_weight}kg</td>
				<c:choose>
                <c:when test="${list2.pet.pet_neut == null}">
                            <td>중성화 x</td>
          		</c:when>
          		<c:when test="${list2.pet.pet_neut != null}">
                            <td>중성화 o</td>
          		</c:when>
          		</c:choose>
          		<c:choose>
          		 <c:when test="${list2.pet.pet_exper == null}">
                            <td>미용경험 없음 </td>
                </c:when>
                <c:when test="${list2.pet.pet_exper != null}">
                            <td>미용경험 ${list.pet.pet_exper} </td>
                </c:when>
                </c:choose>          
                            <td>${list2.pet.pet_vaccin}</td>
                            <td>입질 ${list2.pet.pet_bite}</td>
                            <td>${list2.pet.dislike}</td>
                <c:choose>
          		 <c:when test="${list2.pet.kneecap == null}">            
                            <td>슬개골 없음</td>
                 </c:when>
                 <c:when test="${list2.pet.kneecap != null}">
                 		<td>${list2.pet.kneecap != null}</td>
                 </c:when>
                 </c:choose>       
                       <c:choose>
          		 <c:when test="${list2.pet.kneecap == null}"> 
                            <td>특이사항 없음</td>
                      </c:when>
                      <c:when test="${list2.pet.kneecap != null}"> 
                            <td>${list2.pet.pet_others}</td>
                      </c:when>
                      </c:choose>
                        </tr>
                    </table>
                </div>
                <div class="btnBox">
                    <button class="chatBtn basicBtn">1:1 채팅하기</button>
                    <button class="cancleBtn basicBtn" id="cancleBtn">이용 취소하기</button>
                </div>
              
                
            </div> 	
	    </section>
		<jsp:include page="../../common/footer.jsp" />
		
        <!-- MODAL -->
        <div id="my_modal">
            <a class="modal_close_btn"><i class="fas fa-times" id="closeBtn"></i></a>
            <div id="locCon">
                <h1>정말 취소하시겠습니까?</h1>
                <button id="goTOCancle" class="goTOCancle" >네</button>
                <button id="nextTime">아니오</button>
            </div>
        </div>
	</div>
	
	<!-- script -->
    <script type="text/javascript" src="${path}/resources/js/bPartner/bAside.js"></script>
    <script type="text/javascript" src="${path}/resources/js/bPartner/bShop/bReservationDetail.js"></script>
</body>
</html>