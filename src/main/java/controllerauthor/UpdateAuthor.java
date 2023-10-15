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
 * Servlet implementation class UpdateAuthor
 */
@WebServlet("/updateAuthor")
public class UpdateAuthor extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateAuthor() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AuthorHelper helper = new AuthorHelper();
        
        // Retrieve data from the form
        String oldFirstName = request.getParameter("oldFirstName");
        String oldLastName = request.getParameter("oldLastName");
        String newFirstName = request.getParameter("newFirstName");
        String newLastName = request.getParameter("newLastName");
        
        // Check if the author with the old first and last name exists
        Author existingAuthor = helper.searchAuthorByName(oldFirstName, oldLastName);
        existingAuthor.setFirstName(newFirstName);
        existingAuthor.setLastName(newLastName);
        helper.update(existingAuthor);
   

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
