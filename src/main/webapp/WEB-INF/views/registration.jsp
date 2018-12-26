<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Products</h1>
		<form:form method="POST" action="${pageContext.request.contextPath}/product/save"	modelAttribute="productbean">
			<table>
				<tr>
					<td>ProductId:</td>
					<td><form:input path="productId" disabled="true" /></td>
				</tr>
				<tr>
					<td>ProductName:</td>
					<td><form:input path="productName" /></td>
				</tr>
				<tr>
					<td>ProductCost:</td>
					<td><form:input path="productCost" /></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Submit" />
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>