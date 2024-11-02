package com.minor.project.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table( indexes = {@Index(name = "UNIQUE_EMAIL", columnList = "emailId", unique = true )})
		//@Index(name = "UNIQUE_PHONE_NUMBER", columnList = "phoneNumber", unique = true)})
@Audited
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String userId;
	
	String name;
	
	@Column(length = 15, unique = true)
	Long phoneNumber;
	
	@Enumerated(value = EnumType.STRING)  //by default it is ordinal
	UserType userType; 
	
	@Enumerated(value = EnumType.STRING)
	UserStatus userStatus;
	
	String emailId;
	
	@OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
	@NotAudited
	List<Orders> orderList;
	
	@OneToMany (mappedBy = "loanedToUser",fetch = FetchType.LAZY)
	@NotAudited
	List<Book> loanedBooks;
	
	@CreationTimestamp
	LocalDateTime createdAt; //OffsetDateTime is zone based
	
	@UpdateTimestamp
	LocalDateTime updatedAt;
	
	@PrePersist
	public void prePersist() {
		this.userStatus = userStatus.ACTIVE;
	}
}
