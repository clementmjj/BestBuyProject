<%@include file="Header.jsp"%>
<html>
<head>
<title>${product.productName} - Bestbuy</title>
</head>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
	
		<div class="row">
			<div class="col-sm-3">
				<img
			src="${pageContext.request.contextPath}/resources/images/ProductImages/${product.productId}${product.imageExt}"
			alt="${product.productName}" style="width: 100%;" />
			</div>
			<div class="col-sm-7">
				<h3>${product.productName}</h3>
				<h6>Rs.${product.price}/-</h6>
				<p>${product.productDesc}</p>
				<p>Stock: ${product.stock}</p>
			</div>
			<div class="col-sm-2">
			<a class="btn btn-primary" href="<c:url value="/addtocart/${product.productId}"/>">Add To Cart</a>
			</div>
		</div>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>