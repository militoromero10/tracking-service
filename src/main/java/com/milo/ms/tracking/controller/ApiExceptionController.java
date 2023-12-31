package com.milo.ms.tracking.controller;

import com.milo.ms.tracking.exceptions.SolutionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SolutionException.class)
    public ResponseEntity<Object> handleNotFoundException(Exception e, WebRequest r) {
        return  ResponseEntity.noContent().build();
    }

}
