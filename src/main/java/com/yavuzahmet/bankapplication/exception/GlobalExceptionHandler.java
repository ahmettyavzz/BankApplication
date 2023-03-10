package com.yavuzahmet.bankapplication.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        var fieldError = exception.getBindingResult().getFieldError();
        var errorMessage = "";
        if (Objects.nonNull(fieldError)) {
            errorMessage = fieldError.getField().concat(":").concat(Objects.requireNonNullElse(fieldError.getDefaultMessage(), ""));
        } else {
            errorMessage = exception.getMessage();
        }
        Map<String, String> errors = new HashMap<>();
        errors.put("error", errorMessage);
        errors.put("status", String.valueOf(ErrorStatusCode.INVALID_FIELD.getValue()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<?> generalExceptionHandler(GeneralException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        errors.put("status", ex.getCode());
        return new ResponseEntity<>(errors, ex.getHttpStatus());
    }
}
