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

table {
    width: 100%;
    display:block;
}
thead {
    display: inline-block;
    width: 100%;
}
tbody {
    height: 200px;
    display: inline-block;
    width: 100%;
    overflow: auto;
}
.selectedImages{
	width:100px;
	height:100px;
}
#categoryName
{
	font-size: 150%;
	font-weight: 400;
    line-height: 1;
    color: #777;
}

</style>

<div class="well col-lg-12" ng-init="getAllCategories();">
	<div class="category col-md-3">
		<ul class="sidebar-custom">
			<li><h2>Categories</h2></li>
			<li>
				<a class="btn btn-success btn-block glyphicon glyphicon glyphicon-plus" data-toggle="modal"
				data-target="#addCategory">&nbsp;<strong>ADD</strong></a>
			</li>
			<li><br /></li>
			<li ng-repeat="category in categories">
				<a href="" class="categoryBtn btn btn-default btn-block" ng-click="getProduct(category.categoryId,category.categoryName)">
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
			<div class="col-md-12" ng-show="addBtnBlock">
			<br />
				<div class="col-md-4">
					<span id="categoryName"></span>
				</div>
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<button type="button"
						class="btn btn-success btn-block glyphicon glyphicon glyphicon-plus"
						data-whatever={{product.id}} data-toggle="modal"
						data-target="#addProduct">
						<strong>ADD</strong>
					</button>
				</div>
				<br /><br /><br />
			</div>
			
			<table id="productList" class="table table-striped table-bordered"
				ng-show="productBlock" cellspacing="0" width="100%">
				<tbody>
					<tr class="table-header">
						<th width=5%>Id</th>
						<th width=20%>Name</th>
						<th width=20%>Price</th>
						<th width=20%>Added By</th>
						<th width=20%>Added On</th>
						<th width=15%>Action</th>
					</tr>
				
					<tr ng-repeat="product in products">
						<td width=5%>{{product.productId}}</td>
						<td width=20%>{{product.productName}}</td>
						<td width=20%>{{product.price}}</td>
						<td width=20%>{{product.addedBy}}</td>
						<td width=20%>{{product.dateAdded}}</td>
						<td width=15%>
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

	<input type="hidden" id="errorFlag">

	<!-- add product popup -->
	<div class="modal fade" id="addProduct" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Add new product</h4>
				</div>
				<div id="addProductScreen1">
					<div class="modal-body">
						<div class="input-group">
							<span class="input-group-addon">Name</span> <input type="text" required
									id="add_pName" class="form-control">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">Description</span> 
							<textarea rows="4" id="add_pDescription" class="form-control"
									style="max-width: 471px;"></textarea>
						</div>						<br />
						<div class="input-group">
							<span class="input-group-addon">Price</span> <input type="text" required
									id="add_pPrice" class="form-control" aria-describedby="pprice">
							<span class="input-group-addon">Location</span> <input
									type="text" id="add_pLocations" class="form-control"
									aria-describedby="pLocation">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">Quantity (in weight)</span> <input
									type="text" id="add_pQuantity" class="form-control"
									aria-describedby="pQty">
							<span class="input-group-addon">Quantity (in stock)</span> <input
									type="text" required id="add_pQuantityStock" class="form-control"
									aria-describedby="pQtyStock">		
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">Active</span> <input type="checkbox" checked
									data-toggle="toggle" id="add_pStatus">
						</div>
						<br />
							<input type="text" id="add_pTags" class="form-control"
							placeholder="Tags" aria-describedby="pTags">
						<br />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-success"
								ng-click="storeProductData('#addProductScreen1')">Save and continue</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					</div>
				</div>
				<div id="addProductScreen2">
					<div class="modal-body">
						<div class="input-group col-md-12">
							<form enctype="multipart/form-data">
								<div class="col-md-12">
									<input type="file" class="form-control" id="images" name="images[]" multiple />
								</div>
							</form>
							<div id="image_preview"></div>
						</div>
					</div>
					<br />
					<div class="modal-footer">
						<div id="warn" style="color:darkgray; font-family:-webkit-body; float:left;">*select an image to make it default.</div>
						<div style="float:right;">
							<button type="button" class="btn btn-success"
								ng-click="saveProduct('#addProductScreen2');">Save</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
						</div>
					</div>
				</div>
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
							<span class="input-group-addon">Name</span> <input type="text" required
									id="edit_pName" class="form-control" aria-describedby="pName">
							<input type="hidden" id="edit_productId" class="form-control"
									aria-describedby="pName">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">Description</span> 
							<textarea rows="4" id="edit_pDescription" class="form-control"
									style="max-width: 471px;"></textarea>
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">Price</span> <input type="text" required
									id="edit_pPrice" class="form-control" aria-describedby="pprice">
							<span class="input-group-addon">Location</span> <input
									type="text" id="edit_pLocations" class="form-control"
									aria-describedby="pLocation">
									
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">Qty (in weight)</span> <input
									type="text" id="edit_pQuantity" class="form-control"
									placeholder="in weights" aria-describedby="pprice">
									
							<span class="input-group-addon">Qty (in stock)</span> 
							<span class="input-group-addon" id="edit_pQuantityStock"></span>
							<input type="text" id="edit_ptempQty" class="form-control">		
									
						</div>
						<br />
						<div class="input-group">
						<span class="input-group-addon">Active</span> <input type="checkbox" checked
									data-toggle="toggle" id="edit_pStatus">
						</div>
						<br /> <input type="text" id="edit_pTags" class="form-control"
								placeholder="Tags" aria-describedby="pTags"> <br />
						<br />
						<div class="modal-footer">
							<button type="button" class="btn btn-success"
									ng-click="editProduct('#editProduct');">Save</button>
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
						<span class="input-group-addon">Name</span> <input type="text" required
								id="cName" class="form-control" aria-describedby="cName">
					</div>
					<br />
					<div class="input-group">
						<span class="input-group-addon">Description</span> <input
								type="text" id="cDescription" class="form-control"
								aria-describedby="cDescription" required>
					</div>
					<br />
					<div class="modal-footer">
						<button type="button" class="btn btn-success"
								ng-click="addCategory('#addCategory');">Add</button>
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
						<span class="input-group-addon">Name</span> <input type="text" required
								id="edit_cName" class="form-control" aria-describedby="cName">
					</div>
					<br />
					<div class="input-group">
						<span class="input-group-addon">Description</span> <input
								type="text" id="edit_cDescription" class="form-control"
								aria-describedby="cDescription" required>
					</div>
					<br />
					<div class="modal-footer">
						<button type="button" class="btn btn-success"
								ng-click="editCategory('#editCategory');">Save</button>
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
			
			function convertToBool(x) {
				switch(x.toLowerCase().trim())
				{
			        case "true": case "yes": case "1": return true;
			        case "false": case "no": case "0": case null: return false;
			        default: return false;
		    	}
			}
			
			$("#images").change(function(){
				var total_file=document.getElementById("images").files.length;
				 for(var i=0;i<total_file;i++)
				 {
					var fileName=document.getElementById("images").files[i].name
				  	$('#image_preview').append("<div class='col-md-3'>"+
						  "<input type='radio' name='defaultImage' id='defaultImage_"+i+"_"+fileName+"'>&nbsp;&nbsp;"+fileName+
						  "<img class='selectedImages img-responsive' src='"+URL.createObjectURL(event.target.files[i])+"'></div>");
				 }
		    });
			
			$("#addProduct").on("shown.bs.modal", function () { 
				$("#addProductScreen1").show();
				$("#addProductScreen2").hide();
			});
			
			$('#addCategory').on('hidden.bs.modal',function() {
				$('#addCategory').find("input").val('').end();
			});
			$('#editProduct').on('hidden.bs.modal',function() {
				$('#editProduct').find("input").val('').end();
			});
			
			$('#addProduct').on('hidden.bs.modal',function() {
				$("#addProductScreen2").hide();
				$(this).find("input,textarea,select").val('').end();
				$(this).find(".tag").text('').end();
				$('#image_preview').find("div").remove();
				$("#warn").css("color","darkgrey");
			    var textBoxList = $(this).find("input");
			    for(var i=0;i<textBoxList.length;i++){
			    	textBoxList[i].placeholder="";
			    }
				$("#add_pTags").parent().find(".bootstrap-tagsinput input")[0].placeholder="Tags";
				modal.find('.modal-body #add_pTags').tagsinput('removeAll');
			    $(this).find("input,textarea,select").css('border-color','#ccc').end();
			});

			$('#addImage').on('hidden.bs.modal',function() {
				$("#image_preview").find("div").remove();
				$("#images").val("");
			});

			$('[data-placement="top"]').tooltip();
		
			$('#add_pStatus,#edit_pStatus').bootstrapToggle({
				on : 'ON',
				off : 'OFF',
				size : 'small'
			});
	
			$('#add_pTags').tagsinput({});

			
			$('#add_more').click(function() {
		          "use strict";
		          $(this).before($("<div/>", {
		            id: 'filediv'
		          }).fadeIn('slow').append(
		            $("<input/>", {
		              name: 'file[]',
		              type: 'file',
		              id: 'file',
		              multiple: 'multiple',
		              accept: 'image/*'
		            })
		          ));
		        });

		        deletePreview = function (ele, i) {
		          "use strict";
		          try {
		            $(ele).parent().remove();
		            window.filesToUpload.splice(i, 1);
		          } catch (e) {
		            console.log(e.message);
		          }
		        }

		        $("#file").on('change', function() {
		          "use strict";

		          // create an empty array for the files to reside.
		          window.filesToUpload = [];

		          if (this.files.length >= 1) {
		            $("[id^=previewImg]").remove();
		            $.each(this.files, function(i, img) {
		              var reader = new FileReader(),
		                newElement = $("<div id='previewImg" + i + "' class='previewBox'><img /></div>"),
		                deleteBtn = $("<span class='delete' onClick='deletePreview(this, " + i + ")'>X</span>").prependTo(newElement),
		                preview = newElement.find("img");

		              reader.onloadend = function() {
		                preview.attr("src", reader.result);
		                preview.attr("alt", img.name);
		              };

		              try {
		                window.filesToUpload.push(document.getElementById("file").files[i]);
		              } catch (e) {
		                console.log(e.message);
		              }

		              if (img) {
		                reader.readAsDataURL(img);
		              } else {
		                preview.src = "";
		              }

		              newElement.appendTo("#filediv");
		            });
		          }
		        });
		
			// on edit product button click
			$('#editProduct').on('show.bs.modal',function(event) {
				var button = $(event.relatedTarget)
				var recipient = button.data('whatever')
				var modal = $(this)
				modal.find('.modal-title').text("Editing "+ recipient.productName)
				modal.find('.modal-body #edit_productId').val(recipient.productId)
				modal.find('.modal-body #edit_pName').val(recipient.productName)
				modal.find('.modal-body #edit_pDescription').val(recipient.description)
				modal.find('.modal-body #edit_pPrice').val(recipient.price)
				modal.find('.modal-body #edit_pQuantity').val(recipient.quantityWeight)
				$('.modal-body #edit_pQuantityStock')[0].innerHTML=recipient.quantityStock
				modal.find('.modal-body #edit_pStatus').attr("checked",recipient.productActive)
				modal.find('.modal-body #edit_pLocations').val(recipient.productLocation)
				modal.find('.modal-body #edit_pTags').tagsinput('removeAll');
				var temp = recipient.tags.split(",");					
				for(var i=0; i<temp.length;i++)
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
						});
	</script>
</div>
