package com.minor.project.exception;

import lombok.Getter;

@Getter

public class BooksException extends EntityExceptions {
	public BooksException(ExceptionCode exceptionCode) {
		super(exceptionCode);
	}
}
