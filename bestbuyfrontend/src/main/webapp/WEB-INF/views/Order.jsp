<%@include file="Header.jsp"%>
<html>
<head>
<title>My Order</title>
<script>
	window.onload = showPaymentForm;
</script>

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
		<div class="d-flex justify-content-start">
			<div class="row">
				<div class="col">
					<c:if test="${errorsList!=null}">
						<div id="errors-container">
							<div class="alert alert-danger alert-dismissible">
								<button type="button" id="error-box-close-button" class="close"
									data-dismiss="alert">&times;</button>
								<c:forEach items="${errorsList}" var="error">
									<strong>Error!</strong> ${error}<br>
								</c:forEach>
							</div>
						</div>
					</c:if>
					<form:form modelAttribute="orderDetail"
						action="${pageContext.request.contextPath}/confirmOrder"
						method="post">
						<div class="row">
							<div class="col">
								<div class="form-group">
									<form:select id="payment-select" path="paymentMode"
										class="form-control"
										onchange="showPaymentForm(), closeErrorContainer()">
										<form:option value="Credit Card">Credit Card</form:option>
										<form:option value="Debit Card">Debit Card</form:option>
										<form:option value="Cash On Delivery">Cash On Delivery</form:option>
									</form:select>
								</div>
								<div id="creditcard-container" style="display: none;">
									<div class="row">
										<div class="col">
											<div class="form-group">
												<label>Credit Card Number</label> <input type="text"
													class="form-control" pattern="[0-9]{16}"
													title="Must be 16 digits" name="CreditCardNo" />
											</div>
										</div>
										<div class="col">
											<div class="form-group">
												<label>Expiry Date</label> <input type="month"
													name="CreditCardExp" min="${ExpMin}" class="form-control" />
											</div>
										</div>
										<div class="col">
											<div class="form-group">
												<label>CVV</label> <input type="text" maxlength="3"
													class="form-control" placeholder="CVV" name="CreditCardCVV" />
											</div>
										</div>
									</div>
								</div>
								<div id="debitcard-container" style="display: none;">
									<div class="row">
										<div class="col">
											<div class="form-group">
												<label>Debit Card Number</label> <input type="text"
													pattern="[0-9]{16}" class="form-control" name="DebitCardNo" />
											</div>
										</div>
										<div class="col">
											<div class="form-group">
												<label>Expiry Date</label> <input type="month"
													class="form-control" placeholder="Expiry Date"
													min="${ExpMin}" name="DebitCardExp" />
											</div>
										</div>
										<div class="col">
											<div class="form-group">
												<label>CVV</label> <input type="number" maxlength="3"
													class="form-control" placeholder="CVV" name="DebitCardCVV" />
											</div>
										</div>
									</div>
								</div>
								<div id="cashondelivery-container" style="display: none;"></div>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<button type="submit" class="btn btn-success">Place
									Order</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>