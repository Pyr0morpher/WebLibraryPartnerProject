<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authors and their Books</title>
</head>
<body>
	List of all Authors and their Books:
	<table>
		<c:forEach items="${requestScope.allAuthors}" var="currentauthor">
			<tr>
				<td>${currentauthor.lastName},</td>
				<td>${currentauthor.firstName}</td>

			</tr>
			<c:forEach items="${currentauthor.books}" var="currentbook">
				<tr>
					<td>${currentbook.title}|</td>
					<td>${currentbook.publicationDate}</td>
				</tr>
			</c:forEach>

		</c:forEach>
	</table>
	<br />
	<a href="index.jsp">Home</a>

</body>
</html>