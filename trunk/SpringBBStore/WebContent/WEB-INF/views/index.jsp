<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Spring BBStore</title>
</head>

<body>
    Welcome ${sessionScope.username} to the Spring BBStore application!!!<br>
    <br>
    See <a href="<c:url value='booklist'/>">our catalog of books</a>.<br>
    <br>
    See <a href="<c:url value='shoppingcartdisplay'/>">your shopping cart</a>.<br>
    <br>
    <a href="<c:url value='login'/>">Login</a>.<br>
</body>
</html>