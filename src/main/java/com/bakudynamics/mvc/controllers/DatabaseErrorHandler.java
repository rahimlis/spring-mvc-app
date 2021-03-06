package com.bakudynamics.mvc.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DatabaseErrorHandler {


    @ExceptionHandler(DataAccessException.class)
    public String handleDatabaseException(DataAccessException ex) {
        ex.printStackTrace();
        return "error";
    }

    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessException(AccessDeniedException ex) {
        ex.printStackTrace();
        return "denied";
    }

}
