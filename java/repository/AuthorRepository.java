package com.minor.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.minor.project.entity.Author;
import com.minor.project.entity.UserInfo;

public interface AuthorRepository extends JpaRepository<Author, String> {

	Optional<Author> findByEmailId(String emailId);
	/*
	@Query("select userinfo from UserInfo userinfo where userinfo.id= :userId")
	Optional<UserInfo> getTheInfoJPQLById(@Param("userId") String userId);
	
	@Query(value = "select * from user_info where id= :userId", nativeQuery = true)
	Optional<UserInfo> getTheInfoNativeSQlById(@Param("userId") String userId);
	*/
}
