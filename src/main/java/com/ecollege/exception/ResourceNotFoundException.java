package com.ecollege.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -7937960397930622310L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
	

}
