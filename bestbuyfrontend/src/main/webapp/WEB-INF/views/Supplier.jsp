<%@include file="Header.jsp"%>

<html>
<body>
	<div id="body-container">
		<h3>Add Supplier</h3>
		<form:form action="/bestbuyfrontend/addSupplier"
			modelAttribute="addSupplier">
			<table>
				<tr>
					<td>Supplier Name</td>
					<td><form:input path="supplierName" /></td>
				</tr>
				<tr>
					<td>Supplier Address</td>
					<td><form:textarea path="supplierAddress" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add Supplier" /></td>
				</tr>
			</table>
		</form:form>
		<h3>Existing Suppliers</h3>
		<table>
			<tr>
				<td>Supplier Id</td>
				<td>Supplier Name</td>
				<td>Supplier Address</td>
				<td>Operations</td>
			</tr>
			<c:forEach items="${supplierList}" var="supplier">
				<tr>
					<td>${supplier.supplierId}</td>
					<td>${supplier.supplierName}</td>
					<td>${supplier.supplierAddress}</td>
					<td><a
						href="<c:url value="/editSupplier/${supplier.supplierId}"/>">Edit</a>
						| <a
						href="<c:url value="/deleteSupplier/${supplier.supplierId}"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>