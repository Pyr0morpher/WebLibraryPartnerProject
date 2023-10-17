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
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookHelper helper = new BookHelper();
		List<Book> bookList = helper.showAllBooks();
		request.setAttribute("allBooks", bookList);
		String path = "/showBook.jsp";
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
