<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 사장님</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bMember/bJoin.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />
        <section class="section">
           <div class="joinBox">
                  <div class="joinBox2">
                      <h1>제휴 및 회원가입</h1>
                      <form class="joinFrm">
                          <label>이메일</label>
                          <input type="text" class="inputBox" id="email" name="bp_email" required> 
                          <div class="check_font" id="id_check"></div>
                          
                          <label>비밀번호</label>
                          <input type="password" class="inputBox" id="pwd" name="bp_pwd" required> 
                          <div class="check_font" id="pw_check"></div>
                          
                          <label>비밀번호 재확인</label>
                          <input type="password" class="inputBox" id="pwdCheck" required> 
                          <div class="check_font" id="pw_check2"></div>
                          
                          <label>이름</label>
                          <input type="text" class="inputBox" id="name" name="bp_name" required> 
                          
                          <label>휴대전화</label>
                          <input type="text" class="hpBox" id="hp"  placeholder="핸드폰 번호를 '-'없이 입력해주세요." name="bp_tel" required> 
                          <button type="button" class=" basicBtn" id="hpConfirm">인증번호 받기</button>
                          <button type="button" class=" basicBtn" id="hpConfirm2">인증번호 확인</button>
                          <input type="text" class="inputBox" id="hp2"  placeholder="인증번호를 입력하세요" required> 
                          <div class="check_font" id="hp2_check"></div>
                          
                          <label>사업자 번호</label>
                          <input type="text" class="inputBox" id="bNum"  placeholder="'-'를 포함해서 입력해주세요" name="bp_num" required>
                          <div class="check_font" id="bNum_check"></div>
                           
                          <label>서비스 구분</label>
                          <div class="serviceC">
                              <input type="radio" class="checkShop" name="checkShop" id="salon" value="0"  required> 
                              <label for="salon" class="radioL">미용실</label>
                              <input type="radio" class="checkShop" name="checkShop" id="hospital"  required> 
                              <label for="hospital" class="radioL" value="1">동물 병원</label>
                          </div>                       
                      </form>
                      <input type="button" class="basicBtn" id="submitBtn" value="가입하기">
                  </div> 
              </div>
        </section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	
	<!-- script -->
	<script type="text/javascript" src="${path}/resources/js/bPartner/bMember/bJoin.js"></script>
</body>
</html>