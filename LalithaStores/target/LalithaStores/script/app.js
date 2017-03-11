var app = angular.module('StoreApp', ['ui.router', 'ui.bootstrap']);

app.directive("addbuttonsbutton", function(){
	return {
		restrict: "E",
		template: "<div class='btn btn-default' style='float:right;' addbuttons>Click to add variants</div>"
	}
});

app.directive('addvariant', function() {
	  return {
	    restrict: 'A',
	    template: '<div class="well col-lg-12">'+
			'<div class="dropdown col-lg-2">'+
	    	'	<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">'+
	    	'		 Options<span class="caret"></span>'+
	    	'	</button>'+
	    	'	<ul class="dropdown-menu">'+
	    	'		<li><a href="">Size</a></li>'+
	    	'		<li><a href="">Weight</a></li>'+
	    	'		<li><a href="">Color</a></li>'+
	    	'	</ul>'+
	    	'</div>'+
	    	'<div class="row col-lg-10">'+
	    	'	<tags-input ng-Model="tags"/>'+
	    	'</div>'+
	    	'</div>'
	  }
	});

app.directive("addbuttons", function($compile){
	return function(scope, element, attrs){
		element.bind("click", function(){
			scope.count++;
			angular.element(document.getElementById('space-for-buttons')).append($compile("<div id='customDir"+scope.count+"' addvariant></div>")(scope));
		});
	};
});

app.config(['$stateProvider','$httpProvider', function ($stateProvider,$httpProvider) {
	
    var blank = {
		url:'',
		templateUrl: '/lalithaAdmin/templates/admin/dashboard.jsp',
        controller: 'dashboardController'		
	},
	dashboard= {
        url: '/dashboard',
        templateUrl: '/lalithaAdmin/templates/admin/dashboard.jsp',
        controller: 'dashboardController'
    },
	product = {
		url:'/product',
		templateUrl:'/lalithaAdmin/templates/admin/product.jsp',
		controller:'productController'
	},
	order = {
		url:'/order',
		templateUrl:'/lalithaAdmin/templates/admin/order.jsp',
		controller:'orderController'
	},
	user = {
		url:'/user',
		templateUrl:'/lalithaAdmin/templates/admin/user.jsp',
		controller:'userController'
	};
	
//Now add these route state provider
    $stateProvider
       .state('blank', blank)
       .state('dashboard', dashboard)
       .state('product', product)
       .state('order', order)
       .state('user', user)
       ;
}]);