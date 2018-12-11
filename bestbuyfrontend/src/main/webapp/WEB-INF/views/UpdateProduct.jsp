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
				<div class="col-sm-2"><p>Product Id</p></div>
				<div class="col-sm-10"><form:input path="productId" value="${productId}"
							readonly="true" class="form-control" /></div>
			</div>
			<div class="row">
				<div class="col-sm-2"><p>Product Name</p></div>
				<div class="col-sm-10"><form:input path="productName" value="${productName}" class="form-control" /></div>
			</div>
			<div class="row">
				<div class="col-sm-2"><p>Product Description</p></div>
				<div class="col-sm-10"><form:textarea path="productDesc" value="${productDesc}" class="form-control" /></div>
			</div>
			<div class="row">
				<div class="col-sm-2"><p>Supplier Id</p></div>
				<div class="col-sm-10"><form:input path="supplierId" value="${supplierId}"
							readonly="true" class="form-control" /></div>
			</div>
			<div class="row">
				<div class="col-sm-2"><p>Category Id</p></div>
				<div class="col-sm-10"><form:input path="categoryId" value="${categoryId}"
							readonly="true" class="form-control" /></div>
			</div>
			<div class="row">
				<div class="col-sm-2"><p>Price</p></div>
				<div class="col-sm-10"><form:input path="price" value="${price}" class="form-control" /></div>
			</div>
			<div class="row">
				<div class="col-sm-2"><p>Stock</p></div>
				<div class="col-sm-10"><form:input path="stock" value="${stock}" class="form-control" /></div>
			</div>
			<div class="row">
				<div class="col"><input type="submit" value="Update Product" class="form-control btn btn-success" /></div>
			</div>
		</form:form>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>