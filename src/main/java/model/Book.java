package model;

import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import helper.LocalDateAttributeConverter;

@Entity(name = "book")
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;

	// Using a converter to store LocalDate as a SQL Date
	@Convert(converter = LocalDateAttributeConverter.class)
	private LocalDate publicationDate;

	// Many-to-One relationship with Author
	@ManyToOne
	@JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID")
	private Author author;

	// Default constructor
	public Book() {
		super();
	}

	// Parameterized constructor to set 'id', 'title', 'publicationDate', and
	// 'author'
	public Book(Long id, String title, LocalDate publicationDate, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.publicationDate = publicationDate;
		this.author = author;
	}

	// Getter and Setter methods for 'id'
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// Getter and Setter methods for 'title'
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// Getter and Setter methods for 'publicationDate'
	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	// Getter and Setter methods for 'author'
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	// Override the 'toString' method to provide a string representation of the Book
	// object
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", publicationDate=" + publicationDate + ", author=" + author
				+ "]";
	}
}
