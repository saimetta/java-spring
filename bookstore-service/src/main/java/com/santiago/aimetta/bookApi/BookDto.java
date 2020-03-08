package com.santiago.aimetta.bookApi;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class BookDto {
	private String isbn;
	private String name;
	private Long publisherId;	
	@JsonIgnoreProperties("book")
	private List<AuthorDto> authors;
	@JsonIgnoreProperties("book")
	private List<ChapterDto> chapters;
	
	
	public BookDto () {
	}
	
	public BookDto(String isbn, String name, Long publisherId 
			,List<ChapterDto> chapters
			,List<AuthorDto> authors
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
	public List<ChapterDto> getChapters() {
		return chapters;
	}
	public void setChapters(List<ChapterDto> chapters) {
		this.chapters = chapters;
	}
	
	public List<AuthorDto> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorDto> authors) {
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
		BookDto other = (BookDto) obj;
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
