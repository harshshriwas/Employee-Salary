<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/set-user" method="post">
		<input name="email" type="email" placeholder="Enter Email" />
		<br>
		<br>
		<input name="password" type="password" placeholder="Enter Password" />
		<br>
		<br>
		<input name="firstname" type="text" placeholder="Enter First Name" />
		<br>
		<br>
		<input name="lastname" type="text" placeholder="Enter Last Name" />
		<br>
		<br>
		<input name="userdoj" type="text" placeholder="Enter Date of Joining" />
		<br>
		<br>
		
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>