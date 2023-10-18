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
     * Constructor for the AddAuthor servlet.
     */
    public AddAuthor() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Handle HTTP POST requests.
     * This method is called when the form is submitted to add a new author.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Author a = new Author();
        AuthorHelper helper = new AuthorHelper();
        // Set the first name and last name of the author from the form parameters
        a.setFirstName(request.getParameter("firstName"));
        a.setLastName(request.getParameter("lastName"));
        // Call the helper method to add the author to the database
        helper.add(a);
        // Redirect to the index.jsp page after adding the author
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
