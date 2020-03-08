package com.santiago.aimetta.book;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.santiago.aimetta.author.Author;
import com.santiago.aimetta.chapter.Chapter;
import com.santiago.aimetta.publisher.Publisher;

@Entity
public class Book {
	@Id
	private String isbn;
	private String name;
	//Will persist changes on the publisher too
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "publisher_id")
	@JsonIgnoreProperties("books")
	private Publisher publisher;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "book_authors",
			   joinColumns = @JoinColumn(name="book_id"),
			   inverseJoinColumns = @JoinColumn(name = "author_id")
	)
	@JsonIgnoreProperties("books")
	private Set<Author> authors;
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("book")
	private Set<Chapter> chapters;
	
	
	public Book () {
	}
	
	public Book(String isbn, String name, Publisher publisher 
			,Set<Chapter> chapters
			,Set<Author> authors
			) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.publisher = publisher;
		this.chapters = chapters;
		this.authors = authors;

	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public Set<Chapter> getChapters() {
		return chapters;
	}
	public void setChapters(Set<Chapter> chapters) {
		this.chapters = chapters;
	}
	
	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}
	
	
	
}
