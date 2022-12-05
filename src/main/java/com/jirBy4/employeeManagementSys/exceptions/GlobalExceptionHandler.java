package com.jirBy4.employeeManagementSys.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorObj> handlePokemonNotFoundException(EmployeeNotFoundException ex, WebRequest rqst){
        ErrorObj errorObj = new ErrorObj();

        errorObj.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObj.setMessage(ex.getMessage());
        errorObj.setTimestamp(new Date());

        return new ResponseEntity<>(errorObj, HttpStatus.NOT_FOUND);
    }
}
