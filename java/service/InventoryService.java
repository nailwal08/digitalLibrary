package com.minor.project.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minor.project.entity.BookStatus;
import com.minor.project.entity.Orders;
import com.minor.project.entity.OrderStatus;
import com.minor.project.exception.BooksException;
import com.minor.project.exception.ExceptionCode;
import com.minor.project.request.CreateOrderRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InventoryService {

	//placing new order
	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	OrderService orderService;
	
	@Value("${student.book.quota:2}")
	Integer bookQuota;
	
	@Transactional
	public Orders placeOrder(CreateOrderRequest orderRequest) {
		var student = userService.findActiveUserById(orderRequest.getUserId());
		var book = bookService.getBookNotIssuedToUser(orderRequest.getBookId());
		
		//check if book issued to another user
		if(book.getLoanedToUser() != null) {
			throw new BooksException(ExceptionCode.BOOK_ALREADY_ISSUED);
		}
		//check the order list of a user
		var existingOrders = student.getOrderList();
		if(Objects.nonNull(bookQuota) && existingOrders.size() > bookQuota) {
			throw new BooksException(ExceptionCode.BOOK_QUOTA_EXHAUSTED);
		}
		
		Orders order = Orders.builder()
				.books(new ArrayList<>(Collections.singletonList(book)))
				.createdBy(student)
				.orderStatus(OrderStatus.PENDING)
				.build();
		orderService.saveOrUpdate(order);
		book.setBookStatus(BookStatus.NOT_AVAILABLE);
		book.setLoanedToUser(student);
		bookService.saveOrUpdate(book);
		order.setOrderStatus(OrderStatus.SUCCESS);
		orderService.saveOrUpdate(order);
		return order;
	}
}
