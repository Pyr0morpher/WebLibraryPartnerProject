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
     * Constructor for the ShowAuthor servlet.
     */
    public ShowAuthor() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Handle HTTP GET requests.
     * This method is called when a user accesses the "showAuthor" page.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AuthorHelper helper = new AuthorHelper();
        // Retrieve a list of all authors using the helper
        List<Author> authorList = helper.showAllAuthors();
        // Set the list of authors as an attribute in the request
        request.setAttribute("allAuthors", authorList);
        String path = "/showAuthor.jsp"; // The JSP page to display the list of authors
        // Forward the request to the JSP page for rendering
        getServletContext().getRequestDispatcher(path).forward(request, response);
    }
}
