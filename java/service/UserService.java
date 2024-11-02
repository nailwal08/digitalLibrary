package com.minor.project.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.minor.project.entity.UserInfo;
import com.minor.project.entity.UserStatus;
import com.minor.project.entity.UserType;
import com.minor.project.exception.ExceptionCode;
import com.minor.project.exception.UserException;
import com.minor.project.repository.UserInfoRepository;
import com.minor.project.request.CreateUserRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	public UserInfo saveOrUpdate(UserInfo userInfo) {
		return userInfoRepository.save(userInfo);
	}
	
	public UserInfo findActiveUserById(UUID userId){
		return userInfoRepository.findByUserIdAndUserTypeAndUserStatus(userId.toString(),UserType.STUDENT,UserStatus.ACTIVE).orElseThrow(()-> new UserException(ExceptionCode.USER_ALREADY_EXIST));
	}
	
	public UserInfo createNewUser(CreateUserRequest userRequest) {
		
		var newUser = userRequest.toUserInfo();
		//find existing user
		var existingUser = userInfoRepository.findByEmailIdOrPhoneNumber(newUser.getEmailId(), newUser.getPhoneNumber());
		if(existingUser.isPresent()) {
			throw new UserException(ExceptionCode.USER_ALREADY_EXIST);
		}
		var userInfo = saveOrUpdate(newUser);
		return userInfo;
	}
	
}
