package com.minor.project.request;

import com.minor.project.entity.Author;
import com.minor.project.entity.Book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
public class CreateBookRequest {

	@NotBlank(message = "Name of the Book should not be null")
	String name;
	@NotBlank(message = "ISBN should not be null")
	String isbn;
	@NotNull
	String authorName;
	@NotNull
	String authorEmail;
	
	public Book toBook() {
		var associatedAuthor = Author.builder()
				.name(authorName)
				.emailId(authorEmail)
				.build();
		
		return Book.builder()
				.name(name)
				.isbn(isbn)
				.associatedAuthor(associatedAuthor)
				.build();
	}
}
