package com.minor.project.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Audited

public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String orderId;
	
	@Enumerated(value = EnumType.STRING)
	OrderStatus orderStatus;
	
	@ManyToOne  // many order to one user
	@JoinColumn(name="userId")
	@JsonIgnoreProperties(value = "orderList")
	@ToString.Exclude
	UserInfo createdBy; 
	//LocalDateTime issuedate;
	
	Long amountPaidByUser;
	
	@OneToMany(mappedBy = "mappedWithOrder")  // one order to many user
	@NotAudited
	List<Book> books;
	
	@CreationTimestamp
	LocalDateTime createdAt; //OffsetDateTime is zone based
	
	@UpdateTimestamp
	LocalDateTime updatedAt;
	
}
