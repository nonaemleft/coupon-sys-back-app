package com.chen.couponys.services;

import com.chen.couponys.bins.Category;
import com.chen.couponys.bins.Company;
import com.chen.couponys.bins.Coupon;
import com.chen.couponys.exceptions.CoupounSystemException;
import com.chen.couponys.exceptions.ErrMsg;
import com.chen.couponys.repos.CompanyRepository;
import com.chen.couponys.repos.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service

public class CompanyServiceImpl extends ClientService implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CouponRepository couponRepository;



    @Override
    public void addCoupon(Coupon coupon) throws Exception {
        int id = coupon.getId();
        if (couponRepository.existsById(id)) {
            throw new CoupounSystemException(ErrMsg.ID_ALREADY_EXIST);
        }
        couponRepository.save(coupon);

    }

    @Override
    public void updateCoupon(int id, Coupon coupon) throws Exception {
        if (couponRepository.existsById(id)) {
            throw new CoupounSystemException(ErrMsg.ID_NOT_FOUND);
        }
        coupon.setId(id);
        couponRepository.saveAndFlush(coupon);
    }

    @Override
    public void deleteCoupon(int id) throws CoupounSystemException {
        if (couponRepository.existsById(id)) {
            throw new CoupounSystemException(ErrMsg.ID_NOT_FOUND);
        }
        couponRepository.deleteById(id);
    }

    @Override
    public List<Coupon> getCompanyCoupons(int id) {

        return couponRepository.findByCompany(id);
    }

    @Override
    public List<Coupon> getCompanyCoupons(double maxPrice, int id) {
        return couponRepository.findByCompanyAndPriceLessThan(id, maxPrice);
    }

    @Override
    public List<Coupon> getCompanyCoupons(Category category, int id) {
        return couponRepository.findByCompanyAndCategory(id, category);
    }

    @Override
    public Company getCompanyDetails(int id) throws Exception {
        return companyRepository.findById(id)
                .orElseThrow(()-> new CoupounSystemException(ErrMsg.ID_NOT_FOUND));
    }
}
