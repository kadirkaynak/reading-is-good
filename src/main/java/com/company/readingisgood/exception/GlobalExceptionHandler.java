package com.company.readingisgood.exception;


import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BookNotFoundException.class})
    public final ResponseEntity<Object> bookNotFoundExceptionHandler(BookNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {CustomerExistException.class})
    public final ResponseEntity<Object> customerExistExceptionHandler(CustomerExistException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {OrderNotFoundException.class})
    public final ResponseEntity<Object> orderNotFoundExceptionHandler(OrderNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {BookAmountNotEnoughException.class})
    public final ResponseEntity<Object> bookAmountNotEnoughExceptionHandler(BookAmountNotEnoughException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {OptimisticLockingFailureException.class})
    public final ResponseEntity<Object> optimisticLockingFailureExceptionHandler(OptimisticLockingFailureException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}