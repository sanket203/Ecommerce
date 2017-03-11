<style>
.image-preview-input {
	position: relative;
	overflow: hidden;
	margin: 0px;
	color: #333;
	background-color: #fff;
	border-color: #ccc;
}

.image-preview-input input[type=file] {
	position: absolute;
	top: 0;
	right: 0;
	margin: 0;
	padding: 0;
	font-size: 20px;
	cursor: pointer;
	opacity: 0;
	filter: alpha(opacity = 0);
}

.image-preview-input-title {
	margin-left: 2px;
}

.table-body {
	display: block;
	height: 250px;
	width: 100%;
	overflow-x: break-word;
	overflow-y: auto;
}

.sidebar-custom {
	width: 250px;
	height: 370px;
	overflow-y: auto;
	margin: 0;
	list-style: none;
}

.toggle.ios, .toggle-on.ios, .toggle-off.ios {
	border-radius: 20px;
}

.toggle.ios .toggle-handle {
	border-radius: 20px;
}
a.categoryBtn.btn.btn-default.btn-block
{
	padding-left: 50px;
}

.modCatBtn {
    float: right;
    padding-left: 10px;
    visibility: hidden;
    opacity: 0;
}
.categoryBtn:hover .modCatBtn{
	visibility: visible;
    opacity: 1;
  	transition: 1s;
}

</style>

