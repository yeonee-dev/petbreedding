<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Petbreedding::펫브리띵 관리자</title>
<link href="${path}/resources/css/common/reset.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/bPartner/bheader.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/common/footer.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/admin/mAside.css" rel="stylesheet"
	type="text/css">
<link href="${path}/resources/css/admin/aSales/mClient.css"
	rel="stylesheet" type="text/css">
	<link href="${path}/resources/css/admin/aSales/mChart.css"
	rel="stylesheet" type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
<script language="JavaScript">
$(document).ready(function() {
	Highcharts.chart('container', {
		  chart: {
		    type: 'column'
		  },
		  title: {
		    text: ''
		  },
		
		  xAxis: {
		    categories: [
		    	'2020-08', '2020-09', '2020-10', '2020-11', '2020-12', '2021-01', '2021-02', '2021-03', '2021-04', '2021-05', '2021-06', '2021-07'
		    ],
		    crosshair: true
		  },
		  yAxis: {
		    min: 0,
		    title: {
		      text: ' '
		    }
		  },
		  tooltip: {
		    headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
		    pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
		      '<td style="padding:0"><b>{point.y:.f} 명</b></td></tr>',
		    footerFormat: '</table>',
		    shared: true,
		    useHTML: true
		  },
		  plotOptions: {
		    column: {
		      pointPadding: 0.2,
		      borderWidth: 0
		    }
		  },
		  series: [{
		    name: '사용자',
		    data: [${cnt[0]}, ${cnt[1]}, ${cnt[2]}, ${cnt[3]},${cnt[4]},${cnt[5]}, ${cnt[6]},${cnt[7]},${cnt[8]},${cnt[9]}
            ,${cnt[10]}, ${cnt[11]}, ${cnt[12]}]

		  }, {
		    name: '사업자',
		    data: [${cnt2[0]}, ${cnt2[1]}, ${cnt2[2]}, ${cnt2[3]},${cnt2[4]},${cnt2[5]},${cnt2[6]},${cnt2[7]},${cnt2[8]},${cnt2[9]},
		    	${cnt2[10]},${cnt2[11]},${cnt2[12]}
		    	]

		  }, ]
		});
});

</script>
	<div class="wrapper">
		<jsp:include page="../mheader.jsp" />
		<section class="section">
			<jsp:include page="../mAside.jsp" />
			<div class="mContent">
				<h1>회원조회</h1>
				<div class="memberBox">
					<h1>${total}</h1>
					<span>일반 고객 가입자수</span>
				</div>
				<div class="memberBox">
					<h1>${total2}</h1>
					<span>사업자 고객 가입자수</span>
				</div>
		
			<figure class="highcharts-figure">
  			<div id="container"></div>

</figure>
			
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>

	<!-- script -->
	<script type="text/javascript" src="${path}/resources/js/admin/mAside.js"></script>
	<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>

</body>
</html>