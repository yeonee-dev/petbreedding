var getParameters = function (paramName) {
	// 리턴값을 위한 변수 선언 
	var returnValue;
	// 현재 URL 가져오기
	var url = location.href; 
	// get 파라미터 값을 가져올 수 있는 ? 를 기점으로 slice 한 후 split 으로 나눔 
	var parameters = (url.slice(url.indexOf('?') + 1, url.length)).split('&');
	// 나누어진 값의 비교를 통해 paramName 으로 요청된 데이터의 값만 return 
	for (var i = 0; i < parameters.length; i++) {
		var varName = parameters[i].split('=')[0]; 
		if (varName.toUpperCase() == paramName.toUpperCase()) {
			returnValue = parameters[i].split('=')[1]; return decodeURIComponent(returnValue); 
			} 
		}
}


var orderBy = getParameters('orderBy');
console.log('정렬 기준은???'+orderBy);

if(orderBy=='new'){
	$("input:radio[name='selectOpt']:radio[value='new']").attr("checked",true);
} 
if(orderBy=='like'){
	$("input:radio[name='selectOpt']:radio[value='like']").attr("checked",true);
} 
if(orderBy=='rev'){
	$("input:radio[name='selectOpt']:radio[value='rev']").attr("checked",true);
} 



// $(document).ready(function(){
//	
//	
// // 위치 검색
// $("#newLocRadio").click(function(){
// $("#harListLocNew").show();
// $("#harListLocLike").hide();
// $("#harListLocRev").hide();
//		
// $("#hosListLocNew").show();
// $("#hosListLocLike").hide();
// $("#hosListLocRev").hide();
//		
// });
//
// $("#likeLocRadio").click(function(){
// $("#harListLocNew").hide();
// $("#harListLocLike").show();
// $("#harListLocRev").hide();
//		
// $("#hosListLocNew").hide();
// $("#hosListLocLike").show();
// $("#hosListLocRev").hide();
// });
//
// $("#revLocRadio").click(function(){
// $("#harListLocNew").hide();
// $("#harListLocLike").hide();
// $("#harListLocRev").show();
//		
// $("#hosListLocNew").hide();
// $("#hosListLocLike").hide();
// $("#hosListLocRev").show();
// });
//	
//	
// // 전체 리스트
// $("#newRadio").click(function(){
//		
//		
// $("#newList").show();
// $("#likeList").hide();
// $("#revList").hide();
// });
//	
//	
//	
//
// $("#likeRadio").click(function(){
// $("#newList").hide();
// $("#likeList").show();
// $("#revList").hide();
//		
// });
//
// $("#revRadio").click(function(){
// $("#newList").hide();
// $("#likeList").hide();
// $("#revList").show();
// });
//
// });

function modal(id) {
    var zIndex = 9999;
    var modal = document.getElementById(id);

    // 모달 div 뒤에 희끄무레한 레이어
    var bg = document.createElement('div');
    bg.setStyle({
        position: 'fixed',
        zIndex: zIndex,
        left: '0px',
        top: '0px',
        width: '100%',
        height: '100%',
        overflow: 'auto',
        // 레이어 색갈은 여기서 바꾸면 됨
        backgroundColor: 'rgba(0,0,0,0.4)'
    });
    document.body.append(bg);

    // 닫기 버튼 처리, 시꺼먼 레이어와 모달 div 지우기
    modal.querySelector('.modal_close_btn').addEventListener('click', function () {
        bg.remove();
        modal.style.display = 'none';
    });

    modal.setStyle({
        position: 'fixed',
        display: 'block',
        boxShadow: '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)',

        // 시꺼먼 레이어 보다 한칸 위에 보이기
        zIndex: zIndex + 1,

        // div center 정렬
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        msTransform: 'translate(-50%, -50%)',
        webkitTransform: 'translate(-50%, -50%)'
    });
}

// Element 에 style 한번에 오브젝트로 설정하는 함수 추가
Element.prototype.setStyle = function (styles) {
    for (var k in styles) this.style[k] = styles[k];
    return this;
};

document.getElementById('Loc').addEventListener('click', function () {
    // 모달창 띄우기
    modal('my_modal');
});

