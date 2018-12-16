<%@include file="Header.jsp"%>
<html>
<head>
<title>My Orders</title>
</head>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
		<div class="table-responsive-sm">
			<table class="table table-hover table-cart">
				<thead class="thead-light">
					<tr>
						<th>Sl No.</th>
						<th>Order Id</th>
						<th>Order Date</th>
						<th>Payment Mode</th>
						<th>Total Amount</th>
						<th>View Receipt</th>
					</tr>
				</thead>
				<c:forEach items="${ordersList}" var="order" varStatus="loop">
					<tr>
						<td>${loop.count}.</td>
						<td>${order.orderId}</td>
						<td>${order.orderDate}</td>
						<td>${order.paymentMode}</td>
						<td>&#8377;${order.totalAmount}</td>
						<td><a href="<c:url value="/receipt/${order.orderId}"/>"><i class="fa fa-file-text"></i></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>