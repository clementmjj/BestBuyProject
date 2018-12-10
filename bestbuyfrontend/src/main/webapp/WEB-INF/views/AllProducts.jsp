<%@include file="Header.jsp"%>
<html>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
		<div class="row">
			<c:forEach items="${productList}" var="product">
				<div class="col thumbnail">
					<div class="card" style="width: 100%">
						<a href="<c:url value="/productDisplay/${product.productId}"/>"><img style="height:200px;"
							class="card-img-top"
							src="${pageContext.request.contextPath}/resources/images/ProductImages/${product.productId}${product.imageExt}"
							alt="Card image" style="width: 100%"></a>
						<div class="card-body">
							<h4 class="card-title">
								<a href="<c:url value="/productDisplay/${product.productId}"/>">
									<h6>${product.productName}</h6>
								</a>
							</h4>
							<a href="<c:url value="/productDisplay/${product.productId}"/>"
								class="btn btn-link">Rs.${product.price}/-</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>


</body>
</html>
<%@include file="Footer.jsp"%>