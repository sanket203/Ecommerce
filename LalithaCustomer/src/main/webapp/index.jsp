<!DOCTYPE HTML>
<html>
<head>

<title>Lalitha Store</title>

<link href="font/bootstrap-glyphicons.css" rel="stylesheet" type="text/css">
<link href="style/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="style/bootstrap-multiselect.css" rel="stylesheet" type="text/css">
<link href="style/simple-sidebar.css" rel="stylesheet" type="text/css">
<link href="style/ng-tags-input.min.css" rel="stylesheet" type="text/css">
<link href="style/ng-tags-input.bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="style/bootstrap-toggle.min.css" rel="stylesheet" type="text/css">
<link href="style/style.css" rel="stylesheet" type="text/css">
<link href="style/owl.carousel.css" rel="stylesheet" type="text/css">
<link href="style/form.css" rel="stylesheet" type="text/css" media="all" />
<link href="style/flexslider.css" rel="stylesheet" type="text/css" media="all" />

<script type="text/javascript" src="script/utilities/jquery.min.js"></script>
<script type="text/javascript" src="script/utilities/bootstrap-3.1.1.min.js"></script>
<script type="text/javascript" src="script/utilities/angular.js"></script>
<script type="text/javascript" src="script/utilities/angular-route.js"></script>
<script type="text/javascript" src="script/utilities/angular-ui-router.js"></script>
<script type="text/javascript" src="script/utilities/ui-bootstrap-tpls-2.4.0.js"></script>
<script type="text/javascript" src="script/utilities/bootstrap-multiselect.min.js"></script>
<script type="text/javascript" src="script/utilities/ng-tags-input.min.js"></script>
<script type="text/javascript" src="script/utilities/bootstrap-toggle.min.js"></script>
<script type="text/javascript" src="script/utilities/classie.js"></script>
<script type="text/javascript" src="script/utilities/uisearch.js"></script>
<script type="text/javascript" src="script/utilities/simpleCart.min.js"></script>
<script type="text/javascript" src="script/utilities/owl.carousel.js"></script>
<script type="text/javascript" src="script/utilities/jquery.jscrollpane.min.js"></script>
<script type="text/javascript" src="script/utilities/jquery.mousewheel.js"></script>
<script type="text/javascript" src="script/utilities/jquery.flexslider.js"></script>

<script type="text/javascript" src="script/app.js"></script>
<script type="text/javascript" src="script/controller/masterController.js"></script>
<script type="text/javascript" src="script/controller/homeController.js"></script>
<script type="text/javascript" src="script/controller/loginController.js"></script>
<script type="text/javascript" src="script/controller/productlistController.js"></script>
<script type="text/javascript" src="script/controller/productshowController.js"></script>

<script type="text/javascript" id="sourcecode">
	$(function() {
		$('.scroll-pane').jScrollPane();
	});

	$(window).load(function() {
		$('.flexslider').flexslider({
			animation : "slide",
			controlNav : "thumbnails"
		});
	});
</script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Swim Wear Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />

<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>

</head>

<body ng-app="StoreApp" ng-controller="masterController" ng-init="getAllCategories();">

	<script type="text/javascript">
		var redirected = "home";
		var hashtag = window.location.hash.substr(1);
		if (redirected != "") {
			var redirectedtag = '/' + redirected;
			if (hashtag == "") {
				var redirected = "#/" + "home";
				var url = window.location.href;
				url = url + redirected;
				window.location.href = url;
			}
		}
	</script>
	
	<!--header-->
	<div class="header">
		<div class="header-top">
			<div class="container">
				<div class="top-right">
					<ul>
						<li class="text"><a ng-href="#/login">login</a></li>
						<li class="text"><a ng-href="#/account">signup</a></li>
						<li class="text">
							<a href="checkout.html"> 
								<img src="images/shopping-cart.png" style="width:20px"/>
								<span class="badge">0</span>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="header-bottom">
			<div class="container">
				<div class="content white">
					<nav class="navbar navbar-default" role="navigation">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse"
								data-target="#bs-example-navbar-collapse-1">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<h1 class="navbar-brand">
								<a href="#/home">Lalitha Store</a>
							</h1>
						</div>

						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li ng-repeat="category in categories | limitTo: 4"><a
									ng-href="#/productlist"
									ng-click="getAllProducts(category.categoryId, 0)">{{category.categoryName}}</a>
								</li>

								<li class="dropdown"><a href="" class="dropdown-toggle"
									data-toggle="dropdown">more <b class="caret"></b></a>
									<ul class="dropdown-menu multi-column columns-1">
										<div class="row">
											<div class="col-sm-6">
												<ul class="multi-column-dropdown">
													<li ng-repeat="category in categories" ng-if="$index >= 4">
														<a ng-href="#/productlist"
														ng-click="getAllProducts(category.categoryId, 0)">{{category.categoryName}}</a>
													</li>
												</ul>
											</div>
										</div>
									</ul></li>
							</ul>
						</div>
					</nav>
				</div>

				<div class="search-box">
					<div id="sb-search" class="sb-search">
						<form>
							<input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search"> 
							<input class="sb-search-submit" type="submit" value=""> 
							<span class="sb-icon-search"> </span>
						</form>
					</div>
				</div>

				<!-- search-scripts -->
				<script>
					new UISearch(document.getElementById('sb-search'));
				</script>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--header-->
	
	<!--content-->
	<div ui-view=""></div>
	<!--content-->

	<!--footer-->
	<div class="footer-section">
		<div class="container">
			<div class="footer-grids">
				<div class="col-md-2 footer-grid">
					<h4>company</h4>
					<ul>
						<li><a href="products.html">products</a></li>
						<li><a href="#">Work Here</a></li>
						<li><a href="#">Team</a></li>
						<li><a href="#">Happenings</a></li>
						<li><a href="#">Dealer Locator</a></li>
					</ul>
				</div>
				<div class="col-md-2 footer-grid">
					<h4>service</h4>
					<ul>
						<li><a href="#">Support</a></li>
						<li><a href="#">FAQ</a></li>
						<li><a href="#">Warranty</a></li>
						<li><a href="contact.html">Contact Us</a></li>
					</ul>
				</div>
				<div class="col-md-2 footer-grid">
					<h4>order & returns</h4>
					<ul>
						<li><a href="#">Order Status</a></li>
						<li><a href="#">Shipping Policy</a></li>
						<li><a href="#">Return Policy</a></li>
						<li><a href="#">Digital Gift Card</a></li>
					</ul>
				</div>
				<div class="col-md-2 footer-grid">
					<h4>legal</h4>
					<ul>
						<li><a href="#">Privacy</a></li>
						<li><a href="#">Terms and Conditions</a></li>
						<li><a href="#">Social Responsibility</a></li>
					</ul>
				</div>
				<div class="col-md-4 footer-grid1">
					<div class="social-icons">
						<a href="#"><i class="icon"></i></a> <a href="#"><i
							class="icon1"></i></a> <a href="#"><i class="icon2"></i></a> <a
							href="#"><i class="icon3"></i></a> <a href="#"><i
							class="icon4"></i></a>
					</div>
					<p>Copyright &copy; 2017 Lalitha Store. All rights reserved</p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--footer-->

</body>
</html>