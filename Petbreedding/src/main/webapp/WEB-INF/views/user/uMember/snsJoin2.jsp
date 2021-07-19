<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petverything::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/common/header.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/user/uMember/uJoin.css"
	rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />

		<section class="section">
			<form action="" id="joinFrm" class="joinFrm">
				<h1>회원가입</h1>
				<table>
					<tr>
						<td><span>이메일</span></td>
					</tr>
					<tr>
						<td colspan="2"><input type="text" class="basicTextInput"
							id="email" name="email" readonly value="${email}">
							<div class="check_font" id="id_check"></div>
						</td>
					</tr>

					<tr>
						<td><span>이름</span></td>
					</tr>
					<tr>
						<td colspan="2"><input type="text" class="basicTextInput"
							id="name" name="name" required>
						</td>
					</tr>

					<tr>
						<td><span>닉네임</span></td>
					</tr>
					<tr>
						<td colspan="2"><input type="text" class="basicTextInput"
							id="nickName" name="nickname" value="${nickname }">
							<div class="check_font" id="nickName_check"></div>
						</td>
					</tr>

					<tr>
						<td><span>휴대전화</span></td>
					</tr>
					<tr>
						<td><input type="text" placeholder="핸드폰 번호를 '-'없이 입력해주세요."
							id="hp" class="getChkMsg_bar basicTextInput" required name="tel" >
						</td>
						<td>
							<button type="button" id="hpConfirm" class="basicBtn">인증번호 받기</button>
							<button type="button" class="basicBtn" id="hpConfirm2">인증번호 확인</button>
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type="text" placeholder="인증번호를 입력하세요"
							id="hp2" id="chkNumBar" class="basicTextInput" required>
							<div class="check_font" id="hp2_check"></div>
						</td>
					</tr>
					<input type="hidden" name="password" value="qwer1234!" />
					<input type="hidden" name="naverlogin" value="N" />
					<input type="hidden" name="kakaologin" value="Y" />
					<tr>
						<td colspan="2"><input id="joinBtn" class="basicBtn"
							type="button" value="가입하기">
						</td>
					</tr>
				</table>
			</form>
		</section>

		<jsp:include page="../../common/footer.jsp" />
	</div>

	<!-- script -->
	<script type="text/javascript" src="${path}/resources/js/user/uMember/kakaoJoin.js"></script>
</body>
</html>