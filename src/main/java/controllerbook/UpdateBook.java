package controllerbook;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.BookHelper;
import model.Author;
import model.Book;

/**
 * Servlet implementation class UpdateBook
 */
@WebServlet("/updateBook")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for the UpdateBook servlet.
	 */
	public UpdateBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Handle HTTP POST requests. This method is called when the form is submitted
	 * to update a book.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookHelper helper = new BookHelper();

		// Get the old title and new title from the request parameters
		String oldTitle = request.getParameter("oldTitle");
		String bookTitle = request.getParameter("title");

		// Format and parse the publicationDate
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate publicationDate = LocalDate.parse(request.getParameter("publicationDate"), formatter);

		// Create an author object and set first name and last name from the form
		// parameters
		Author author = new Author();
		author.setFirstName(request.getParameter("firstName"));
		author.setLastName(request.getParameter("lastName"));

		// Search for the book to be updated by its old title
		Book bookToUpdate = helper.searchBookByTitle(oldTitle);
		// Set the new title, publication date, and author
		bookToUpdate.setTitle(bookTitle);
		bookToUpdate.setPublicationDate(publicationDate);
		bookToUpdate.setAuthor(author);

		// Call the helper method to update the book in the database
		helper.update(bookToUpdate);

		// Redirect to the index.jsp page after updating the book
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
