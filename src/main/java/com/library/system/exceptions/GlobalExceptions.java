package com.library.system.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.library.system.services.GenreNotFoundException;

@RestControllerAdvice
public class GlobalExceptions extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = BookNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public final ErrorDetails handleBookNotFoundException(BookNotFoundException ex, WebRequest request)
			throws Exception {

		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(true));

		return errorDetails;
	}

	@ExceptionHandler(value = BookAlreadyExistingException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public final ErrorDetails handleBookAlreadyExistingException(BookAlreadyExistingException ex, WebRequest request)
			throws Exception {

		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(true));

		return errorDetails;

	}
	
	@ExceptionHandler(value = GenreNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public final ErrorDetails handleGenreNotFoundException(GenreNotFoundException ex, WebRequest request)
			throws Exception {

		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(true));

		return errorDetails;
	}

}