<div class="well col-lg-12" ng-init="getAllCategories();">
	<div class="category col-md-3">
		<ul class="sidebar-custom">
			<li><h2>Categories</h2></li>
			<li>
				<a class="btn btn-success btn-block glyphicon glyphicon glyphicon-plus"
				data-toggle="modal" data-target="#addCategory">&nbsp;<strong>ADD</strong></a>
			</li>
			<li><br /></li>
			<li ng-repeat="category in categories">
				<a href="" class="categoryBtn btn btn-default btn-block" ng-click="getProduct(category.categoryId)">
					{{category.categoryName}}
					<span class="modCatBtn glyphicon glyphicon glyphicon-trash" data-whatever={{category.categoryId}}
					data-toggle="modal" data-target="#deleteCategory"></span>
					<span class="modCatBtn glyphicon glyphicon glyphicon-edit" data-whatever={{category}}
					data-toggle="modal" data-target="#editCategory"></span>
				</a>
			</li>
		</ul>
	</div>

	<div class="blank col-md-1"></div>

	<div class="well product col-md-8">
		<div id="custom-search-input">
			<div class="input-group col-md-12">
				<input type="text" class="form-control input-md"
					placeholder="search product" /> <span class="input-group-btn">
					<button class="btn btn-default btn-md" type="button">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</span>
			</div>
		</div>

		<div id="productBlock">
			<div class="pull-right col-md-4" ng-show="addBtnBlock">
				<br />
				<button type="button"
					class="btn btn-success btn-block glyphicon glyphicon glyphicon-plus"
					data-whatever={{product.id}} data-toggle="modal"
					data-target="#addProduct">
					<strong>ADD</strong>
				</button>
				<br />
			</div>

			<table id="productList" class="table table-striped table-bordered"
				ng-show="productBlock" cellspacing="0" width="100%">
				<tbody>
					<tr class="table-header">
						<th>Id</th>
						<th>Name</th>
						<th>Price</th>
						<th>Added By</th>
						<th>Added On</th>
						<th>Action</th>
					</tr>
					</thead>
				<tbody>
					<tr ng-repeat="product in products">
						<td>{{product.productId}}</td>
						<td>{{product.productName}}</td>
						<td>{{product.price}}</td>
					<td>{{product.addedBy}}</td>
					<td>{{product.dateAdded}}</td>
						<td>
							<button type="button"
								class="btn btn-primary btn-sm glyphicon glyphicon-edit"
								data-whatever={{product}} data-toggle="modal"
								data-placement="top" title="Edit" data-target="#editProduct"></button>
							<button type="button"
								class="btn btn-danger btn-sm glyphicon glyphicon-trash"
								data-whatever={{product.productId}} data-toggle="modal"
								data-placement="top" title="Delete" data-target="#deleteProduct"></button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<!-- add product popup -->
	<div class="modal fade" id="addProduct" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Add new product</h4>
				</div>
				<form enctype="multipart/form-data">
					<div class="modal-body">
						<div class="input-group">
							<span class="input-group-addon">Name</span> <input type="text"
									id="add_pName" class="form-control" aria-describedby="pName">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">Description</span> <input
									type="text" id="add_pDescription" class="form-control"
									aria-describedby="pdescription">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">Price</span> <input type="text"
									id="add_pPrice" class="form-control" aria-describedby="pprice">
							<span class="input-group-addon">Quantity</span> <input
									type="text" id="add_pQuantity" class="form-control"
									placeholder="in weights" aria-describedby="pQty">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">Location</span> <input
									type="text" id="add_pLocations" class="form-control"
									aria-describedby="pLocation">
						</div>
						<br />
						<div class="input-group">
							<span>Active&nbsp;</span> <input type="checkbox" checked
									data-toggle="toggle" id="add_pStatus">
						</div>
						<br />
							<input type="text" id="add_pTags" class="form-control"
								placeholder="tags" aria-describedby="pTags">
						<br />
						<div class="row">
							<div class="col-lg-12 col-md-6 col-sm-8">
								<div class="input-group image-preview">
									<input type="text" class="form-control image-preview-filename"
											disabled="disabled"> <span class="input-group-btn">
										<button type="button"
												class="btn btn-default image-preview-clear"
												style="display: none;">
											<span class="glyphicon glyphicon-remove"></span> Clear
										</button>
										<div class="btn btn-default image-preview-input">
											<span class="glyphicon glyphicon-folder-open"></span> <span
													class="image-preview-input-title">Browse</span> <input
													type="file" accept="image/png, image/jpg, image/gif"
													name="imageFile" id="imageFile" />
										</div>
									</span>
								</div>
							</div>
						</div>
						<br />
						<div class="modal-footer">
							<button type="button" class="btn btn-success"
									data-dismiss="modal" ng-click="saveProduct();">Add</button>
							<button type="button" class="btn btn-default"
									data-dismiss="modal">Cancel</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- edit product popup -->
	<div class="modal fade" id="editProduct" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Edit</h4>
				</div>
				<form enctype="multipart/form-data">
					<div class="modal-body">
						<div class="input-group">
							<span class="input-group-addon">Name</span> <input type="text"
									id="edit_pName" class="form-control" aria-describedby="pName">
							<input type="hidden" id="edit_productId" class="form-control"
									aria-describedby="pName">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">Description</span> <input
									type="text" id="edit_pDescription" class="form-control"
									aria-describedby="pdescription">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">Price</span> <input type="text"
									id="edit_pPrice" class="form-control" aria-describedby="pprice">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">Quantity</span> <input
									type="text" id="edit_pQuantity" class="form-control"
									placeholder="in weights" aria-describedby="pprice">
						</div>
						<br />
						<div class="input-group">
							<span>Active&nbsp;</span> <input type="checkbox" checked
									data-toggle="toggle" id="edit_pStatus">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">Location</span> <input
									type="text" id="edit_pLocations" class="form-control"
									aria-describedby="pLocation">
						</div>
						<br /> <input type="text" id="edit_pTags" class="form-control"
								placeholder="tags" aria-describedby="pTags"> <br />
						<div class="row">
							<div class="col-lg-12 col-md-6 col-sm-8">
								<div class="input-group image-preview">
									<input type="text" class="form-control image-preview-filename"
											disabled="disabled"> <span class="input-group-btn">
										<button type="button"
												class="btn btn-default image-preview-clear"
												style="display: none;">
											<span class="glyphicon glyphicon-remove"></span> Clear
										</button>
										<div class="btn btn-default image-preview-input">
											<span class="glyphicon glyphicon-folder-open"></span> <span
													class="image-preview-input-title">Browse</span> <input
													type="file" accept="image/png, image/jpg, image/gif"
													name="imageFile" id="edit_imageFile" />
										</div>
									</span>
								</div>
							</div>
						</div>
						<br />
						<div class="modal-footer">
							<button type="button" class="btn btn-success"
									data-dismiss="modal" ng-click="editProduct();">Save</button>
							<button type="button" class="btn btn-default"
									data-dismiss="modal">Cancel</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- delete product popup -->
	<div class="modal fade" id="deleteProduct" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Delete Product</h4>
				</div>
				<div class="modal-body">
					<div class="input-group">
						<span class="input-group-addon" id="delete_productId">Are you
							sure you want to delete the product?</span>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-success" data-dismiss="modal"
								ng-click="deleteProduct();">Delete</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- add category popup -->
	<div class="modal fade" id="addCategory" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Add new category</h4>
				</div>
				<div class="modal-body">
					<div class="input-group">
						<span class="input-group-addon">Name</span> <input type="text"
								id="cName" class="form-control" aria-describedby="cName">
					</div>
					<br />
					<div class="input-group">
						<span class="input-group-addon">Description</span> <input
								type="text" id="cDescription" class="form-control"
								aria-describedby="cDescription">
					</div>
					<br />
					<div class="modal-footer">
						<button type="button" class="btn btn-success"
								ng-click="addCategory();" data-dismiss="modal">Add</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- edit category popup -->
	<div class="modal fade" id="editCategory" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Delete category</h4>
				</div>
				<div class="modal-body">
					<div class="input-group">
						<span class="input-group-addon">Name</span> <input type="text"
								id="edit_cName" class="form-control" aria-describedby="cName">
					</div>
					<br />
					<div class="input-group">
						<span class="input-group-addon">Description</span> <input
								type="text" id="edit_cDescription" class="form-control"
								aria-describedby="cDescription">
					</div>
					<br />
					<div class="modal-footer">
						<button type="button" class="btn btn-success"
								ng-click="editCategory();" data-dismiss="modal">Save</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- delete category popup -->
	<div class="modal fade" id="deleteCategory" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Delete category</h4>
				</div>
				<div class="modal-body">
					<div class="input-group">
						<span class="input-group-addon" id="delete_categoryId">Are you
							sure you want to delete the category?</span>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-success" data-dismiss="modal"
								ng-click="deleteCategory();">Delete</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#addCategory, #addProduct').on('hidden.bs.modal',function() {
				$(this).find("input,textarea,select,.image-preview-filename").val('').end();
				$(this).find(".tag").text('').end();
				$('.image-preview').attr("data-content", "").popover('hide');
				$('.image-preview-filename').val("");
				$('.image-preview-clear').hide();
				$('.image-preview-input input:file').val("");
				$(".image-preview-input-title").text("Browse");
			});

		$('[data-placement="top"]').tooltip();
		
		$('#add_pStatus,#edit_pStatus').bootstrapToggle({
			on : 'ON',
			off : 'OFF',
			size : 'small'
		});

		$('#add_pTags').tagsinput({});
		
			// on edit product button click
			$('#editProduct').on('show.bs.modal',function(event) {
				var button = $(event.relatedTarget)
				var recipient = button.data('whatever')
				var modal = $(this)
				modal.find('.modal-title').text("Editing "+ recipient.productId)
				modal.find('.modal-body #edit_productId').val(recipient.productId)
				modal.find('.modal-body #edit_pName').val(recipient.productName)
				modal.find('.modal-body #edit_pDescription').val(recipient.description)
				modal.find('.modal-body #edit_pPrice').val(recipient.price)
				modal.find('.modal-body #edit_pQuantity').val(recipient.quantityWeight)
				modal.find('.modal-body #edit_pStatus').attr("checked",recipient.productActive)
				modal.find('.modal-body #edit_pLocations').val(recipient.productLocation)
				var temp = recipient.tags.split(",");
				var tagsToDelete = modal.find('.modal-body #edit_pTags').tagsinput();
				var oldTags = tagsToDelete[0].itemsArray.length;
				while(oldTags--)
				{
					modal.find('.modal-body #edit_pTags').tagsinput('remove', tagsToDelete[0].itemsArray[oldTags]);
					if(oldTags==0){break;}
				}												
				for(var i=0; i<temp.length-1;i++)
				{
					modal.find('.modal-body #edit_pTags').tagsinput('add', temp[i]);	
				}		
			});

							// on delete product button click
							$('#deleteProduct').on('show.bs.modal',function(event) {
								var button = $(event.relatedTarget)
								var recipient = button.data('whatever')
								var modal = $(this)
								modal.find('.modal-title').text("Deleting product")
								modal.find('.modal-body #delete_productId').val(recipient)
							});
							
							// on edit category button click
							$('#editCategory').on('show.bs.modal',
							function(event) {
								var button = $(event.relatedTarget)
								var recipient = button.data('whatever')
								var modal = $(this)
								modal.find('.modal-title').text("Editing category")
								modal.find('.modal-body #edit_cName').val(recipient.categoryName)
								modal.find('.modal-body #edit_cDescription').val(recipient.description)
							});
							
							// on delete category button click
							$('#deleteCategory').on('show.bs.modal',function(event) {
								var button = $(event.relatedTarget)
								var recipient = button.data('whatever')
								var modal = $(this)
								modal.find('.modal-title').text("Deleting category")
								modal.find('.modal-body #delete_categoryId').val(recipient)
							});

							$(document).on('click','#close-preview',function() {
								$('.image-preview').popover('hide');
								$('.image-preview').hover(
									function() {
										$('.image-preview').popover('show');
									},
									function() {
										$('.image-preview').popover('hide');
									}
								);
							});

							$(function() {
								// Create the close button
								var closebtn = $('<button/>', {
									type : "button",
									text : 'x',
									id : 'close-preview',
									style : 'font-size: initial;',
								});
								closebtn.attr("class", "close pull-right");
								// Set the popover default content
								$('.image-preview').popover(
										{
											trigger : 'manual',
											html : true,
											title : "<strong>Preview</strong>"
													+ $(closebtn)[0].outerHTML,
											content : "There's no image",
											placement : 'bottom'
										});
								// Clear event
								$('.image-preview-clear')
										.click(
												function() {
													$('.image-preview').attr(
															"data-content", "")
															.popover('hide');
													$('.image-preview-filename')
															.val("");
													$('.image-preview-clear')
															.hide();
													$(
															'.image-preview-input input:file')
															.val("");
													$(
															".image-preview-input-title")
															.text("Browse");
												});
								// Create the preview image
								$(".image-preview-input input:file")
										.change(
												function() {
													var img = $('<img/>', {
														id : 'dynamic',
														width : 250,
														height : 200
													});
													var file = this.files[0];
													var reader = new FileReader();
													// Set preview image into the popover data-content
													reader.onload = function(e) {
														$(
																".image-preview-input-title")
																.text("Change");
														$(
																".image-preview-clear")
																.show();
														$(
																".image-preview-filename")
																.val(file.name);
														img
																.attr(
																		'src',
																		e.target.result);
														$(".image-preview")
																.attr(
																		"data-content",
																		$(img)[0].outerHTML)
																.popover("show");
													}
													reader.readAsDataURL(file);
												});
							});

						});
	</script>

</div>
