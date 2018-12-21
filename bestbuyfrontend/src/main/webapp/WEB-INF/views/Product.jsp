<%@include file="Header.jsp"%>
<html>
<head>
<title>Manage Products</title>
<c:if test="${errors==true}">
	<script>
		function showAddProductWithErrors() {
			document.getElementById("btn-addProduct").click();
		}
		window.onload = showAddProductWithErrors;
	</script>
</c:if>
</head>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
		<div class="modal fade" id="modal_add_product">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h3 class="modal-title">Add Product</h3>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<form:form action="${pageContext.request.contextPath}/addProduct"
							modelAttribute="addProduct" enctype="multipart/form-data"
							method="post">
							<div class="form-group">
								<label>Product Name</label>
								<form:input path="productName" class="form-control" />
								<form:errors class="error-text" path="productName" />
							</div>
							<div class="form-group">
								<label>Product Description</label>
								<form:textarea path="productDesc" class="form-control" />
								<form:errors class="error-text" path="productDesc" />
							</div>
							<div class="row">
								<div class="col">
									<div class="form-group">
										<label>Supplier</label>
										<form:select path="supplierId" class="form-control">
											<form:option value="0">--select--</form:option>
											<form:options items="${supplierListMap}" />
										</form:select>
										<form:errors class="error-text" path="supplierId" />
									</div>
								</div>
								<div class="col">
									<div class="form-group">
										<label>Category</label>
										<form:select path="categoryId" class="form-control">
											<form:option value="0">--select--</form:option>
											<form:options items="${categoryListMap}" />
										</form:select>
										<form:errors class="error-text" path="categoryId" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col">
									<div class="form-group">
										<label>Price</label>
										<form:input type="number" path="price" class="form-control" />
										<form:errors class="error-text" path="price" />
									</div>
								</div>
								<div class="col">
									<div class="form-group">
										<label>Stock</label>
										<form:input type="number" path="stock" class="form-control" />
										<form:errors class="error-text" path="stock" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label>Select Image</label>
								<div class="custom-file">
									<form:input type="file" path="image" class="custom-file-input" />
									<label class="custom-file-label" for="customFile">Choose
										file</label>
								</div>
								<form:errors class="error-text" path="image" />
							</div>
							<input type="submit" value="Add"
								class="form-control btn btn-success" />

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
				<h3>Product list</h3>
			</div>
			<div>
				<button type="button" id="btn-addProduct" class="btn btn-primary"
					data-toggle="modal" data-target="#modal_add_product">
					<i class="fa fa-plus"></i> Add Product
				</button>
			</div>
		</div>

		<div class="table-responsive-sm">
			<table class="table table-hover">
				<thead class="thead-light">
					<tr>
						<th>Product Id</th>
						<th>Product Name</th>
						<th>Product Description</th>
						<th>SupplierId</th>
						<th>CategoryId</th>
						<th>Price</th>
						<th>Stock</th>
						<th>Operations</th>
					</tr>
				</thead>
				<c:forEach items="${productList}" var="product">
					<tr>
						<td>${product.productId}</td>
						<td><a class="link-default"
							href="<c:url value="/productDisplay/${product.productId}"/>">${product.productName}</a></td>
						<td>${product.productDesc}</td>
						<td>${product.supplierId}</td>
						<td>${product.categoryId}</td>
						<td>${product.price}</td>
						<td>${product.stock}</td>
						<td><a class="link-default"
							href="<c:url value="/editProduct/${product.productId}"/>"><i
								data-toggle="tooltip" title="Edit" class="fa fa-pencil"></i></a> | <a
							class="link-default"
							href="<c:url value="/deleteProduct/${product.productId}"/>"><i
								data-toggle="tooltip" title="Delete" class="fa fa-trash-o"></i></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>