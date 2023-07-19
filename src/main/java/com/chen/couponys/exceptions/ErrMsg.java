package com.chen.couponys.exceptions;

import lombok.Getter;

@Getter
public enum ErrMsg {
    COUPON_SOLD_OUT("this coupon is sold out"),
    COUPON_ALREADY_PURCHASED(" you already purchase this coupon"),
    INVALID_ACTION("invalid action to this user"),
    SECURITY_EMAIL_ALREADY_EXIST("email already exist"),
    SECURITY_CANNOT_CREATE_ADMIN("can not create admin"),
    EMAIL_NOT_FOUND("email not found"),
    EMAIL_AND_PASSWORD_DO_ONT_MACH("email and password don't mach to any usr of this client type in the system"),
    ID_NOT_FOUND("id not found"),
    ID_ALREADY_EXIST("id already exist"),
    NAME_ALREADY_EXIST("name already exist");

    private String massage;

    ErrMsg(String massage){
        this.massage = massage;
    }


}
