
var url  = "";

 $('button[id*="btn_"]').click(function(){
	 
	 
	 var msg  =  $(this).attr("text-msg");
	 /*
	  * Recuperando o Host name do Servidor
	  */
	 var hostname = location.hostname;
	 	 
		 url  = "http://"+hostname+(hostname == "localhost" ? ":8080/":"/")+$(this).attr("id").split("_")[1]; 
	 /*
	  * Adicionando Mensagem no modal 
	  */
	 $(".text-msg").html(msg); 
 });
 
 
 $(".btn-confirm").click(function(){
	 
	 document.location.href = url;
	 
 });
 
 


