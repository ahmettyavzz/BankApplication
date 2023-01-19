package com.yavuzahmet.bankapplication.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 10000 - 20000 -> GENERAL CODES
 * 20000 - 30000 -> ACCOUNT CODES
 * 30000 - 40000 -> CUSTOMER CODES
 */

@AllArgsConstructor
@Getter
public enum ErrorStatusCode {
    ACCOUNT_NOT_FOUND_BY_ID(20001, "Account with this id not found!", HttpStatus.NO_CONTENT),
    CUSTOMER_NOT_FOUND_BY_ID(30001, "Customer with this id not found!", HttpStatus.NO_CONTENT),
    INVALID_FIELD(10001, "Invalid Input !", HttpStatus.BAD_REQUEST);

    private final int value;
    private final String description;
    private final HttpStatus httpStatus;
}