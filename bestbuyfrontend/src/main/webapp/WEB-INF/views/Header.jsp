<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/themes/theme1/css/styles.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="${pageContext.request.contextPath}/resources/JS/scripts.js"></script>

</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		<!-- Brand -->
		<c:if test="${sessionScope.role==null}">
			<a class="navbar-brand" href="/bestbuyfrontend"> <img
				src="${pageContext.request.contextPath}/resources/themes/theme1/images/logo.png"
				alt="logo" style="width: 100px;">
			</a>
		</c:if>
		<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
			<a class="navbar-brand" href="<c:url value="/adminHome"/>"> <img
				src="${pageContext.request.contextPath}/resources/themes/theme1/images/logo.png"
				alt="logo" style="width: 100px;">
			</a>
		</c:if>
		<c:if test="${sessionScope.role=='ROLE_USER'}">
			<a class="navbar-brand" href="<c:url value="/home"/>"> <img
				src="${pageContext.request.contextPath}/resources/themes/theme1/images/logo.png"
				alt="logo" style="width: 100px;">
			</a>
		</c:if>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<!-- Links -->
			<ul class="navbar-nav mr-auto">
				<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbardrop"
						data-toggle="dropdown"><i class="fa fa-wrench"></i> Manage</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="<c:url value="/category"/>">Categories</a>
							<a class="dropdown-item" href="<c:url value="/product"/>">Products</a>
							<a class="dropdown-item" href="<c:url value="/supplier"/>">Suppliers</a>
						</div></li>
				</c:if>
				<c:if test="${sessionScope.role=='ROLE_USER'}">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/home"/>"><i class="fa fa-home"
							aria-hidden="true"></i> Home</a></li>

				</c:if>
			</ul>
			<c:if test="${sessionScope.loggedIn}">
				<p class="navbar-nav" style="color: #fff;">Welcome ${username}</p>
			</c:if>
			<ul class="navbar-nav">
				<c:if test="${!sessionScope.loggedIn}">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/login"/>"><i class="fa fa-sign-in"></i>
							Login </a></li>
				</c:if>
				<c:if test="${sessionScope.loggedIn}">
					<c:if test="${sessionScope.role=='ROLE_USER'}">
						<li class="nav-item"><a class="nav-link"
							href="<c:url value="/myOrders"/>"><i
								class="fa fa-shopping-bag"></i> My Orders </a></li>
						<li class="nav-item"><a class="nav-link"
							href="<c:url value="/viewcart"/>"><i
								class="fa fa-shopping-cart"></i> My Cart</a></li>
					</c:if>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/perform_logout"/>"><i
							class="fa fa-sign-out"></i> Logout </a></li>
				</c:if>
				<c:if test="${sessionScope.role==null}">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="register"/>"><i class="fa fa fa-user-plus"></i>
							Register </a></li>
				</c:if>
			</ul>
		</div>
	</nav>
</body>
</html>