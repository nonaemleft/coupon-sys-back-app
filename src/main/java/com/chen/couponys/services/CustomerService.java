package com.chen.couponys.services;

import com.chen.couponys.bins.Category;
import com.chen.couponys.bins.Coupon;
import com.chen.couponys.bins.Customer;

import java.util.List;

public interface CustomerService {
    ;

    List<Coupon> getCustomerCoupons(int customerId);

    List<Coupon> getCustomerCoupons(int id, Category category);

    List<Coupon> getCustomerCoupons(int id ,double maxPrice);

    Customer getCustomerDetails(int id) throws Exception;

    void purchaseCoupon(int id, int couponId) throws Exception;
    void delPurchaseCoupon(int customerId, int couponId);

}
