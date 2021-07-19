    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
            level: 5 // 지도의 확대 레벨
        };

    //지도를 미리 생성
    var map = new daum.maps.Map(mapContainer, mapOption);
    //주소-좌표 변환 객체를 생성
    var geocoder = new daum.maps.services.Geocoder();
    //마커를 미리 생성
    var marker = new daum.maps.Marker({
        position: new daum.maps.LatLng(37.537187, 127.005476),
        map: map
    });

    // ********** 새로운 매장 주소 등록 *************
    function execDaumPostcode1() {
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = data.address; // 최종 주소 변수

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("shopAddr").value = addr;
                // 주소로 상세 정보를 검색
                geocoder.addressSearch(data.address, function(results, status) {
                    // 정상적으로 검색이 완료됐으면
                    if (status === daum.maps.services.Status.OK) {

                        var result = results[0]; //첫번째 결과의 값을 활용
                        console.log(result);
                        console.log(typeof result);
                        
                        var y = result.y;
                        var x = result.x;
                        console.log('y좌표:'+y);
                        console.log(typeof y);
                        console.log('x좌표:'+x);
                        console.log(typeof x);
                        
                        document.getElementById("y").value = y;
                        document.getElementById("x").value = x;
                        
                        // 해당 주소에 대한 좌표를 받아서
                        var coords = new daum.maps.LatLng(y, x);
                        console.log(coords);
                        console.log(typeof coords);
                        
                        // 지도를 보여준다.
                        mapContainer.style.display = "block";
                        map.relayout();
                        // 지도 중심을 변경한다.
                        map.setCenter(coords);
                        // 마커를 결과값으로 받은 위치로 옮긴다.
                        marker.setPosition(coords)
                        

                        
                    }
                });
            }
        }).open();
        

        
    }
    
    
    // ************* 기존 매장 주소 수정 *****************
    function execDaumPostcode2() {
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = data.address; // 최종 주소 변수

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("shopAddr").value = addr;
                // 주소로 상세 정보를 검색
                geocoder.addressSearch(data.address, function(results, status) {
                    // 정상적으로 검색이 완료됐으면
                    if (status === daum.maps.services.Status.OK) {

                        var result = results[0]; //첫번째 결과의 값을 활용
                        console.log(result);
                        console.log(typeof result);
                        

                        
                        
                        var y = result.y;
                        var x = result.x;
                        console.log('y좌표:'+y);
                        console.log(typeof y);
                        console.log('x좌표:'+x);
                        console.log(typeof x);
                        
                        document.getElementById("y").value = y;
                        document.getElementById("x").value = x;
                        
                        // 해당 주소에 대한 좌표를 받아서
                        var coords = new daum.maps.LatLng(y, x);
                        console.log(coords);
                        console.log(typeof coords);
                        
                        // 지도를 보여준다.
                        mapContainer.style.display = "block";
                        map.relayout();
                        // 지도 중심을 변경한다.
                        map.setCenter(coords);
                        // 마커를 결과값으로 받은 위치로 옮긴다.
                        marker.setPosition(coords)
                    }
                });
            }
        }).open();
        
        
    }
// TODO
// if ($("#area").val().trim() == '') {
// alert("모든 정보를 기입해주세요.");
// $("#area").focus();
// return;
// } else if ($("#store_tel").val().trim() == '') {
// alert("모든 정보를 기입해주세요.");
// $("#store_tel").focus();
// return;
// } else if ($("#code").val().trim() == '') {
// alert("모든 정보를 기입해주세요.");
// $("#code").focus();
// return;
// } else if ($("#id").val().trim() == '') {
// alert("모든 정보를 기입해주세요.");
// $("#id").focus();
// return;
// } else if ($("#password").val().trim() == '') {
// alert("모든 정보를 기입해주세요.");
// $("#password").focus();
// return;
// } else if ($("#storename").val().trim() == '') {
// alert("모든 정보를 기입해주세요.");
// $("#storename").focus();
// return;
// } else if ($("#close").val().trim() == '') {
// alert("모든 정보를 기입해주세요.");
// $("#close").focus();
// return;
// } else if ($("#open").val().trim() == '') {
// alert("모든 정보를 기입해주세요.");
// $("#open").focus();
// return;
// } else if ($("#parking").val().trim() == '') {
// alert("모든 정보를 기입해주세요.");
// $("#parking").focus();
// return;
// } else if ($("#postcode").val().trim() == '') {
// alert("모든 정보를 기입해주세요.");
// $("#postcode").focus();
// return;
// }
// });
	
	


