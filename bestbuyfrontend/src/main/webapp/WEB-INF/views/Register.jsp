<%@include file="Header.jsp"%>
<html>
<head>
<title>Register</title>
</head>
<body class="bg-dark">
	<div class="container-fluid" id="body-container">
		<div class="d-flex justify-content-center">
			<div id="register_controls" class="row bg-light">
				<div class="col">
					<h3>Register</h3>
					<p>Create your account and start shopping with us today.</p>
					<form:form action="addUser" modelAttribute="addUser">
						<div class="row">
							<div class="col">
								<form:input path="userFullName" placeholder="Full Name"
									class="form-control" />
							</div>
							<div class="col">
								<form:input path="email" placeholder="Email"
									class="form-control" />
							</div>
						</div>
						<div class="row">
							<div class="col">
								<form:input path="mobileNo" placeholder="Mobile Number"
									class="form-control" />
							</div>
							<div class="col">
								<form:textarea path="userAddress" placeholder="Address"
									class="form-control" />
							</div>
						</div>
						<div class="row">
							<div class="col">
								<form:input path="userName" placeholder="Username"
									class="form-control" />
							</div>
						</div>
						<div class="row">
							<div class="col">
								<form:password path="password" placeholder="Password"
									class="form-control" />
							</div>
						</div>
						<div class="row">
							<div class="col">
								<input type="text" name="confirmPassword"
									placeholder="Confirm Password" class="form-control" />
							</div>
						</div>
						<div class="row">
							<div class="col">
								<input type="submit" value="Register"
									class="form-control btn btn-primary" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>