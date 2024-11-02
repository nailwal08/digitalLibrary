package com.minor.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minor.project.entity.Orders;
import com.minor.project.request.CreateOrderRequest;
import com.minor.project.service.InventoryService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/orders")
@Slf4j
public class OrderController {

	@Autowired
	InventoryService inventoryService;
	
	@PostMapping(value ="", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> createNewOrder(@RequestBody @Valid CreateOrderRequest request){
		return new ResponseEntity<>(inventoryService.placeOrder(request),HttpStatus.CREATED);
	}
}
