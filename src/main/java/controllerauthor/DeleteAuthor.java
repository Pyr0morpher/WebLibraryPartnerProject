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
 * Servlet implementation class DeleteAuthor
 */
@WebServlet("/deleteAuthor")
public class DeleteAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteAuthor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AuthorHelper helper = new AuthorHelper();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Author deleteable = helper.searchAuthorByName(firstName, lastName);
		helper.delete(deleteable);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

	}

}
