package com.chen.couponys.controllers;

import com.chen.couponys.bins.Category;
import com.chen.couponys.bins.Coupon;
import com.chen.couponys.bins.Customer;
import com.chen.couponys.bins.User;
import com.chen.couponys.exceptions.CoupounSystemException;
import com.chen.couponys.exceptions.ErrMsg;
import com.chen.couponys.login.ClientsType;
import com.chen.couponys.security.TokenService;
import com.chen.couponys.services.CustomerService;
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
   @PutMapping("/purchase")
    private void purchaseCoupon(@RequestHeader UUID token, @RequestParam int couponId) throws Exception {
        if (!tokenService.isUserAllowed(token, ClientsType.CUSTOMER)){
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
       User user = tokenService.userFromToken(token);
       customerService.purchaseCoupon(user.getId(),couponId);

    }
}
