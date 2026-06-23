package com.fresherway.fresherway.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String>
    handleResourceNotFound(
            ResourceNotFoundException ex){

        Map<String,String> response =
                new HashMap<>();

        response.put(
                "message",
                ex.getMessage());

        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(
            HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,String>
    handleException(Exception ex){

        Map<String,String> response =
                new HashMap<>();

        response.put(
                "message",
                ex.getMessage());

        return response;
    }
    @ExceptionHandler(
        MethodArgumentNotValidException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public Map<String,String> handleValidation(
        MethodArgumentNotValidException ex){

    Map<String,String> errors =
            new HashMap<>();

    ex.getBindingResult()
            .getFieldErrors()
            .forEach(error ->
                    errors.put(
                            error.getField(),
                            error.getDefaultMessage()));

    return errors;
}
}