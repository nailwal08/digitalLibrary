package com.minor.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minor.project.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, String>{

}
