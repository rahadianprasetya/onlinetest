package com.online.test.dto;

/**
 * @Author ian
 * @create 06/02/25 11.08
 */
public class FizzBuzzResponse {

    private String message;
    private int statusCode;

    public FizzBuzzResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
