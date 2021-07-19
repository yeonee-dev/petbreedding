$("#down1").on("click",function(){
   if($("#content1").is(":visible")){ //﻿display 속성이 none이 아닐 경우 true
       $("#content1").css("display","none");
       $("#up1").css("display","none");
       $(this).css("display","block");
   }
   else{  //﻿display 속성이 none일 경우 false
       $("#content1").css("display","block");
       $("#up1").css("display","block");
       $(this).css("display","none");
    }
});

$("#up1").on("click",function(){
	   if($("#content1").is(":visible")){ //﻿display 속성이 none이 아닐 경우 true
	       $("#content1").css("display","none");
	       $("#down1").css("display","block")
	       $(this).css("display","none");
	   }
	   else{  //﻿display 속성이 none일 경우 false
	       $("#content1").css("display","block");
	       $("#down1").css("display","none")
	       $("up1").css("display","block");
	    }
	});

$("#down2").on("click",function(){
	   if($("#content2").is(":visible")){ //﻿display 속성이 none이 아닐 경우 true
	       $("#content2").css("display","none");
	       $("#up2").css("display","none");
	       $(this).css("display","block");
	   }
	   else{  //﻿display 속성이 none일 경우 false
	       $("#content2").css("display","block");
	       $("#up2").css("display","block");
	       $(this).css("display","none");
	    }
	});

	$("#up2").on("click",function(){
		   if($("#content2").is(":visible")){ //﻿display 속성이 none이 아닐 경우 true
		       $("#content2").css("display","none");
		       $("#down2").css("display","block")
		       $(this).css("display","none");
		   }
		   else{  //﻿display 속성이 none일 경우 false
		       $("#content2").css("display","block");
		       $("#down2").css("display","none")
		       $("up2").css("display","block");
		    }
		});