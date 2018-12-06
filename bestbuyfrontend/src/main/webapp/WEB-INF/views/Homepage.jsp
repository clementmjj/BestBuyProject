<%@include file="Header.jsp" %>
<html>
<body>
	<c:forEach items="${productList}" var="product">
		<div>
		<a href="<c:url value="productDisplay/${product.productId}" />">
			<h6>${product.productName}</h6>
			<img src="${image}" style="width: 150px; height:150px;"/>
			<p>${product.price}</p>
		</a>
		</div>
	</c:forEach>
</body>
</html>
<%@include file="Footer.jsp" %>