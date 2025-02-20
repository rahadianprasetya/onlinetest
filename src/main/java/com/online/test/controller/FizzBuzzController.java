package com.online.test.controller;

import com.online.test.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ian
 * @create 06/02/25 10.58
 */
@RestController
public class FizzBuzzController {


    @RequestMapping(value = "/fizzbuzz/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FizzBuzzResponse> getFizzBuzzResponse(@PathVariable("code") String code)
            throws FizzException, BuzzException, FizzBuzzException {

        if (FizzBuzzEnum.FIZZ.getValue().equals(code)) {
            throw new FizzException("Fizz Exception has been thrown", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        } else if (FizzBuzzEnum.BUZZ.getValue().equals(code)) {
            throw new BuzzException("Buzz Exception has been thrown", HttpStatus.BAD_REQUEST.getReasonPhrase());
        } else if (FizzBuzzEnum.FIZZBUZZ.getValue().equals(code)) {
            throw new FizzBuzzException("FizzBuzz Exception has been thrown", HttpStatus.INSUFFICIENT_STORAGE.getReasonPhrase());
        }
        //return FizzBuzzResponse

        return ResponseEntity.ok(new FizzBuzzResponse("Ok", HttpStatus.OK.value()));
    }

}
