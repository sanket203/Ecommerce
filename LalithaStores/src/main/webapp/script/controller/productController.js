app.controller("productController", function($scope, $rootScope) {

	$scope.productBlock=false;
	
	$scope.showSimpleToast = function(msg) {
		var x = document.getElementById("toast");
		x.className = "show";
		x.innerText = msg;
		setTimeout(function() {
			x.className = x.className.replace("show", "");
		}, 3000);
	};

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
				$scope.showSimpleToast(data.message);
				$rootScope.$digest();
			},
			error : function(e) {
				$scope.showSimpleToast(data.message);
				console.log("ERROR: ", e);
			}
		});
	};

	$scope.getProduct = function(categoryId) {
		
		$scope.productBlock=true;
		
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
		var tags="";
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
			'quantityWeight' : $('.modal-body #add_pQuantity').val(),
			'categoryId' : $scope.categoryId,
			'productActive' : status,
			'price' : $('.modal-body #add_pPrice').val(),
			'productLocation' : $('.modal-body #add_pLocations').val(),
			'tags' : tags,
			'addedBy' : 'Sumant'
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
				$scope.showSimpleToast(data.message);
				$scope.getProduct($scope.categoryId);
				$rootScope.$digest();
			},
			error : function(e) {

				console.log("ERROR: ", e);
			}
		});
	};

	$scope.editProduct = function() {
		if ($('.modal-body #edit_pStatus').val() == "on") {
			status = true;
		} else {
			status = false;
		}
		$scope.productJson = {
			'productId' : $('.modal-body #edit_productId').val(),
			'productName' : $('.modal-body #edit_pName').val(),
			'description' : $('.modal-body #edit_pDescription').val(),
		
			'productActive' : status,
			'quantityWeight' : $('.modal-body #edit_pQuantity').val(),
			'price' : $('.modal-body #edit_pPrice').val(),
			'productLocation' : $('.modal-body #edit_pLocations').val(),
			'quantityWeight': $('.modal-body #edit_pQuantityWeight').val()
			//'tags' : tags
		};

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "updateProducts.htm",
			dataType : "json",
			data : JSON.stringify($scope.productJson),
			success : function(data) {
				$scope.showSimpleToast(data.message);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
	}
	
	$scope.deleteProduct = function() {
		var product = $("#delete_productId").val();
		var productJson = {
			productId : product,
			categoryId: $scope.categoryId
		};
        alert(JSON.stringify(productJson));
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "deleteProduct.htm",
			data : JSON.stringify(productJson),
			dataType : "json",
			success : function(data) {
				$scope.getAllUsers();
				$rootScope.Message = data.message;
				$rootScope.$digest();
			},
			error : function(e) {
				console.log("ERROR: ", e);
				alert(e);
			}
		});
	};

});