package com.chen.couponys.jobs;

import com.chen.couponys.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class ClearExpiredToken {
    @Autowired
    private TokenService tokenService;

    @Scheduled(fixedDelay = 1000*60)
    public void clearTokes(){
        tokenService.clear();
    }
}
