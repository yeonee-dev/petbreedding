<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<aside class="mAside">
    <div class="mMenu">
        <ul>
        	<a href="${pageContext.request.contextPath}/mClient" >
	            <li class="menu" id="mMember">
	                <i class="fas fa-user"></i>
	                <p>회원관리</p>
	            </li>
            </a>
            <a href="${pageContext.request.contextPath}/mSales" >
	            <li class="menu" id="mSales">
	                <i class="fas fa-chart-bar"></i>
	                <p>매출관리</p>
	            </li>
            </a>
            <a href="${pageContext.request.contextPath}/mfreeboard" >
	            <li class="menu hs" id="mBoard">
	                <i class="fas fa-file-alt"></i>
	                <p>게시물관리</p>
	            </li>
            </a>
            <a href="${pageContext.request.contextPath}/mwaitList" >
            	<li class="menu" id="mShop">
                <i class="fas fa-home"></i>
                <p>사업장관리</p>
            	</li>
            </a>
        </ul>
        
    </div> 
    <div class="mSideMenu" id="mBoardm">
        <div class="mBox">
            <ul>
                <p>게시물 관리</p>
                <li class="bs"><a href="mfreeboard">자유게시판</a></li>
                <li class="bs"><a href="mservice">공지사항게시판</a></li>
                <li class="bs"><a href="mboard">문의게시판</a></li>
                <li class="bs"><a href="${pageContext.request.contextPath}/oftenQna">자주묻는질문 관리</a></li>
            </ul>
        </div>
    </div> 
    <div class="mSideMenu" id="mShopm">
       <div class="mBox">
           <ul>
               <p>사업장 관리</p>
               <li class="bs"><a href="${pageContext.request.contextPath}/mwaitList">제휴승인게시판</a></li>
               <li class="bs"><a href="${pageContext.request.contextPath}/mcancel">제휴취소게시판</a></li>
           </ul>
       </div>
    </div> 
</aside>