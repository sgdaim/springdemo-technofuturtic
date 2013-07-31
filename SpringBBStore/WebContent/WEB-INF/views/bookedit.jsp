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
	<form:form modelAttribute="book" method="post" action="bookeditsubmit">
		<form:hidden path="id" />
		Title: <form:input path="title" />	<br>
		Price: <form:input path="price" />euros<br>
		ISBN: <form:input path="isbn" />  <br>
		<input type="submit" value="Save" />
	</form:form>
</body>
</html>