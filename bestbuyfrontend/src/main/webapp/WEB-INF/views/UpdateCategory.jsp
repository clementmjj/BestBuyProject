<%@include file="Header.jsp"%>
<html>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
		<h3>Update Category</h3>
		<form action="updateCategory" method="post">

			<div class="row">
				<div class="col-sm-2">
					<p>Category ID</p>
				</div>
				<div class="col-sm-10"><input type="text" id="categoryId" name="categoryId"
						value="${category.categoryId}" class="form-control" readonly /></div>
			</div>
			<div class="row">
				<div class="col-sm-2">
					<p>Category Name</p>
				</div>
				<div class="col-sm-10"><input type="text" id="categoryName" name="categoryName"
						value="${category.categoryName}" class="form-control" /></div>
			</div>
			<div class="row">
				<div class="col-sm-2">
					<p>Category Desc</p>
				</div>
				<div class="col-sm-10"><input type="text" id="categoryDesc" name="categoryDesc"
						value="${category.categoryDesc}" class="form-control" /></div>
			</div>
			<div class="row">
				<div class="col"><input type="submit" value="Update Category" class="btn btn-success form-control" /></div>
			</div>
		</form>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>