package com.minor.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minor.project.entity.Author;
import com.minor.project.entity.Book;
import com.minor.project.exception.BooksException;
import com.minor.project.exception.ExceptionCode;
import com.minor.project.request.CreateBookRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CatalogueService {

	@Autowired
	AuthorService authorService;
	
	@Autowired
	BookService bookService;
	
	@Transactional
	public Book addBookToCatalogue(CreateBookRequest createBookRequest) {
		var inMemoryBook = createBookRequest.toBook();
		
		//check if author exist
		var existingAuthor = authorService.getAuthorByEmail(inMemoryBook.getAssociatedAuthor().getEmailId());
		if(existingAuthor.isEmpty()) {
			Author author = authorService.saveOrupdate(inMemoryBook.getAssociatedAuthor());
			inMemoryBook.setAssociatedAuthor(author);
		}
		else {
			inMemoryBook.setAssociatedAuthor(existingAuthor.get());
		}
		
		//check if book exist
		var existingBook = bookService.getBookByIsbn(inMemoryBook.getIsbn());
		if(existingBook.isPresent()) {
			throw new BooksException(ExceptionCode.BOOK_ALREADY_EXISTS);
		}
		return bookService.saveOrUpdate(inMemoryBook);
		
	}
	
	public Book getBookbyIsbn(String isbn) {
		var existingBook = bookService.getBookByIsbn(isbn);
		if(existingBook.isEmpty()) {
			throw new BooksException(ExceptionCode.BOOK_NOT_FOUND);
		}
		return existingBook.get();
	}
	
}
