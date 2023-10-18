<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete an Author</title>
</head>
<body>

	<form action="deleteAuthor" method="post">
		Enter first name of Author to delete: <input type="text"
			name="firstName" size="25"> Enter last name of Author to
		delete: <input type="text" name="lastName" size="25"> <input
			type="submit" value="Delete" />
	</form>
</body>
</html>