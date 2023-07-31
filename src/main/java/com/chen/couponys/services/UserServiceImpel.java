package com.chen.couponys.services;

import com.chen.couponys.bins.User;
import com.chen.couponys.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpel implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByEmailAndPassword(String email, String password) {
        return userRepository.existsByEmailAndPassword(email,password);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).get(0);
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id).orElseThrow();
    }
}
