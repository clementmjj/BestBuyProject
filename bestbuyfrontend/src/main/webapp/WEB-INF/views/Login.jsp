<%@include file="Header.jsp" %>

<html>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
			<h3>Login</h3>
			<form:form action="loginUser" modelAttribute="login">
				<table>
					<tr>
						<td>Username</td>
						<td><form:input path="userName"/></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><form:password path="password"/></td>
					</tr>
					<tr>
						<td><input type="submit" value="Login"/></td>
					</tr>
				</table>
			</form:form>
		</div>
	</body>
</html>
<%@include file="Footer.jsp" %>