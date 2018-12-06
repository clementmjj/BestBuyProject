<%@include file="Header.jsp" %>
<html>
<body>
	<h3>${product.productName}</h3>
	<img src="${pageContext.request.contextPath}/resources/images/${product.productId}.JPG" alt="${product.productName}" style="width: 150px; height: 150px;"/>	
	<p>${product.productDesc}</p>
	<p>Rs.${product.price}/-</p>
	<p>Stock: ${product.stock}</p>
	<button>Buy Now</button>
	<button>Add To Cart</button>
	
</body>
</html>
<%@include file="Footer.jsp" %>