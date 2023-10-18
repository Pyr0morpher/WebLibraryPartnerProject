package helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Author;
import model.Book;

public class BookHelper {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("WebLibraryPartnerProject");
	AuthorHelper authorHelper = new AuthorHelper();

	// method to add book
	public void add(Book model) {
		EntityManager manager = factory.createEntityManager();
		Author existingAuthor = authorHelper.searchAuthorByName(model.getAuthor().getFirstName(),
				model.getAuthor().getLastName());

		if (existingAuthor != null) {
			// Author already exists, use the existing author
			model.setAuthor(existingAuthor);
		}

		// Persist the book
		manager.getTransaction().begin();
		manager.persist(model);
		manager.getTransaction().commit();
		manager.close();
	}

	// method to delete Book
	public void delete(Book model) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.find(Book.class, model.getId()));
		manager.getTransaction().commit();
		manager.close();
	}

	// method to search for book using JPQL query
	public Book searchBookByTitle(String oldName) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Book> query = manager.createQuery("SELECT b FROM book AS b WHERE b.title = :bookTitle", Book.class);
		query.setParameter("bookTitle", oldName);
		Book dbEntity = query.getSingleResult();
		manager.close();
		return dbEntity;
	}

	// method to show books using JPQL query
	@SuppressWarnings("unchecked")
	public List<Book> showAllBooks() {
		EntityManager manager = factory.createEntityManager();
		List<Book> allItems = manager.createQuery("SELECT i FROM book i").getResultList();
		manager.close();
		return allItems;

	}

	// method to update books
	public void update(Book model) {
		EntityManager manager = factory.createEntityManager();
		model.setAuthor(
				authorHelper.searchAuthorByName(model.getAuthor().getFirstName(), model.getAuthor().getLastName()));
		Book dbEntity = manager.find(Book.class, model.getId());
		manager.getTransaction().begin();
		dbEntity.setTitle(model.getTitle());
		dbEntity.setPublicationDate(model.getPublicationDate());
		dbEntity.setAuthor(model.getAuthor());
		manager.getTransaction().commit();
		manager.close();

	}

}
