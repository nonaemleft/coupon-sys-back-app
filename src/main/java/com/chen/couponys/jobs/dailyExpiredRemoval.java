package com.chen.couponys.jobs;

import com.jb.coupoun_2_spring.bins.Coupon;
import com.jb.coupoun_2_spring.repos.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class dailyExpiredRemoval {
    @Autowired
    private CouponRepository couponRepository;
//todo del expire
    @Scheduled(fixedRate =86_400_000 )
    public void dailyRemoval(){

        System.out.println("daily coupon check");

    }
}
