package controllerauthor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.AuthorHelper;
import model.Author;

/**
 * Servlet implementation class ShowAuthor
 */
@WebServlet("/showAuthor")
public class ShowAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowAuthor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AuthorHelper helper = new AuthorHelper();
		List<Author> authorList = helper.showAllAuthors();
		request.setAttribute("allAuthors", authorList);
		String path = "/showAuthor.jsp";
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
