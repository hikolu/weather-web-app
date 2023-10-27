package com.hikolu.weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class WeatherExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<WeatherErrorResponse> handleException(CityNotFoundException exc) {

        WeatherErrorResponse error = new WeatherErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setSuccess(Boolean.FALSE);
        error.setMessage(exc.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
