package com.minor.project.entity;


import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(indexes = {@Index(name = "UNIQUE_EMAIL", columnList = "emailId", unique = true)})
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String authorId;
	String name;
	@Column(nullable = false)
	String emailId;
	
	@OneToMany(mappedBy ="associatedAuthor")
	@JsonIgnoreProperties(value = "associatedAuthor")
	@ToString.Exclude
	List<Book> asscociatedBooks;
	
	@CreationTimestamp
	LocalDateTime createdAt; //OffsetDateTime is zone based
	
	@UpdateTimestamp
	LocalDateTime updatedAt; 
}
