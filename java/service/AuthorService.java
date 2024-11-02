package com.minor.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minor.project.entity.Author;
import com.minor.project.repository.AuthorRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthorService {

	@Autowired
	AuthorRepository authorRepository;
	
	public Author saveOrupdate(Author author) {
		return authorRepository.save(author);
	}
	public Optional<Author> getAuthorByEmail(String emailId){
		return authorRepository.findByEmailId(emailId);
	}
}
