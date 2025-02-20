package com.online.test.dto;

/**
 * @Author ian
 * @create 06/02/25 11.10
 */
public enum FizzBuzzEnum {

    FIZZ("fizz"),
    BUZZ("buzz"),
    FIZZBUZZ("fizzbuzz");

    private final String value;

    private FizzBuzzEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FizzBuzzEnum getStatus(String value) {
        switch (value) {
            case "Fizz":
                return FizzBuzzEnum.FIZZ;
            case "Buzz":
                return FizzBuzzEnum.BUZZ;
            case "FizzBuzz":
                return FizzBuzzEnum.FIZZBUZZ;
            default:
                return null;
        }
    }
}
