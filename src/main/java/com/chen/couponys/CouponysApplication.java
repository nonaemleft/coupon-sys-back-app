package com.chen.couponys;

import com.chen.couponys.repos.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CouponysApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouponysApplication.class, args);

		System.out.println("raddy");
	}

}
