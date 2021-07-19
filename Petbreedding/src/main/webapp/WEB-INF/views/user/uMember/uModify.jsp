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
<link href="${path}/resources/css/user/uMember/uModify.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/user/myPageAside.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	    <div class="wrapper">
        <jsp:include page="../../common/header.jsp" />

        <section class="section">
        <jsp:include page="../myPageAside.jsp" />
			<div class="uContent">
            <h1 class="updTitle">회원 정보 수정</h1>
            <form action="" id="updFrm" class="updFrm">
            	<input type="hidden" value="${client.cl_num}" name="cl_num" id="cl_num" />
                <table>
					<tr>
						<td><span>이메일</span></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="text" class="frmBasic" value="${client.email }" name="email" readonly>
						</td>
					</tr>
                    <tr>
                        <td>
                            <span>이름</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="text" class="frmBasic" name="name" value="${client.name }" required>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <span>비밀번호</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="password" class="frmBasic" name="password" id="pwd"  required>
                            <div class="errorMsg" id="pw_check"></div>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <span>비밀번호 재확인</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="password" class="frmBasic" id="pwdCheck" required>
                            <div class="errorMsg" id="pw_check2"></div>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <span>닉네임</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="text" class="getPhone_bar" name="nickname" id="changeN" value="${client.nickname }" required readonly>
                            <button type="button" class="updPhobe_btn basicBtn" id="changeNic">닉네임<br> 변경</button>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <span>휴대전화</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" name="tel" class="getPhone_bar" id="change" value="${client.tel }" readonly  required >
                            <button type="button" class="updPhobe_btn basicBtn" id="changeTel">휴대폰 번호<br> 변경</button>
                            <div class="errorMsg" id="error"></div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="mBtnBox">
                            <button class="updBtn basicBtn" id="modify" type="button">수정하기</button>
                        </td>
                    </tr>
                </table>
            </form>
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
        
    	<!-- 닉네임 MODAL -->
         <div id="my_modal2">
            <a class="modal_close_btn"><i class="fas fa-times"></i></a>
            <div class="locCon" id="con2">
            	<table>
					<tr>
						<td>
							<input type="text" placeholder="변경하실 닉네임을 적어주세요" id="nickName" required>
						</td>
					</tr>
					<tr>
						<td>
							<div class="errorMsg" id="nickName_check"></div>
						</td>
						
					</tr>
					            	
            	</table>
            	<div class="btnBox">
	 				<input type="button" id="confirm2" value="확인">
					<input type="button" class="refuse" value="취소">
				</div>
            </div>
        </div>	
    </div>
    
    <!-- script -->
    <script type="text/javascript" src="${path}/resources/js/user/uMember/uModify.js"></script>
    <script type="text/javascript" src="${path}/resources/js/user/uMember/uDelete.js"></script>
    <script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
    
</body>
</html>