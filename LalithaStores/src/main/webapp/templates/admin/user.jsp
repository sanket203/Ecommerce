<div class="well col-lg-12" ng-init="getAllUsers();">

	<button type="button" class="btn btn-success" data-toggle="modal"
		style="float: right" data-target="#addUser">
		<span class="glyphicon glyphicon-plus" aria-hidden="true"> ADD</span>
	</button>
	<br /> <br />

	<table id="example" class="table table-striped table-bordered"
		cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>User ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Contact</th>
				<th>Location</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<tr ng-repeat="user in users">
				<td>{{user.userId}}</td>
				<td>{{user.firstName}}&nbsp;{{user.lastName}}</td>
				<td>{{user.emailId}}</td>
				<td>{{user.contact}}</td>
				<td>{{user.location}}</td>
				<td>
					<button type="button"
						class="btn btn-primary btn-sm glyphicon glyphicon-edit"
						data-toggle="modal" data-whatever={{user}} data-target="#editUser">&nbsp;Edit</button>
					<button type="button"
						class="btn btn-danger btn-sm glyphicon glyphicon-trash"
						data-whatever={{user.emailId}} data-toggle="modal"
						data-target="#deleteUser">&nbsp;Delete</button>
				</td>
			</tr>
		</tbody>
	</table>

	<!-- add user popup -->
	<div class="modal fade" id="addUser" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Add new user</h4>
				</div>
				<div class="modal-body">
					<div class="input-group">
						<span class="input-group-addon">First Name</span> <input
							type="text" id="fname" class="form-control"
							aria-describedby="fname">
					</div>
					<br />
					<div class="input-group">
						<span class="input-group-addon">Last Name</span> <input
							type="text" id="lname" class="form-control"
							aria-describedby="lname">
					</div>
					<br />
					<div class="input-group">
						<span class="input-group-addon">Email Id</span> <input type="text"
							id="email" class="form-control" aria-describedby="email">
					</div>
					<br />
					<div class="input-group">
						<span class="input-group-addon">Contact Number</span> <input
							type="text" id="contact" class="form-control"
							aria-describedby="contact">
					</div>
					<br />
					<div class="input-group">
						<span class="input-group-addon">Location</span> <input type="text"
							id="location" class="form-control" aria-describedby="location">
					</div>
					<br />
					<div class="input-group">
						<span class="input-group-addon">Permissions</span>
						<select id="permissions" multiple="multiple">
							<option value="ROLE_ADMIN">Administrator</option>
							<option value="ROLE_USER_MANAGEMENT">User Management</option>
							<option value="ROLE_PRODUCT_MANAGEMENT">Product Management</option>
							<option value="ROLE_ORDER_MANAGEMENT">Order Management</option>
						</select>
					</div>
					<br />
					<div class="modal-footer">
						<button type="button" class="btn btn-success" data-dismiss="modal"
							ng-click="addUser();">Save</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- edit user popup -->
	<div class="modal fade" id="editUser" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">View User</h4>
				</div>
				<div class="modal-body">
					<div class="input-group">
						<span class="input-group-addon">First Name</span> <input
							type="text" id="edit_fname" class="form-control"
							value={{user.userId}} aria-describedby="fname">
					</div>
					<br />
					<div class="input-group">
						<span class="input-group-addon">Last Name</span> <input
							type="text" id="edit_lname" class="form-control"
							aria-describedby="lname">
					</div>
					<br />
					<div class="input-group">
						<span class="input-group-addon">Email Id</span> <input type="text"
							id="edit_email" class="form-control" aria-describedby="email"
							disabled>
					</div>
					<br />
					<div class="input-group">
						<span class="input-group-addon">Contact Number</span> <input
							type="text" id="edit_contact" class="form-control"
							aria-describedby="contact">
					</div>
					<br />
					<div class="input-group">
						<span class="input-group-addon">Location</span> <input type="text"
							id="edit_location" class="form-control"
							aria-describedby="location">
					</div>
					<br />
					<div class="input-group">
						<span>Active&nbsp;</span> <input type="checkbox" checked
							data-toggle="toggle" id="edit_user" data-style="ios">
					</div>
					<br />
					<div class="input-group">
						<span class="input-group-addon">Permissions</span>
						<select id="edit_permissions" multiple="multiple">
							<option value="ROLE_ADMIN">Administrator</option>
							<option value="ROLE_USER_MANAGEMENT">User Management</option>
							<option value="ROLE_PRODUCT_MANAGEMENT">Product Management</option>
							<option value="ROLE_ORDER_MANAGEMENT">Order Management</option>
						</select>
					</div>
					<br />
					<div class="modal-footer">
						<button type="button" class="btn btn-success" data-dismiss="modal"
							ng-click="editUser();">Save</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- delete user popup -->
	<div class="modal fade" id="deleteUser" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Deleting</h4>
				</div>
				<div class="modal-body">
					<div class="input-group">
						<span class="input-group-addon" id="delete_emailId">Are you
							sure you want to delete the user?</span>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-success" data-dismiss="modal"
							ng-click="deleteUser();">Delete</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
	</div>

</div>

<script type="text/javascript">
	$(document).ready(function() {
				
				$('#edit_user').bootstrapToggle({
					on : 'ON',
					off : 'OFF',
					size : 'small'
				});

				$('#permissions').multiselect({});
				
				$('#addUser,#editUser ').on('hidden.bs.modal', function () {
				    $(this).find("input,textarea,select").val('').end();
				    $('#permissions').multiselect('destroy');
				    $('#edit_permissions').multiselect('destroy');
				});
								
				$('#addUser').on('show.bs.modal',function(event) {
				    $('#permissions').multiselect({});
				});
				
				// on edit user button click
				$('#editUser').on('show.bs.modal',
						function(event) {
							var button = $(event.relatedTarget)
							var recipient = button.data('whatever')
							var modal = $(this)
							modal.find('.modal-title').text(
									"Editing " + recipient.firstName + " "
											+ recipient.lastName)
							modal.find('.modal-body #edit_fname').val(
									recipient.firstName)
							modal.find('.modal-body #edit_lname').val(
									recipient.lastName)
							modal.find('.modal-body #edit_email').val(
									recipient.emailId)
							modal.find('.modal-body #edit_contact').val(
									recipient.contact)
							modal.find('.modal-body #edit_location').val(
									recipient.location)
							$('#edit_permissions').multiselect();
						    var roles = ['ROLE_PRODUCT_MANAGEMENT','ROLE_ORDER_MANAGEMENT'];
						    $('#edit_permissions').multiselect('select', roles);		
									
						});

				// on delete user button click
				$('#deleteUser').on('show.bs.modal', function(event) {
					var button = $(event.relatedTarget)
					var recipient = button.data('whatever')
					var modal = $(this)
					modal.find('.modal-title').text("Deleting " + recipient)
					modal.find('.modal-body #delete_emailId').val(recipient)
				});
			});
</script>





