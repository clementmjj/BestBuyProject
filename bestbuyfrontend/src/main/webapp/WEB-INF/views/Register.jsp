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
									<form:errors path="userFullName"/>
							</div>
							<div class="col">
								<form:input path="email" placeholder="Email"
									class="form-control" />
									<form:errors path="email"/>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<form:input path="mobileNo" placeholder="Mobile Number"
									class="form-control" />
									<form:errors path="mobileNo"/>
							</div>
							<div class="col">
								<form:textarea path="userAddress" placeholder="Address"
									class="form-control" />
									<form:errors path="userAddress"/>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<form:input path="username" placeholder="Username"
									class="form-control" />
									<form:errors path="username"/>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<form:password path="password" placeholder="Password"
									class="form-control" />
									<form:errors path="password"/>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<form:input path="confirmPassword" placeholder="Confirm Password" class="form-control" />
								<form:errors path="confirmPassword"/>
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