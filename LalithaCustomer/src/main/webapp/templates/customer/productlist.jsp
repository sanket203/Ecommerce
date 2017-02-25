<div class="content">
	<div class="product-model">
		<div class="container">
			
			<div class="product-model-sec single-product-grids">
				<div class="product-grid single-product" ng-repeat="product in productlist">
					<a href="#/productshow"
						ng-click="navigateWithProductAndCategoryId(product.categoryId,product.productId)">
						<div class="more-product">
							<span> </span>
						</div> 
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="{{product.imageUrl}}" class="img-responsive" alt="">
							<div class="b-wrapper">
								<h4 class="b-animate b-from-left  b-delay03">
									<button>View</button>
								</h4>
							</div>
						</div>
					</a>
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>{{product.productName}}</h4>
							<span class="item_price">Rs. {{product.price}}</span>
							<div ng-if = !(product.productActive)>
								<span class="item_price" style="color:red">Out Of Stock</span>
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
