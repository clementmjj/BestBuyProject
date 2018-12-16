<%@include file="Header.jsp"%>
<html>
<head>
<title>My Order</title>
</head>
<body>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
		<h3>My Order</h3>
		<div class="table-responsive-sm">
			<table class="table table-hover table-cart">
				<thead class="thead-light">
					<tr>
						<th>Sl No.</th>
						<th>Product Name</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Total Price</th>
					</tr>
				</thead>
				<c:forEach items="${orderItems}" var="orderItem" varStatus="loop">
					<tr>
						<td>${loop.count}.</td>
						<td>${orderItem.productName}</td>
						<td>&#8377;${orderItem.price}</td>
						<td>${orderItem.quantity}</td>
						<td>&#8377;${orderItem.price*orderItem.quantity}</td>
					</tr>
				</c:forEach>
				<thead class="thead-dark">
					<tr>
						<th colspan="4">Grand Total</th>
						<th colspan="2"><c:set var="total" value="0" /> <c:forEach
								items="${orderItems}" var="orderItem">
								<c:set var="itemTotal"
									value="${(orderItem.price*orderItem.quantity)}" />
								<c:set var="total" value="${(total+itemTotal)}" />
							</c:forEach>&#8377;${total}</th>
					</tr>
				</thead>
			</table>
		</div>
		<a class="link-default" href="<c:url value="/allproducts"/>">Continue
			Shopping</a>
		<h4>Choose Payment Mode</h4>
		<form:form modelAttribute="orderDetail"
			action="${pageContext.request.contextPath}/confirmOrder"
			method="post">
			<div class="row">
				<div class="col-sm-3">
					<form:select size="3" class="form-control nav" path="paymentMode">
						<form:option value="Credit Card" class="nav-link"
							data-toggle="tab" href="#creditcard">Credit Card</form:option>
						<form:option value="Debit Card" class="nav-link" data-toggle="tab"
							href="#debitcard">Debit Card</form:option>
						<form:option value="Cash on Delivery" class="nav-link"
							data-toggle="tab" href="#cashondelivery">Cash On Delivery</form:option>
					</form:select>

				</div>
				<div class="col-sm-9">
					<div class="tab-content">
						<div id="creditcard" class="container tab-pane active">
							<input type="text" class="form-control" placeholder="Card Number" />
							<input type="date" class="form-control" placeholder="Expiry Date" />
							<input type="text" class="form-control" placeholder="CVV" />
						</div>
						<div id="debitcard" class="container tab-pane fade">
							<input type="text" class="form-control" placeholder="Card Number" />
							<input type="date" class="form-control" placeholder="Expiry Date" />
							<input type="text" class="form-control" placeholder="CVV" />
						</div>
						<div id="cashondelivery" class="container tab-pane fade">
							<p>cash on delivery details</p>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<button type="submit" class="btn btn-success">Place Order</button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>