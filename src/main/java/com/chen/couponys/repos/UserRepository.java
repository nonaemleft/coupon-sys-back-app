package com.chen.couponys.repos;

import com.chen.couponys.bins.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    boolean existsByEmailAndPassword(String email, String password);
    List<User> findByEmail(String email);

}
