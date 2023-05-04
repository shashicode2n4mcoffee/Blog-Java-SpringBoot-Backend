package com.app.blog.exception;

import com.app.blog.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> resourceNotFoundHandler(ResourceNotFoundException ex){
        ErrorDto errorResponse = new ErrorDto();

        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        return  new ResponseEntity<ErrorDto>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> validationExceptionHandler(MethodArgumentNotValidException ex){
        Map<String, Object> response = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            response.put(fieldName,message);
        });

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorDto> userAlreadyExistsException(ResourceAlreadyExistsException ex){
        ErrorDto errorResponse = new ErrorDto();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatus(HttpStatus.ALREADY_REPORTED.value());
        return new ResponseEntity<ErrorDto>(errorResponse, HttpStatus.ALREADY_REPORTED);
    }
}
