<%@include file="Header.jsp"%>
<html>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
		<h3>${product.productName}</h3>
		<img
			src="${pageContext.request.contextPath}/resources/images/ProductImages/${product.productId}${product.imageExt}"
			alt="${product.productName}" style="width: 150px; height: 150px;" />
		<p>${product.productDesc}</p>
		<p>Rs.${product.price}/-</p>
		<p>Stock: ${product.stock}</p>
		<a href="<c:url value="/addtocart/${product.productId}"/>">
			<button>Add To Cart</button>
		</a>
	</div>

</body>
</html>
<%@include file="Footer.jsp"%>