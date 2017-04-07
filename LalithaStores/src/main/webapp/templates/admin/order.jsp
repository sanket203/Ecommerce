<div class="well col-lg-12">
	<div class="panel panel-default col-lg-12">
		<div class="panel-heading">Order List</div>
		<table class="table">
			<thead>
				<tr>
					<th>Order Id</th>
					<th>Customer Name</th>
					<th>Order Date</th>
					<th>Bill Amount</th>
					<th>Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">1123</th>
					<td>Alok Sharma</td>
					<td>22-Feb-2017</td>
					<td>Rs. 12300.00</td>
					<td>New</td>
					<td>
						<button type="button"
							class="btn btn-primary btn-sm glyphicon glyphicon-edit"
							data-whatever={{order}} data-toggle="modal" data-placement="top"
							title="Edit" data-target="#orderViewEdit"></button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="modal fade col-md-12" id="orderViewEdit" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Order Details</h4>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<div class="panel-group" id="accordion">
							<div>
								<br />
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#customerDetail"><span
											class="glyphicon glyphicon-user"></span>&nbsp;Customer
											Details</a>
									</h4>
								</div>
								<div id="customerDetail" class="panel-collapse collapse in">
									<div class="panel-body">
										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<input type="text" id=ocdName class="form-control"
														placeholder="Name" disabled />
												</div>
												<div class="form-group">
													<input type="text" id=ocdContact class="form-control"
														placeholder="Contact" disabled />
												</div>
												<div class="form-group">
													<textarea class="form-control" id=ocdAddress
														placeholder="Address" rows="5" disabled></textarea>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div>
								<br />
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#productDetail"><span
											class="glyphicon glyphicon-gift"></span>&nbsp;Product Details</a>
									</h4>
								</div>
								<div id="productDetail" class="panel-collapse collapse in">
									<div class="panel-body">
										<div class="row">
											<div class="panel panel-default col-lg-12">
												<div class="panel-heading">Product List</div>
												<table class="table">
													<thead>
														<tr>
															<th>Name</th>
															<th>Description</th>
															<th>Qty</th>
															<th>Unit Price</th>
															<th>Total Price</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td>Shoe
															</th>
															<td>Black Running</td>
															<td>1</td>
															<td>2500.00</td>
															<td>2500.00</td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div>
								<br />
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#shippingDetail"><span
											class="glyphicon glyphicon-road"></span>&nbsp;Shipping
											Details</a>
									</h4>
								</div>
								<div id="shippingDetail" class="panel-collapse collapse in">
									<div class="panel-body">
										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<input type="text" id=osdReferenceNo class="form-control"
														placeholder="Referece Number" disabled />
												</div>
												<div class="form-group">
													<input type="text" id=osdMode class="form-control"
														placeholder="Mode" disabled />
												</div>
												<div class="form-group">
													<input type="text" id=ocdAmount class="form-control"
														placeholder="Amount" disabled />
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div>
								<br />
							</div>
							<div class="input-group">
								<span class="input-group-addon">Order Status</span> 
								<select id="orderStatus">
									<option value="placed">Placed</option>
									<option value="processing">Processing</option>
									<option value="processed">Processed</option>
									<option value="dispatched">Dispatched</option>
									<option value="outForDelivery">Out For Delivery</option>
									<option value="delivered">Delivered</option>
									<option value="return">Return</option>
								</select>
							</div>
							<div>
								<br />
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-success"
									data-dismiss="modal" ng-click="updateStatus();">Update</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Cancel</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function() {
    $('#orderStatus').multiselect();
});
</script>