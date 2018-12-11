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
			
			
			<div class="row">
				<div class="col-sm-2">
					<p>Supplier Id</p>
				</div>
				<div class="col-sm-10"><form:input path="supplierId" value="${supplierId}"
							readonly="true" class="form-control" /></div>
			</div>
			<div class="row">
				<div class="col-sm-2">
					<p>Supplier Name</p>
				</div>
				<div class="col-sm-10"><form:input path="supplierName" value="${supplierName}" class="form-control" /></div>
			</div>
			<div class="row">
				<div class="col-sm-2">
					<p>Supplier Address</p>
				</div>
				<div class="col-sm-10"><form:textarea path="supplierAddress"
							value="${supplierAddress}" class="form-control" /></div>
			</div>
			<div class="row">
				<div class="col"><input type="submit" value="Update Supplier" class="btn btn-success form-control" /></div>
			</div>
		</form:form>
	</div>

</body>
</html>
<%@include file="Footer.jsp"%>