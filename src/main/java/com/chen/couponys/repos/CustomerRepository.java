package com.chen.couponys.repos;

import com.chen.couponys.bins.Category;
import com.chen.couponys.bins.Coupon;
import com.chen.couponys.bins.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByFirstName(String name);

    List<Customer> findByEmail(String email);
@Query(value = "SELECT inspringwetrust.coupons.id,inspringwetrust.coupons.company_id,inspringwetrust.coupons.category,inspringwetrust.coupons.title,inspringwetrust.coupons.`description`,inspringwetrust.coupons.start_date,inspringwetrust.coupons.end_date,inspringwetrust.coupons.amount,inspringwetrust.coupons.price,inspringwetrust.coupons.image  from  inspringwetrust.customers_coupon_list\n" +
        "            inner join inspringwetrust.coupons\n" +
        "            on inspringwetrust.customers_coupon_list.coupon_list_id= inspringwetrust.coupons.id \n" +
        "            where CUSTOMER_ID =?",nativeQuery = true)
    List<Coupon> findCustomerCoupons(int customerId);


    @Query(value = "SELECT inspringwetrust.coupons.id,inspringwetrust.coupons.company_id,inspringwetrust.coupons.category,inspringwetrust.coupons.title,inspringwetrust.coupons.`description`,inspringwetrust.coupons.start_date,inspringwetrust.coupons.end_date,inspringwetrust.coupons.amount,inspringwetrust.coupons.price,inspringwetrust.coupons.image  from  inspringwetrust.customers_coupon_list\n" +
            "            inner join inspringwetrust.coupons\n" +
            "            on inspringwetrust.customers_coupon_list.coupon_list_id= inspringwetrust.coupons.id \n" +
            "            where CUSTOMER_ID =? and category =?", nativeQuery = true)
    List<Coupon> findCustomerCoupons(int customerId, Category category);

    @Query(value = "SELECT inspringwetrust.coupons.id,inspringwetrust.coupons.company_id,inspringwetrust.coupons.category,inspringwetrust.coupons.title,inspringwetrust.coupons.`description`,inspringwetrust.coupons.start_date,inspringwetrust.coupons.end_date,inspringwetrust.coupons.amount,inspringwetrust.coupons.price,inspringwetrust.coupons.image  from  inspringwetrust.customers_coupon_list\n" +
            "            inner join inspringwetrust.coupons\n" +
            "            on inspringwetrust.customers_coupon_list.coupon_list_id= inspringwetrust.coupons.id \n" +
            "            where CUSTOMER_ID =? and price <= ?" ,nativeQuery = true)
    List<Coupon> findCustomerCoupons(int customerId, double maxPrice);



    @Query(value = "delete  FROM inspringwetrust.customers_coupon_list where customer_id = ? and coupon_list_id = ?;", nativeQuery = true)
     void delPurchaseCoupon(int customerID, int couponID);


}
