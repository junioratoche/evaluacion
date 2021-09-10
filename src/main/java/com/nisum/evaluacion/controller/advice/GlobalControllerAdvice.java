package com.nisum.evaluacion.controller.advice;

import com.nisum.evaluacion.exception.ExampleNisumException;
import com.nisum.evaluacion.helper.MessageHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map response = new HashMap();
        response.put(MessageHelper.MESSAGE, getFieldError(e));
        return ResponseEntity.badRequest().body(response);
    }


    @ExceptionHandler(ExampleNisumException.class)
    public ResponseEntity exampleGlobalLogicException(ExampleNisumException e) {
        Map response = new HashMap();
        response.put(MessageHelper.MESSAGE, e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    private String getFieldError(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldErrors().stream().findFirst().get();
        return "[" + fieldError.getField() + "] " + fieldError.getDefaultMessage();
    }
}

