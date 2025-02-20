package com.online.test.exception;

import com.online.test.dto.BuzzException;
import com.online.test.dto.FizzBuzzException;
import com.online.test.dto.FizzException;
import com.online.test.dto.GlobalError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @Author ian
 * @create 06/02/25 11.11
 */

@RestControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {

    //TODO:: implement handler methods for FizzException, BuzzException and FizzBuzzException

    @ExceptionHandler(FizzException.class)
    public ResponseEntity<GlobalError> handleFizzException(FizzException ex) {
        return new ResponseEntity<>(new GlobalError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BuzzException.class)
    public ResponseEntity<GlobalError> handleBuzzException(BuzzException ex) {
        return new ResponseEntity<>(new GlobalError(ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FizzBuzzException.class)
    public ResponseEntity<GlobalError> handleFizzBuzzException(FizzBuzzException ex) {
        return new ResponseEntity<>(new GlobalError(ex.getMessage(), HttpStatus.INSUFFICIENT_STORAGE.getReasonPhrase()), HttpStatus.INSUFFICIENT_STORAGE);
    }
}










