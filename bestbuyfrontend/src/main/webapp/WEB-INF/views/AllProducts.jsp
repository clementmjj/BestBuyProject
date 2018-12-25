<%@include file="Header.jsp"%>
<html>
<head>
<title>Product list</title>
</head>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
		<h3>All Products</h3>
		<div class="d-flex flex-wrap justify-content-center">
			<c:forEach items="${productList}" var="product">
				<div class="flex-fill m-2 ml-5 mr-5" style="max-width: 200px;">
					<div class="product-thumbnail-container mb-2">
						<a href="<c:url value="/productDisplay/${product.productId}"/>">
							<img class="product-thumbnail img-thumbnail"
							src="${pageContext.request.contextPath}/resources/images/ProductImages/${product.productId}${product.imageExt}"
							alt="${product.productName}">
						</a>
					</div>
					<a class="product-container-pName"
						href="<c:url value="/productDisplay/${product.productId}"/>"><h6>${product.productName}</h6></a>
					<a class="product-container-pPrice"
						href="<c:url value="/productDisplay/${product.productId}"/>"><h6>&#8377;${product.price}/-</h6></a>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>