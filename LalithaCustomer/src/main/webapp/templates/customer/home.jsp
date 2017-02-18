<div class="col-lg-12">

	<div class="banner-section">
		<div class="container">
			<div class="banner-grids">
				<div class="col-md-6 banner-grid">
					<h2>the latest collections</h2>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
					<a ng-href="#/productlist" class="button"> shop now </a>
				</div>
				<div class="col-md-6 banner-grid1">
					<img src="images/p2_1.png" class="img-responsive" alt="" />
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>

	<div class="banner-bottom">
		<div class="gallery-cursual">
			<script>
				$(document).ready(function() {
					$("#owl-demo").owlCarousel({
						items : 3,
						lazyLoad : true,
						autoPlay : true,
						pagination : false,
					});
				});
			</script>
			<div id="owl-demo" class="owl-carousel text-center">
				<div class="item">
					<img class="lazyOwl" data-src="images/b1.png" alt="name">
					<div class="item-info">
						<h5>Spices</h5>
					</div>
				</div>
				<div class="item">
					<img class="lazyOwl" data-src="images/b2.png" alt="name">
					<div class="item-info">
						<h5>Coconut</h5>
					</div>
				</div>
				<div class="item">
					<img class="lazyOwl" data-src="images/b3.png" alt="name">
					<div class="item-info">
						<h5>Banana Chips</h5>
					</div>
				</div>
				<div class="item">
					<img class="lazyOwl" data-src="images/b4.png" alt="name">
					<div class="item-info">
						<h5>Lungi</h5>
					</div>
				</div>
				<div class="item">
					<img class="lazyOwl" data-src="images/b1.png" alt="name">
					<div class="item-info">
						<h5>Spices</h5>
					</div>
				</div>
				<div class="item">
					<img class="lazyOwl" data-src="images/b2.png" alt="name">
					<div class="item-info">
						<h5>Coconut</h5>
					</div>
				</div>
				<div class="item">
					<img class="lazyOwl" data-src="images/b3.png" alt="name">
					<div class="item-info">
						<h5>Banana Chips</h5>
					</div>
				</div>
				<div class="item">
					<img class="lazyOwl" data-src="images/b4.png" alt="name">
					<div class="item-info">
						<h5>Lungi</h5>
					</div>
				</div>
			</div>
		</div>
		<div class="gallery">
			<div class="container">
				<h3>Latest products</h3>
				<div class="gallery-grids">
					<div class="col-md-3 gallery-grid" ng-repeat="product in products">
					<a href="#/productshow">
						<div class="more-product">
							<span> </span>
						</div>
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="{{product.Image}}" class="img-responsive" alt="">
							<div class="b-wrapper">
								<h4 class="b-animate b-from-left  b-delay03">
									<button>+</button>
								</h4>
							</div>
						</div>
					</a>
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>{{product.Name}}</h4>
							<span class="item_price">{{product.Price}}</span>
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
</div>