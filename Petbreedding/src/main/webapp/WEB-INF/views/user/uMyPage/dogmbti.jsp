<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/user/uShop/mbti.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"	rel="stylesheet">
</head>
<body>
	<div class="wrapper">
	<jsp:include page="../../common/header.jsp" />
	 <section class="section">
	 <c:if test="${client.email == null}">
	 <center>
	 <div class="nologin">
	 <p>로그인 후 이용 가능합니다</p><br>
	 <a href="${pageContext.request.contextPath}/uLogin"><button class="basicBtn gologin">로그인 하러 가기</button></a>
	 </div>
	 </center>
	 </c:if>
	<c:if test="${client.email !=null }">
	  <div class="container">
	  <center>
    <section id="main" class="mx-auto my-5 py-5 px-3">
      <h1>우리집 댕댕이의 MBTI는 뭘까?!</h1>
      <div class="col-lg-6 col-md-8 col-sm-10 col-12 mx-auto">
        <img src="${path}/resources/images/main.PNG" alt="mainImage" class="img-fluid">
      </div>
      <p>
        펫브리띵 에서 제공하는 멍비티아이 입니다! <br>
        아래 '멍비티아이 하러가기' 버튼을 눌러 시작해 주십시오.
      </p>
      <button type="button" class="basicBtn goback" onclick="js:begin()">멍비티아이 하러가기</button>
    </section>
    <section id="qna">
      <div class="status mx-auto mt-5">
        <div class="statusBar">
        </div>
      </div>
      <div class="qBox my-5 py-3 mx-auto">

      </div>
      <div class="answerBox">

      </div>
    </section>
    <section id="result" class="mx-auto my-5 py-5 px-3">
      <h1>우리집 댕댕이 결과는?!</h1>
      <div class="resultname">

      </div>
      <div id="resultImg" class="my-3 col-lg-6 col-md-8 col-sm-10 col-12 mx-auto">

      </div>
      <div class="resultDesc">

      </div>
	
	<a href="mbtipet"><button type="button" class="basicBtn goback">다시 하러 가기</button></a>
    </section>
    </center>
      </div>
      </c:if>
	 
	 
	 
	  </section>
	 
	 
	<jsp:include page="../../common/footer.jsp" />
	<!-- script -->
    <script src="${path}/resources/js/user/uMyPage/mbti.js"></script>
    <script type="text/javascript" src="${path}/resources/js/common/topBtn.js"></script>
	</div>
</body>
</html>
	
	
	