<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update an Author</title>
</head>
<body>


	<form action="updateAuthor" method="post">
		New First Name: <input type="text" name="newFirstName" size="25" />
		New Last Name: <input type="text" name="newLastName" size="25" /> 
		Enter the current Author's first name: <input type="text" name="oldFirstName" size="25">
		Enter the current Author's last name: <input type="text" name="oldLastName" size="25"> 
		<input type="submit" value="Update" />
	</form>
</html>