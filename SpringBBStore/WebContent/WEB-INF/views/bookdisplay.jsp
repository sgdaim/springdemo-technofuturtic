<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Books Display</title>
</head>

<body>

   <i>The Book Store Book Detail</i>
   <hr/>
   Isbn: ${book.isbn} <br>
   Title: ${book.title} <br>
   Author: ${book.author} <br>
   Price: ${book.price} <br>
   <br>
   <a href="<c:url value='bookedit?id=${book.id}'/>">Edit book</a>  <br>
   <br>
   <form action='<%=response.encodeUrl("shoppingcartadd")%>'>
   		<input type="submit" value="add to cart" />
   		<input type="hidden" name="bookidtoadd" value="${book.id}" />
   </form>
   
	<a href="./">home page</a><br/>
   
</body>
</html>