<%@include file="Header.jsp"%>

<html>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
		<h3>Create an account and shop with us</h3>
		<form:form action="addUser" modelAttribute="addUser">
			<table>
				<tr>
					<td>Full name</td>
					<td><form:input path="userFullName" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>Mobile No</td>
					<td><form:input path="mobileNo" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><form:textarea path="userAddress" /></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><form:input path="userName" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Register" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>