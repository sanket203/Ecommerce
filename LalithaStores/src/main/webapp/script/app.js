var app = angular.module('StoreApp', ['ui.router', 'ui.bootstrap']);

app.service("FormValidationService",function(){
	this.validateForm = function(formId) {
		debugger;
		var textBoxValidation = false;
		var checkBoxValidation = false;
		var radioBtnValidation = false;
		switch(formId){
		case "#addUser" : 
		case "#editUser" : 
			textBoxValidation = this.validateTextboxes(formId);
			checkBoxValidation = this.validateCheckboxes(formId);
			radioBtnValidation = true;
			break;
		case "#addProductScreen1" :
		case "#editProduct" :
			textBoxValidation = this.validateTextboxes(formId);
			checkBoxValidation = true;
			radioBtnValidation = true;
			break;
		case "#addProductScreen2" :
			textBoxValidation = true;
			checkBoxValidation = true;
			radioBtnValidation = this.validateRadioButtons(formId);
			break;	
		}
		
		if (textBoxValidation) 
		{
			if (checkBoxValidation) 
			{
				if (radioBtnValidation) 
				{ 
					return true; 
				}
				else 
				{
					return false;
				}
			} 
			else 
			{
				return false;
			}
		} 
		else 
		{
			return false;
		}
	}

	this.validateTextboxes = function(formId) {
		debugger;
		var valdationFlag = 0;
		var fieldList = $(formId).find('input[type=text]');
		for (var i = 0; i < fieldList.length; i++) {
			if (fieldList[i].id != "") {
				if(fieldList[i].required){
					var elementId = "#" + fieldList[i].id;
					if ($(elementId).val() == "") {
						fieldList[i].placeholder = "*mandatory field";
						$(elementId).css("border-color", "red");
					} else {
						fieldList[i].placeholder = "";
						$(elementId).css("border-color", "#ccc");
						valdationFlag++;
					}
				}
				else{valdationFlag++;}
			}
			else{valdationFlag++;}
		}
		if (valdationFlag == fieldList.length) {
			return true;
		} else
			return false;
	}
	
	this.validateCheckboxes = function(formId) {
		var valdationFlag = 0;
		var fieldList = $(formId).find('input[type=checkbox]');
		for (var i = 0; i < fieldList.length; i++) {
			if (!fieldList[i].checked) {
				valdationFlag++;
			}
		}
		if (formId == "#editUser") {
			valdationFlag++;
		}

		if (valdationFlag == fieldList.length)
		{
			$(".multiselect").css("border-color", "red");
			return false;
		}
		else
		{
			$(".multiselect").css("border-color", "#ccc");
			return true;
		}
	}
	
	this.validateRadioButtons = function(formId){
		var valdationFlag = 0;
		var fieldList = $(formId).find('input[type=radio]');
		for (var i = 0; i < fieldList.length; i++) {
			if (!fieldList[i].checked) {
				valdationFlag++;
			}
		}
		if (valdationFlag == fieldList.length)
		{
			$("#warn").css("color", "red");
			return false;
		}
		else
		{
			return true;
		}
	}
	
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