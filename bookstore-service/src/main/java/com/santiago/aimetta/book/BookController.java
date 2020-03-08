package com.santiago.aimetta.book;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.santiago.aimetta.authorApi.AuthorDto;
import com.santiago.aimetta.bookApi.BookDto;

@RestController
public class BookController {


	@Autowired
	private RestTemplate restTemplate;
	

	
	@RequestMapping(method = RequestMethod.GET,path = "/books")
	public List<Book> getAllBooks() {
		//We can use this b/c the books-service/books returns a list instead of a list wrapped in an object
		//If that is the case we can use a wrapper for restTemplate
		//BookDtoList bookApiDtos = restTemplate.getForObject("http://books-service/books",BookDtoList.class);
		List<Book> result = new ArrayList<Book>();
		
		ResponseEntity<List<BookDto>> response = restTemplate.exchange(
				  "http://books-service/books",
				  HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<List<BookDto>>(){});
		List<BookDto> bookDtoList = response.getBody();
		
		
		
		Function<Long,AuthorDto> getAuthorInfo = (authorId) -> {
			return restTemplate.getForObject("http://authors-service/authors/"+authorId, AuthorDto.class);
		};

		
		bookDtoList.forEach(bookDto -> {
			List<AuthorDto> authors = new ArrayList<AuthorDto>();
			bookDto.getAuthors().forEach(bookAuthorDto -> {
				Long authorId = bookAuthorDto.getAuthorId();
				authors.add(getAuthorInfo.apply(authorId));
			});
			
			result.add(new Book(bookDto,authors));
		});
		return result;
	
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/books/{id}")
	public Book getBook(@PathVariable String id) {
		BookDto bookApiDto = restTemplate.getForObject("http://books-service/books/"+id, BookDto.class);
		List<AuthorDto> authors = new ArrayList<AuthorDto>();
		bookApiDto.getAuthors().forEach(author -> {
			authors.add(
					restTemplate.getForObject("http://authors-service/authors/"+author.getAuthorId(), AuthorDto.class)
					);

		});
		return new Book(bookApiDto,authors);
	}

}
