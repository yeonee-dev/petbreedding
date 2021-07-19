<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/common/header.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/user/uMyPage/mypetRegister.css"
	rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/myPageAside.css" rel="stylesheet"
	type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
	<div class="wrapper">
		<jsp:include page="../../common/header.jsp" />

		<section class="section">
			<jsp:include page="../myPageAside.jsp" />
			<form action="${path}/addmypet" method="POST" id="petInfoFrm"
				class="petInfo_container" enctype="multipart/form-data">
				<input type="hidden" name="cl_num" value="${client.cl_num}">

				<table class="petInfo_container">
					<tr>
						<td colspan="2" class="imgTd">
							<div class="imgContainer">
								<div class="imgBox">
								</div>
								<input type="file" id="realInput" name="pet_img"
									class="image_inputType_file" value="파일선택" accept="image/*"
									onchange="setThumbnail(event);" multiple>
							</div> <i id="browseBtn" class="fas fa-plus"></i>
						</td>
					</tr>

					<tr>
						<td colspan="2"><input type="text" placeholder="이름을 입력해주세요"
							class="basicTextInput m_20 mt_21" name="pet_name" id="pet_name">
							<div class="check_font" id="pet_namechk"></div></td>
					</tr>

					<tr>
						<td colspan="2"><select name="pet_kind" id="selectPet"
							class="selectBox m_20">
								<option value="견종" name="">견종</option>
								<option value="골든두들">골든두들</option>
								<option value="골든리트리버">골든리트리버</option>
								<option value="그레이하운드">그레이하운드</option>
								<option value="꼬똥">꼬똥</option>
								<option value="닥스훈트">닥스훈트</option>
								<option value="도베르만">도베르만</option>
								<option value="말라뮤트">말라뮤트</option>
								<option value="말티즈">말티즈</option>
								<option value="믹스">믹스</option>
								<option value="배들링턴테리어">배들링턴테리어</option>
								<option value="불독">불독</option>
								<option value="보더콜리">보더콜리</option>
								<option value="보스턴테리어">보스턴테리어</option>
								<option value="브로조이">브로조이</option>
								<option value="비글">비글</option>
								<option value="비숑">비숑</option>
								<option value="빠삐용">빠삐용</option>
								<option value="사모예드">사모예드</option>
								<option value="슈나우저">슈나우저</option>
								<option value="스피츠">스피츠</option>
								<option value="시바견">시바견</option>
								<option value="시베리안허스키">시베리안허스키</option>
								<option value="시츄">시츄</option>
								<option value="실키테리어">실키테리어</option>
								<option value="쉽독">쉽독</option>
								<option value="요크셔">요크셔</option>
								<option value="웰시코기">웰시코기</option>
								<option value="진돗개">진돗개</option>
								<option value="차우차우">차우차우</option>
								<option value="치와와">치와와</option>
								<option value="코카스파니엘">코카스파니엘</option>
								<option value="패키니즈">패키니즈</option>
								<option value="퍼그">퍼그</option>
								<option value="폭스테리어">폭스테리어</option>
								<option value="포메라니언">포메라니언</option>
								<option value="푸들">푸들</option>
								<option value="폼피츠">폼피츠</option>
								<option value="화이트테리어">화이트테리어</option>
						</select>
							<div class="check_font" id="pet_kindchk"></div></td>
					</tr>

					<tr>
						<td colspan="2"><input type="text" id="pet_birth"
							name="pet_birth" placeholder="반려견 나이를 입력해주세요"
							class="basicTextInput perInfo_text m_20">
							<div class="check_font" id="pet_birthchk"></div></td>
					</tr>
					<tr>
						<td colspan="2"><input type="text" id="pet_weight"
							name="pet_weight" placeholder="반려견 몸무게를 입력해주세요"
							class="basicTextInput perInfo_text m_20">
								<div class="check_font" id="pet_weightchk"></div></td>
					</tr>

					<tr>
						<td colspan="2" class="radioBox" id="gen">
							<ul class="selectOpt">

								<input type="radio" id="male" name="pet_gen" value="male">
								<li class="genderList"><label for="male">남아</label><br>
								</li>
								<input type="radio" id="female" name="pet_gen" value="female">
								<li class="genderList"><label for="female">여아</label><br>
								</li>
								<input type="radio" id="neutrality" name="pet_neut" value="1">
								<li class="genderList list_neut m_20"><label
									for="neutrality">중성화</label></li>
								<div class="check_font" id="pet_genchk"></div>
							</ul>

						</td>
					</tr>

					<tr>
						<td><span>[선택] 미용 경험</span></td>
					</tr>

					<tr>
						<td colspan="2"><select name="selectBeautyEx"
							id="selectBeautyEx" class="selectBox m_20" name="pet_exper">
								<option value="선택">선택</option>
								<option value="없음">없음</option>
								<option value="1회">1회</option>
								<option value="2회">2회</option>
								<option value="3회 이상">3회 이상</option>
						</select></td>
					</tr>

					<tr>
						<td><span>[선택] 예방접종 유무</span></td>
					</tr>
					<tr>
						<td colspan="2"><select name="pet_vaccin"
							id="selectInjectionEx" class="selectBox m_20">
								<option value="선택">선택</option>
								<option value="2차 이하">2차 이하</option>
								<option value="3차 완료">3차 완료</option>
								<option value="4차 완료">4차 완료</option>
								<option value="5차 완료">5차 완료</option>
						</select></td>
					</tr>

					<tr>
						<td><span>[선택] 입질 여부</span></td>
					</tr>
					<tr>
						<td colspan="2"><select name="pet_bite" id="selectBite"
							class="selectBox m_20">
								<option value="선택">선택</option>
								<option value="안해요">안해요</option>
								<option value="해요">해요</option>
						</select></td>
					</tr>

					<tr>
						<td><span>[선택] 싫어하는 부위</span></td>
					</tr>
					<tr>
						<td colspan="2" class="radioBox">
							<ul class="selectOpt">
								<input type="radio" id="eye" name="dislike" value="eye">
								<li class="hateList"><label for="eye">눈</label><br></li>
								<input type="radio" id="nose" name="dislike" value="nose">
								<li class="hateList"><label for="nose">코</label><br></li>
								<input type="radio" id="mouth" name="dislike" value="mouth">
								<li class="hateList"><label for="mouth">입</label></li>
								<input type="radio" id="ear" name="dislike" value="ear">
								<li class="hateList"><label for="ear">귀</label><br></li>
								<input type="radio" id="neck" name="dislike" value="neck">
								<li class="hateList hateListL m_20"><label for="neck">목</label><br>
								</li>


								<input type="radio" id="body" name="dislike" value="body">
								<li class="hateList"><label for="body">몸통</label></li>
								<input type="radio" id="leg" name="dislike" value="leg">
								<li class="hateList"><label for="leg">다리</label><br></li>
								<input type="radio" id="tail" name="dislike" value="tail">
								<li class="hateList"><label for="tail">꼬리</label><br>
								</li>
								<input type="radio" id="it" name="dislike" value="it">
								<li class="hateList"><label for="it">생식기</label></li>
								<input type="radio" id="none" name="dislike" value="none">
								<li class="hateList hateListL m_20"><label for="none">없음</label>
								</li>

							</ul>
						</td>
					</tr>

					<tr>
						<td><span>[선택] 슬개골 탈구</span></td>
					</tr>
					<tr>
						<td colspan="2"><select name="kneecap" id="selectKneecap"
							class="selectBox m_20">
								<option value="선택">선택</option>
								<option value="없음">없음</option>
								<option value="1기">1기</option>
								<option value="2기">2기</option>
								<option value="3기">3기</option>
								<option value="4기">4기</option>
						</select></td>
					</tr>

					<tr>
						<td><span>[선택] 특이사항</span></td>
					</tr>
					<tr>
						<td colspan="2" class="radioBox">
							<ul class="selectOpt">
								<input type="radio" id="skin" name="others" value="skin">
								<li class="otherslist"><label for="skin">피부병</label><br></li>
								
								<input type="radio" id="heart" name="others" value="heart">
								<li class="otherslist"><label for="heart">심장질환</label><br></li>
								
								<input type="radio" id="marking" name="others" value="marking">
								<li class="otherslist"><label for="marking">마킹</label></li>
								
								<input type="radio" id="moutinung" name="others" value="moutinung">
								<li class="otherslist m_10"><label for="moutinung">마운팅</label></li>
								
								<input type="radio" id="none" name="others" value="none">
								<li class="otherslist otherslistL m_10"><label for="none">없음</label></li>
							</ul>
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type="text"
							class="basicTextInput perInfo_text m_20" name="pet_others">
							<p class="errorMsg">에이작스 메세지</p></td>
					</tr>


					<tr>
						<td colspan="2">
							<button id="petInfo_register" class="basicBtn" type="submit">등록하기</button>
						</td>
					</tr>
				</table>
			</form>
		</section>

		<jsp:include page="../../common/footer.jsp" />
	</div>
	<!-- script -->
	<script src="https://kit.fontawesome.com/6a57affb8e.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript"
		src="${path}/resources/js/user/uMyPage/mypetRegister.js"></script>
</body>
</html>