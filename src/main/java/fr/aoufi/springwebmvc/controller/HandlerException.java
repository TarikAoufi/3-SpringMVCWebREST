package fr.aoufi.springwebmvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.aoufi.springwebmvc.dto.JsonError;
import fr.aoufi.springwebmvc.exception.PersonneNotFoundException;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { PersonneNotFoundException.class})  
	@ResponseStatus(HttpStatus.NOT_FOUND)
	protected void handleExceptionInternal(HttpServletResponse response, Exception ex) 
			throws IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		JsonError jsonError = new JsonError();
		jsonError.setMessage(ex.getMessage());
		jsonError.setCode(HttpStatus.NOT_FOUND.value());
		
		String errorMessage = objectMapper.writeValueAsString(jsonError);
		
		response.getWriter().println(errorMessage);
	}


}
