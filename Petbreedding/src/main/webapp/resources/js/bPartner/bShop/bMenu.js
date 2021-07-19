$(function(){
	
	$("#addItemBtn1").click(function() {
		
		
		var form = '<form  class="newDynamicTable" action="bp/bMenu/write" method="POST">\
				<label><input type="radio" name="style_deep" value="0" >메인</label>\
				<label><input type="radio" name="style_deep" class="next" value="1">서브&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>\
				<input  type="text" placeholder="메뉴" id="menu" name="style_name">\
				<input  type="text" placeholder="가격" id="price" name="price">\
				<input  type="text" placeholder="소요시간" id="time" name="style_time">\
				<button type="submit" class="basicBtn okBtn" >완료</button>\
				</form>';
		
		$(".insert").prepend (
				form
		)
	});
	
	$("#addItemBtn2").click(function() {
		
		
		var form = '<form class="newDynamicTable" action="bp/bMenu/write" method="POST">\
			<input type="text" placeholder="진료명" id="medName" name="medName">\
			<input type="text" placeholder="가격" id="medPrice" name="medPrice">\
			<button type="submit" class="basicBtn medOkBtn">완료</button>\
			</form>';
		
		$(".medInsert").prepend (
				form
		)
	});
	

		// 메뉴 삭제 모달
	$(".delBtns").on("click", function() {

		$("#modalC").css("display", "block");


		var frm = $(this).parents(".dynamicTable");
		console.log(frm);
		var frmdata = frm.serialize();
		console.log(frmdata);
		
		$("#yes").on("click", function() {
			
			$.ajax({
				url : 'bp/bMenu/delete', // <<-- 처리 요청 URL
				type : 'post',
				dataType : "text",
				data : frmdata,
				success : function(data) {
		            console.log(data);
		            $("#modalC").css("display", "none");
		            location.href = "/petbreedding/bMenu";
		        },
			});
		});

		$("#no").on("click", function() {
			$("#modalC").css("display", "none");
		});

	});
		

		
});

