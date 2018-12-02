<%@include file="Header.jsp" %>
<html>
<head>
<title>Update Product</title>
</head>
<body>
	<div class="section">
		<h3>Update Product ${product.productName} (Id: ${productId})</h3>
		<form:form action="/bestbuyfrontend/updateProduct" modelAttribute="updateProduct">
			<table>
				<tr>
					<td>Product Id</td>
					<td><form:input path="productId" value="${productId}" readonly="true"/></td>
				</tr>
				<tr>
					<td>Product Name</td>
					<td><form:input path="productName" value="${productName}"/></td>
				</tr>
				<tr>
					<td>Product Description</td>
					<td><form:textarea path="productDesc" value="${productDesc}"/></td>
				</tr>
				<tr>
					<td>Supplier Id</td>
					<td><form:input path="supplierId" value="${supplierId}"/></td>
				</tr>
				<tr>
					<td>Category Id</td>
					<td><form:input path="categoryId" value="${categoryId}"/></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><form:input path="price" value="${price}"/></td>
				</tr>
				<tr>
					<td>Stock</td>
					<td><form:input path="stock" value="${stock}"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update Product"/></td>
				</tr>
			</table>
		</form:form>
	</div>
	
</body>
</html>
<%@include file="Footer.jsp" %>