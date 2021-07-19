<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet"	type="text/css">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet"	type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet"	type="text/css">
<link href="${path}/resources/css/bPartner/bAside.css"	rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bMyPage/bMyPageUpdate.css"	rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ffd90e8fd83a8d1b7acd8b168a81415f"></script>
<!-- services와 clusterer, drawing 라이브러리 불러오기 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services,clusterer,drawing"></script>

</head>
<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />
		<section class="section">
		<jsp:include page="../bAside.jsp" />
			<div class="bContent">
				<h1>내 정보 수정</h1>
				<form class="updateFrm">
					<input type="hidden" name="bp_Id" value="${bP.bp_Id}"> 
					<label>이메일</label> 
					<input type="text" class="inputBox" name="bp_email" value="${bP.bp_email }" readonly>
					
					<label>이름</label> 
					<input type="text" class="inputBox" name="bp_name" value="${bP.bp_name }" required>
					
					<label>비밀번호</label> 
					<input type="password" class="inputBox" id="pwd" name="bp_pwd" required>
					<div class="errorMsg" id="pw_check"></div>
					
					<label>비밀번호 재확인</label> 
					<input type="password" class="inputBox" id="pwdCheck" required> 
					<div class="errorMsg" id="pw_check2"></div>
					
					<label>휴대전화</label> 
					<input type="text" class="hpBox" id="hp" name="bp_tel" readonly  value="${bP.bp_tel }">
					<button type="button" class="basicBtn hpBtn" id="changeTel">휴대폰번호 변경</button>
					
					<label>은행명</label> 
					<select class="inputBox" id="checkBank" name="bp_bank" required>
						<option disabled >은행선택</option>
						<option>KB국민은행</option>
						<option>KEB 하나은행</option>
						<option>신한은행</option>
						<option>하나은행</option>
						<option>NH농협</option>
						<option>IBK기업은행</option>
						<option>KDB산업은행</option>
						<option>한국씨티은행</option>
						<option>SC제일은행</option>
						<option>BNK부산은행</option>
						<option>DGB대구은행</option>
						<option>BNK경남은행</option>
						<option>SH수협은행</option>
						<option>광주은행</option>
						<option>전북은행</option>
						<option>제주은행</option>
						<option>카카오뱅크</option>
					</select> 
					
					<label>계좌번호</label> 
					<input type="text" class="inputBox" id="account" name="bp_acnt" placeholder="'-'를 포함해서 입력해주세요." required>
					<div class="errorMsg" id="error"></div>
					
				</form>
				<input type="button" class="basicBtn submitBtn" id="modify" value="수정하기">
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
		
        <!--휴대폰 MODAL -->
         <div id="my_modal">
            <a class="modal_close_btn"><i class="fas fa-times" id="closeBtn"></i></a>
            <div class="locCon">
            	<table>
					<tr>
						<td>
							<input type="text" placeholder="'-'없이 입력해주세요." id="tel" required>
							<input type="button" class="basicBtn" id="sendMessage" value="인증번호 받기">
							<input type="button" class="basicBtn" id="cfMessage" value="인증번호 확인">
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" placeholder="인증번호를 입력해주세요" id="num" required>
							<div class="errorMsg" id="hp2_check"></div>
						</td>
						
					</tr>
					            	
            	</table>
            	<div class="btnBox">
	 				<input type="button" id="confirm" value="확인">
					<input type="button" class="refuse" value="취소">
				</div>
            </div>
        </div>
	</div>
	
	
	<!-- script -->
    <script type="text/javascript" src="${path}/resources/js/bPartner/bAside.js"></script>
    <script type="text/javascript" src="${path}/resources/js/bPartner/bMember/bMyPageUpdate.js"></script>
    <script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
</body>
</html>