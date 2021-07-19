$(document).ready(function(){
    setDateBox();
    
    $("#browseBtn").bind("click", function() {
        insertImg();
    });
});    

// select box 연도 , 월 표시
function setDateBox(){
    var dt = new Date();
    var year = "";
    var com_year = dt.getFullYear();
    // 발행 뿌려주기
    $("#YEAR").append("<option value=''>년도</option>");
    // 올해 기준으로 -1년부터 +5년을 보여준다.
    for(var y = (com_year-20); y <= (com_year); y++){
        $("#YEAR").append("<option value='"+ y +"'>"+ y + "년" +"</option>");
    }
    // 월 뿌려주기(1월부터 12월)
    var month;
    $("#MONTH").append("<option value=''>월</option>");
    for(var i = 1; i <= 12; i++){
        $("#MONTH").append("<option value='"+ i +"'>"+ i + "월" +"</option>");
    }
    //  일 뿌려주기()
    $("#DATE").append("<option value=''>일</option>")
    for(var i = 1; i <= 31; i++) {
        $("#DATE").append("<option value='일'>" + i + "일" + "</option>");
    }
}

function insertImg() {
    $("#realInput").trigger("click");
}

$("#pet_name").blur(function() {

	if ($("#pet_name").val() == "") {
		// 빈칸일시
		$("#pet_namechk").text("필수입력칸입니다. 펫 이름을 입력해주세요");
		$("#pet_namechk").css("color", "red");
	} else {
		$("#pet_namechk").text("펫 이름 입력이 완료되었습니다.");
		$("#pet_namechk").css("color", "green");
	}
});

$("#selectPet").blur(function() {
	if ($("#selectPet").val() == "견종") {
		// 빈칸일시
		$("#pet_kindchk").text("필수입력칸입니다. 견종을 선택해주세요");
		$("#pet_kindchk").css("color", "red");
	} else {
		$("#pet_kindchk").text("견종이 선택되었습니다.");
		$("#pet_kindchk").css("color", "green");
	}
});

$("#selectPet").blur(function() {
	if ($("#selectPet").val() == "견종") {
		// 빈칸일시
		$("#pet_kindchk").text("필수입력칸입니다. 견종을 선택해주세요");
		$("#pet_kindchk").css("color", "red");
	} else {
		$("#pet_kindchk").text("견종이 선택되었습니다.");
		$("#pet_kindchk").css("color", "green");
	}
});

$("#pet_birth").blur(function() {
	if ($("#pet_birth").val() == "") {
		// 빈칸일시
		$("#pet_birthchk").text("필수입력칸입니다. 펫 나이를 입력해주세요.");
		$("#pet_birthchk").css("color", "red");
	} else {
		$("#pet_birthchk").text("나이가 입력되었습니다.");
		$("#pet_birthchk").css("color", "green");
	}
});

$("#pet_weight").blur(function() {
	var pattern1 = /^[0-9.]*$/;	
	var str = document.getElementById("pet_weight").value;
	if (!pattern1.test(document.getElementById("pet_weight").value)) {
		// 빈칸일시
		$("#pet_weightchk").text("몸무게는 숫자로만 입력해주세요.");
		$("#pet_weightchk").css("color", "red");
	} else {
		$("#pet_weightchk").text("몸무게가 입력되었습니다.");
		$("#pet_weightchk").css("color", "green");
	}
});


//사진 미리보기 

function setThumbnail(event) {
	for (var image of event.target.files) { 
		var reader = new FileReader(); 
		reader.onload = function(event) { 
			var img = document.createElement("img"); 
			img.setAttribute("src", event.target.result); 
			img.setAttribute("width", "150"); 
			img.setAttribute("height", "150");
			img.setAttribute("text-align", "");
			document.querySelector("div.imgBox").appendChild(img); };
			console.log(image); 
			reader.readAsDataURL(image);
	}
}

