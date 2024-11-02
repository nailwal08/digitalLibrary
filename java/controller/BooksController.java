/**
 * Page<Book>  vs  List<Book>
 * 
 */
package com.minor.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minor.project.entity.Book;
import com.minor.project.request.CreateBookRequest;
import com.minor.project.service.BookService;
import com.minor.project.service.CatalogueService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/books")
@Slf4j
public class BooksController {

	@Autowired
	CatalogueService catalogueService;
	
	@Autowired
	BookService bookService;
	
	@PostMapping(value ="", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> addBook(@RequestBody @Valid CreateBookRequest createBookRequest) {
		return new ResponseEntity<>(catalogueService.addBookToCatalogue(createBookRequest), HttpStatus.CREATED);
	}
	
	@GetMapping(value ="/book/isbn/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> getBooks(@PathVariable("id") String isbn) {
		return new ResponseEntity<>(catalogueService.getBookbyIsbn(isbn), HttpStatus.CREATED);
	}
	
	@GetMapping(value ="/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Book>> getBooksbyName(@PathVariable("name") String name, @RequestParam(required = false) int pageNum) {
		return new ResponseEntity<>(bookService.getBooksByNameStartingWith(name,pageNum) , HttpStatus.CREATED);
	}
}
