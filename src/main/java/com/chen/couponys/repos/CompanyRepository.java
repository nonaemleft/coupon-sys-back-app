package com.chen.couponys.repos;

import com.chen.couponys.bins.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
List<Company> findByEmail (String email);
boolean existsByName(String name);
boolean existsByEmail (String email);


}
