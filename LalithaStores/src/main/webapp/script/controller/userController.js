﻿app.controller("userController", function($scope, $http, $rootScope, FormValidationService) {

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
	
	$scope.getAllUsers = function() {
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "getAllUsers.htm",
			dataType : "json",
			success : function(data) {
				$scope.currentUser = $rootScope.currentUserEmail;
				$scope.users = data.data;
				$scope.$digest();
			},
			error : function(e) {
				$scope.showSimpleToast(e);
			}
		});
	};

	$scope.addUser = function(userModal) {
		if($scope.formValidation(userModal))
		{
			var requestData = {
				firstName : $(".modal-body #fname").val(),
				lastName : $(".modal-body #lname").val(),
				emailId : $(".modal-body #email").val(),
				contact : $(".modal-body #contact").val(),
				location : $(".modal-body #location").val(),
				roles : $("#permissions").val()
			};
	
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "addUser.htm",
				data : JSON.stringify(requestData),
				dataType : "json",
				success : function(data) {
					$scope.showSimpleToast(data.message);
					if(data.status=="200"){
						$scope.getAllUsers();					
						$(userModal).modal('hide');
						$rootScope.$digest();
					}
				},
				error : function(e) {
					$scope.showSimpleToast(e.message);
				}
			});
		}
	};

	$scope.editUser = function(userModal) {
		if($scope.formValidation(userModal))
		{
			var requestData = {
				firstName : $(".modal-body #edit_fname").val(),
				lastName : $(".modal-body #edit_lname").val(),
				emailId : $(".modal-body #edit_email").val(),
				contact : $(".modal-body #edit_contact").val(),
				status : $(".modal-body #edit_user")[0].checked ? 1 : 0,
				location : $(".modal-body #edit_location").val(),
				roles : $("#edit_permissions").val()
			};
	
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "updateUser.htm",
				data : JSON.stringify(requestData),
				dataType : "json",
				success : function(data) {
					$scope.showSimpleToast(data.message);
					if(data.status=="200"){
						$scope.getAllUsers();
						$(userModal).modal('hide');
						$rootScope.$digest();
					}
				},
				error : function(e) {
					console.log("ERROR: ", e);
					$scope.showSimpleToast(e.message);
				}
			});
		}
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
