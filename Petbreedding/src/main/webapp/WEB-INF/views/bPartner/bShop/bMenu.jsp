<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Petbreedding::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bShop/bMenu.css" rel="stylesheet" type="text/css" >
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="${path}/resources/js/bPartner/bShop/bMenu.js"></script>
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />
		<section class="section">
			<jsp:include page="../bAside.jsp" />
			
			<c:if test="${bP.bp_type==0}">
			<div class="bContent">
			
				<div class="menucon">
					<button id="addItemBtn1" class="basicBtn addItemBtn">옵션추가</button>
				</div>
				<div class="menuhead">
					
					<h1>스타일 관리</h1>
					<table style="border: 1px;">
						<thead>
							<tr>
								<th width="180px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;타입&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
								<th width="300px">스타일명</th>
								<th width="100px">가격&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
								<th width="100px">소요시간</th>
							</tr>
						</thead>
						<tbody id="dynamicTbody">

						</tbody>
					</table>
				</div>

				<div class="insert">


					<!-- style_deep (0 : 메인메뉴  1: 서브메뉴) -->

					<c:if test="${empty menuList }">
						<form class="dynamicTable" action="${path}/bp/bMenu/write" method="POST">
							<label><input type="radio" name="style_deep" value="0">메인</label>
							<!-- 예약 페이지: 기타 추가요금 -->
							<label><input type="radio" name="style_deep" value="1">서브</label>
							<input type="text" placeholder="메뉴" id="menu" name="style_name">
							<input type="text" placeholder="가격" id="price" name="price">
							<input type="text" placeholder="소요시간" id="time" name="style_time">
							<button type="submit" class="basicBtn okbtn">완료</button>
						</form>
					</c:if>

					<!-- 등록된 스타일 불러오기 -->
					<c:if test="${!empty menuList }">
						<c:forEach var="list" items="${menuList }" varStatus="status">
							<form class="dynamicTable frm_${list.style_num  }">
								<c:if test="${list.style_deep eq 0}">
									<label><input type="radio" name="style_deep" value="0"
										checked="checked">메인</label>
									<label><input type="radio" name="style_deep" value="1">서브&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
								</c:if>
								<c:if test="${list.style_deep eq 1}">
									<label><input type="radio" name="style_deep" value="0">메인</label>
									<label><input type="radio" name="style_deep" value="1"
										checked="checked">서브&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
								</c:if>
								<input type="hidden" value="${list.style_num }" name="style_num">
								<input type="hidden" value="${list.harNum }" name="harNum">
								<input type="text" placeholder="메뉴" id="menu" name="style_name"
									value="${list.style_name }"> <input type="text"
									placeholder="가격" id="price" name="price" value="${list.price }">
								<input type="text" placeholder="소요시간" id="time"
									name="style_time" value="${list.style_time }">
								<button type="submit" class="basicBtn rebtn" id="rebtn1"
									formaction="${path}/bp/bMenu/rewrite">수정</button>
								<button id="cancleBtn" type="button"
									class="basicBtn delBtns rebtn">삭제</button>
								<div id="modalC" class="modalC">
									<div class="contentC">
										<p>정말 삭제하시겠습니까?</p>
										<button type="button" class="basicBtn" id="yes">네</button>
										<button class="basicBtn" id="no">아니오</button>
									</div>
								</div>
							</form>
						</c:forEach>
					</c:if>


				</div>


			</div>
			</c:if>
			
			<c:if test="${bP.bp_type == 1}">
			
			<div class="bContent">
			
				<div class="menucon">
					<button id="addItemBtn2" class="basicBtn addItemBtn">옵션추가</button>
				</div>
				
				<div class="medHead">
					<h1>진료 종류 관리</h1>
					<table style="border: 1px;">
						<thead>
							<tr>
								<th width="350px" align="center">진료명</th>
								<th width="200px" align="center">가격</th>
							</tr>
						</thead>
						<tbody id="dynamicTbody">
						</tbody>
					</table>
				</div>
				
				<div class="medInsert">
				
				<c:if test="${empty menuList }">
				 	<form class="dynamicTable" action="${path}/bp/bMenu/write" method="POST">
							<input type="text" placeholder="진료명" id="medName" name="medName">
							<input type="text" placeholder="가격" id="medPrice" name="medPrice">
							<button type="submit" class="basicBtn medOkBtn">완료</button>
						</form>
				</c:if>
				
				
				 
				<!-- 등록된 진료 종류 불러오기 -->
				<c:if test="${!empty menuList }">
					<c:forEach var="list" items="${menuList }" varStatus="status">
						<form class="dynamicTable frm_${list.medNum  }">
							<input type="hidden" value="${list.medNum}" name="medNum">
							<input type="text" placeholder="진료명" id="medName" name="medName" value="${list.medName }">
							<input type="text" placeholder="진료가격" id="medPrice" name="medPrice" value="${list.medPrice }">
							<button type="submit" class="basicBtn rebtn" formaction="${path}/bp/bMenu/rewrite">수정</button>
							<button id="cancleBtn" type="button" class="basicBtn delBtns rebtn">삭제</button>
							<div id="modalC" class="modalC">
								<div class="contentC">
									<p>정말 삭제하시겠습니까?</p>
									<button type="button" class="basicBtn" id="yes">네</button>
									<button class="basicBtn" id="no">아니오</button>
								</div>
							</div>
						</form>
					</c:forEach>
				</c:if>
				 
				</div>
				
				
			</div>
			
			</c:if>
			
			
			
			<jsp:include page="../../common/footer.jsp" />
		</section>
	</div>