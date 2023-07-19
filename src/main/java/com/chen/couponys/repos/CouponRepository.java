package com.chen.couponys.repos;

import com.chen.couponys.bins.Category;
import com.chen.couponys.bins.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {


    List<Coupon> findByCompany(int id);

    List<Coupon> findByEndDateAfter(Date date);

    List<Coupon> findByCompanyAndPriceLessThan(int id, double maxPrice);
    List<Coupon> findByTitle(String title);

    List<Coupon> findByCompanyAndTitle(int id, String title);

    List<Coupon> findByCompanyAndCategory(int id, Category category);

    @Query(value = "INSERT INTO `inspringwetrust`.`customers_coupon_list` (`customer_id`, `coupon_list_id`) VALUES (?, ?);",nativeQuery = true)
    void purchaseCoupon(int id, int couponId) throws Exception;

    @Override
    void delete(Coupon coupon);
}
