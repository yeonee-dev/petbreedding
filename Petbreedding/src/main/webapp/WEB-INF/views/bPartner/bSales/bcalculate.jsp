<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/header.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/bPartner/bAside.css" rel="stylesheet" type="text/css" >
<link href="${path}/resources/css/bPartner/bSales/bcal.css" rel="stylesheet" type="text/css" >
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
<script type="text/javascript">
$(document).ready(function() {
	//미용실 차트
	Highcharts.chart('container', {
	  chart: {
	    type: 'line'
	  },
	  title: {
	    text: ''
	  },
	 
	  xAxis: {
	    categories: ['${month[11]}', '${month[10]}', '${month[9]}', '${month[8]}', '${month[7]}', '${month[6]}', '${month[5]}', '${month[4]}', '${month[3]}', '${month[2]}', '${month[1]}', '${month[0]}']
	  },
	  yAxis: {
	    title: {
	      text: '원'
	    }
	  },
	  plotOptions: {
	    line: {
	      dataLabels: {
	        enabled: true
	      },
	      enableMouseTracking: false
	    }
	  },
	  series: [{
		  colorByPoint: true,
		  name: '최근 1년 매출액',
	    data: [${year[11]}, ${year[10]}, ${year[9]}, ${year[8]}, ${year[7]}, ${year[6]}, ${year[5]}, ${year[4]},${year[3]}, ${year[2]},${year[1]},${year[0]}]
	  }]
	});
	
});
</script>
	<div class="wrapper">
	<jsp:include page="../bheader.jsp" />
	 <section class="section">
	 <jsp:include page="../bAside.jsp"/>
	 <div class="bContent">
	 	<c:if test="${bP.bp_type == 0}">
	 	<div class="calhead">
	        <p>이번달 총 매출액 </p>
	        <p></p><br>    
	    </div>
	    <div class="calrow">
	    <h1><fmt:formatNumber value="${har}" type="number"/>원</h1>
	    <div class="calbtn">
	    </div>
					    
	    <figure class="highcharts-figure">
  		<div id="container"></div>
  
		</figure>
	    </div>
	    </c:if>
	    <c:if test="${bP.bp_type == 1}">
		<div class="calhead">
	        <p>이번달 총 매출액 </p>
	        <p></p><br>    
	    </div>
	    <div class="calrow">
	    <h1><fmt:formatNumber value="${hos}" type="number"/>원</h1>
	    <div class="calbtn">
	
	    </div>
					    
	    <figure class="highcharts-figure2">
  		<div id="container2"></div>
  			
		</figure>
	    </div>
	    
	    </c:if>
	 </div>
	 
    
	 </section>
	<jsp:include page="../../common/footer.jsp" />
	</div>
	
	<script type="text/javascript">
	//병원 차트
	$(document).ready(function() {
	Highcharts.chart('container2', {
		  chart: {
		    type: 'line'
		  },
		  title: {
		    text: ''
		  },
		 
		  xAxis: {
		    categories: ['${month2[11]}', '${month2[10]}', '${month2[9]}', '${month2[8]}', '${month2[7]}', '${month2[6]}', '${month2[5]}', '${month2[4]}', '${month2[3]}', '${month2[2]}', '${month2[1]}', '${month2[0]}']
		  },
		  yAxis: {
		    title: {
		      text: '원'
		    }
		  },
		  plotOptions: {
		    line: {
		      dataLabels: {
		        enabled: true
		      },
		      enableMouseTracking: false
		    }
		  },
		  series: [{
			  colorByPoint: true,
			  name: '최근 1년 매출액',
		    data: [${year2[11]}, ${year2[10]}, ${year2[9]}, ${year2[8]}, ${year2[7]}, ${year2[6]}, ${year2[5]}, ${year2[4]},${year2[3]}, ${year2[2]},${year2[1]},${year2[0]}]
		  }]
		});
	});
	</script>

<script type="text/javascript" src="${path}/resources/js/bPartner/bAside.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="./jquery-ui-1.12.1/datepicker-ko.js"></script>
<script src="${path}/resources/js/user/uBoard/service.js"></script>
<script src="https://kit.fontawesome.com/aca84cf3fb.js" crossorigin="anonymous"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-3d.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
</body>
</html>	 