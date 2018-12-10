<%@include file="WEB-INF/views/Header.jsp"%>
<html>
<head>
<title>Welcome to Bestbuy</title>
<style>
.carousel-inner img {
	width: 100%;
}
</style>
</head>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
		<div id="carousel-container" class="carousel slide"
			data-ride="carousel">
			<ul class="carousel-indicators">
				<li data-target="#demo" data-slide-to="0" class="active"></li>
				<li data-target="#demo" data-slide-to="1"></li>
				<li data-target="#demo" data-slide-to="2"></li>
				<li data-target="#demo" data-slide-to="3"></li>
			</ul>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img
						src="${pageContext.request.contextPath}/resources/images/Carousel/img1.jpg"
						alt="img1">
				</div>
				<div class="carousel-item">
					<img
						src="${pageContext.request.contextPath}/resources/images/Carousel/img2.jpg"
						alt="img2">
				</div>
				<div class="carousel-item">
					<img
						src="${pageContext.request.contextPath}/resources/images/Carousel/img3.jpg"
						alt="img3">
				</div>
				<div class="carousel-item">
					<img
						src="${pageContext.request.contextPath}/resources/images/Carousel/img4.jpg"
						alt="img4">
				</div>
			</div>
			<a class="carousel-control-prev" href="#carousel-container"
				data-slide="prev"> <span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next" href="#carousel-container"
				data-slide="next"> <span class="carousel-control-next-icon"></span>
			</a>
		</div>
	</div>
</body>
</html>
<%@include file="WEB-INF/views/Footer.jsp"%>