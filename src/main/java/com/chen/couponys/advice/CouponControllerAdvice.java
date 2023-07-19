package com.chen.couponys.advice;

import com.chen.couponys.exceptions.CoupounSystemException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CouponControllerAdvice {
    @ExceptionHandler(value = {CoupounSystemException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrDetails handleException(Exception e){
        return new ErrDetails(e.getMessage());
    }
}
