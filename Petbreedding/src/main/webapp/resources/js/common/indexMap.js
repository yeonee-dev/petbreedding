//if (navigator.geolocation) {
//  navigator.geolocation.getCurrentPosition(success);
//} else {
//  error('Geo Location is not supported');
//}
//
//navigator.geolocation.getCurrentPosition(success);
//
//function success(position) {
//     var lat = position.coords.latitude;
//     var long = position.coords.longitude;
//}
//
//var coords = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
//
//var options = {
//  zoom: 15,
//  center: coords,
//  mapTypeControl: false,
//  navigationControlOptions: {
//      style: google.maps.NavigationControlStyle.SMALL
//  },
//  mapTypeId: google.maps.MapTypeId.ROADMAP
//};
//var map = new google.maps.Map(document.getElementById("mapcontainer"), options);
//
//var marker = new google.maps.Marker({
//    position: coords,
//    map: map,
//    title:"You are here!"
//});

///* 병원 지도 */
//var mapContainer1 = document.getElementById('map1'), // 지도를 표시할 div 
//mapOption1 = {
//	center: new kakao.maps.LatLng(37.566826, 126.570667), // 지도의 중심좌표
//	level: 3 // 지도의 확대 레벨
//}; 
//
//var map1 = new kakao.maps.Map(mapContainer1, mapOption1);  //지도를 생성합니다
//
//
///* 미용실 지도  */
//var mapContainer0 = document.getElementById('map0'), // 지도를 표시할 div 
//mapOption0 = {
//	center: new kakao.maps.LatLng(37.566826, 126.4654651), // 지도의 중심좌표
//	level: 3 // 지도의 확대 레벨
//}; 
//
//var map0 = new kakao.maps.Map(mapContainer0, mapOption0);  //지도를 생성합니다
//
//
///* 현재 위치 정보 */
//function init()
//{
//    window.navigator.geolocation.getCurrentPosition(current_position);
//}
// 
//function current_position(position)
//{
//    var msg;
//    
//    msg = "Latitude: " + position.coords.latitude + ", " + "Longitude: " + position.coords.longitude;
//    
//    console.log(msg);
//    
//    var latitude = position.coords.latitude;
//    var longitude = position.coords.longitude;
//    
//    
//}
// 
//window.addEventListener("load", init);
