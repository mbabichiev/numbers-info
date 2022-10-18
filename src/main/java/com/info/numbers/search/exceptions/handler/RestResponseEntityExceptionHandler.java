package com.info.numbers.search.exceptions.handler;

import com.info.numbers.search.exceptions.NumberNotFoundException;
import com.info.numbers.search.exceptions.model.ApiExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(NumberNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ApiExceptionModel handleNumberNotFoundException(RuntimeException exception, WebRequest request) {
        return new ApiExceptionModel(exception.getMessage(), LocalDateTime.now(),
                ((ServletWebRequest) request).getRequest().getRequestURI());
    }

}
