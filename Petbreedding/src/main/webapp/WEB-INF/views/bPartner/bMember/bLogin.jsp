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
<link href="${path}/resources/css/bPartner/bMember/bLogin.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />
        <section class="section">
            <div class="loginBox">
                <img class="IDlogo" src="${pageContext.request.contextPath}/resources/images/logo.png">
                <form class="blFrm">
                    <!-- <label>아이디</label> -->
                    <input type="text" id="bId" class="inputArea" placeholder="아이디" name="bp_email">
                    <!-- <label>비밀번호</label> -->
                    <input type="password" id="bPwd" class="inputArea"  placeholder="비밀번호" name="bp_pwd">
                    <div id="errorText"></div>
                    <input type="button" class="basicBtn" id="loginBtn" value="로그인">
		<span id="searchIdPw">아이디/비밀번호 찾기</span>
                </form>
            </div>
        </section>
		<jsp:include page="../../common/footer.jsp" />
		
		<!--MODAL-->
        <div id="modal" class="searchModal_Container">
            <div class="searchModal_box">
                <div class="searchModal_content">
                    <div class="tabmenu">
                        <ul>
							<li id="tab1" class="btnCon">
                                <input type="radio" name="tabmenu" checked id="tabmenu1" class="Tmenu">
                                <label for="tabmenu1" class="searchBtn">아이디 찾기</label>
                                 <div class="tabCon" >
                                 	<div id="searchId">
                                 		<form id="searchIdFrm">
                                 			<label class="search" id="nameS">이름 </label>
		                                     <input type="text" class="tabInput" placeholder="이름을 입력해주세요." name="bp_name"><br>
		                                     <label class="search">핸드폰 번호</label>
		                                     <input type="text" class="tabInput" placeholder="가입하신 번호를 '-'없이 입력해주세요." name="bp_tel">
		                                     <div class="error" id="noId"></div>
                                 		</form>
		                                <button class="searchB basicBtn" id="findIdBtn">찾기</button>
                                     </div>
                                     <div id="findId">
                                     	<p>고객님의 정보와 일치하는 아이디는 "<span id="foundEmail"></span>" 입니다.</p>
                                 	 </div>
                                 </div>
                             </li>
                            <li id="tab2" class="btnCon">
                                <input type="radio" name="tabmenu" id="tabmenu2"  class="Tmenu">
                                <label for="tabmenu2" class="searchBtn">비밀번호 찾기</label>
                                <div class="tabCon">
	                                <div id="searchPwd">
	                               		 <form id="searchPwdFrm">
		                                	<label class="search"  id="emailS">이메일</label>
		                                	<input type="text" class="tabInput" placeholder="가입하신 이메일을 입력해주세요." name="bp_email" id="sendEmail"><br>
		                                	<label class="search">핸드폰 번호</label>
		                                    <input type="text" class="tabInput" placeholder="가입하신 번호를 '-'없이 입력해주세요." name="bp_tel">
		                                    <div class="error" id="noPwd"></div>
	                                    </form>
	                                    <button class="searchB basicBtn" id="findPwdBtn">찾기</button>
	                                </div>                                    
                                    <div id="findPwd">
                                    	<form id="newPwdBox">
                                    		<input type="hidden" id="haveEmail" name="bp_email">
                                    		<label class="search" id="newPwd" >새 비밀번호</label>
		                                    <input type="password" class="tabInput" placeholder="새로운 비밀번호를 입력해주세요." name="bp_pwd" id="pwd">
		                                    <div class="error" id="pw_check"></div>
		                                    <label class="search">새 비밀번호 재확인</label>
		                                    <input type="password" class="tabInput" placeholder="비밀번호를 다시 입력해주세요." id="pwdCheck">
		                                    <div class="error" id="pw_check2"></div>
                                    	</form>
	                                    <button class="searchB basicBtn" id="changePwd">비밀번호 변경</button>
                                	</div> 
                                </div>
                                
                             </li>
                        </ul>
                    </div>
                </div>
                <i class="fas fa-times fa-lg" id="modalExit"></i>
            </div>
        </div>
		
		
		
		
	</div>	
	<!-- script -->
	<script type="text/javascript" src="${path}/resources/js/bPartner/bMember/bLogin.js"></script>
</body>
</html>