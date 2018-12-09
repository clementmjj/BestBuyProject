<%@include file="Header.jsp"%>
<html>
<body>
	<div id="body-container">
		<form action="<c:url value="/addCategory"/>" method="post">
			<h3>Add Category</h3>
			<table>
				<tr>
					<td>Category Name</td>
					<td><input type="text" id="categoryName" name="categoryName" /></td>
				</tr>
				<tr>
					<td>Category Desc</td>
					<td><input type="text" id="categoryDesc" name="categoryDesc" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Add Category" /></td>
				</tr>
			</table>
		</form>

		<h5>Existing Categories</h5>
		<table>
			<tr>
				<td>Category ID</td>
				<td>Category Name</td>
				<td>Category Desc</td>
				<td>Operations</td>
			</tr>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.categoryId}</td>
					<td>${category.categoryName}</td>
					<td>${category.categoryDesc}</td>
					<td><a
						href="<c:url value="/editCategory/${category.categoryId}"/>">Edit</a>
						<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>