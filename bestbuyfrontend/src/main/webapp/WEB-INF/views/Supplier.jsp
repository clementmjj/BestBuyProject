<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>Category Page</h3>

<form action="<c:url value="/addCategory"/>" method="post">
<h5>Add Supplier</h5>
<table>
	<tr>
		<td>Supplier Name </td>
		<td><input type="text" id="supplierName" name="supplierName"/></td>
	</tr>
	<tr>
		<td>Supplier Address </td>
		<td><input type="text" id="supplierAddr" name="supplierAddr"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Add Supplier"/></td>
	</tr>
</table>
</form>

<h5>Existing Suppliers</h5>
<table>
	<tr>
		<td>Supplier ID</td>
		<td>Supplier Name</td>
		<td>Supplier Address</td>
		<td>Operations</td>
	</tr>
	<c:forEach items="${supplierList}" var="supplier">
	<tr>
		<td>${supplier.supplierId}</td>
		<td>${supplier.supplierName}</td>
		<td>${supplier.supplierAddress}</td>
		<td>
			<a href="<c:url value="/editCategory/${supplier.supplierId}"/>">Edit</a>
			<a href="<c:url value="/deleteCategory/${supplier.supplierId}"/>">Delete</a>
		</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>