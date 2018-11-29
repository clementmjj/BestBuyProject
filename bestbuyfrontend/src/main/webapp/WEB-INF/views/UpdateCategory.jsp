<%@include file="Header.jsp" %>
<!-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->

<h3 align="center">Update Category Page</h3>

<form action="<c:url value="/updateCategory"/>" method="post">

<table>
	<tr>
		<td>Category ID </td>
		<td><input type="text" id="categoryId" name="categoryId" value="${category.categoryId}" readonly/></td>
	</tr>
	<tr>
		<td>Category Name </td>
		<td><input type="text" id="categoryName" name="categoryName" value="${category.categoryName}"/></td>
	</tr>
	<tr>
		<td>Category Desc </td>
		<td><input type="text" id="categoryDesc" name="categoryDesc" value="${category.categoryDesc}"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Update Category"/></td>
	</tr>
</table>
</form>