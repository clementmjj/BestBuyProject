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
				<h5 style="color: #5b0000;">Rs.${product.price}/-</h5>
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
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>