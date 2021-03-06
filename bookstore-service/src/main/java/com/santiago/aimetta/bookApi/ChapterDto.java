package com.santiago.aimetta.bookApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.santiago.aimetta.book.Book;

public class ChapterDto {
	private Long id;
	private String title;
	private Integer chapterNumber;
	@JsonIgnoreProperties("chapters")
	private Book book;
	
	public ChapterDto() {
		
	}
	
	public ChapterDto(String title, Integer chapterNumber) {
		super();
		this.title = title;
		this.chapterNumber = chapterNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getChapterNumber() {
		return chapterNumber;
	}
	public void setChapterNumber(Integer chapterNumber) {
		this.chapterNumber = chapterNumber;
	}
	
	public Book getBook() {
		return this.book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Chapter [title=" + title + ", chapterNumber=" + chapterNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chapterNumber == null) ? 0 : chapterNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		ChapterDto other = (ChapterDto) obj;
		if (chapterNumber == null) {
			if (other.chapterNumber != null)
				return false;
		} else if (!chapterNumber.equals(other.chapterNumber))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	
	
	
	
	
}
