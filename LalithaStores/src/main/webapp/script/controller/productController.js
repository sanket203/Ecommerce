app.controller("productController", function($scope, $rootScope, FormValidationService) {

	$scope.productBlock = false;
	$scope.addBtnBlock = false;
	$scope.ProductDetail={};
	$scope.categoryId = "";

	
	$scope.showSimpleToast = function(msg) {
		var x = document.getElementById("toast");
		x.className = "show";
		x.innerText = msg;
		setTimeout(function() {
			x.className = x.className.replace("show", "");
		}, 3000);
	};

	$scope.formValidation = function(formId){
		return FormValidationService.validateForm(formId);
	}
	
	// get Category
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

	// add category
	$scope.addCategory = function() {
		var requestData = {
			categoryName : $('#cName').val(),
			description : $('#cDescription').val(),
			addedBy :  $rootScope.currentUserName
		};

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "addCategory.htm",
			dataType : "json",
			data : JSON.stringify(requestData),
			success : function(data) {
				if(data.status=="500"){$("#errorFlag").val(true);}
				else{$("#errorFlag").val(false);}
				debugger;
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

	// get product
	$scope.getProduct = function(categoryId) {

		$scope.categoryId = categoryId;
		if ($scope.categoryId != 0) {
			$scope.addBtnBlock = true;
		}
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
				if ($scope.products.length > 0) {
					$scope.productBlock = true;
				} else {
					$scope.productBlock = false;
					$scope.showSimpleToast("No product found");
				}
				$rootScope.$digest();
			},
			error : function(e) {
				console.log("ERROR: ", e);
				$scope.showSimpleToast(e.message);
			}
		});
	};

	
	$scope.storeProductData = function(formId){
		if($scope.formValidation(formId))
		{
			$scope.ProductDetail = {
					productName : $('.modal-body #add_pName').val(),
					description : $('.modal-body #add_pDescription').val(),
					categoryId : $scope.categoryId,
					price : $('.modal-body #add_pPrice').val(),
					quantity : $('.modal-body #add_pQuantity').val(),
					quantityStock : $('.modal-body #add_pQuantityStock').val(),
					productActive : $(".modal-body #add_pStatus")[0].checked,
					productLocation : $('.modal-body #add_pLocations').val(),
					tags : $('.modal-body #add_pTags').val(),
					addedBy : $rootScope.currentUserName,
					defaultImage:""
				};
			$("#addProductScreen1").hide(1000);
			$("#addProductScreen2").show(1000);
		}
	};
	
	// add product
	$scope.saveProduct = function(formId){
		if($scope.formValidation(formId))
		{
			debugger;
			$scope.productJson = $scope.ProductDetail;
			$scope.productJson.defaultImage=$("input[name='defaultImage']:checked")[0].id.split("_")[2];
			var formData = new FormData();
			formData.append("productJson", JSON.stringify($scope.productJson));
			for(var i=0; i<images.files.length;i++)
			{
				formData.append("imageFile", images.files[i]);
			}			
	
			$.ajax({
				type : "POST",
				processData : false,
				contentType : false,
				enctype : 'multipart/form-data',
				url : "addProduct.htm",
				data : formData,
				success : function(data) {
					debugger;
					$scope.showSimpleToast(data.message);
					$("#addProduct").modal('hide');
					$scope.getProduct($scope.categoryId);
					$rootScope.$digest();
				},
				error : function(e) {
					console.log("ERROR: ", e);
					$("#errorFlag").val(true);
				}
			});
		}
	};

	// edit product
	$scope.editProduct = function() {
		$scope.productJson = {
			productId : $('.modal-body #edit_productId').val(),
			productName : $('.modal-body #edit_pName').val(),
			description : $('.modal-body #edit_pDescription').val(),
			categoryId : $scope.categoryId,
			productActive : $(".modal-body #edit_pStatus")[0].checked,
			quantityWeight : $('.modal-body #edit_pQuantity').val(),
			price : $('.modal-body #edit_pPrice').val(),
			productLocation : $('.modal-body #edit_pLocations').val(),
			tags : $('.modal-body #edit_pTags').val(),
		};

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "updateProducts.htm",
			dataType : "json",
			data : JSON.stringify($scope.productJson),
			success : function(data) {
				$scope.showSimpleToast(data.message);
				$scope.getProduct($scope.categoryId);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				$("#errorFlag").val(true);
			}
		});
	};

	$scope.deleteProduct = function() {
		var product = $("#delete_productId").val();
		var productJson = {
			productId : product,
			categoryId : $scope.categoryId
		};

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "deleteProduct.htm",
			data : JSON.stringify(productJson),
			dataType : "json",
			success : function(data) {
				$scope.getProduct($scope.categoryId);
				$scope.showSimpleToast(data.message);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				$scope.showSimpleToast(e.message);
			}
		});
	};

	$scope.deleteCategory=function(){
		var categoryId = $("#delete_categoryId").val();
		var productJson = {
			categoryId : categoryId
		};

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "deleteCategory.htm",
			data : productJson,
			dataType : "json",
			success : function(data) {
				$scope.getAllCategories();
				$scope.showSimpleToast(data.message);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				$scope.showSimpleToast(e.message);

			}
		});
	};
	$scope.editCategory=function(){
		
	};


});