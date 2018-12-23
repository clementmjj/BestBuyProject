<%@include file="Header.jsp"%>
<html>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
		<h3>Update Category</h3>
		<form action="${pageContext.request.contextPath}/updateCategory"
			method="post">
			<div class="form-group">
				<label>Category ID</label> <input type="text" id="categoryId"
					name="categoryId" value="${category.categoryId}"
					class="form-control" readonly />
			</div>
			<div class="form-group">
				<label>Category Name</label> <input type="text" id="categoryName"
					name="categoryName" value="${category.categoryName}"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Category Desc</label>
				<textarea rows="4" id="categoryDesc" name="categoryDesc"
					class="form-control">${category.categoryDesc}</textarea>
			</div>
			<input type="submit" value="Update Category"
				class="btn btn-success form-control" />
		</form>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>