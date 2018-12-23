<%@include file="Header.jsp"%>
<html>
<head>
<title>Update Product</title>
</head>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
		<h3>Update Product</h3>
		<form:form action="${pageContext.request.contextPath}/updateProduct"
			modelAttribute="updateProduct">
			<div class="row">
				<div class="col">
					<div class="form-group">
						<label>Product Id</label>
						<form:input path="productId" value="${productId}" readonly="true"
							class="form-control" />
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label>Supplier Id</label>
						<form:input path="supplierId" value="${supplierId}"
							readonly="true" class="form-control" />
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label>Category Id</label>
						<form:input path="categoryId" value="${categoryId}"
							readonly="true" class="form-control" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label>Product Name</label>
				<form:input path="productName" value="${productName}"
					class="form-control" />
				<form:errors class="error-text" path="productName" />
			</div>
			<div class="form-group">
				<label>Product Description</label>
				<form:textarea path="productDesc" value="${productDesc}"
					class="form-control" />
				<form:errors class="error-text" path="productDesc" />
			</div>
			<div class="row">
				<div class="col">
					<div class="form-group">
						<label>Price</label>
						<form:input type="number" path="price" value="${price}"
							class="form-control" />
						<form:errors class="error-text" path="price" />
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label>Stock</label>
						<form:input type="number" path="stock" value="${stock}"
							class="form-control" />
						<form:errors class="error-text" path="stock" />
					</div>
				</div>
			</div>
			<input id="btn-updateProduct" type="submit" value="Update Product"
				class="form-control btn btn-success" />
		</form:form>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>