app.controller("productlistController", function($scope, CategoryAndProductIdService) {
	debugger;
	$scope.navigateWithProductAndCategoryId = function(cid, pid) {
		CategoryAndProductIdService.setCategoryId(cid);
		CategoryAndProductIdService.setProductId(pid);
	};

	var requestParam = {
		categoryId : CategoryAndProductIdService.getCategoryId()
	};

	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getProducts.htm",
		data : requestParam,
		dataType : "json",
		success : function(data) {
			debugger;
			$scope.productlist = data.data;
			$scope.$digest();
		},
		error : function(e) {
			debugger;
			console.log("ERROR: ", e);
		}
	});

});