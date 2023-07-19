package com.chen.couponys.services;

import com.chen.couponys.bins.User;

public interface UserService {
    boolean existsByEmail(String email);
    boolean existsByEmailAndPassword(String email, String password);
    User findByEmail(String email);
    User getById(int id);
}
