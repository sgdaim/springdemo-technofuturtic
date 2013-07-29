<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Person list</title>
</head>
<body>
<center>
		<h1>Person list</h1>
		<br>

		<table border="0" cellspacing="10">
			<tr>
				<td>Name</td>
				<td>First name</td>
			</tr>
			<c:forEach items="${persons}"  var="person"> 
				<tr>
					<td>${person.lastName}</td>
					<td>${person.firstName}</td>
				</tr>
			</c:forEach>
		</table>
	</center>
		<a href="person/create">Create person</a><br/>	
		<a href="./">Home</a><br/>			
</body>
</html>