package com.talissonmelo.osworks.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.talissonmelo.osworks.domain.service.exceptions.RuleException;

@ControllerAdvice
public class ApiExceptionHanlder extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(RuleException.class)
	public ResponseEntity<Object> rule(RuleException e, WebRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandardError error = new StandardError();
		error.setStatus(status.value());
		error.setMsg(e.getMessage());
		error.setTimestamp(LocalDateTime.now());
		
		return handleExceptionInternal(e, error, new HttpHeaders(), status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<FieldName> names = new ArrayList<>();
		
		for(ObjectError error: ex.getBindingResult().getAllErrors()) {
			String name = ((FieldError) error).getField();
			String msg = error.getDefaultMessage();
					
			names.add(new FieldName(name, msg));
		}
		
		StandardError error = new StandardError();
		error.setStatus(status.value());
		error.setTimestamp(LocalDateTime.now());
		error.setMsg("Campos Inválidos. Preencha novamento os dados e tente novamente.");
		error.setErrors(names);
		return super.handleExceptionInternal(ex, error, headers, status, request);
	}
}
