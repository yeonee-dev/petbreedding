<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0 user-scalable=no">
<title>Petbreedding::펫브리띵 사장님</title>
<link type="text/css" rel="stylesheet" href="${path}/resources/css/common/reset.css">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/bPartner/bheader.css">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/common/footer.css">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/bPartner/bAside.css">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/bPartner/bShop/bShopInfo.css">
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ffd90e8fd83a8d1b7acd8b168a81415f&libraries=services"></script>

</head>
<body>
	<div class="wrapper">
		<jsp:include page="../bheader.jsp" />
		<section class="section">
		<jsp:include page="../bAside.jsp" />
			<div class="bContent">
			
				<!-- 
						******* TODO: 사업장 수정 페이지 작업중~~~ ******   
				-->
			<!-- 입력된 사업장 정보가 없으면 사업장 등록 -->
			
				<c:if test="${empty vo}">
				<h2>사업장 등록</h2>
			<form action="${path}/bp/bShop/write" method="POST" id="bShopInfoFrm" enctype="multipart/form-data">
				<br>
				<table class="tblInfo">
					<tr>
						<th>서비스 구분</th>
						<c:if test="${bP.bp_type == 0 }">
						<th><input  onClick="return false;" type="radio" name="shop" id="bshop" value="0" checked="checked"><label for ="bshop">&nbsp;&nbsp;미용실</label></th>
						<th><input  onClick="return false;" type="radio" name="shop" id="hshop" value="1"><label for ="hshop">&nbsp;&nbsp;동물병원</label></th>
						</c:if>
						<c:if test="${bP.bp_type == 1 }">
						<th><input onClick="return false;" type="radio" name="shop" id="bshop" value="0"><label for ="bshop">&nbsp;&nbsp;미용실</label></th>
						<th><input onClick="return false;" type="radio" name="shop" id="hshop" value="1" checked="checked"><label for ="hshop">&nbsp;&nbsp;동물병원</label></th>
						</c:if>
					</tr>
					<tr>
						<th>매장명</th>
						<td colspan="2"><input id="shopName" type="text" placeholder="사업자 등록증에 명시된 매장명을 입력해주세요." name="shopName" ></td>
					</tr>
					<tr>
						<th>매장 주소</th>
						<td colspan="2">
							<input type="text" id="shopAddr" placeholder="주소" name="shopAddr" style="width: 150px">
							<input type="button" class="basicBtn" onclick="execDaumPostcode1()" value="주소 검색"><br>
							<div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>	
					</tr>
					<tr>
						<th>매장 전화번호</th>
						<td colspan="2"><input id="shopTel" type="text" placeholder="'-'를 포함해서 입력해주세요" name="shopTel"></td>
					</tr>
					<tr>
						<th>영업시간</th>
						<td colspan="2"><input id="shopTime" type="text" name="shopTime"></td>
					</tr>
					<tr>
						<th>간단소개</th>
						<td colspan="2"><input id="shopMInfo" type="text" name="shopMInfo"></td>
					</tr>
					<tr>
						<th>대표 사진 (1)</th>
						<th colspan="2">
							  <div class="imgContainer">
                                <div class="imgBox">
                                    <img src="">
                                </div>
                                <input type="file" id="inputShopImg" name="shopMainImg" multiple="multiple" accept=".jpg, .jpeg, .png" value="파일선택">
                            </div>
						</th>
					</tr>
					<tr>
						<th>매장 사진 (1)</th>
						<th colspan="2">
							  <div class="imgContainer">
                                <div class="imgBox">
                                    <img src="">
                                </div>
                                <input type="file" id="inputShopImg" name="shopImg" multiple="multiple" accept=".jpg, .jpeg, .png" value="파일선택">
                            </div>
						</th>
					</tr>
					<tr>
						<th>주휴일</th>
						<th colspan="2">
						<div class="wrap"><input type="checkbox" id="mon" name="shopDayOff" value="1"><label for="mon"><div class="dayitem">월</div></label></div>
						<div class="wrap"><input type="checkbox" id="tue" name="shopDayOff" value="2"><label for="tue"><div class="dayitem">화</div></label></div>
						<div class="wrap"><input type="checkbox" id="wed" name="shopDayOff" value="3"><label for="wed"><div class="dayitem">수</div></label></div>
						<div class="wrap"><input type="checkbox" id="thu" name="shopDayOff" value="4"><label for="thu"><div class="dayitem">목</div></label></div>
						<div class="wrap"><input type="checkbox" id="fri" name="shopDayOff" value="5"><label for="fri"><div class="dayitem">금</div></label></div>
						<div class="wrap"><input type="checkbox" id="sat" name="shopDayOff" value="6"><label for="sat"><div class="dayitem">토</div></label></div>
						<div class="wrap"><input type="checkbox" id="sun" name="shopDayOff" value="7"><label for="sun"><div class="dayitem">일</div></label></div>						
						</th>
					</tr>					
				</table>
				<br><br>
				<button class="basicBtn InfoRegi">등록하기</button>
			</form>
			</c:if>
			
			<c:if test="${!empty vo}">
						<h2>사업장 수정</h2>
			<form action="${path}/bp/bShop/update" method="POST" id="bShopInfoFrm" enctype="multipart/form-data">
					<c:if test="${bP.bp_type == 0 }">
					<input type="hidden" name="harNum" value="${vo.harNum}"/>
					</c:if>
					<c:if test="${bP.bp_type == 1 }">
					<input type="hidden" name="hosNum" value="${vo.hosNum}"/>
					</c:if>
					<input type="hidden" name="bpId" value="${vo.bpId}"/>
				<br>
				<table class="tblInfo">
					<tr>
						<th>서비스 구분</th>
						<c:if test="${bP.bp_type == 0 }">
						<th><input  onClick="return false;" type="radio" name="shop" id="bshop" value="0" checked="checked"><label for ="bshop">&nbsp;&nbsp;미용실</label></th>
						<th><input  onClick="return false;" type="radio" name="shop" id="hshop" value="1"><label for ="hshop">&nbsp;&nbsp;동물병원</label></th>
						</c:if>
						<c:if test="${bP.bp_type == 1 }">
						<th><input onClick="return false;" type="radio" name="shop" id="bshop" value="0"><label for ="bshop">&nbsp;&nbsp;미용실</label></th>
						<th><input onClick="return false;" type="radio" name="shop" id="hshop" value="1" checked="checked"><label for ="hshop">&nbsp;&nbsp;동물병원</label></th>
						</c:if>
					</tr>
					<tr>
						<th>매장명</th>
						<td colspan="2"><input id="shopName" type="text" placeholder="사업자 등록증에 명시된 매장명을 입력해주세요." name="shopName" value="${vo.shopName }"></td>
					</tr>
					<tr>
						<th>매장 주소</th>
						<td colspan="2">
							<input type="text" id="shopAddr" placeholder="주소" name="shopAddr" style="width: 150px" value="${vo.shopAddr }">
							<input type="button" class="basicBtn" onclick="execDaumPostcode2()" value="주소 검색"><br>
							<div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>	
					</tr>
					<tr>
						<th>매장 전화번호</th>
						<td colspan="2"><input id="shopTel" type="text" placeholder="'-'를 포함해서 입력해주세요" name="shopTel" value="${vo.shopTel }"></td>
					</tr>
					<tr>
						<th>영업시간</th>
						<td colspan="2"><input id="shopTime" type="text" name="shopTime" value="${vo.shopTime }"></td>
					</tr>
					<tr>
						<th>간단소개</th>
						<td colspan="2"><input id="shopMInfo" type="text" name="shopMInfo" value="${vo.shopMInfo }"></td>
					</tr>
					<tr>
						<th>대표 사진 (1)</th>
						<th colspan="2">
							  <div class="imgContainer">
                                <div class="imgBox">
                                    <img src="">
                                </div>
                                <input type="file" id="inputShopImg" name="shopMainImg" multiple="multiple" accept=".jpg, .jpeg, .png" value="파일선택">
                            </div>
						</th>
					</tr>
					<tr>
						<th>매장 사진 (3)</th>
						<th colspan="2">
							  <div class="imgContainer">
                                <div class="imgBox">
                                    <img src="">
                                </div>
                                <input type="file" id="inputShopImg" name="shopImg" multiple="multiple" accept=".jpg, .jpeg, .png" value="파일선택">
                            </div>
						</th>
					</tr>
						<th>주휴일</th>
						<th colspan="2">
							<c:if test="${!empty vo.mon }">
								<div class="wrap"><input type="checkbox" id="mon" checked name="shopDayOff" value="1"><label for="mon"><div class="dayitem">월</div></label></div>
							</c:if>
							<c:if test="${empty vo.mon }">
								<div class="wrap"><input type="checkbox" id="mon" name="shopDayOff" value="1"><label for="mon"><div class="dayitem">월</div></label></div>
							</c:if>
							<c:if test="${!empty vo.tue }">
								<div class="wrap"><input type="checkbox" id="tue" checked name="shopDayOff" value="2"><label for="tue"><div class="dayitem">화</div></label></div>
							</c:if>
							<c:if test="${empty vo.tue }">
								<div class="wrap"><input type="checkbox" id="tue" name="shopDayOff" value="2"><label for="tue"><div class="dayitem">화</div></label></div>
							</c:if>
							<c:if test="${!empty vo.wed }">
								<div class="wrap"><input type="checkbox" id="wed" checked name="shopDayOff" value="3"><label for="wed"><div class="dayitem">수</div></label></div>
							</c:if>
							<c:if test="${empty vo.wed }">
								<div class="wrap"><input type="checkbox" id="wed" name="shopDayOff" value="3"><label for="wed"><div class="dayitem">수</div></label></div>
							</c:if>
							<c:if test="${!empty vo.thu }">
								<div class="wrap"><input type="checkbox" id="thu" checked name="shopDayOff" value="4"><label for="thu"><div class="dayitem">목</div></label></div>
							</c:if>
							<c:if test="${empty vo.thu }">
								<div class="wrap"><input type="checkbox" id="thu" name="shopDayOff" value="4"><label for="thu"><div class="dayitem">목</div></label></div>
							</c:if>
							<c:if test="${!empty vo.fri }">
								<div class="wrap"><input type="checkbox" id="fri" checked name="shopDayOff" value="5"><label for="fri"><div class="dayitem">금</div></label></div>
							</c:if>
							<c:if test="${empty vo.fri }">
								<div class="wrap"><input type="checkbox" id="fri" name="shopDayOff" value="5"><label for="fri"><div class="dayitem">금</div></label></div>
							</c:if>
							<c:if test="${!empty vo.sat }">
								<div class="wrap"><input type="checkbox" id="sat" checked name="shopDayOff" value="6"><label for="sat"><div class="dayitem">토</div></label></div>
							</c:if>
							<c:if test="${empty vo.sat }">
								<div class="wrap"><input type="checkbox" id="sat" name="shopDayOff" value="6"><label for="sat"><div class="dayitem">토</div></label></div>
							</c:if>
							<c:if test="${!empty vo.sun }">
								<div class="wrap"><input type="checkbox" id="sun" checked name="shopDayOff" value="0"><label for="sun"><div class="dayitem">일</div></label></div>
							</c:if>
							<c:if test="${empty vo.sun }">
								<div class="wrap"><input type="checkbox" id="sun" name="shopDayOff" value="0"><label for="sun"><div class="dayitem">일</div></label></div>
							</c:if>

						</th>
					</tr>					
				</table>
				<br><br>
				<button class="basicBtn InfoRegi">등록하기</button>
			</form>
			</c:if>
			
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>
	
		<!-- 스크립트 -->
		<script type="text/javascript" src="${path}/resources/js/bPartner/bAside.js"></script>
		<script type="text/javascript" src="${path}/resources/js/bPartner/bPostcode.js"></script>
		<script type="text/javascript" src="${path}/resources/js/bPartner/bBoard/bShopInfo.js"></script>
		
</body>
</html>