package com.minor.project.exception;

import org.springframework.http.HttpStatus;

import lombok.*;

@AllArgsConstructor
@Getter
//@Setter
@ToString
public enum ExceptionCode {

	BOOK_ALREADY_EXISTS("LM_BOOK_001","Book Already Exist",HttpStatus.BAD_REQUEST),
	BOOK_NOT_FOUND("LM_BOOK_002","Book Not Found",HttpStatus.NOT_FOUND),
	BOOK_ALREADY_ISSUED("LM_BOOK_003","Book Already Issued",HttpStatus.BAD_REQUEST),
	BOOK_QUOTA_EXHAUSTED("LM_BOOK_004","Book Quota Exhausted",HttpStatus.BAD_REQUEST),
	USER_ALREADY_EXIST("LM_USER_001","User Already Exist",HttpStatus.BAD_REQUEST),
	USER_NOT_FOUND("LM_USER_002","User Not Found",HttpStatus.NOT_FOUND);
	
	final String errorCode;
	final String errorMessage;
	final HttpStatus status;
	
}
