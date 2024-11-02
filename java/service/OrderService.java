package com.minor.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minor.project.entity.Orders;
import com.minor.project.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	public Orders saveOrUpdate(Orders order) {
		return orderRepository.save(order);
	}
}
