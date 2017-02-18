app.controller("masterController", function($scope, $rootScope, CategoryAndProductIdService) {
	
	$scope.getAllCategories = function() {
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "getAllCategories.htm",
			dataType : "json",
			success : function(data) {
				debugger;
				$scope.categories = data.data;
				$rootScope.$digest();
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
	};
		
	$scope.navigateWithProductAndCategoryId = function(cid, pid) {
		CategoryAndProductIdService.setCategoryId(cid);
		CategoryAndProductIdService.setProductId(pid);
	};

	$scope.products = [ {
		Id : 101,
		Name : "Bata Shoe",
		Price : 123.00,
		Image : "images/nia.png"
	}, {
		Id : 102,
		Name : "Redtape Shoe",
		Price : 123.00,
		Image : "images/nia.png"

	}, {
		Id : 103,
		Name : "Woodland Shoe",
		Price : 123.00,
		Image : "images/nia.png"

	}, {
		Id : 104,
		Name : "Lee Cooper Shoe",
		Price : 123.00,
		Image : "images/nia.png"

	}, {
		Id : 101,
		Name : "Bata Shoe",
		Price : 123.00,
		Image : "images/nia.png"
	}, {
		Id : 102,
		Name : "Redtape Shoe",
		Price : 123.00,
		Image : "images/nia.png"

	}, {
		Id : 103,
		Name : "Woodland Shoe",
		Price : 123.00,
		Image : "images/nia.png"

	}, {
		Id : 104,
		Name : "Lee Cooper Shoe",
		Price : 123.00,
		Image : "images/nia.png"

	} ];

});