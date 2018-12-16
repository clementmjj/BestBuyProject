<%@include file="Header.jsp"%>
<html>
<head>
<title>Receipt</title>
</head>
<body class="bg-light">
	<div class="container" id="body-container"
		style="background-color: #fff;">


		<div class="row">
			<div class="col-sm-3">
				<h2>RECEIPT</h2>
			</div>
			<div class="col-sm-9">
				<div class="row">
					<div class="col">
						<b>Order Id:</b> ${order.orderId}
					</div>
					<div class="col">
						<b>Order Date:</b> ${order.orderDate}
					</div>
				</div>
				<div class="row">
					<div class="col">
						<b>Shipping Address:</b> ${user.userAddress}
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<div class="table-responsive-sm">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Sl No.</th>
								<th>Product Name</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Total Price</th>
							</tr>
						</thead>
						<c:forEach items="${itemList}" var="item" varStatus="loop">
							<tr>
								<td>${loop.count}.</td>
								<td>${item.productName}</td>
								<td>${item.price}</td>
								<td>${item.quantity}</td>
								<td>${item.price*item.quantity}</td>
							</tr>
						</c:forEach>
						<thead>
							<tr>
								<th colspan="4">Grand Total</th>
								<th>${order.totalAmount}</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<div class="d-flex justify-content-end">
					<div><small>Ordered Through</small><br> <img
						src="${pageContext.request.contextPath}/resources/themes/theme1/images/logo.png"
						alt="logo" style="width: 100px;"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>