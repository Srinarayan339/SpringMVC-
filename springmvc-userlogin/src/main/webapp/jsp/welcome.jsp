<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<div>
				<c:if test="${not empty errorPass}">
					<div >${errorPass}</div>
				</c:if>
			
	</div>
	<div>
				<c:if test="${not empty errorNum}">
					<div >${errorNum}</div>
				</c:if>
			
	</div>
	<table>
		<tr>
			<td>Welcome ${Username}</td>
		</tr>
		<tr>
		</tr>
		<tr>
		</tr>
		<tr>
			<td><a href="home.jsp">Home</a></td>
		</tr>
	</table>
</body>
</html>