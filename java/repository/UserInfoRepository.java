package com.minor.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minor.project.entity.UserInfo;
import com.minor.project.entity.UserStatus;
import com.minor.project.entity.UserType;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

	Optional<UserInfo> findByEmailIdOrPhoneNumber(String emailId, Long phoneNumber);
	
	Optional<UserInfo> findByUserIdAndUserTypeAndUserStatus(String userId, UserType userType,UserStatus userStatus );
}
