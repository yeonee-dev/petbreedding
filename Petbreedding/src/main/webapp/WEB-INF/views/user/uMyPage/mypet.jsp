<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/myPageAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/user/uMyPage/mypet.css" rel="stylesheet" type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../../common/header.jsp" />
	 <section class="section">
	 <jsp:include page="../myPageAside.jsp"/>
	 <div id="petInfo">
	  <div class="pethead">
            <h1>반려동물 정보</h1>
	  <c:forEach var="list" items="${list}">
            <div class="petBox">
	  			<input type="hidden" value="${list.pet_num}" name="pet_num" id="pet_num"> 
	            <img src="${path}/resources/uploadFile/mypet/${list.pet_img}" width="250" height="150" onerror="this.src='${path}/resources/images/logoForChat.png'"  />
	            <div class="petname"><a href="petdetail">${list.pet_name}</a></div>
	            <div class="btnwrap">
	            <a href="mypetupdate?pet_num=${list.pet_num}"><button id="updateBtn" class="btn basicBtn">수정</button></a>
	            <a class="cancleM"><button id="delBtn" class="btn basicBtn">삭제</button></a>
	  		</div>
        </div>
	 </c:forEach>
         </div>
        <div class="petrow">
                <a href="openMyPet"><i id="plus" class="fas fa-plus-circle"></i>
                <p class="plusp">새 동물 등록</p></a>
            </button>
        </div> 
        
        <!-- 펫 삭제 모달 -->
	<div id="cancel-modal" class="modal">
	<div class="cancel-content">
		<p class="boldtext">펫을 삭제하시겠습니까?</p> 
		<p class="text">
		<br>
		펫과 관련된 모든 정보가 삭제됩니다.
		</p>
		<div class="btn2">
			<button class="basicBtn" id="yesCalncle">네</button>
			<button class="basicBtn" id="noCalncle">아니오</button>
		</div>
	</div>
	
     </div>   
	 </section>
	<jsp:include page="../../common/footer.jsp" />
	<!-- script -->
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script type="text/javascript" src="${path}/resources/js/user/uMyPage/mypet.js"></script>
	</div>