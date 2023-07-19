package com.chen.couponys.controllers;



import com.jb.coupoun_2_spring.bins.User;
import com.jb.coupoun_2_spring.exceptions.CoupounSystemException;
import com.jb.coupoun_2_spring.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody User user) throws CoupounSystemException {
        authService.register(user);
    }

    @PostMapping("login")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID login(@RequestBody User user) throws CoupounSystemException {
        return authService.login(user);
    }
}
