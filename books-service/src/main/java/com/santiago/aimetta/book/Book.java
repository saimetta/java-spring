package com.santiago.aimetta.book;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.santiago.aimetta.author.Author;
import com.santiago.aimetta.chapter.Chapter;

@Entity
public class Book {
	@Id
	private String isbn;
	private String name;
	@Column(name = "publisher_id")
	private Long publisherId;
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("book")
	private Set<Author> authors;
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("book")
	private Set<Chapter> chapters;
	
	
	public Book () {
	}
	
	public Book(String isbn, String name, Long publisherId 
			,Set<Chapter> chapters
			,Set<Author> authors
			) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.publisherId = publisherId;
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
	
	public Long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
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

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + "]";
	}




	
	
}
