<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/login" method="post">
		<input name="userEmail" type="email" placeholder="Enter Email" />
		<br>
		<br>
		<input name="userPassword" type="password" placeholder="Enter password" />
		<br>
		<br>
		<input type="submit" value="Submit"/>
		<input type="button" value="Register" onclick="gotoRagister()"/>
	</form>
	
	<script>
		function gotoRagister()
		{
			alert("go to register page");
			document.location.href="/register";
		}
	</script>
</body>
</html>