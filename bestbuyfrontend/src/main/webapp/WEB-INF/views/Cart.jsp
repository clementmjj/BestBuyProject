<%@include file="Header.jsp"%>
<html>
<head>
<title>My Cart</title>
</head>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
		<h3>My Cart</h3>
		<form action="<c:url value="/showOrder/${username}"/>" method="post">
			<div class="table-responsive-sm">
				<table class="table table-hover table-cart">
					<thead class="thead-light">
						<tr>
							<th>Sl No.</th>
							<th>Product</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Total Price</th>
							<th></th>
						</tr>
					</thead>
					<c:if test="${empty(cartItems)}">
						<tr>
							<td colspan="5">Your cart is empty</td>
						</tr>
					</c:if>
					<c:forEach items="${cartItems}" var="cartItem" varStatus="loop">
						<tr>
							<td>${loop.index+1}.</td>
							<td>
								<div class="row">
									<div class="col-sm-2" style="max-height: 50px;">
										<img style="max-height: 100%; max-width: 100%;"
											src="${pageContext.request.contextPath}/resources/images/ProductImages/${cartItem.productId}${cartItem.imageExt}"
											alt="${cartItem.productName}" />
									</div>
									<div class="col-sm-10">
										<h6>${cartItem.productName}</h6>
									</div>
								</div>

							</td>
							<td id="price_${cartItem.productId}">&#8377;${cartItem.price}</td>
							<td><input id="quantity_${cartItem.productId}"
								class="form-control" type="number"
								oninput="updatePrice(this.id)"
								name="${cartItem.productId}_quantity" min="1"
								max="${cartItem.stock}" value="${cartItem.quantity}"
								style="width: 100px;" /></td>
							<td id="totalPrice_${cartItem.productId}" class="productSubtotal">&#8377;${(cartItem.price*cartItem.quantity)}</td>
							<td><a class="link-default"
								href="<c:url value="/deletefromcart/${cartItem.cartItemId}"/>"><i
									data-toggle="tooltip" title="Remove Item" class="fa fa-remove"></i></a></td>
						</tr>
					</c:forEach>
					<thead class="thead-dark">
						<tr>
							<th colspan="4">Grand Total</th>
							<th id="grandTotal" colspan="2"><c:set var="total" value="0" />
								<c:forEach items="${cartItems}" var="cartItem">
									<c:set var="itemTotal"
										value="${(cartItem.price*cartItem.quantity)}" />
									<c:set var="total" value="${(total+itemTotal)}" />
								</c:forEach>&#8377;${total}</th>
						</tr>
					</thead>

				</table>
			</div>
			<div class="d-flex justify-content-between">
				<div>
					<a class="link-default" href="<c:url value="/home"/>">Continue
						Shopping</a>
				</div>
				<div>
					<c:if test="${!empty(cartItems)}">
						<button type="submit" class="btn btn-success">
							<i class="fa fa-shopping-cart"></i> Checkout
						</button>
					</c:if>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>