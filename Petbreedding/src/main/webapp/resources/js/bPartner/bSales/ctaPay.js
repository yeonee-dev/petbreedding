

//	/* 약관 체크 */
//	
	var chk1 = $("#agr2").is(":checked");
	var chk2 = $("#agr3").is(":checked");
	var chk3 = $("#agr4").is(":checked");
	//이용동의 체크여부 확인
	$("#agrs1").on("click",function(){
	    var chk = $(this).is(":checked");
	    if(chk){
	        $(".agreeAll").prop('checked', true);
	     } else {
	        $(".agreeAll").prop('checked', false);
	    }
	});

	$(".agreeAll").on("click", function(){
	    var allchk = $("input:checkbox[class=agreeAll]:checked").length;
	    console.log("allchk : " + allchk);
	    if(allchk !=2){
	        $("#agrs1").prop('checked',false);
	    }else{
	        $("#agrs1").prop('checked',true); 
	    }
	});


