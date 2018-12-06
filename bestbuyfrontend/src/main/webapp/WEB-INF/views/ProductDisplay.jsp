<%@include file="Header.jsp" %>
<html>
<body>
<img src="${pageContext.request.contextPath}/resources/images/${product.productId}.jpg" alt="${product.productName}"/>
	<h3>${product.productName}</h3>
	<p>${product.productDesc}</p>
	<p>Rs.${product.price}/-</p>
	<p>Stock: ${product.stock}</p>
	<button>Buy Now</button>
	<button>Add To Cart</button>
	
</body>
</html>
<%@include file="Footer.jsp" %>