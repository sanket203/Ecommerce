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
	
	$scope.getAllProducts = function(categoryId) {
		
		var requestParam = {
				categoryId : categoryId
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

	}
	
	;
		
	$scope.navigateWithProductAndCategoryId = function(cid, pid) {
		CategoryAndProductIdService.setCategoryId(cid);
		CategoryAndProductIdService.setProductId(pid);
	};
	
	"images/asus.jpg"
	"images/nexus.jpg"
	"images/samsung.jpg"
	"images/LgTV.jpg"

	$scope.products = [ {
		Id : 101,
		Name : "Bata Shoe",
		Price : 123.00,
		Image : "images/asus.jpg"
	}, {
		Id : 102,
		Name : "Redtape Shoe",
		Price : 123.00,
		Image : "images/nexus.jpg"

	}, {
		Id : 103,
		Name : "Woodland Shoe",
		Price : 123.00,
		Image : "images/asus.jpg"

	}, {
		Id : 104,
		Name : "Lee Cooper Shoe",
		Price : 123.00,
		Image : "images/nexus.jpg"

	}, {
		Id : 101,
		Name : "Bata Shoe",
		Price : 123.00,
		Image : "images/asus.jpg"
	}, {
		Id : 102,
		Name : "Redtape Shoe",
		Price : 123.00,
		Image : "images/samsung.jpg"

	}, {
		Id : 103,
		Name : "Woodland Shoe",
		Price : 123.00,
		Image : "images/nia.png"

	}, {
		Id : 104,
		Name : "Lee Cooper Shoe",
		Price : 123.00,
		Image : "images/samsung.jpg"

	} ];

});