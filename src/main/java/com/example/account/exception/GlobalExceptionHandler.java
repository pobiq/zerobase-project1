package com.example.account.exception;

import static com.example.account.type.ErrorCode.INTERNAL_SERVER_ERROR;
import static com.example.account.type.ErrorCode.INVALID_REQUEST;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.account.dto.ErrorReponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AccountException.class)
	public ErrorReponse handleAccountException(AccountException e) {
		log.error("{} is occurred.", e.getErrorCode());
		
		return new ErrorReponse(e.getErrorCode(), e.getErrorMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorReponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		log.error("MethodArgumentNotValidException is occurred.", e);
		
		return new ErrorReponse(INVALID_REQUEST, INVALID_REQUEST.getDescription());
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ErrorReponse handleDataIntegrityViolationException(DataIntegrityViolationException e) {
		log.error("DataIntegrityViolationException is occurred.", e);
		
		return new ErrorReponse(INVALID_REQUEST, INVALID_REQUEST.getDescription());
	}
	
	@ExceptionHandler(Exception.class)
	public ErrorReponse handleException(Exception e) {
		log.error("Exception is occurred.", e);
		
		return new ErrorReponse(INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR.getDescription());
	}
}
