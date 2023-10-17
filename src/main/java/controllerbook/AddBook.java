package controllerbook;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book a = new Book();
        BookHelper helper = new BookHelper();
        a.setTitle(request.getParameter("title"));

        // Format and parse the publicationDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateStr = request.getParameter("publicationDate");
        try {
            LocalDate publicationDate = LocalDate.parse(dateStr, formatter);
            a.setPublicationDate(publicationDate);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }


        Author author = new Author();
        author.setFirstName(request.getParameter("firstName"));
        author.setLastName(request.getParameter("lastName"));

        a.setAuthor(author); // Set the author for the book
        author.getBooks().add(a);

        helper.add(a);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }



}
