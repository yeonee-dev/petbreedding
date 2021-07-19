<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="bheader">
    <nav class="UserNav">
        <ul>
            <c:if test = "${!empty admin }">
	            <li id="userName"><a href="#">관리자님</a></li>
	            <li><a href="${pageContext.request.contextPath}/mlogout">로그아웃</a></li>
            </c:if>
            <c:if test = "${empty admin }">
	            <li><a href="${pageContext.request.contextPath}/mLogin">로그인</a></li>
            </c:if>
        </ul>
    </nav>
    <c:if test = "${!empty admin }">
		<a href="${pageContext.request.contextPath}/mClient">
			<img  class="logo" src="${pageContext.request.contextPath}/resources/images/logo.png" > 
		</a>
    </c:if>
    <c:if test = "${empty admin }">
	    <a href="${pageContext.request.contextPath}/mLogin">
	    	<img class="logo" src="${pageContext.request.contextPath}/resources/images/logo.png" > 
	    </a>          
    </c:if>
</header>