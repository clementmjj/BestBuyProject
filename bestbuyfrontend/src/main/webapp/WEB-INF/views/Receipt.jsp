<%@include file="Header.jsp"%>
<html>
<head>
<title>Receipt</title>
</head>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
		<table>
			<thead>
				<th>Sl No.</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Total Price</th>
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
			<tr>
				<td colspan="4">Grand Total</td>
				<td>${order.totalAmount}</td>
			</tr>
		</table>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>