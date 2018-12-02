<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://fonts.googleapis.com/css?family=Hind:400,700" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/theme1/css/bootstrap.min.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/theme1/css/slick.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/theme1/css/slick-theme.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/theme1/css/nouislider.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/theme1/css/font-awesome.min.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/theme1/css/style.css"/>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/theme1/css/styleEdit.css"/>
	
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	
	<!-- jQuery Plugins -->
	<script src="${pageContext.request.contextPath}/resources/themes/theme1/js/main.js"></script>
	<script src="${pageContext.request.contextPath}/resources/themes/theme1/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/themes/theme1/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/themes/theme1/js/slick.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/themes/theme1/js/nouislider.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/themes/theme1/js/jquery.zoom.min.js"></script>
	
	
</head>
<body>
	<p id="demo">demo</p>
	<header>
		<div id="header">
			<div class="container">
				<div class="pull-left">
					<!-- Logo -->
					<div class="header-logo">
						<a class="logo" href="/bestbuyfrontend">
							<img src="${pageContext.request.contextPath}/resources/themes/theme1/images/logo.png" alt="">
						</a>
					</div>
					<!-- /Logo -->
					
					<!-- Search -->
					<div class="header-search">
					
						<form>
							<input class="input search-input" type="text" placeholder="Enter your keyword">
							<select class="input search-categories">
								<option value="0">All Categories</option>
								<c:forEach items="${categoryList}" var="category">
								<option value="${category.categoryId}">${category.categoryName}</option>
								</c:forEach>
							</select>
							<button class="search-btn"><i class="fa fa-search"></i></button>
						</form>
					</div>
					<!-- /Search -->
				</div>
				<div class="pull-right">
					<ul class="header-btns">
					
						<!-- Admin links -->
						<li class="header-account dropdown default-dropdown">
							<div class="dropdown-toggle" role="button" data-toggle="dropdown" aria-expanded="true">
								<div class="header-btns-icon">
									<i class="fa fa-wrench"></i>
								</div>
								<strong class="text-uppercase">Manage <i class="fa fa-caret-down"></i></strong>
							</div>
							<a href="test" class="text-uppercase">test</a>
							<ul class="custom-menu">
								<li><a href="category">Categories</a></li>
								<li><a href="product">Products</a></li>
								<li><a href="supplier">Suppliers</a></li>
							</ul>
						</li>
						<!-- /Admin links -->
						
						<!-- Account -->
						<li class="header-account dropdown default-dropdown">
							<div class="dropdown-toggle" role="button" data-toggle="dropdown" aria-expanded="true">
								<div class="header-btns-icon">
									<i class="fa fa-user-o"></i>
								</div>
								<strong class="text-uppercase">My Account <i class="fa fa-caret-down"></i></strong>
							</div>
							<a href="login" class="text-uppercase">Login</a> / <a href="register" class="text-uppercase">Join</a>
							<ul class="custom-menu">
								<li><a href="#"><i class="fa fa-user-o"></i> My Account</a></li>
								<li><a href="#"><i class="fa fa-check"></i> Checkout</a></li>
								<li><a href="login"><i class="fa fa-unlock-alt"></i> Login</a></li>
								<li><a href="register"><i class="fa fa-user-plus"></i> Create An Account</a></li>
							</ul>
						</li>
						<!-- /Account -->

						<!-- Cart -->
						<li class="header-cart dropdown default-dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<div class="header-btns-icon">
									<i class="fa fa-shopping-cart"></i>
									<span class="qty">3</span>
								</div>
								<strong class="text-uppercase">My Cart:</strong>
								<br>
								<span>35.20$</span>
							</a>
							<div class="custom-menu">
								<div id="shopping-cart">
									<div class="shopping-cart-list">
										<div class="product product-widget">
											<div class="product-thumb">
												<img src="product image link" alt="">
											</div>
											<div class="product-body">
												<h3 class="product-price">$32.50 <span class="qty">x3</span></h3>
												<h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
											</div>
											<button class="cancel-btn"><i class="fa fa-trash"></i></button>
										</div>
									</div>
									<div class="shopping-cart-btns">
										<button class="main-btn">View Cart</button>
										<button class="primary-btn">Checkout <i class="fa fa-arrow-circle-right"></i></button>
									</div>
								</div>
							</div>
						</li>
						<!-- /Cart -->

						<!-- Mobile nav toggle-->
						<li class="nav-toggle">
							<button class="nav-toggle-btn main-btn icon-btn"><i class="fa fa-bars"></i></button>
						</li>
						<!-- / Mobile nav toggle -->
					</ul>
				</div>
			</div>
			<!-- header -->
		</div>
	</header>

	<div id="navigation">
		<!-- container -->
		<div class="container">
			<div id="responsive-nav">
				<!-- category nav -->
				<div class="category-nav">
					<span class="category-header">Categories <i class="fa fa-list"></i></span>
					<ul class="category-list">
						<c:forEach items="${categoryList}" var="category">
						<li>${category.categoryName}</li>
						</c:forEach>
					</ul>
				</div>
				<!-- /category nav -->

				<!-- menu nav -->
				<div class="menu-nav">
					<ul class="menu-list">
						<li><a href="/bestbuyfrontend">Home</a></li>
						<li class="dropdown mega-dropdown"><a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="">Women <i class="fa fa-caret-down"></i></a>
							<div class="custom-menu">
								<div class="row">
									<div class="col-md-4">
										<ul class="list-links">
											<li>Categories</li>
										</ul>
									</div>
								</div>
							</div>
						</li>
						<li class="dropdown mega-dropdown"><a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="">Men <i class="fa fa-caret-down"></i></a>
							<div class="custom-menu">
								<div class="row">
									<div class="col-md-3">
										<ul class="list-links">
											<li>Categories</li>
										</ul>
									</div>
								</div>
							</div>
						</li>
					</ul>
				</div>
				<!-- menu nav -->
			</div>
		</div>
		<!-- /container -->
	</div>
</body>
</html>