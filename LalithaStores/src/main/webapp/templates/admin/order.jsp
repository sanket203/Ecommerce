<style>
#orderViewEdit .form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control {
    background-color: white;
    opacity: 1;
</style>

<div class="well col-lg-12" ng-init="getAllOrders();">
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
				<tr ng-repeat="order in orders">
					<th scope="row">{{order.orderId}}</th>
					<td>{{order.customer}}</td>
					<td>{{order.orderDate}}</td>
					<td>{{order.totalAmount}}</td>
					<td>{{order.status}}</td>
					<td>
						<button type="button" class="btn btn-primary btn-sm glyphicon glyphicon-edit"
							ng-click="getOrderById(order.orderDetailsId)" data-whatever={{selectedOrder}}
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
												<div class="input-group">
													<span class="input-group-addon">Name</span> 
													<input type="text" id=ocdName class="form-control"
														placeholder="Name" disabled />
												</div>
												<br/>
												<div class="input-group">
												<span class="input-group-addon">Contact</span> 
													<input type="text" id=ocdContact class="form-control"
														placeholder="Contact" disabled />
												</div>
												<br/>
												<div class="input-group">
												<span class="input-group-addon">Email</span> 
													<input type="text" id=ocdEmail class="form-control"
														placeholder="Contact" disabled />
												</div>
												<br/>
												<div class="input-group">
													<span class="input-group-addon">Address</span> 
													<textarea class="form-control" id=ocdAddress
														placeholder="Address" rows="3" disabled></textarea>
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
															<th>Qty</th>
															<th>Unit Price</th>
															<th>Total Price</th>
														</tr>
													</thead>
													<tbody>
														<tr ng-repeat="p in products">
															<td>{{p.productName}}</td>
															<td>{{p.quantity}}</td>
															<td>{{p.amount}}</td>
															<td>{{p.quantity * p.amount}}</td>
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
											class="glyphicon glyphicon-road"></span>&nbsp;Payment
											Details</a>
									</h4>
								</div>
								<div id="shippingDetail" class="panel-collapse collapse in">
									<div class="panel-body">
										<div class="row">
											<div class="col-md-12">
												<div class="input-group">
												<span class="input-group-addon">ReferenceNo</span>
													<input type="text" id=opdReferenceNo class="form-control"
														placeholder="Referece Number" disabled />
												</div>
												<br/>
												<div class="input-group">
													<span class="input-group-addon">Mode</span>
													<input type="text" id=opdMode class="form-control"
														placeholder="Mode" disabled />
												</div>
												<br />
												<div class="input-group">
													<span class="input-group-addon">Amount</span>
													<input type="text" id=opdAmount class="form-control"
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