<%@include file="Header.jsp"%>
<html>
<head>
<title>My Cart</title>
</head>
<body>
	<div id="body-container">
		<form action="/bestbuyfrontend/checkout" method="post">
			<table>
				<tr>
					<td>Sl No.</td>
					<td>Product</td>
					<td>Quantity</td>
					<td>Tot Price</td>
					<td>Operations</td>
				</tr>
				<c:forEach items="${cartItems}" var="cartItem" varStatus="loop">
					<tr>
						<td>${loop.index+1}</td>
						<td>${cartItem.productName}<br>
						<img
							src="${pageContext.request.contextPath}/resources/images/ProductImages/${cartItem.productId}${cartItem.imageExt}"
							alt="${cartItem.productName}"
							style="width: 100px; height: 100px;" /></td>
						<td><input type="number" name="quantity" min="1"
							max="${cartItem.stock}" value="${cartItem.quantity}"
							style="width: 100px;" /></td>
						<td>${(cartItem.price*cartItem.quantity)}<br> <a
							href="<c:url value="/updateCartItemPrice/${quantity.value}"/>">Update
								price</a>
						</td>
						<td><a
							href="<c:url value="/deletefromcart/${cartItem.cartItemId}"/>">Delete</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3">Grand Total</td>
					<td><c:set var="total" value="0" /> <c:forEach
							items="${cartItems}" var="cartItem">
							<c:set var="itemTotal"
								value="${(cartItem.price*cartItem.quantity)}" />
							<c:set var="total" value="${(total+itemTotal)}" />
						</c:forEach> ${total}</td>
				</tr>
			</table>
			<input type="submit" value="Checkout
		" />
		</form>
		<a href="<c:url value="/allproducts"/>">Continue Shopping</a>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>