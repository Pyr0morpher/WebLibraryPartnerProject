package helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Author;

public class AuthorHelper {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("WebLibraryPartnerProject");
	
	public void add(Author model) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(model);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void delete(Author model) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.find(Author.class, model.getId()));
		manager.getTransaction().commit();
		manager.close();
	}
	
	public List<Author> showAllAuthors() {
		EntityManager manager = factory.createEntityManager();
		manager.clear();
		Query q = manager.createQuery("SELECT i FROM author i");
		List<Author> allItems = q.getResultList();
		manager.close();
		return allItems;
		
	}

	public void update(Author model) {
		EntityManager manager = factory.createEntityManager();
		Author dbEntity = manager.find(Author.class, model.getId());
		manager.getTransaction().begin();
		dbEntity.setFirstName(model.getFirstName());
		dbEntity.setLastName(model.getLastName());
		manager.getTransaction().commit();
		manager.close();
		
	}

	public Author searchAuthorByName(String firstName, String lastName) {
	    EntityManager manager = factory.createEntityManager();
	    TypedQuery<Author> query = manager.createQuery("SELECT i FROM author AS i WHERE i.firstName = :firstName AND i.lastName = :lastName", Author.class);
	    query.setParameter("firstName", firstName);
	    query.setParameter("lastName", lastName); 
	    Author dbEntity = query.getSingleResult();
	    manager.close();
	    return dbEntity;

	}



}