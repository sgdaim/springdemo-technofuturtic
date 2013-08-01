<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>Shopping Cart</title>
</head>
<body>
	<h1>Shopping Cart</h1><br>

	<table cellspacing="10">
		<tr>
			<td>Title</td>
			<td>Author</td>
			<td>ISBN</td>
			<td>Price</td>
			<td>Remove</td>
		</tr>
		
		<c:forEach items="${shoppingCart.books}" var="book">
			<tr>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.isbn}</td>
				<td>${book.price} euros</td>
    			<td> <a href='./shoppingCartRemove?id=${book.id}'>Remove from cart</a></td>
			</tr>
		</c:forEach>
		
		<tr>
		    <td>Total price</td>
		    <td></td>
		    <td></td>
		    <td>${shoppingCart.totalPrice}</td>
	</table>
	
</body>
</html>