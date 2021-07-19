<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside class="myPageAside">
	<div class="divborder">
		<br>
		<div class="divBold">마이페이지</div>
		<div class="divBolder">MYPAGE</div>
		<br>
	</div>
	<div class="divborder">
		<ul>
			<label>예약 내역</label>
			<br>
			<br>
			<c:if test = "${empty client }">
				<a href="${pageContext.request.contextPath}/uLogin"><li>- 예약확인/조회</li></a>
			</c:if>
			<c:if test = "${!empty client }">
				<a href="${pageContext.request.contextPath}/mypage?cl_num=${client.cl_num}"><li>- 예약확인/조회</li></a>
			</c:if>
		</ul>
	</div>
	<div class="divborder">
		<ul>
			<label>마이펫 수첩</label>
			<br>
			<br>
			<a href="petlist"><li>- 반려동물 수첩</li></a>
		</ul>
	</div>
	<div class="divborder">
		<ul>
			<label>나의 활동</label>
			<br>
			<br>
			<a href="${pageContext.request.contextPath}/myboard?cl_num=${client.cl_num}"><li>- 내가 쓴 글</li></a>
			<a href="${pageContext.request.contextPath}/myreply?cl_num=${client.cl_num}"><li>- 내가 쓴 댓글</li></a>
			<a href="${pageContext.request.contextPath}/mypage/ask?user_num=${client.cl_num}"><li>- 1:1문의</li></a>
			<a href="${pageContext.request.contextPath}/chatlist"><li>- 채팅 내역</li></a>
			<a href="${pageContext.request.contextPath}/noticelist"><li>- 알림 내역</li></a>
			<a href="${pageContext.request.contextPath}/myzzim?cl_num=${client.cl_num}"><li>- 찜 목록</li></a>
			<a href="${pageContext.request.contextPath}/point?cl_num=${client.cl_num}"><li>- 포인트 내역</li></a>
		</ul>
	</div>
	<div class="divborder">
		<ul>
			<label>나의 정보</label>
			<br>
			<br>
			<a href="${pageContext.request.contextPath}/uModify"><li>- 회원 정보 수정</li></a>
			<a href="${pageContext.request.contextPath}/uDelete"><li>- 회원 탈퇴</li></a>
		</ul>
	</div>
</aside>