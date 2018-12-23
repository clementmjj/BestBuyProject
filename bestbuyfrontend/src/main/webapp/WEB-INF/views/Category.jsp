<%@include file="Header.jsp"%>
<html>
<head>
<title>Manage Categories</title>
<c:if test="${errors==true}">
	<script>
		function showAddCategoryWithErrors() {
			document.getElementById("btn-addCategory").click();
		}
		window.onload = showAddCategoryWithErrors;
	</script>
</c:if>
</head>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
		<c:if test="${deleteError==true}">
			<div class="alert alert-warning alert-dismissible">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Delete Error!</strong> 1 or more products fall under this
				category. Please delete all the products that fall under this
				category and try again.
			</div>
		</c:if>
		<div class="modal fade" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h3 class="modal-title">Add Category</h3>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<form action="<c:url value="/addCategory"/>" method="post">
							<div class="form-group">
								<label>Category Name</label> <input type="text"
									id="categoryName" name="categoryName" class="form-control" />
								<c:if test="${!empty(category_name_errors)}">
									<p class="error-text">
										<c:forEach items="${category_name_errors}" var="error">${error}<br>
										</c:forEach>
									</p>
								</c:if>
							</div>
							<div class="form-group">
								<label>Category Description</label> <input type="text"
									id="categoryDesc" name="categoryDesc" class="form-control" />
								<c:if test="${!empty(category_desc_errors)}">
									<p class="error-text">
										<c:forEach items="${category_desc_errors}" var="error">${error}<br>
										</c:forEach>
									</p>
								</c:if>
							</div>
							<input type="submit" value="Add"
								class="form-control btn btn-success" />
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>

		<div class="d-flex justify-content-between">
			<div>
				<h3>Category list</h3>
			</div>
			<div>
				<button id="btn-addCategory" type="button" class="btn btn-primary"
					data-toggle="modal" data-target="#myModal">
					<i class="fa fa-plus"></i> Add Category
				</button>
			</div>
		</div>
		<div class="table-responsive-sm">
			<table class="table table-hover table-sm">
				<thead class="thead-light">
					<tr>
						<th>Category ID</th>
						<th>Category Name</th>
						<th>Category Desc</th>
						<th>Operations</th>
					</tr>
				</thead>

				<c:forEach items="${categoryList}" var="category">
					<tr>
						<td>${category.categoryId}</td>
						<td>${category.categoryName}</td>
						<td>${category.categoryDesc}</td>
						<td><a class="link-default"
							href="<c:url value="/editCategory/${category.categoryId}"/>"><i
								data-toggle="tooltip" title="Edit" class="fa fa-pencil"></i></a> | <a
							class="link-default"
							href="<c:url value="/deleteCategory/${category.categoryId}"/>"><i
								data-toggle="tooltip" title="Delete" class="fa fa-trash-o"></i></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>