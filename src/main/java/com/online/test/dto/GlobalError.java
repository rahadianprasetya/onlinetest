package com.online.test.dto;

/**
 * @Author ian
 * @create 06/02/25 11.09
 */
public class GlobalError {

    private String message;
    private String errorReason;

    public GlobalError() {
    }

    public GlobalError(String message, String errorReason) {
        this.message = message;
        this.errorReason = errorReason;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setErrorReason(String errorReason) {
        this.errorReason = errorReason;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorReason() {
        return errorReason;
    }
}
