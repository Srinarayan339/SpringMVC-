<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>More Information</title>
</head>
<body>

	<div>
				<c:if test="${not empty errorNum}">
					<div >${errorNum}</div>
				</c:if>
			
	</div>
	
	<form:form id="moreinfoForm" modelAttribute="moreinformation" action="moreinfoprocess"
		method="post">

		<table align="center">
			<tr>
				<td><form:label path="firstname">FirstName</form:label></td>
				<td><form:input path="firstname" name="firstname" type="text"
						id="firstname" require="required" /></td>
			</tr>
			<tr>
				<td><form:label path="lastname">LastName</form:label></td>
				<td><form:input path="lastname" name="lastname" id="lastname"  require="required" type="text"/></td>
			</tr>
			<tr>
				<td><form:label path="mobile">Mobile</form:label></td>
				<td><form:input path="mobile" name="mobile" id="mobile" require="required" type="number" maxlength="10"/></td>
			</tr>
			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td><form:input path="address" name="address" id="address" /></td>
			</tr>
			<%-- <tr>
				<td><form:label path="dob">DOB</form:label></td>
				<td><form:input path="dob" name="dob" id="dob" type="date"/></td>
			</tr> --%>
			<tr>
				<td><form:label path="qualification">Qualification</form:label></td>
			<td>
				<form method="post" name="qualification">
    			<select id="qualification" name="qualification" ">
        			<option value="dropdown">Select qualification
        			<option value="ug">UG
        			<option value="pg">PG
    			</select>
    			<input type="hidden" name="dropdown" id="dropdown">
    			</form>
    			</td>
			</tr>
			
			<tr>
				<td><form:label path="engprof">English proficiency(Out of 100%)</form:label></td>
				<td><form:input path="engprof" name="engprof" id="engprof" /></td>
			</tr>

			<tr>
				<td></td>
				<td><form:button id="submit" name="submit">Submit</form:button></td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="home.jsp">Home</a></td>
			</tr>
		</table>
	</form:form>

</body>
</html>