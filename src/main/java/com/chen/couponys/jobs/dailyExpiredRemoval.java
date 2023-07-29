package com.chen.couponys.jobs;

import com.chen.couponys.bins.Coupon;
import com.chen.couponys.repos.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
public class dailyExpiredRemoval {
    @Autowired
    private CouponRepository couponRepository;

    @Scheduled(fixedRate =86_400_000 )
    public void dailyRemoval(){
        List<Coupon> couponList = couponRepository.findByEndDateAfter(Date.valueOf(LocalDate.now()));
        couponList.forEach(c->couponRepository.delete(c));
        System.out.println("daily coupon check");

    }
}
