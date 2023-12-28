package com.example.SharkAdminApi.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error"); // Название вашей страницы ошибки
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }
}
