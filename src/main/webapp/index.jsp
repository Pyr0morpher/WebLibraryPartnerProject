<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Management System</title>
</head>
<body>	
    <h1>Library Management System</h1>
    <form action="showBook" method="get">
        <input type="submit" value="Show Books" />
    </form>
    <a href="updateBook.jsp">Update Books</a>
    <a href="deleteBook.jsp">Delete Books</a>
    <a href="addBook.jsp">Add Books</a>
    <form action="showAuthor" method="get">
        <input type="submit" value="Show Authors" />
    </form>
    <a href="updateAuthor.jsp">Update Authors</a>
    <a href="deleteAuthor.jsp">Delete Authors</a>
    <a href="addAuthor.jsp">Add Authors</a>
</body>
</html>