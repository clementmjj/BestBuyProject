<%@include file="Header.jsp" %>
<html>
<head>
<title>Bestbuy - Home</title>
</head>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
	<h3>All Products</h3>
		<div class="row">
			<c:forEach items="${productList}" var="product">
				<div class="col thumbnail">
					<div class="card">
						<a href="<c:url value="/productDisplay/${product.productId}"/>"><img
							class="card-img-top"
							src="${pageContext.request.contextPath}/resources/images/ProductImages/${product.productId}${product.imageExt}"
							alt="${product.productName}"></a>
						<div class="card-body">
							<h5 class="card-title">
								<a href="<c:url value="/productDisplay/${product.productId}"/>">${product.productName}</a>
							</h5>
							<h6 class="card-text">
								<a href="<c:url value="/productDisplay/${product.productId}"/>"
									class="">Rs.${product.price}/-</a>
							</h6>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>
<%@include file="Footer.jsp" %>