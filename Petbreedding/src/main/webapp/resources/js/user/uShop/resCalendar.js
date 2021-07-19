var mon,tue,wed,thu,fri,sat,sun = null;
$(function() {
	var har_num = $(".harNum").val();
	var hos_num = $(".hosNum").val();
	
	if(har_num != null){
		$.ajax({
			url:"checkDayOff",
			type:"post",
			data:{
				har_num : har_num
			},
			success:function(data){
				console.log(data);
				for (var i in data){
					mon = data[i].mon;
					tue = data[i].tue;
					wed = data[i].wed;
					thu = data[i].thu;
					fri = data[i].fri;
					sat = data[i].sat;
					sun = data[i].sun;
					
				}
				mon = parseInt(mon);
				tue = parseInt(tue);
				wed = parseInt(wed);
				thu = parseInt(thu);
				fri = parseInt(fri);
				sat = parseInt(sat);
				sun = parseInt(sun);
				
				datePick();    
			}
		});
	}else if(hos_num != null){
		$.ajax({
			url:"checkDayOff2",
			type:"post",
			data:{
				hos_num : hos_num
			},
			success:function(data){
				console.log(data);
				for (var i in data){
					mon = data[i].mon;
					tue = data[i].tue;
					wed = data[i].wed;
					thu = data[i].thu;
					fri = data[i].fri;
					sat = data[i].sat;
					sun = data[i].sun;
					
				}
				mon = parseInt(mon);
				tue = parseInt(tue);
				wed = parseInt(wed);
				thu = parseInt(thu);
				fri = parseInt(fri);
				sat = parseInt(sat);
				sun = parseInt(sun);
				
				datePick();    
			}
		});
	}
      
});



function datePick(){
	$("#calendar").datepicker({
	    dateFormat: 'yy-mm-dd' //Input Display Format 변경         
	    ,prevText: '이전 달'
	    ,nextText: '다음 달'	
	    ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
	    ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
	    ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
	    ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
	   	,showMonthAfterYear : true
		,beforeShowDay: function(date){//선택 불가능한 요일 설정 0 : 일요일 ~ 6 : 토요일
			var day = date.getDay();
			return [(day != mon && day != tue && day != wed && day != thu && day != fri && day != sat && day != sun)];
		}	
	   	,yearSuffix: '년'
		,minDate: "+1D" //최소 선택일자(sysdate)
	    ,maxDate: "+1M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
		,onSelect: function(dateText, inst) {
	        var date = $(this).val();
	        $(".choose_date").css("display","block");
	        $("#choDate").val(date).change();
   
	   }

	}); 
	//초기값을 오늘 날짜로 설정
	$('#calendar').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후) 
}


