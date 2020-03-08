package com.santiago.aimetta.author;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.santiago.aimetta.book.Book;


@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Embedded //The address is an component value of the author, if the author is removed the address too
	private Address address;
	@ManyToMany(mappedBy = "authors")
	@JsonIgnoreProperties("authors")
	private Set<Book> books;

	
	public Author() {}
	
	
	public Author(String name, Address adress) {
		super();
		this.name = name;
		this.address = adress;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address adress) {
		this.address = adress;
	}

	public Long getId() {
		return id;
	}


	public Set<Book> getBooks() {
		return books;
	}


	public void setBooks(Set<Book> books) {
		this.books = books;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
