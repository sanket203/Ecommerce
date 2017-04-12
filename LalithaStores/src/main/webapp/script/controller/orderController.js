app.controller("orderController", function($scope, $rootScope) {

	$scope.showSimpleToast = function(msg) {
		var x = document.getElementById("toast");
		x.className = "show";
		x.innerText = msg;
		setTimeout(function() {
			x.className = x.className.replace("show", "");
		}, 3000);
	};

	$scope.orderId = "";

	$scope.getAllOrders = function() {
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "getAllOrders.htm",
			dataType : "json",
			success : function(data) {
				$scope.orders = data.data;
				$rootScope.$digest();
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
	};

	$scope.getOrderById = function(orderId) {
		debugger;
		$scope.orderId = orderId;
		var requestData = {
			'orderId' : orderId
		};

		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "getOrderById.htm",
			data : requestData,
			dataType : "json",
			success : function(data) {
				$scope.mapOrderToModal(data.data);
				$("#orderViewEdit").modal("show");
				$rootScope.$digest();
			},
			error : function(e) {
				console.log("ERROR: ", e);
				$scope.showSimpleToast(e.message);
			}
		});
	};

	$scope.updateStatus = function() {
		var requestData = {
			'orderId' : $scope.orderId,
			'orderStatus' : $("#orderStatus").val()
		};

		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "updateStatus.htm",
			data : requestData,
			dataType : "json",
			success : function(data) {
				$scope.showSimpleToast(data.message);
				if(data.status=="200"){
					$scope.getAllOrders();
					$rootScope.$digest();
				}
			},
			error : function(e) {
				console.log("ERROR: ", e);
				$scope.showSimpleToast(e.message);
			}
		});
	};

	$scope.mapOrderToModal = function(data) {
		// customer details
		$('#orderViewEdit #ocdName').val(data.customer);
		$('#orderViewEdit #ocdContact').val(data.customer);
		var address = data.address.streetAddress + "," + data.address.city
				+ "," + data.address.state + "," + data.address.country + ","
				+ data.address.zipcode;
		$('#orderViewEdit #ocdAddress').val(address);
		
		$('#orderStatus').multiselect('select' , data.status);    
		// product details
		$scope.products = data.products;

		$('#orderViewEdit #opdReferenceNo').val("TYRUYG12312");
		$('#orderViewEdit #opdMode').val("Online" + data.paymentMode);
		$('#orderViewEdit #opdAmount').val(data.totalAmount);
	}

});