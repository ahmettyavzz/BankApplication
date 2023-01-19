package com.yavuzahmet.bankapplication.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class GeneralException extends RuntimeException {
    private final String message;
    private final String code;
    private final HttpStatus httpStatus;

    public GeneralException(ErrorStatusCode err) {
        super();
        this.message = err.getDescription();
        this.code = String.valueOf(err.getValue());
        this.httpStatus = err.getHttpStatus();
    }
}