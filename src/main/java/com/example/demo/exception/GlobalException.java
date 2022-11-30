package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = UserException.class)
	@ResponseStatus
	@ResponseBody
	
	public ErrorResponse handleUserExistsExceptions(UserException e)
	{
		return new ErrorResponse(404, e.getMessage());
	}
}
