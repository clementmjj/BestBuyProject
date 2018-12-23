<%@include file="Header.jsp"%>
<html>
<head>
<title>Bestbuy - Admin Home</title>
</head>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
		<h3>Welcome Admin!</h3>
		<div class="row">
			<div class="col">
				<h6>Manage:</h6>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<a style="margin: 10px;" href="<c:url value="/category"/>"
					class="btn btn-primary">Categories</a>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<a style="margin: 10px;" href="<c:url value="/product"/>"
					class="btn btn-primary">Products</a>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<a style="margin: 10px;" href="<c:url value="/supplier"/>"
					class="btn btn-primary">Suppliers</a>
			</div>
		</div>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>