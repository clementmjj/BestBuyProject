<%@include file="Header.jsp"%>

<html>
<head>
<title>Manage Suppliers</title>
</head>
<body class="bg-light">
	<div class="container-fluid" id="body-container">


		<div class="modal fade" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h3 class="modal-title">Add Supplier</h3>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<form:form action="/bestbuyfrontend/addSupplier"
							modelAttribute="addSupplier">
							<table>
								<tr>
									<td>Supplier Name</td>
									<td><form:input path="supplierName" /></td>
								</tr>
								<tr>
									<td>Supplier Address</td>
									<td><form:textarea path="supplierAddress" /></td>
								</tr>
								<tr>
									<td><input type="submit" value="Add"
										class="btn btn-success" /></td>
								</tr>
							</table>
						</form:form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>

		<div class="d-flex justify-content-between">
			<div>
				<h3>Supplier list</h3>
			</div>
			<div>
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#myModal">
					<i class="fa fa-plus"></i> Add Supplier
				</button>
			</div>
		</div>


		<div class="table-responsive-sm">
			<table class="table table-hover">
				<thead class="thead-light">
					<tr>
						<th>Supplier Id</th>
						<th>Supplier Name</th>
						<th>Supplier Address</th>
						<th>Operations</th>
					</tr>
				</thead>

				<c:forEach items="${supplierList}" var="supplier">
					<tr>
						<td>${supplier.supplierId}</td>
						<td>${supplier.supplierName}</td>
						<td>${supplier.supplierAddress}</td>
						<td><a class="link-default"
							href="<c:url value="/editSupplier/${supplier.supplierId}"/>"><i
								data-toggle="tooltip" title="Edit" class="fa fa-pencil"></i></a> | <a
							class="link-default"
							href="<c:url value="/deleteSupplier/${supplier.supplierId}"/>"><i
								data-toggle="tooltip" title="Edit" class="fa fa-trash-o"></i></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>
</body>
</html>
<%@include file="Footer.jsp"%>