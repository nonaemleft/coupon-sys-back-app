package com.chen.couponys.services;

import com.chen.couponys.bins.Category;
import com.chen.couponys.bins.Company;
import com.chen.couponys.bins.Coupon;
import com.chen.couponys.exceptions.CoupounSystemException;
import java.util.List;

public interface CompanyService {
    void addCoupon(Coupon coupon) throws Exception;
    void updateCoupon(int id, Coupon coupon) throws Exception;
    void deleteCoupon(int id) throws CoupounSystemException;
    List<Coupon> getCompanyCoupons(int id);
    List<Coupon> getCompanyCoupons(double maxPrice, int id);
    List<Coupon> getCompanyCoupons(Category category, int id);
    Company getCompanyDetails(int id) throws Exception;
}
