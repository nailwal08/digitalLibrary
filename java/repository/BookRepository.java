package com.minor.project.repository;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.minor.project.entity.Book;

public interface BookRepository extends JpaRepository<Book, String> {
	
	Optional<Book> findByIsbn(String isbn);

	Page<Book> findAllByNameStartingWith(PageRequest pageRequest ,String stringBookNameStartsWith);
}
