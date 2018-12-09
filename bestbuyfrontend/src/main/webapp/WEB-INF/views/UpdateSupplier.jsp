<%@include file="Header.jsp"%>
<html>
<head>
<title>Update Supplier</title>
</head>
<body>
	<div id="body-container">
		<h3>Update Supplier ${supplier.supplierName} (Id: ${supplierId})</h3>
		<form:form action="/bestbuyfrontend/updateSupplier"
			modelAttribute="updateSupplier">
			<table>
				<tr>
					<td>Supplier Id</td>
					<td><form:input path="supplierId" value="${supplierId}"
							readonly="true" /></td>
				</tr>
				<tr>
					<td>Supplier Name</td>
					<td><form:input path="supplierName" value="${supplierName}" /></td>
				</tr>
				<tr>
					<td>Supplier Address</td>
					<td><form:textarea path="supplierAddress"
							value="${supplierAddress}" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update Supplier" /></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>
<%@include file="Footer.jsp"%>