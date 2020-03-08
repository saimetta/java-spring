package com.santiago.aimetta.publisher;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.santiago.aimetta.book.Book;

@Entity
@Table(name = "publisher")
public class Publisher {
	
	@Column(name = "publisher_name")
	private String name;
	@Id
	@Column(name = "code")
	private String code;
	
	@OneToMany(mappedBy = "publisher")
	@JsonIgnoreProperties("publisher")
	private Set<Book> books; 
	
	public Publisher() {
		
	}
	
	public Publisher(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public Set<Book> getBooks() {
		return books;
	}
	@Override
	public String toString() {
		return "Publisher [name=" + name + ", code=" + code + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Publisher other = (Publisher) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	
	
	
	
}
