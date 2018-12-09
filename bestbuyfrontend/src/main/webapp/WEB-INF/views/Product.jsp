<%@include file="Header.jsp"%>
<html>
<head>
<title>Product</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 bg-light">
				<h3>Add Product</h3>
				<form:form action="/bestbuyfrontend/addProduct"
					modelAttribute="addProduct" enctype="multipart/form-data"
					method="post">
					<div class="row">
						<div class="col">
							<p>Product Name</p>
						</div>
						<div class="col">
							<form:input path="productName" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col">
							<p>Product Description</p>
						</div>
						<div class="col">
							<form:textarea path="productDesc" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col">
							<p>Supplier</p>
						</div>
						<div class="col">
							<form:select path="supplierId" class="form-control">
								<form:option value="0">--select--</form:option>
								<form:options items="${supplierListMap}" />
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<p>Category</p>
						</div>
						<div class="col">
							<form:select path="categoryId" class="form-control">
								<form:option value="0">--select--</form:option>
								<form:options items="${categoryListMap}" />
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<p>Price</p>

						</div>
						<div class="col">
							<form:input path="price" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col">
							<p>Stock</p>
						</div>
						<div class="col">
							<form:input path="stock" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col">
							<p>Select Image</p>
						</div>
						<div class="col">
							<form:input type="file" path="image" />
						</div>
					</div>
					<div class="row">
						<div class="col">
							<input type="submit" value="Add Product" class="form-control btn btn-default" />
						</div>
					</div>
				</form:form>
			</div>
			<div class="col-sm-9 bg-light">
				<h3>Existing Products</h3>
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
								<td><a
									href="<c:url value="/productDisplay/${product.productId}"/>">${product.productName}</a></td>
								<td>${product.productDesc}</td>
								<td>${product.supplierId}</td>
								<td>${product.categoryId}</td>
								<td>${product.price}</td>
								<td>${product.stock}</td>
								<td><a
									href="<c:url value="/editProduct/${product.productId}"/>"><i data-toggle="tooltip" title="Edit"
										class="fa fa-pencil"></i></a> | <a
									href="<c:url value="/deleteProduct/${product.productId}"/>"><i data-toggle="tooltip" title="Delete"
										class="fa fa-trash-o"></i></a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>