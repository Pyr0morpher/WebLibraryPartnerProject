package controllerbook;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.AuthorHelper;
import helper.BookHelper;
import model.Author;
import model.Book;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/addBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for the AddBook servlet.
	 */
	public AddBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Handle HTTP POST requests. This method is called when the form is submitted
	 * to add a new book.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book a = new Book();
		BookHelper helper = new BookHelper();
		// Set the book title from the form parameter
		a.setTitle(request.getParameter("title"));

		// Format and parse the publicationDate
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateStr = request.getParameter("publicationDate");
		LocalDate publicationDate = LocalDate.parse(dateStr, formatter);
		a.setPublicationDate(publicationDate);

		AuthorHelper authorHelper = new AuthorHelper();
		Author author = authorHelper.searchAuthorByName(request.getParameter("firstName"),
				request.getParameter("lastName"));
		if (author == null) {
			author = new Author();
			author.setFirstName(request.getParameter("firstName"));
			author.setLastName(request.getParameter("lastName"));
		} else {
			a.setAuthor(author);
			author.getBooks().add(a);
		}

		// Call the helper method to add the book to the database
		helper.add(a);
		// Redirect to the index.jsp page after adding the book
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
