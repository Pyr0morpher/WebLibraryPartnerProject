package controllerauthor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.AuthorHelper;
import model.Author;

/**
 * Servlet implementation class AddAuthor
 */
@WebServlet("/addAuthor")
public class AddAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAuthor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Author a = new Author();
		AuthorHelper helper = new AuthorHelper();
		a.setFirstName(request.getParameter("firstName"));
		a.setLastName(request.getParameter("lastName"));
		helper.add(a);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
