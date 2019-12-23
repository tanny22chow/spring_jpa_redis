package com.springPrac.springredisdemo.AppException.ExceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springPrac.springredisdemo.AppException.ApplicationDetailsNotFoundException;
import com.springPrac.springredisdemo.AppException.GenericExceptionModel.ExceptionModel;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ApplicationDetailsNotFoundException.class)
	public ResponseEntity<Object> handleApplicationDetailsNotFoundException(ApplicationDetailsNotFoundException ex, WebRequest request){
		ExceptionModel exception=new ExceptionModel(new Date(),ex.getMessage());
		return new ResponseEntity<Object>(exception, HttpStatus.NOT_FOUND);
	}
}
