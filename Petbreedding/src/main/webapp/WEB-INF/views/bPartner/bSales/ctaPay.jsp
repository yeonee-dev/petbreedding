<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bSales/ctaPay.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bAside.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />

		<section class="section">
			<jsp:include page="../bAside.jsp" />

			<div class="bContent">
					<p class="title">울트라콜 결제</p>
				<form action="#" id="cpFrm">
					<div class="container">
						<div class="mb30">
							<span>구매자 정보</span>
						</div>
						<div class="mt15">
							<span class="info">구매자명  </span> <span id="name" >${bP.bp_name}</span>
							<input type="hidden" id="BP_ID" value="${bP.bp_Id}"/>
						</div>
						<div class="mt15">
							<span class="info">연락처 </span> <span id="tel">${bP.bp_tel}</span>
						</div>
						<div class="mt15">
							<span class="info">이메일  </span> <span id="email">${bP.bp_email}</span>
						</div>
					</div>

					<main>
						<div>
							<div class="container spaceBw">
								<span>결제 상품</span> <span id="CM_TYPE">${vo.CM_TYPE}</span>
								<input type="hidden" id="CM_CODE" value="${vo.CM_CODE}"/>
							</div>

							<div class="container spaceBw">
								<span>결제 금액</span>
								<div>
									<span class="totalPrice">총 결제 금액</span> <span id="price">${vo.PRICE}원</span>
								</div>
							</div>

							<div class="container">
								<p>이용 동의</p>
								<div>
									<input type="checkbox" id=agrs1 class="mb30"> <label
										for="agrs1">모두 동의</label>
								</div>

								<div>
									<input type="checkbox" id="agr2" class="agreeAll mb30" >
									<label for="agr2">상기 결제 내역을 확인, 결제 진행에 동의(필수)</label>
								</div>

								<div>
									<input type="checkbox" id="agr3" class="agreeAll">
									<label for="agr3">취소/변경/환불/수수료 및 기한을 확인 후 동의(필수)</label>
									<p class="detail">자세히 보기</p>
								</div>

								<div>
									<input type="checkbox" id="agr4"  class="agreeAll">
									<label for="agr4">개인 정보 수집에 동의</label>
									<p class="detail">자세히 보기</p>
								</div>

							</div>
						</div>
					</main>

					<button class="basicBtn payBtn" type="button" id="check_module">결제하기</button>
					<p>

				</form>


			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	
	<!-- script -->
	<script src="https://kit.fontawesome.com/6a57affb8e.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="${path}/resources/js/bPartner/bAside.js"></script>
    <script type="text/javascript" src="${path}/resources/js/bPartner/bSales/ctaPay2.js"></script>
    <script type="text/javascript" src="${path}/resources/js/bPartner/bSales/ctaPay.js"></script>
</body>
</html>