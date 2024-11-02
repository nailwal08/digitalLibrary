package com.minor.project.entity;

import java.time.LocalDateTime;
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

public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String bookId;
	String name;
	String isbn;
	
	Integer securityDeposit;
	
	@Enumerated(value = EnumType.STRING)
	BookStatus bookStatus;
	
	//Many to one w.r.t books
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value="asscociatedBooks")
	@ToString.Exclude
	Author associatedAuthor;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value = "loanedBooks")
	@ToString.Exclude
	UserInfo loanedToUser;
	 
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value = "books")
	@ToString.Exclude
	Orders mappedWithOrder;
	
	@CreationTimestamp
	LocalDateTime createdAt; //OffsetDateTime is zone based
	
	@UpdateTimestamp
	LocalDateTime updatedAt; 
	
	//it is used to give a default value
	@PrePersist
	public void prePersist() {
		this.bookStatus = BookStatus.AVAILABLE;
		this.securityDeposit = 250;
	}
}
