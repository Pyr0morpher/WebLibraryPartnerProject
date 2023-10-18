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
	<ul>
		<li><form action="showBook" method="get">
				<input type="submit" value="Show Books" />
			</form></li>
		<li><a href="updateBook.jsp">Update Books</a></li>
		<li><a href="deleteBook.jsp">Delete Books</a></li>
		<li><a href="addBook.jsp">Add Books</a></li>
	</ul>
	<ul>
		<li><form action="showAuthor" method="get">
				<input type="submit" value="Show Authors" />
			</form></li>
		<li><a href="updateAuthor.jsp">Update Authors</a></li>
		<li><a href="deleteAuthor.jsp">Delete Authors</a></li>
		<li><a href="addAuthor.jsp">Add Authors</a></li>
	</ul>
</body>
</html>
