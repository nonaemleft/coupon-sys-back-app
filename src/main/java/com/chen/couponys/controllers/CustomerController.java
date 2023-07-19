package com.chen.couponys.controllers;

import com.jb.coupoun_2_spring.bins.Category;
import com.jb.coupoun_2_spring.bins.Coupon;
import com.jb.coupoun_2_spring.bins.Customer;
import com.jb.coupoun_2_spring.bins.User;
import com.jb.coupoun_2_spring.exceptions.CoupounSystemException;
import com.jb.coupoun_2_spring.exceptions.ErrMsg;
import com.jb.coupoun_2_spring.login.ClientsType;
import com.jb.coupoun_2_spring.security.TokenService;
import com.jb.coupoun_2_spring.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    TokenService tokenService;


    @GetMapping("/coupon")
    public List<Coupon> getCustomerCoupons(@RequestHeader UUID token) throws CoupounSystemException {
        if (!tokenService.isUserAllowed(token, ClientsType.CUSTOMER)){
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        User user = tokenService.userFromToken(token);
        return customerService.getCustomerCoupons(user.getId());
    }


    @GetMapping("/coupon/category")
    List<Coupon> getCustomerCoupons(@RequestHeader UUID token, @RequestParam Category category) throws CoupounSystemException {
        if (!tokenService.isUserAllowed(token, ClientsType.CUSTOMER)){
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        User user = tokenService.userFromToken(token);
        return customerService.getCustomerCoupons(user.getId(),category);
    }


    @GetMapping("/coupon/price")
    public List<Coupon> getCustomerCoupons(@RequestHeader UUID token,@RequestParam double maxPrice) throws CoupounSystemException {
        if (!tokenService.isUserAllowed(token, ClientsType.CUSTOMER)){
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        User user = tokenService.userFromToken(token);
        return customerService.getCustomerCoupons(user.getId(),maxPrice);
    }
    @GetMapping
    public Customer getCustomerDetails(@RequestHeader UUID token) throws Exception {
        if (!tokenService.isUserAllowed(token, ClientsType.CUSTOMER)){
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        User user = tokenService.userFromToken(token);
        return customerService.getCustomerDetails(user.getId());
    }
    //todo
    private void purchaseCoupon(@RequestHeader UUID token) throws CoupounSystemException {
        if (!tokenService.isUserAllowed(token, ClientsType.CUSTOMER)){
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }

    }
}
