package com.minor.project.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EntityExceptions extends RuntimeException {

	ExceptionCode exceptionCode;

	public EntityExceptions(ExceptionCode exceptionCode) {
		super(exceptionCode.errorMessage);
		this.exceptionCode = exceptionCode;
	}
}
