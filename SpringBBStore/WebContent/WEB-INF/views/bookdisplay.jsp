<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
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
   <a href="book/edit?id=${book.id}">Edit book</a>
</body>
</html>