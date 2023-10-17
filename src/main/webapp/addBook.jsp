<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add a Book</title>
</head>
<body>
    <form action="addBook" method="post">
        Author First Name:<input type="text" name="firstName" size="25" />
        Author Last Name:<input type="text" name="lastName" size="25" />
        Title: <input type="text" name="title" size="25" />
        Publication Date: <input type="date" name="publicationDate" size="25" />
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
