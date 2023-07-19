package com.chen.couponys.controllers;

import com.chen.couponys.bins.Category;
import com.chen.couponys.bins.Company;
import com.chen.couponys.bins.Coupon;
import com.chen.couponys.bins.User;
import com.chen.couponys.exceptions.CoupounSystemException;
import com.chen.couponys.exceptions.ErrMsg;
import com.chen.couponys.login.ClientsType;
import com.chen.couponys.security.TokenService;
import com.chen.couponys.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private TokenService tokenService;

    @GetMapping
    public Company getCompanyDetails(@RequestHeader UUID token) throws Exception {
        if (!tokenService.isUserAllowed(token, ClientsType.ADMINISTRATOR)){
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        User user = tokenService.userFromToken(token);
        return companyService.getCompanyDetails(user.getId());
    }

    @GetMapping("/coupons")
    public List<Coupon> getCompanyCoupons(@RequestHeader UUID token) throws CoupounSystemException {
        if (!tokenService.isUserAllowed(token, ClientsType.COMPANY)){
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        User user = tokenService.userFromToken(token);
        return companyService.getCompanyCoupons(user.getId());
    }


    @GetMapping("/coupons/Price")
    public List<Coupon> getCompanyCoupons(@RequestHeader UUID token, @RequestParam double max) throws CoupounSystemException {
        if (!tokenService.isUserAllowed(token, ClientsType.COMPANY)) {
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        User user = tokenService.userFromToken(token);
        return companyService.getCompanyCoupons(max,user.getId());
    }


    @GetMapping("/coupons/category")
    public List<Coupon> getCompanyCoupons(@RequestHeader UUID token, @RequestParam Category category) throws CoupounSystemException {
        if (!tokenService.isUserAllowed(token, ClientsType.COMPANY)) {
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        User user = tokenService.userFromToken(token);
        return companyService.getCompanyCoupons(category,user.getId());
    }

    @PostMapping("/coupons/add")
    public void addCoupon(@RequestHeader UUID token, @RequestBody Coupon coupon) throws Exception {
        if (!tokenService.isUserAllowed(token, ClientsType.COMPANY)) {
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        companyService.addCoupon(coupon);

    }

    @PostMapping("/coupons/update/{id}")
    public void updateCoupon(@RequestHeader UUID token, @PathVariable int id, @RequestBody Coupon coupon) throws Exception {
        if (!tokenService.isUserAllowed(token, ClientsType.COMPANY)) {
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        companyService.updateCoupon(id, coupon);
    }

    @DeleteMapping("/coupons/del/{id}")
    public void deleteCoupon(@RequestHeader UUID token, @PathVariable int id) throws CoupounSystemException {
        if (!tokenService.isUserAllowed(token, ClientsType.COMPANY)) {
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        companyService.deleteCoupon(id);

    }


}
