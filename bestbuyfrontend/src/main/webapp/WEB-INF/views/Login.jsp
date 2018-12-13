<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Login</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/themes/theme1/css/styles.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body class="bg-dark">
	<div class="container-fluid" id="body-container">
		<div class="d-flex justify-content-center">
			<div style="text-align: center;">
				<div class="row">
					<div class="col">
						<a href="<c:url value="/"/>"><img style="width: 75%;"
							src="${pageContext.request.contextPath}/resources/themes/theme1/images/logo.png"></a>
					</div>
				</div>
				<div id="login_controls" class="row bg-light">
					<div class="col">
						<h3>Login</h3>
						<p>Please enter your username and password</p>
						<form action=""${pageContext.request.contextPath}/j_spring_security_check"
							method="post">
							<div class="row">
								<div class="col">
									<input type="text" name="username" placeholder="Username"
										class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col">
									<input type="password" name="password" placeholder="Password"
										class="form-control" />
								</div>
							</div>
							<div class="row">
								<div class="col">
									<input type="submit" value="Login" name="submit"
										class="form-control btn btn-primary" /> 
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>


		<div id="login_container"></div>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>