package com.minor.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minor.project.entity.UserInfo;
import com.minor.project.request.CreateUserRequest;
import com.minor.project.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserInfo> createUser(@RequestBody @Valid CreateUserRequest request) {
		return new ResponseEntity<>(userService.createNewUser(request), HttpStatus.CREATED);
	}
}
