<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
</head>

<body>
    <h1>Login</h1>
	<form method='POST' action='loginsubmit'>
		username: <input type='text' name='username' value="${param.username}"/> <br/>
		password: <input type='password' name='password'/> <br/>
		<input type='submit' value='OK'> <br/>
	</form>
</body>
</html>