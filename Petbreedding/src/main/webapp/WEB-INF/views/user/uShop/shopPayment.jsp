<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petverything::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/user/uShop/shopPayment.css" rel="stylesheet" type="text/css" >
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
<div class="wrapper">    
		<jsp:include page="../../common/header.jsp" />
			<section class="section">
			<p><span><a href="/">홈</a>></span><span><a onclick="history.back();">예약하기</a>></span>결제하기</p>
            <div class="payContainer">
                <div class="reservation_info infoBox">
                   <table>
                   <c:forEach items="${myRev}" var="myRev">
                   		<input type="hidden" value="${myRev.cl_num }" id="cl_num"/>
                   		<input type="hidden" value="${myRev.har_num }" id="exp_Id"/>
                   		<input type="hidden" value="${myRev.har_rnum }" id="har_rnum"/>
                   		<input type="hidden" value="${myRev.hairSalon.shopName }" id="exp_from"/>
                       <tr>
                           <th>예약 정보</th>
                       </tr>
                       <tr>
                           <td class="infoName">일정</td>
                           <td colspan="2">${myRev.res_date }&nbsp;&nbsp;&nbsp;|&nbsp; ${myRev.res_time }</td>
                       </tr>
                       <tr>
                        <td class="infoName">상품</td>
                        <td>${myRev.style.style_name }                            
                           <c:if test="${!empty another }">
                           	(+)${another }
                           </c:if>      
                        </td>
                    </tr>
                    </c:forEach>
                   </table>
                </div>
                <div class="reserveUser_info infoBox">
                    <table>
                        <tr>
                            <th>예약자 정보</th>
                        </tr>
                        <tr>
                            <td class="infoName">예약자명</td>
                            <td colspan="2" id="name">${client.name }</td>
                        </tr>
                        <tr>
                            <td class="infoName">연락처</td>
                            <td id="tel">${client.tel }</td>                        
                        </tr>
                        <tr>
                            <td class="infoName">이메일</td>
                            <td id="email">${client.email }</td>                        
                        </tr>
                    </table>
                 </div>
                 <div class="usingPoint_info infoBox">
                    <table>
                        <tr>
                            <th class="pointInfo">포인트 사용</th>
                            <td>보유 포인트</td>
                            <c:if test="${empty point or point eq -1}">
                            	<td id="nowPoint">0P</td>
                            </c:if>
                            <c:if test="${!empty point and (point ne -1)}">
                            	<td id="nowPoint">${point }</td>
                            	<td><span>P</span></td>
                            </c:if>
                            <td><input type="text" id="pointArea" value="0"><input type="checkbox" id="pointAll"><label for="pointAll">모두 사용</label></td>
                        </tr>                        
                    </table>
                 </div>
                 <div class="totalpay_info infoBox">
                     <h4>결제 금액</h4>
                     <div >
                        <p>총 상품 금액 
                        	<span class="money">원</span>
	                        <span id="totalPrice" class="money">
	                        	<fmt:formatNumber type="number" maxFractionDigits="3" value="${totalPrice }" />
							</span>
						</p>
                        <p>포인트 사용<span class="money">P</span><span class="usePoint money" >0</span></p>
                        <p >총 결제 금액 <span class="money">원</span><span id="payMoney" class="money"></span></p>
                     </div>                              
                 </div>
                 <div class="agreeInfo infoBox">
                    <table>
                        <tr>
                            <th>이용 동의</th>                   
                        </tr>                
                        <tr>
                            <td>
                                <input type="checkbox" id="agreeInfo1"/><label for="agreeInfo1">모두 동의</label>                                                         
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="checkbox" id="agreeInfo2" class="agreeAll"/>상기 결제 내역을 확인, 결제 진행에 동의 (필수)                                                         
                            </td>
                        </tr> 
                        <tr>
                            <td>
                                <input type="checkbox" id="agreeInfo3"  class="agreeAll"/>개인 정보 수집에 동의(필수)                                                       
                                <br><a href="#" class="detailInfo">자세히 보기</a>
                            </td>
                        </tr> 
                        <tr>
                            <td>
                            <c:forEach items="${myRev}" var="myRev">
                                <input type="checkbox" id="agreeInfo4"  class="agreeAll"/>개인정보 제 3자 제공에 동의(필수)<br>   
                                <small class="detailInfo">예약서비스 및 커뮤니케이션을 위해 개인 정보를 제공 받는 대상 : ${myRev.har_name }</small>
                                <br><a href="#" class="detailInfo">자세히 보기</a>
                            </c:forEach>
                            </td>
                        </tr>          
                    </table>
                 </div>
                 <div class="btnBox" id="btnBox">
                    <input type="button" id="reservation_btn" value="결제하기">
                </div>
            </div>
            <!--TOPBTN-->
            <a id="MOVE_TOP_BTN" href="#"><i class="fas fa-arrow-up"></i></a>
		</section>
		<jsp:include page="../../common/footer.jsp" />
</div>
	
	 <!-- script -->
     <script type="text/javascript" src="${path}/resources/js/user/uShop/shopPayment.js"></script>
     <script type="text/javascript" src="${path}/resources/js/user/uShop/shopPay.js"></script>
     <script type="text/javascript" src="${path}/resources/js/common/topBtn.js"></script>
</body>
</html>