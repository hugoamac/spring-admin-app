(function($) {

	console.log("loading upload scripts...");
	
	$("#uploadInfo").hide();
	
	$("#inputFile").on("change",function(){
		
		var inputFile = $(this)[0];
		var file = inputFile.files[0];
		
		$("#uploadInfo").addClass("alert-info").html('<i class="glyphicon glyphicon-file"></i> ' + file.name);
		$("#uploadInfo").show();
	});
	
	$("#myModal").on("hide.bs.modal", function() {
		
		$("#uploadInfo").empty().hide();
		$("#inputFile").val(null);
	});
	

	$("#myModal").on("shown.bs.modal", function() {

		$("#sendFile", this).on("click", function() {

			var inputFile = $("#inputFile")[0];
			var data = new FormData();
			var file = inputFile.files[0];
			
			if (file !== undefined) {

				var fileName = file.name;
				
				data.append("file", file, fileName);

				$.ajax({
					url : "/admin/products/upload",
					type : "post",
					data : data,
					cache : false,
					enctype : "multipart/form-data",
					contentType : false,
					processData : false,
					beforeSend : function(){
						$("#sendFile").hide();
						$("#uploadInfo").addClass("alert-info").html('<i class="glyphicon glyphicon-floppy-save"></i> Importando dados, aguarde...');	
					},
					success : function(data) {
						
						$("#sendFile").show();
						
						console.log("Result upload:", data );
						
						if(data.success === true){
							
							$("#uploadInfo").addClass("alert-info").html('<i class="glyphicon glyphicon-ok"></i> Finalizado.');
							
							setTimeout(function(){ 
								
								$("#myModal").modal("hide");
								
								document.location.reload(true);
								
							}, 1000);
							
						}else{
							
							$("#uploadInfo").addClass("alert-danger").html('<i class="glyphicon glyphicon-warning-sign"></i> Erro ao importar arquivo.');
						}
					},

				});
			}

		});
	});

})(jQuery);
