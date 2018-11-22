<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="Header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
</head>
<body>
	<h3>Category</h3>
	<form action="addCategory" method="post">
		<table>
			<tr>
				<td>Category name</td>
				<td><input type="text" name="categoryName"/>
			</tr>
			<tr>
				<td>Category Desc</td>
				<td><input type="text" name="categoryDesc"/></td>
			</tr>
		</table>
	</form>
</body>
</html>