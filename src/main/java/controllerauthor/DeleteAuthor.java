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
     * Constructor for the DeleteAuthor servlet.
     */
    public DeleteAuthor() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Handle HTTP POST requests.
     * This method is called when the form is submitted to delete an author.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AuthorHelper helper = new AuthorHelper();
        // Get the first name and last name of the author to be deleted from the request parameters
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        // Search for the author by name and get the author object
        Author deleteable = helper.searchAuthorByName(firstName, lastName);
        // Call the helper method to delete the author from the database
        helper.delete(deleteable);
        // Redirect to the index.jsp page after deleting the author
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
