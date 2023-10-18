package controllerbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.BookHelper;
import model.Book;

/**
 * Servlet implementation class ShowBook
 */
@WebServlet("/showBook")
public class ShowBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for the ShowBook servlet.
	 */
	public ShowBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Handle HTTP GET requests. This method is called when a user accesses the
	 * "showBook" page.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookHelper helper = new BookHelper();
		// Retrieve a list of all books using the helper
		List<Book> bookList = helper.showAllBooks();
		// Set the list of books as an attribute in the request
		request.setAttribute("allBooks", bookList);
		String path = "/showBook.jsp"; // The JSP page to display the list of books
		// Forward the request to the JSP page for rendering
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}
