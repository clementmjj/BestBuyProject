<%@include file="/WEB-INF/views/Header.jsp" %>
<html>
<body>
	<c:forEach items="${categoryList}" var="category">
	<p>${category.categoryId} | ${category.categoryName}</p>
	</c:forEach>
	<p>ddd ${string}</p>
</body>
</html>