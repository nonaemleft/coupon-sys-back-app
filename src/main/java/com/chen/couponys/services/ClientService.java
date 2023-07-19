package com.chen.couponys.services;

import com.chen.couponys.repos.CompanyRepository;
import com.chen.couponys.repos.CouponRepository;
import com.chen.couponys.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ClientService {
    @Autowired
    protected CouponRepository couponRepository;
    @Autowired
    protected CompanyRepository companyRepository;
    @Autowired
    protected CustomerRepository customerRepository;


}
