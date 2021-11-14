(function($) {
	
	$(document).ready(function(){
		
		
		$("input").on("focus",function(){
			$(this).val("");
		});
		
	});
	
})(jQuery);