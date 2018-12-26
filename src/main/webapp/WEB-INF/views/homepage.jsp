<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Management Sample App</title>
</head>
<body>
	<div align="center">
		<h1>User's List</h1>
		
		<table border="1">

			<th>ProductId</th>
			<th>ProductName</th>
			<th>ProductCost</th>
			
			<c:forEach var="product" items="${productList}">
				<tr>
					<td>${product.productId}</td>
					<td>${product.productName}</td>
					<td>${product.productCost}</td>
					
					<td><a href="update?id=${product.productId}">EditProduct</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteproduct?id=${product.productId}">DeleteProduct</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New Product Register <a href="navigatetoreg">here</a>
		</h4>
	</div>
</body>
</html>