package com.salesianostriana.monument.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MonumentNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(MonumentNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(MonumentNotFoundException ex) {
		return ex.getMessage();
	}
}
