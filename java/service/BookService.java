package com.minor.project.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.minor.project.entity.Book;
import com.minor.project.exception.BooksException;
import com.minor.project.exception.ExceptionCode;
import com.minor.project.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookService {

	@Autowired
    BookRepository bookRepository;
	
	public Book getBookNotIssuedToUser(UUID bookId) {
		return bookRepository.findById(bookId.toString()).orElseThrow(()-> new BooksException(ExceptionCode.BOOK_NOT_FOUND));
	}
	
	public Book saveOrUpdate(Book book) {
		return bookRepository.save(book);
	}
	
	public Optional<Book> getBookByIsbn(String isbn){
		return bookRepository.findByIsbn(isbn);
	}
	
	public Page<Book> getBooksByNameStartingWith(String nameStartsWith, int pageNum){
		PageRequest pageRequest = PageRequest.of(pageNum, 20, Sort.by(Sort.Direction.DESC, "createdAt"));
		//Pageable pageable = Pageable.ofSize(20);
		return bookRepository.findAllByNameStartingWith(pageRequest, nameStartsWith);
	}
}
