app.controller("userController", function($scope, $http, $rootScope) {

	$scope.showSimpleToast = function(msg) {
		var x = document.getElementById("toast");
		x.className = "show";
		x.innerText = msg;
		setTimeout(function() {
			x.className = x.className.replace("show", "");
		}, 3000);
	};
	
	$scope.getAllUsers = function() {
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "getAllUsers.htm",
			dataType : "json",
			success : function(data) {
				$scope.users = data.data;
				$scope.$digest();
			},
			error : function(e) {
				$scope.showSimpleToast(e);
			}
		});
		console.log(JSON.stringify($scope.users));
	};

	$scope.addUser = function() {
		debugger;
		var fname = $("#fname").val();
		var lname = $("#lname").val();
		var email = $("#email").val();
		var contact = $("#contact").val();
		var location = $("#location").val();
		var permissions = $("#permissions").val();

		var requestData = {
			firstName : fname,
			lastName : lname,
			emailId : email,
			contact : contact,
			location : location,
			password : "123456",
		// Permissions : permissions
		};

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "addUser.htm",
			data : JSON.stringify(requestData),
			dataType : "json",
			success : function(data) {
				debugger;
				$scope.getAllUsers();
				$scope.showSimpleToast(data.message);
				$rootScope.$digest();
			},
			error : function(e) {
				console.log("ERROR: ", e);
				// display(e);
			}
		});
	};

	$scope.editUser = function() {
		debugger;
		var fname = $("#edit_fname").val();
		var lname = $("#edit_lname").val();
		var email = $("#edit_email").val();
		var contact = $("#edit_contact").val();
		var location = $("#edit_location").val();
		// var permissions = $("#edit_permissions").val();

		var requestData = {
			firstName : fname,
			lastName : lname,
			emailId : email,
			contact : contact,
			status : 1,
			location : location,
		// Permissions : permissions
		};

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "updateUser.htm",
			data : JSON.stringify(requestData),
			dataType : "json",
			success : function(data) {
				$scope.getAllUsers();
				$scope.showSimpleToast(data.message);
				$rootScope.$digest();
			},
			error : function(e) {
				console.log("ERROR: ", e);
				$scope.showSimpleToast(e.message);
			}
		});
	};

	$scope.deleteUser = function() {
		var email = $("#delete_emailId").val();
		var requestData = {
			emailId : email
		};

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "deleteUser.htm",
			data : JSON.stringify(requestData),
			dataType : "json",
			success : function(data) {
				$scope.getAllUsers();
				$scope.showSimpleToast(data.message);
				$rootScope.$digest();
			},
			error : function(e) {
				console.log("ERROR: ", e);
				alert(e);
			}
		});
	};

});
