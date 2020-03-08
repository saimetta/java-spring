package com.santiago.aimetta.bookApi;



public class AuthorDto {

	
	private Long authorId;
	private BookDto book;

	
	public AuthorDto() {}
	
	
	public AuthorDto(Long authorId, BookDto book) {
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


	public void setBook(BookDto book) {
		this.book = book;
	}


	public BookDto getBook() {
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
		AuthorDto other = (AuthorDto) obj;
		if (authorId == null) {
			if (other.authorId != null)
				return false;
		} else if (!authorId.equals(other.authorId))
			return false;
		return true;
	}



	
	




	
	
	
	
}
