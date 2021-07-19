<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petbreedding::펫브리띵</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/common/error.css" rel="stylesheet" type="text/css" >
</head>
<body>
	<img src="${path}/resources/images/404error.png">
	<button class="basicBtn errorBtn" id="mainBtn" onclick="location.href='/petbreedding/'">메인으로</button>
	<button class="basicBtn errorBtn" id="backBtn" onClick="history.back();">이전 페이지로</button>
</body>
</html>