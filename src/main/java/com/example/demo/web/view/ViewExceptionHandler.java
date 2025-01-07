package com.example.demo.web.view;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ViewExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleServerError(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error-500");  // 500 에러 페이지로 리다이렉트
        modelAndView.addObject("message", "서버에서 예기치 않은 오류가 발생했습니다.");
        return modelAndView;
    }
}
