<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 관리자</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/admin/aMember/mLogin.css" rel="stylesheet" type="text/css" >
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
<div class="wrapper">
		<jsp:include page="../mheader.jsp" />
        <section class="section">
            <div class="loginBox">
                <img class="IDlogo" src="${path}/resources/images/logo.png">
                <form id="loginFrm">
                    <!-- <label>아이디</label> -->
                    <input type="text" id="bId" class="inputArea" placeholder="아이디" name="admin_id">
                    <!-- <label>비밀번호</label> -->
                    <input type="password" id="bPwd" class="inputArea"  placeholder="비밀번호" name="admin_pwd">
                    <input type="button" class="basicBtn" id="loginBtn" value="로그인" src="#">
                </form>
            </div>
        </section>
		<jsp:include page="../../common/footer.jsp" />	
</div>
<!-- script -->
	<script type="text/javascript" src="${path}/resources/js/admin/aMember/mLogin.js"></script>
</body>
</html>