// 시.도 선택후 시.군.구 선택창
function categoryChange(e) {
	
	console.log(e);
	
    var city1 = ["종로구", "중구", "용산구", "성동구","광진구", "동대문구", "중랑구", "성북구", "강북구", "도봉구", "노원구","은평구", "서대문구", "마포구", "양천구","강서구", "구로구","금천구", "영등포구", "동작구", "관악구","서초구", "강남구", "송파구","강동구"];
    var city2 = ["중구", "서구", "동구", "영도구","부산진구", "동래구", "남구", "북구","강서구", "해운대구", "사하구", "금정구","연제구", "수영구", "사상구"];
    var city3 = ["중구", "동구", "서구", "남구", "북구","수성구", "달서구", "달성군"];
    var city4 = ["중구", "동구", "미추홀구", "연수구", "남동구","부평구", "계양구", "서구","강화군","옹진군"];
    var city5 = ["동구", "서구", "남구", "북구", "광산구"];
    var city6 = ["동구", "중구", "서구", "유성구", "대덕구"];
    var city7 = ["중구", "남구", "동구", "북구", "울주군"];
    var city8 = [];
    var city9 = ["수원시 장안구", "수원시 권선구", "수원시 팔달구", "수원시 영통구", "성남시 수정구","성남시 중원구","성남시 분당구", "안양시 만안구", "안양시 동안구", "안산시 상록구", "안산시 단원구","용인시 처인구", "용인시 기흥구","용인시 수지구", "부천시", "광명시","평택시","과천시", "오산시", "시흥시","군포시", "의왕시", "하남시","이천시","김포시", "화성시", "광주시","여주시", "양평군", "고양시 덕양구","고양시 일산동구","고양시 일산서구", "의정부시", "동두천시","구리시", "남양주시", "파주시","양주시","포천시", "연천군", "가평군"];
    var city10 = ["춘천시", "원주시", "강릉시", "동해시", "태백시","속초시", "삼척시", "홍천군", "횡성군", "영월군", "평창군","정선군", "철원군", "화천군", "양구군", "인제군","고성군","양양군"];
    var city11 = ["청주시 상당구", "청주시 흥덕구", "청주시 서원구", "청주시 청원구", "충주시", "제천시", "보은군", "옥천군", "영동군", "증평군", "진천군","괴산군", "음성군", "단양군"];
    var city12 = ["천안시 동남구", "천안시 서북구", "공주시", "보령시", "아산시","논산시", "계룡시", "당진시", "금산군", "부여군", "서천군","청양군", "홍성군", "예산군", "태안군"];
    var city13 = ["전주시 완산구", "전주시 덕진구", "군산시", "익산시", "정읍시","남원시", "김제시", "완주군", "진안군", "무주군", "장수군","임실군", "순창군", "고창군", "부안군"];
    var city14 = ["목포시", "여수시", "순천시", "나주시", "광양시","곡성군", "구례군", "고흥군", "보성군", "화순군", "장흥군","강진군", "해남군", "영암군", "무안군", "함평군", "영광군","장성군", "완도군", "진도군", "신안군"];
    var city15 = ["포항시 남구", "포항시 북구", "경주시", "김천시", "안동시","영주시", "영천시", "상주시", "문경시", "경산시", "군위군","의성군", "청송군", "영양군", "영덕군", "청도군", "고령군","성주군", "칠곡군", "예천군", "봉화군","울진군","울릉군"];
    var city16 = ["창원시 의창구", "창원시 성산구", "창원시 마산합포구", "창원시 마산회원구", "창원시 진해구","진주시", "통영시", "사천시", "김해시", "밀양시", "거제시","의령군", "함안군", "창녕군", "고성군", "남해군", "하동군","산청군", "함양군", "거창군", "합천군"];
    var city17 = ["제주시", "서귀포시"];
    var target = document.getElementById("chooseLoc");

    if (e.value == "서울") var d = city1;
    else if (e.value == "부산") var d = city2;
    else if (e.value == "대구") var d = city3;
    else if (e.value == "인천") var d = city4;
    else if (e.value == "광주") var d = city5;
    else if (e.value == "대전") var d = city6;
    else if (e.value == "울산") var d = city7;
    else if (e.value == "세종특별자치시") var d = city8;
    else if (e.value == "경기") var d = city9;
    else if (e.value == "강원도") var d = city10;
    else if (e.value == "충북") var d = city11;
    else if (e.value == "충남") var d = city12;
    else if (e.value == "전북") var d = city13;
    else if (e.value == "전남") var d = city14;
    else if (e.value == "경북") var d = city15;
    else if (e.value == "경남") var d = city16;
    else if (e.value == "제주특별자치도") var d = city17;
    

    target.options.length = 0;

    for (x in d) {
        var opt = document.createElement("option");
        opt.value = d[x];
        opt.innerHTML = d[x];
        target.appendChild(opt);
    }
    
}


