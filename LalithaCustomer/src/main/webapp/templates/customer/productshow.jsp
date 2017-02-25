<html>
<head>
</head>

<body>


<div class="content">
	<div class="single">
		<div class="container">
			<div class="single-grids">
				<div class="col-md-6 single-grid">
					<div class="flexslider">
						<ul class="slides">
							<li data-thumb="{{product.imageUrl}}" >
									<img src="{{product.imageUrl}}" />
							</li>
							<li data-thumb="{{product.imageUrl}}" >
									<img src="{{product.imageUrl}}" >
							</li>
							<li data-thumb="{{product.imageUrl}}" >
									<img src="{{product.imageUrl}}" >
							</li>
						</ul>
					</div>
				</div>
				<div class="col-md-6 single-grid simpleCart_shelfItem">
					<h3>{{product.productName}}</h3>
					<p>{{product.productDescription}}</p>
					<div class="galry">
						<div class="">
							<h5 class="item_price">Rs. {{product.price}}</h5>
						</div>
						<div class="clearfix"></div>
					</div>

					<p class="qty">Qty :</p>
					<input min="1" type="number" id="quantity" name="quantity"
						value="1" class="form-control input-small">

					<div class="btn_form">
						<a href="#" class="add-cart item_add">ADD TO CART</a>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- collapse -->
	<div class="collpse">
		<div class="container">
			<div class="panel-group collpse" id="accordion" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a role="button" data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" aria-expanded="true"
								aria-controls="collapseOne"> Description </a>
						</h4>
					</div>
					<div id="collapseOne" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="headingOne">
						<div class="panel-body">{{product.productDescription}}</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwo">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#collapseTwo"
								aria-expanded="false" aria-controls="collapseTwo">
								additional information </a>
						</h4>
					</div>
					<div id="collapseTwo" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingTwo">
						<div class="panel-body">{{product.productDescription}}</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingFour">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#collapseFour"
								aria-expanded="false" aria-controls="collapseFour"> help </a>
						</h4>
					</div>
					<div id="collapseFour" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingFour">
						<div class="panel-body">{{product.productDescription}}</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- collapse -->
	<div class="related-products">
		<div class="container">
			<h3>Related Products</h3>
			<div class="product-model-sec single-product-grids">
				<div class="product-grid single-product">
					<a href="single.html">
						<div class="more-product">
							<span> </span>
						</div>
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/nia.png" class="img-responsive" alt="">
							<div class="b-wrapper">
								<h4 class="b-animate b-from-left  b-delay03">
									<button>+</button>
								</h4>
							</div>
						</div>
					</a>
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>Product #1</h4>
							<span class="item_price">$187.95</span>
							<div class="ofr">
								<p class="pric1">
									<del>Rs 280</del>
								</p>
								<p class="disc">[12% Off]</p>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="product-grid single-product">
					<a href="single.html">
						<div class="more-product">
							<span> </span>
						</div>
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/nia.png" class="img-responsive" alt="">
							<div class="b-wrapper">
								<h4 class="b-animate b-from-left  b-delay03">
									<button>+</button>
								</h4>
							</div>
						</div>
					</a>
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>Product #1</h4>
							<span class="item_price">$187.95</span>
							<div class="ofr">
								<p class="pric1">
									<del>Rs 280</del>
								</p>
								<p class="disc">[12% Off]</p>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="product-grid single-product">
					<a href="single.html">
						<div class="more-product">
							<span> </span>
						</div>
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/nia.png" class="img-responsive" alt="">
							<div class="b-wrapper">
								<h4 class="b-animate b-from-left  b-delay03">
									<button>+</button>
								</h4>
							</div>
						</div>
					</a>
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>Product #1</h4>
							<span class="item_price">$187.95</span>
							<div class="ofr">
								<p class="pric1">
									<del>Rs 280</del>
								</p>
								<p class="disc">[12% Off]</p>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="product-grid single-product">
					<a href="single.html">
						<div class="more-product">
							<span> </span>
						</div>
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/nia.png" class="img-responsive" alt="">
							<div class="b-wrapper">
								<h4 class="b-animate b-from-left  b-delay03">
									<button>+</button>
								</h4>
							</div>
						</div>
					</a>
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>Product #1</h4>
							<span class="item_price">$187.95</span>
							<div class="ofr">
								<p class="pric1">
									<del>Rs 280</del>
								</p>
								<p class="disc">[12% Off]</p>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>


</body>
</html>