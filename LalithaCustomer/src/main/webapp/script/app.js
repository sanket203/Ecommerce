var app = angular.module('StoreApp', [ 'ui.router', 'ui.bootstrap', 'ngTagsInput' ]);
//₹

app.service("CategoryAndProductIdService",function(){
	this.categoryId=0;
	this.productId=0;
	this.getCategoryId=function(){
		return this.categoryId;
	};
	this.setCategoryId=function(cid){
		this.categoryId=cid;
	};
	this.getProductId=function(){
		return this.productId;
	};
	this.setProductId=function(pid){
		this.productId=pid;
	};
});

app.config([
		'$stateProvider',
		'$httpProvider',
		function($stateProvider, $httpProvider) {
			var blank = {
				url : '',
				templateUrl : '/LalithaCustomer/templates/customer/home.jsp',
				controller : 'masterController'
			}, home = {
				url : '/home',
				templateUrl : '/LalithaCustomer/templates/customer/home.jsp',
				controller : 'masterController'
			}, login = {
					url : '/login',
					templateUrl : '/LalithaCustomer/templates/customer/login.jsp',
					controller : 'loginController'
			}, account = {
					url : '/account',
					templateUrl : '/LalithaCustomer/templates/customer/account.jsp',
					controller : 'accountController'
			}, productlist = {
				url : '/productlist',
				templateUrl : '/LalithaCustomer/templates/customer/productlist.jsp',
				controller : 'masterController'
			}, productshow = {
				url : '/productshow',
				templateUrl : '/LalithaCustomer/templates/customer/productshow.jsp',
				controller : 'productshowController'
			};

			// Now add these route state provider
			$stateProvider
			.state('blank', blank)
			.state('home', home)
			.state('login', login)
			.state('account', account)
			.state('productlist', productlist)
			.state('productshow', productshow);
		} ]);