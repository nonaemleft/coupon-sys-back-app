package com.chen.couponys.services;

import com.chen.couponys.bins.Category;
import com.chen.couponys.bins.Coupon;
import com.chen.couponys.bins.Customer;
import com.chen.couponys.exceptions.CoupounSystemException;
import com.chen.couponys.exceptions.ErrMsg;
import com.chen.couponys.repos.CouponRepository;
import com.chen.couponys.repos.CustomerRepository;
import com.chen.couponys.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class CustomerServiceImpl extends ClientService implements CustomerService {


    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;


    @Override

    public void purchaseCoupon(int customerId, int couponId) throws Exception {
        List<Coupon> couponList = getCustomerDetails(customerId).getCouponList();

        for (Coupon coupon : couponList) {
            if (coupon.getId() == couponId) {
                throw new CoupounSystemException(ErrMsg.COUPON_ALREADY_PURCHASED);
            }
        }
        Coupon coupon1 = couponRepository.findById(couponId).orElseThrow();
        if (coupon1.getAmount() == 0) {
            throw new CoupounSystemException(ErrMsg.COUPON_SOLD_OUT);
        }
        coupon1.setAmount(coupon1.getAmount() - 1);
        couponRepository.saveAndFlush(coupon1);
        couponRepository.purchaseCoupon(customerId, couponId);

    }

    @Override
    public void delPurchaseCoupon(int customerId, int couponId) {
        customerRepository.delPurchaseCoupon(customerId,couponId);
    }

    @Override
    public List<Coupon> getCustomerCoupons(int customerId) {
        return customerRepository.findCustomerCoupons(customerId);
    }

    @Override
    public List<Coupon> getCustomerCoupons(int id, Category category) {
        return customerRepository.findCustomerCoupons(id, category);
    }

    @Override
    public List<Coupon> getCustomerCoupons(int id, double maxPrice) {
        return customerRepository.findCustomerCoupons(id, maxPrice);
    }

    @Override
    public Customer getCustomerDetails(int id) throws Exception {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CoupounSystemException(ErrMsg.ID_NOT_FOUND));
    }


}
