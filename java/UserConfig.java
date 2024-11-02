package com.minor.project.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@ToString
public class UserConfig implements InitializingBean{

	@Value("${student.book.quota:2}")
	Integer bookQuota;
	
	@Override
	public void afterPropertiesSet() throws Exception{
		log.info("values :", this);
	}
}
