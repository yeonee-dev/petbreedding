$(".title").on("click",function(){
	var content = $(this).next();
	var up = $(this).find('span.up');
	var down = $(this).find('span.down');
	if(content.is(":visible")){
		content.css("display", "none");
		up.css("display","none");
		down.css("display","block");
	}else{
		content.css("display","block");
		up.css("display","block");
		down.css("display","none");
	}
});
