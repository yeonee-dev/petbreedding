var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

//지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

//주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();


var shopAddr = $("#shopAddr").val();


//주소로 좌표를 검색합니다
geocoder.addressSearch(shopAddr, function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
//        var infowindow = new kakao.maps.InfoWindow({
//            content: '<div style="width:150px;text-align:center;padding:6px 0;">${shopInfo.shopName }</div>'
//        });
//        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    




//const url = new URL(window.location.href);	
//// URLSearchParams 객체
//const urlParams = url.searchParams;
//	
//
//	
//	var y = $("#y").val();
//	var x = $("#x").val();
//	console.log("y좌표::" + y);
//	console.log("x좌표::" + x);
//	   
//	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
//	
//	var options = { //지도를 생성할 때 필요한 기본 옵션
//			center: new kakao.maps.LatLng(y, x), //지도의 중심좌표.
//			level: 5 //지도의 레벨(확대, 축소 정도)
//			
//	};
//	
////지도 생성 및 객체 리턴
//	var map = new kakao.maps.Map(container, options); 
////주소-좌표 변환 객체를 생성
//	var geocoder = new daum.maps.services.Geocoder();
//	
//    var marker = new daum.maps.Marker({
//        position: new daum.maps.LatLng(y, x),
//        map: map
//    });
//    
//    map.relayout();
//    // 지도 중심을 변경한다.
//    map.setCenter(y, x);
//    // 마커를 결과값으로 받은 위치로 옮긴다.
//    marker.setPosition(y, x);
//    
//
//
