app.controller("adminController", function ($scope, $location,$rootScope) {
	
    $scope.setUserId = function(id){
	$rootScope.currentUserId = id;
	};
});