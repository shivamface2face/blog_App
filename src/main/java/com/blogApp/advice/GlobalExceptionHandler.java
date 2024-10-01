package com.blogApp.advice;

import com.blogApp.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
     public ResponseEntity<ApiError>handelResourceNotFound(ResourceNotFoundException exception){
      ApiError apiError= ApiError.builder()
              .httpStatus(HttpStatus.NOT_FOUND)
              .msg(exception.getMessage())
              .build();

      return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
 }


@ExceptionHandler(MethodArgumentNotValidException.class)
 public ResponseEntity<Map<String,String>>hadelMethodArgNotVlaidException(MethodArgumentNotValidException ex){
        Map<String,String>resp=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
        String fieldName=((FieldError)error).getField();
         String msg= error.getDefaultMessage();
         resp.put(fieldName,msg);
        });

        return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
 }


//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
//                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
//
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }


}
