$("li a").click(function(event){
	event.preventDefault();

	if($(this).data("seleccion")!=null){
		$("#cont").load($(this).data("seleccion")+".jsp");
     
	}
});

$("div button").click(function(event){
	event.preventDefault();

	if($(this).data("seleccion")!=null){
		$("#section").load($(this).data("seleccion")+".jsp");
     
	}
});

$(".selec").click(function(event){
	event.preventDefault();

	if($(this).data("seleccion")!=null){
		$("#conten_dir_integr").load($(this).data("seleccion")+".jsp");
     
	}
});






 