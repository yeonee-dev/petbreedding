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
<link href="${path}/resources/css/admin/aSales/mSales.css" rel="stylesheet" type="text/css">
<link href="${path}/resources/css/admin/aSales/mSalesChart.css" rel="stylesheet" type="text/css">
<script src="https:/use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<script type="text/javascript">
$(document).ready(function() {

	//최근 6개월 매출액 차트
	Highcharts.chart('container', {
		  chart: {
		    type: 'column'
		  },
		  title: {
		    text: ''
		  },
		  xAxis: {
		    type: 'category',
		    labels: {
		      rotation: -45,
		      style: {
		        fontSize: '13px',
		        fontFamily: 'Verdana, sans-serif'
		      }
		    }
		  },
		  yAxis: {
		    min: 0,
		    title: {
		      text: 'Population (millions)'
		    }
		  },
		  legend: {
		    enabled: false
		  },
		  tooltip: {
		    pointFormat: '순매출: <b>{point.y:f} 원</b>'
		  },
		  series: [{
			  
		    name: 'Population',
		    data: [
		      ['${chart[0]}', ${cnt[0]}],
		      ['${chart[1]}', ${cnt[1]}],
		      ['${chart[2]}', ${cnt[2]}],
		      ['${chart[3]}', ${cnt[3]}],
		      ['${chart[4]}', ${cnt[4]}],
		      ['${chart[5]}', ${cnt[5]}],
		    ],
		    dataLabels: {
		      enabled: true,
		      rotation: -90,
		      color: '#FFFFFF',
		      align: 'right',
		      format: '{point.y:f}원', // one decimal
		      y: 10, // 10 pixels down from the top
		      style: {
		        fontSize: '13px',
		        fontFamily: 'Verdana, sans-serif'
		      }
		    }
		  }]
		});
	//최근 6개월 순매출 차트
Highcharts.chart('container2', {
	  chart: {
	    type: 'column'
	  },
	  title: {
	    text: ''
	  },
	  xAxis: {
	    type: 'category',
	    labels: {
	      rotation: -45,
	      style: {
	        fontSize: '13px',
	        fontFamily: 'Verdana, sans-serif'
	      }
	    }
	  },
	  yAxis: {
	    min: 0,
	    title: {
	      text: 'Population (millions)'
	    }
	  },
	  legend: {
	    enabled: false
	  },
	  tooltip: {
	    pointFormat: '순매출: <b>{point.y:f} 원</b>'
	  },
	  series: [{
	    name: 'Population',
	    colorByPoint: true,
	    data: [
	      ['${chart[0]}', ${real[0]}],
	      ['${chart[1]}', ${real[1]}],
	      ['${chart[2]}', ${real[2]}],
	      ['${chart[3]}', ${real[3]}],
	      ['${chart[4]}', ${real[4]}],
	      ['${chart[5]}', ${real[5]}],
	    ],
	    dataLabels: {
	      enabled: true,
	      rotation: -90,
	      color: '#FFFFFF',
	      align: 'right',
	      format: '{point.y:f}원', // one decimal
	      y: 10, // 10 pixels down from the top
	      style: {
	        fontSize: '13px',
	        fontFamily: 'Verdana, sans-serif'
	      }
	    }
	  }]
	});
	
	//연간 매출액 차트
Highcharts.chart('container3', {
	  chart: {
	    type: 'line'
	  },
	  title: {
	    text: ''
	  },
	  xAxis: {
	    categories: ['2020-08', '2020-09', '2020-10', '2020-11', '2020-12', '2021-01', '2021-02', '2021-03', '2021-04', '2021-05', '2021-06', '2021-07']
	  },
	  yAxis: {
	    title: {
	      text: ''
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
	    name: '연간 매출액',
	    data: [${year[0]}, ${year[1]}, ${year[2]}, ${year[3]}, ${year[4]}, ${year[5]}, ${year[6]}, ${year[7]}, ${year[8]}, ${year[9]}, ${year[10]}, ${year[11]}]
	  }]
	});
	
	
	//울트라콜 점유율 차트
Highcharts.chart('container4', {
	  chart: {
	    type: 'variablepie'
	  },
	  title: {
	    text: ''
	  },
	  tooltip: {
	    headerFormat: '',
	    pointFormat: '<span style="color:{point.color}">\u25CF</span> <b> {point.name}</b><br/>' +
	      ' 점유율: <b>{point.y}</b><br/>'
	      
	  },
	  series: [{
	    minPointSize: 10,
	    innerSize: '20%',
	    zMin: 0,
	    name: 'countries',
	    data: [{
	      name: '울트라콜',
	      y: ${ultra},
	      z: 100
	    }, {
	      name: '사업자',
	      y: ${bp},
	      z: 150
	    }]
	  }]
	});
	
	//점포별 점유율
Highcharts.chart('container5', {
	  chart: {
	    type: 'pie',
	    options3d: {
	      enabled: true,
	      alpha: 45
	    }
	  },
	  title: {
	    text: ''
	  },

	  plotOptions: {
	    pie: {
	      innerSize: 100,
	      depth: 45
	    }
	  },
	  series: [{
	    colorByPoint: true,
	    name: '점유율:',
	    data: [
	      ['헤어살롱', ${har}],
	     
	      ['병원', ${hos}],
	    ]
	  }]
	});
});
</script>
	<div class="wrapper">
		<jsp:include page="../mheader.jsp" />
		<section class="section">
			<jsp:include page="../mAside.jsp" />
			<div class="mContent">
				<div class="bbox">
					<h4>
						총매출<span>(최근 6개월 기준)</span>
					</h4>
					<div class="salesBox box">
						<figure class="highcharts-figure">
							<div id="container"></div>
						</figure>
					</div>
				</div>
				<div class="bbox">
					<h4>
						순매출<span>(최근 6개월 기준)</span>
					</h4>
					<div class="salesBox box">
						<figure class="highcharts-figure2">
							<div id="container2"></div>
						</figure>
					</div>
				</div>
				<div class="tbox">
					<h4>
						연간매출액<span>(최근 1년)</span>
					</h4>
					<figure class="highcharts-figure3">
 					 <div id="container3"></div>
  					</figure>
				</div>

				<div class="bbox">
					<h4>울트라콜 점유율</h4>
					<figure class="highcharts-figure4">
  					<div id="container4"></div>
 	
					</figure>
				</div>
				<div class="bbox">
					<h4>업종별 울트라콜 이용(전체)</h4>
				<figure class="highcharts-figure5">
  				<div id="container5"></div>
				</figure>
				</div>
			</div>
		</section>
		<jsp:include page="../../common/footer.jsp" />
	</div>

	<!-- script -->
	<script type="text/javascript" src="${path}/resources/js/admin/mAside.js"></script>
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/variable-pie.js"></script>
	<script src="https://code.highcharts.com/highcharts-more.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	<script src="https://code.highcharts.com/modules/export-data.js"></script>
	<script src="https://code.highcharts.com/modules/accessibility.js"></script>
	<script src="https://code.highcharts.com/highcharts-3d.js"></script>
</body>
</html>