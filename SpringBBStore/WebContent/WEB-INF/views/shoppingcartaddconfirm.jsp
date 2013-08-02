<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Book added to cart</title>
</head>

<body>

   <i>Book ${book.title} added to the cart!</i> <br/>
   <br/>
   <a href="<c:url value='book?id=${book.id}'/>">Back to Book Detail</a>  <br>
   <br/>
   <a href="<c:url value='shoppingcartdisplay'/>">Show shopping cart</a>  <br>
   <br/>
   <a href="./">home page</a><br/>
   
</body>
</html>