<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Admin</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="<c:url value="/font/bootstrap-glyphicons.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/style/bootstrap.min.css"/>" rel="stylesheet"
	type="text/css">
<link href="<c:url value="/style/bootstrap-multiselect.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/style/simple-sidebar.css"/>" rel="stylesheet"
	type="text/css">
<link href="<c:url value="/style/ng-tags-input.min.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/style/ng-tags-input.bootstrap.min.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/style/bootstrap-toggle.min.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/style/angular-material.min.css"/>"
	rel="stylesheet" type="text/css">


<script type="text/javascript"
	src="<c:url value="/script/utilities/jquery.min.js"/>" defer="true"></script>
<script type="text/javascript"
	src="<c:url value="/script/utilities/bootstrap-3.1.1.min.js"/>" defer="true"></script>
<script type="text/javascript"
	src="<c:url value="/script/utilities/angular.js"/>" defer="true"></script>
<script type="text/javascript"
	src="<c:url value="/script/utilities/angular-route.js"/>" defer="true"></script>
<script type="text/javascript"
	src="<c:url value="/script/utilities/angular-ui-router.js"/>"
	defer="true"></script>
<script type="text/javascript"
	src="<c:url value="/script/utilities/ui-bootstrap-tpls-2.4.0.js"/>"
	defer="true"></script>
<script type="text/javascript"
	src="<c:url value="/script/utilities/bootstrap-multiselect.min.js"/>"
	defer="true"></script>
<script type="text/javascript"
	src="<c:url value="/script/utilities/ng-tags-input.min.js"/>"
	defer="true"></script>
<script type="text/javascript"
	src="<c:url value="/script/utilities/bootstrap-toggle.min.js"/>"
	defer="true"></script>
<script type="text/javascript"
	src="<c:url value="/script/utilities/angular-material.min.js"/>"
	defer="true"></script>
<script type="text/javascript"
	src="<c:url value="/script/utilities/angular-animate.min.js"/>"
	defer="true"></script>
<script type="text/javascript"
	src="<c:url value="/script/utilities/angular-aria.min.js"/>"
	defer="true"></script>

<script type="text/javascript" src="<c:url value="/script/app.js"/>"
	defer="true"></script>
<script type="text/javascript"
	src="<c:url value="/script/controller/adminController.js"/>"
	defer="true"></script>
<script type="text/javascript"
	src="<c:url value="/script/controller/dashboardController.js"/>"
	defer="true"></script>
<script type="text/javascript"
	src="<c:url value="/script/controller/userController.js"/>"
	defer="true"></script>
<script type="text/javascript"
	src="<c:url value="/script/controller/productController.js"/>"
	defer="true"></script>
<script type="text/javascript"
	src="<c:url value="/script/controller/orderController.js"/>"
	defer="true"></script>

</head>

<body ng-app="StoreApp" class="container" ng-controller="adminController">
	<script type="text/javascript">
		var redirected = "dashboard";
		var hashtag = window.location.hash.substr(1);
		if (redirected != "") {
			var redirectedtag = '/' + redirected;
			if (hashtag == "") {
				var redirected = "#/" + "dashboard";
				var url = window.location.href;
				url = url + redirected;
				window.location.href = url;
			}
		}
	</script>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Lalitha Store</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="#">Admin</a></li>
				<li> <a href="<c:url value="/logout" />"><span class="glyphicon glyphicon-log-in"></span>
						Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="well  nav nav-justified" role="group">
		<div style="text-align: -webkit-center;">
			<a type="button" class="btn btn-lg btn-default" ng-href="#/dashboard">DASHBOARD</a>
			<a type="button" class="btn btn-lg btn-default" ng-href="#/user">USER MANAGEMENT</a> 
			<a type="button" class="btn btn-lg btn-default" ng-href="#/product">PRODUCT MANAGEMENT</a> 
			<a type="button" class="btn btn-lg btn-default" ng-href="#/order">ORDER MANAGEMENT</a>
		</div>
		<div>
			<div id="toast"></div>
			<hr/>
		</div>
		<div ui-view=""></div>
	</div>
</body>
</html>