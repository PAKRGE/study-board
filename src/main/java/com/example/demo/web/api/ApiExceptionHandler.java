package com.example.demo.web.api;

import com.example.demo.service.exception.IdNotFoundException;
import com.example.demo.service.exception.UserNotFoundException;
import com.example.demo.web.model.response.BoardUpdateResponse;
import com.example.demo.web.model.response.WriteContentsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.OK)
    public WriteContentsResponse handleUserNotFoundException() {
        return WriteContentsResponse.fail();
    }

    @ExceptionHandler(IdNotFoundException.class)
    @ResponseStatus(HttpStatus.OK)
    public BoardUpdateResponse handleIdNotFoundException(){
        return BoardUpdateResponse.fail();
    }
}
