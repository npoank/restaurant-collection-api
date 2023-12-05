package com.kulbitski.restaurantCollectionAPI.configs;

import com.kulbitski.restaurantCollectionAPI.dto.ExceptionDTO;
import com.kulbitski.restaurantCollectionAPI.exceptions.RestaurantNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ExceptionDTO handleException(Exception ex) {
        return new ExceptionDTO(ex.getMessage(), ex.getClass().getSimpleName());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RestaurantNotFoundException.class)
    @ResponseBody
    public ExceptionDTO handleException(RestaurantNotFoundException ex) {
        return new ExceptionDTO(ex.getMessage(), ex.getClass().getSimpleName());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ExceptionDTO handleException(IllegalArgumentException ex) {
        return new ExceptionDTO(ex.getMessage(), ex.getClass().getSimpleName());
    }
}
