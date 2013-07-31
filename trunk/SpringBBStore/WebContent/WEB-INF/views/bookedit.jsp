<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book editing</title>
</head>
<body>
	<h1>Edit Book</h1>
	<form:form modelAttribute="book" method="post" action="book/editsubmit">
		<table>
		<tr>
			<td>
				<form:hidden path="id" />
				<form:input path="title" />	<br>
				<form:input path="price" />euros<br>
				<form:input path="isbn" />  <br>
				<input type="submit" value="Save" />
		    </td>
		</tr>
		</table>
	</form:form>
</body>
</html>