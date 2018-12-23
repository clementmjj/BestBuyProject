<%@include file="Header.jsp"%>
<html>
<head>
<title>Update Supplier</title>
</head>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
		<h3>Update Supplier</h3>
		<form:form action="${pageContext.request.contextPath}/updateSupplier"
			modelAttribute="updateSupplier">
			<div class="form-group">
				<label>Supplier Id</label>
				<form:input path="supplierId" value="${supplierId}" readonly="true"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Supplier Name</label>
				<form:input path="supplierName" value="${supplierName}"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Supplier Address</label>
				<form:textarea path="supplierAddress" value="${supplierAddress}"
					class="form-control" />
			</div>
			<input type="submit" value="Update Supplier"
				class="btn btn-success form-control" />
		</form:form>
	</div>

</body>
</html>
<%@include file="Footer.jsp"%>