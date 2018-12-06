<%@include file="Header.jsp" %>
<html>
	<head>
		<title>Product</title>
	</head>
	<body>
		<div class="section">
			<h3>Add Product</h3>
			<form:form action="addProduct" modelAttribute="addProduct" enctype="multipart/form-data" method="post">
				<table>
					<tr>
						<td>Product Name</td>
						<td><form:input path="productName"/></td>
					</tr>
					<tr>
						<td>Product Description</td>
						<td><form:textarea path="productDesc"/></td>
					</tr>
					<tr>
						<td>Supplier</td>
						<td>
							<form:select path="supplierId">
								<form:option value="0">--select--</form:option>
								<form:options items="${supplierListMap}"/>
							</form:select>
						</td>
						
					</tr>
					<tr>
						<td>Category</td>
						<td>
							<form:select path="categoryId">
								<form:option value="0">--select--</form:option>
								<form:options items="${categoryListMap}"/>
							</form:select>
						</td>
					</tr>
					<tr>
						<td>Price</td>
						<td><form:input path="price"/></td>
					</tr>
					<tr>
						<td>Stock</td>
						<td><form:input path="stock"/></td>
					</tr>
					<tr>
						<td>Select Image</td>
						<td><form:input type="file" path="image"/></td>
					</tr>
					<tr>
						<td><input type="submit" value="Add Product"/></td>
					</tr>
				</table>
			</form:form>
			<h3>Existing Products</h3>
			<table>
				<tr>
					<td>Product Id</td>
					<td>Product Name</td>
					<td>Product Description</td>
					<td>SupplierId</td>
					<td>CategoryId</td>
					<td>Price</td>
					<td>Stock</td>
					<td>Operations</td>
				</tr>
				<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.productId}</td>
					<td><a href="<c:url value="/productDisplay/${product.productId}"/>">${product.productName}</a></td>
					<td>${product.productDesc}</td>
					<td>${product.supplierId}</td>
					<td>${product.categoryId}</td>
					<td>${product.price}</td>
					<td>${product.stock}</td>
					<td><a href="editProduct/${product.productId}">Edit</a> | <a href="deleteProduct/${product.productId}">Delete</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>
<%@include file="Footer.jsp" %>