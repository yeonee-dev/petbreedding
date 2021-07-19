<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<aside class="bAside">
    <div class="bMenu">
        <ul>
            <a href="${pageContext.request.contextPath}/bReservation"><li class="menu" id="res">
                <i class="far fa-calendar-alt"></i>
                <p>예약관리</p>
            </li></a>
            
            <c:if test="${bP.bp_reg == 0 }">
            <a href="${pageContext.request.contextPath}/bShop">
            <li class="menu hs" id="bShop">
            	<i class="fas fa-home"></i>
            	<p>사업장관리</p></li>
            </li>
            </a>
            </c:if>
            
			<c:if test="${bP.bp_reg == 1 }">
				<a href="${pageContext.request.contextPath}/bShop/update">
					<li class="menu hs" id="bShop">
						<i class="fas fa-home"></i>
						<p>사업장관리</p></li>
				</a>
			</c:if>

			<a href="${pageContext.request.contextPath}/bMenu"><li class="menu" id="menuOP">
	            <c:if test="${bP.bp_type==0}">
	                <i class="fas fa-bars"></i>
	                <p>스타일 관리</p>
	            </c:if>
	           	<c:if test="${bP.bp_type==1}">
	                <i class="fas fa-stethoscope"></i>
	                <p>진료 종류<br>관리</p>
	            </c:if>
	            </li>
            </a>
            <a href="${pageContext.request.contextPath}/bchatlist">
	            <li class="menu">
	                <i class="fas fa-comments"></i>
	                <p>채팅관리</p>
	            </li>
            </a>
            <a href="${pageContext.request.contextPath}/bCalculate"><li class="menu" id="bCal">
                <i class="fas fa-chart-bar"></i>
                <p>매출관리</p>
            </li></a>
            <a href="${pageContext.request.contextPath}/cta/cta"><li class="menu" id="cta">
                <i class="fas fa-phone-alt"></i>
                <p>울트라콜</p>
            </li></a>
            <a href="${pageContext.request.contextPath}/bNotice"><li class="menu hs" id="bMyPage">
                <i class="fas fa-user"></i>
                <p>마이페이지</p>
            </li></a>
        </ul>
        
    </div> 
    <div class="bSideMenu" id="bShopM">
        <div class="bBox">
            <ul>
                <p>사업장 관리</p>
                <c:if test="${bP.bp_reg == 0 }">
                	<a href="${pageContext.request.contextPath}/bShop"><li class="bs">사업장 등록</li></a>
                </c:if>
                <c:if test="${bP.bp_reg == 1 }">
                	<a href="${pageContext.request.contextPath}/bShop/update"><li class="bs">사업장 수정</li></a>
                </c:if>
                <li class="bs" onClick="location.href='/petbreedding/bReview'">리뷰 관리</li>
            </ul>
        </div>
    </div>  
    <div class="bSideMenu" id="bMyPageM">
        <div class="bBox">
            <ul>
                <div class="bmp"> 
                    <p>마이페이지</p>
                    <a href="${pageContext.request.contextPath}/bMyPageUpdate"><li class="bs">내정보 수정</li></a>
                </div>
                <div class="bmp"> 
                    <p>고객센터</p>
                    <a href="${pageContext.request.contextPath}/bNotice"><li class="bs">공지사항</li></a>
                    <a href="${pageContext.request.contextPath}/bFAQ"><li class="bs">자주묻는 질문</li></a>
                    <a href="${pageContext.request.contextPath}/bQna?user_num=${bP.bp_Id}"><li class="bs">내 문의 내역</li></a>
                    <a href="bQna/writeFrm?user_num=${bP.bp_Id}"><li class="bs">1:1 문의하기</li></a>
                </div>
                <div class="bmp"> 
                    <a id="cancleM"><li class="bs">제휴취소 신청</li></a>
                </div>
            </ul>
        </div>
    </div>              

<!-- 제휴 취소 모달 -->
<div id="cancel-modal" class="modal">
	<div class="cancel-content">
	<input type="hidden" value="${bP.bp_Id}" id="bp_Id" />
		<p class="boldtext">제휴를 취소 하시겠습니까?</p> 
		<p class="text">
		<br>
		고객님과 관련된 모든 정보가 삭제됩니다.
		<br>
		정산이 완료 되면 탈퇴 처리됩니다.<br><br></p>
		<div class="btn">
			<button class="basicBtn" id="yesCalncle">네</button>
			<button class="basicBtn" id="noCalncle">아니오</button>
		</div>
	</div>
</aside>

