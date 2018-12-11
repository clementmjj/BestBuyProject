<%@include file="Header.jsp"%>
<html>
<head>
<title>My Cart</title>
</head>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
		<h3>My Cart</h3>
		<form action="/bestbuyfrontend/checkout" method="post">
			<div class="table-responsive-sm">
				<table class="table table-hover table-cart">
					<thead class="thead-light">
						<tr>
							<th>Sl No.</th>
							<th>Product</th>
							<th>Quantity</th>
							<th>Tot Price</th>
							<th></th>
						</tr>
					</thead>
					<c:forEach items="${cartItems}" var="cartItem" varStatus="loop">
						<tr>
							<td>${loop.index+1}.</td>
							<td>
								<div class="row">
									<div class="col-sm-3">
										<img style="width: 100px;"
											src="${pageContext.request.contextPath}/resources/images/ProductImages/${cartItem.productId}${cartItem.imageExt}"
											alt="${cartItem.productName}" style="//swidth: 100px;" />
									</div>
									<div class="col-sm-9">
										<h6>${cartItem.productName}</h6>
									</div>
								</div>

							</td>

							<td><input class="form-control" type="number"
								name="quantity" min="1" max="${cartItem.stock}"
								value="${cartItem.quantity}" style="width: 100px;" /></td>
							<td>&#8377;${(cartItem.price*cartItem.quantity)}<br> <a
								class="link-default"
								href="<c:url value="/updateCartItemPrice/${quantity.value}"/>">Update
									price</a>
							</td>
							<td><a class="link-default"
								href="<c:url value="/deletefromcart/${cartItem.cartItemId}"/>"><i
									data-toggle="tooltip" title="Remove Item" class="fa fa-remove"></i></a></td>
						</tr>
					</c:forEach>
					<thead class="thead-dark">
						<tr>
							<th colspan="3">Grand Total</th>
							<th colspan="2"><c:set var="total" value="0" /> <c:forEach
									items="${cartItems}" var="cartItem">
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
					<a class="link-default" href="<c:url value="/allproducts"/>">Continue
						Shopping</a>
				</div>
				<div>
					<button type="submit" class="btn btn-success">
						<i class="fa fa-shopping-cart"></i> Checkout
					</button>
				</div>
			</div>
		</form>

	</div>
</body>
</html>
<%@include file="Footer.jsp"%>