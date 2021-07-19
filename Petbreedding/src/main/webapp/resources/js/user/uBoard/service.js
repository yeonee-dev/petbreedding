$(document).ready(function() {
$(".que").click(function() {
    $(this).next(".anw").stop().slideToggle(300);
   $(this).toggleClass('on').siblings().removeClass('on');
   $(this).next(".anw").siblings(".anw").slideUp(300); // 1개씩 펼치기
 });


 $(".que2").click(function() {
    $(this).next(".anw2").stop().slideToggle(300);
   $(this).toggleClass('on').siblings().removeClass('on');
   $(this).next(".anw2").siblings(".anw2").slideUp(300); // 1개씩 펼치기
 });
});

// myboard 전체선택
function selectAll(selectAll)  {
    const checkboxes = document.getElementsByName('board');
    checkboxes.forEach((checkbox) => {
      checkbox.checked = selectAll.checked;
    });
  }

//boardDetail로 이동
$(".goDetail").on("click",function(){
	var boNum = $(this).prev().find('input').val();
	location.href = "fboardcon?boNum="+boNum+"";
});

//댓글삭제 눌렀을때 
$("#deleteCM").on("click",function(){
	var arr = [];
	$("input[name=board]:checked").each(function(item){
		arr.push($(this).val());
	});
	var allData = {"coNum" : arr};
	$.ajax({
		url : "mycdelete",
		type : "POST",
		data : {arr : arr},
		success : function(data){
			if(data > 0){
				alert("댓글이 삭제되었습니다.");
				location.reload();
			}else{
				alert("댓글삭제 오류");
			}
		},
		error: function(){
			console.log("에러");
		}
		
	});
});

//글삭제 눌렀을때 
$("#deleteBoard").on("click",function(){
	var arr = [];
	$("input[name=board]:checked").each(function(item){
		arr.push($(this).val());
	});
	var allData = {"coNum" : arr};
	$.ajax({
		url : "myBoarddelete",
		type : "POST",
		data : {arr : arr},
		success : function(data){
			if(data > 0){
				alert("글이 삭제되었습니다.");
				location.reload();
			}else{
				alert("글삭제 오류");
			}
		},
		error: function(){
			console.log("에러");
		}
		
	});
});

// bmenu
function tableCreate(){
	  var tc = new Array();
	  var html = '';
	        
	  var menu = $("#menu").val();
	  var price = $("#price").val();
	        
	  html += '<tr>';
	  html += '<td>'+menu+'</td>';
	  html += '<td>'+price+'</td>';
	 
	  html += '</tr>';
	        
	  $("#dynamicTable").append(html);
	        
	  $("#menu").val('');
	  $("#price").val('');
	  }

	  function tableDelete(){
	    $('#dynamicTable tbody tr:last').remove();
	    }