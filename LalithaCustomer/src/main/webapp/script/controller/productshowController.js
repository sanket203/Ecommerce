app.controller("productshowController", function($scope, $http, CategoryAndProductIdService) {
	debugger;

	var requestParam = {
		categoryId : CategoryAndProductIdService.getCategoryId(),
		productId : CategoryAndProductIdService.getProductId()
	};

	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getSingleProduct.htm",
		data : requestParam,
		dataType : "json",
		success : function(data) {
			debugger;
			$scope.product = data.data;
			$scope.$digest();
			$('.flexslider').flexslider({
			animation : "slide",
			controlNav : "thumbnails"
		});
				},
		error : function(e) {
			debugger;
			console.log("ERROR: ", e);
		}
	});
	
	
});
