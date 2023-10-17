<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update a Book</title>
</head>
<body>


	<form action="updateBook" method="post">
		New Title: <input type="text" name="title" size="25" />
		New Publication Date: <input type="date" name="publicationDate" size="25" /> 
		New Author's First Name: <input type="text" name="firstName" size="25" />		
		New Author's Last Name: <input type="text" name="lastName" size="25" />
		Enter the Current Title: <input type="text" name="oldTitle"
			size="25"> <input type="submit" value="Update" />
	</form>

</body>
</html>