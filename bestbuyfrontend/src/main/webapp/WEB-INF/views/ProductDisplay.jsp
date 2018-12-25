<%@include file="Header.jsp"%>
<html>
<head>
<title>${product.productName}-Bestbuy</title>
</head>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
		<div class="row">
			<div class="col-sm-3">
				<img
					src="${pageContext.request.contextPath}/resources/images/ProductImages/${product.productId}${product.imageExt}"
					alt="${product.productName}"
					style="max-width: 100%; max-height: 300px; margin: 0 auto 10px auto; display: block;" />
				<h6 class="text-success">Available: ${product.stock}</h6>
			</div>
			<div class="col-sm-9">
				<h3>${product.productName}</h3>
				<h5 style="color: #b70000;">&#8377;${product.price}/-</h5>
				<p>${product.productDesc}</p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<c:if test="${sessionScope.role=='ROLE_USER'}">
					<a class="btn btn-primary form-control"
						href="<c:url value="/addtocart/${product.productId}"/>">Add To
						Cart</a>
				</c:if>
			</div>
		</div>
		<c:if test="${sessionScope.role=='ROLE_USER'}">
			<div class="container-fluid mt-5 rounded"
				style="background-color: #fff;">
				<h4>Other Products in this category</h4>
				<div class="d-flex flex-wrap justify-content-start">
					<c:forEach items="${relatedProductsList}" var="relatedProduct">
						<div class="flex-fill m-2 mr-5 ml-5" style="max-width: 200px;">
							<div class="product-thumbnail-container mb-2">
								<a
									href="<c:url value="/productDisplay/${relatedProduct.productId}"/>">
									<img class="product-thumbnail img-thumbnail"
									src="${pageContext.request.contextPath}/resources/images/ProductImages/${relatedProduct.productId}${relatedProduct.imageExt}"
									alt="${relatedProduct.productName}">
								</a>
							</div>
							<a class="product-container-pName"
								href="<c:url value="/productDisplay/${relatedProduct.productId}"/>"><h6>${relatedProduct.productName}</h6></a>
							<a class="product-container-pPrice"
								href="<c:url value="/productDisplay/${relatedProduct.productId}"/>"><h6>&#8377;${relatedProduct.price}/-</h6></a>
						</div>
					</c:forEach>
				</div>
			</div>
		</c:if>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>