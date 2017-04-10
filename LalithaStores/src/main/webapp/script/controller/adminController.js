app.controller("adminController", function ($scope, $location,$rootScope) {
	
    $scope.setUserId = function(name,id,emailId){
	alert(emailId);
	$rootScope.currentUserName = name;
	$rootScope.currentUserId = id;
	$rootScope.currentUserEmail = emailId ;
	};
});