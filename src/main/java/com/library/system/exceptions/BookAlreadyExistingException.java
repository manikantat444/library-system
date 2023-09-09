package com.library.system.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookAlreadyExistingException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	public String message;

	public BookAlreadyExistingException(String message) {
		super(message);
	}
	
	
	
	
}
