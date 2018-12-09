<%@include file="Header.jsp"%>
<html>
<body>
	<div class="container-fluid">
		<h3>${product.productName}</h3>
		<img
			src="${pageContext.request.contextPath}/resources/images/ProductImages/${product.productId}${product.imageExt}"
			alt="${product.productName}" style="width: 150px; height: 150px;" />
		<p>${product.productDesc}</p>
		<p>Rs.${product.price}/-</p>
		<p>Stock: ${product.stock}</p>
		<a href="<c:url value=""/>"><button>Buy Now</button></a> <a
			href="<c:url value="/addtocart/${product.productId}"/>"><button>Add
				To Cart</button></a>
	</div>

</body>
</html>
<%@include file="Footer.jsp"%>