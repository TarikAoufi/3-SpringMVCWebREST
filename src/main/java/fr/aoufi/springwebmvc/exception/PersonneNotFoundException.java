package fr.aoufi.springwebmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonneNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PersonneNotFoundException (String message){
		super(message);
	}
}
