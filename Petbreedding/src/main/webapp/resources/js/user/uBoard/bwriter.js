/**
 * 
 */
//CKEDITOR.instances.editor.getData();
ClassicEditor
.create( document.querySelector( '#editor' ), {
	cloudServices: {
		uploadUrl: 'https://81683.cke-cs.com/easyimage/upload/',
		tokenUrl: "https://81683.cke-cs.com/token/dev/257c3679671be1fe578579914bcdfe4a6ff64cef58f14d2780b701e3c7d1"
	},
} )
.catch( error => {
    console.error( error );
} );

$("#successbtn").on("click",function(){
	var setForm = $("#editor").text();
});

$("#browseBtn").on("click",function(){
	history.back();
});