app.controller("adminController", function ($scope, $location,$rootScope) {
	
    $scope.setUserId = function(name,id){
	$rootScope.currentUserName = name;
	$rootScope.currentUserId = id;
	};
});