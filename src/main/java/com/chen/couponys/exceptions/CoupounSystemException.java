package com.chen.couponys.exceptions;

public class CoupounSystemException extends Exception {
    public CoupounSystemException(ErrMsg errMsg) {
        super(errMsg.getMassage());
    }
}
