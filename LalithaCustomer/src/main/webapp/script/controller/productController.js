app.controller("productController", function($scope, $rootScope) {

	$scope.categoryId = "";

	$scope.getAllCategories = function() {
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "getCategories.htm",
			dataType : "json",
			success : function(data) {
				$scope.categories = data.data;
				$rootScope.$digest();
				$rootScope.Message = data.message;
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
	};

	$scope.addCategory = function() {
		var requestData = {
			categoryName : $('#cName').val(),
			description : $('#cDescription').val(),
			addedBy : 'admin'
		};

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "addCategory.htm",
			dataType : "json",
			data : JSON.stringify(requestData),
			success : function(data) {
				$scope.getAllCategories();
				$rootScope.Message = data.message;
				$rootScope.$digest();
			},
			error : function(e) {

				$rootScope.Message = data.message;
				console.log("ERROR: ", e);
			}
		});
	};

	// edit_pName
	// edit_pDescription
	// edit_pPrice
	// edit_pQuantity
	// edit_pStatus
	// edit_pLocations
	// edit_pTags
	// categoryId: 1
	// creationDate: 1486798598000
	// description: "Samsung"
	// modificationDate: 1486798552000
	// price: "15000"
	// productActive: true
	// productId: 2
	// productLocation: "Delhi"
	// productName: "Note 5"
	// quantityWeight: "200 gm"
	// tags: "note"

	$scope.getProduct = function(categoryId) {
		$scope.categoryId = categoryId;
		var requestData = {
			'categoryId' : $scope.categoryId
		};

		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "getProducts.htm",
			data : requestData,
			dataType : "json",
			success : function(data) {
				debugger;
				$scope.products = data.data;
				$rootScope.$digest();
			},
			error : function(e) {

				console.log("ERROR: ", e);
			}
		});
	};

	$scope.saveProduct = function() {
		var status;
		var tags;
		for (var i = 0; i < $scope.add_pTags.length; i++) {
			tags += $scope.add_pTags[i].text + ",";
		}

		if ($('.modal-body #add_pStatus').val() == "on") {
			status = true;
		} else {
			status = false;
		}

		$scope.productJson = {
			'productName' : $('.modal-body #add_pName').val(),
			'description' : $('.modal-body #add_pDescription').val(),
			// 'categoryId' : $scope.categoryId,
			'categoryId' : $scope.categoryId,
			'productActive' : status,
			'price' : $('.modal-body #add_pPrice').val(),
			'productLocation' : $('.modal-body #add_pLocations').val(),
			'tags' : tags
		};
		var formData = new FormData();
		formData.append("productJson", JSON.stringify($scope.productJson));
		formData.append("imageFile", imageFile.files[0]);

		$.ajax({
			type : "POST",
			processData : false,
			contentType : false,
			enctype : 'multipart/form-data',
			url : "addProduct.htm",
			data : formData,
			success : function(data) {
				$rootScope.Message = data.message;
				$scope.getProduct($scope.categoryId);
				$rootScope.$digest();
			},
			error : function(e) {

				console.log("ERROR: ", e);
			}
		});
	};

	$scope.editProduct = function() {
		debugger;
		if ($('.modal-body #edit_pStatus').val() == "on") {
			status = true;
		} else {
			status = false;
		}
		$scope.productJson = {
			'productId' : $('.modal-body #edit_productId').val(),
			'productName' : $('.modal-body #edit_pName').val(),
			'description' : $('.modal-body #edit_pDescription').val(),
			'categoryId' : $scope.categoryId,
			'productActive' : status,
			'quantityWeight' : $('.modal-body #edit_pQuantity').val(),
			'price' : $('.modal-body #edit_pPrice').val(),
			'productLocation' : $('.modal-body #edit_pLocations').val(),
			'tags' : $('.modal-body #edit_pTags').val(),
		};

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "updateProducts.htm",
			dataType : "json",
			data : JSON.stringify($scope.productJson),
			success : function(data) {
				alert(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				// display(e);
			}
		});
	};

});