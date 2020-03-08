package com.santiago.aimetta.author;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.santiago.aimetta.book.Book;


@Entity
public class Author {

	@Id
	@Column(name = "author_id")
	private Long authorId;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "book_id")
	@JsonIgnoreProperties("authors")
	private Book book;

	
	public Author() {}
	
	
	public Author(Long authorId, Book book) {
		super();
		this.authorId = authorId;
		this.book = book;
	}


	public Long getAuthorId() {
		return authorId;
	}


	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public Book getBook() {
		return book;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorId == null) ? 0 : authorId.hashCode());
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
		Author other = (Author) obj;
		if (authorId == null) {
			if (other.authorId != null)
				return false;
		} else if (!authorId.equals(other.authorId))
			return false;
		return true;
	}



	
	




	
	
	
	
}
