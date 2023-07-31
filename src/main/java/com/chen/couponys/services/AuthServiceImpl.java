package com.chen.couponys.services;

import com.chen.couponys.bins.User;
import com.chen.couponys.exceptions.CoupounSystemException;
import com.chen.couponys.exceptions.ErrMsg;
import com.chen.couponys.login.ClientsType;
import com.chen.couponys.repos.UserRepository;
import com.chen.couponys.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Override
    public void register(User user) throws CoupounSystemException {

        if (user.getType().equals(ClientsType.ADMINISTRATOR)) {
            throw new CoupounSystemException(ErrMsg.SECURITY_CANNOT_CREATE_ADMIN);
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new CoupounSystemException(ErrMsg.SECURITY_EMAIL_ALREADY_EXIST);
        }

        userRepository.save(user);

    }
//todo: enter id from db
    @Override
    public UUID login(User user) throws CoupounSystemException {
        if (!userRepository.existsByEmailAndPassword(user.getEmail(), user.getPassword())) {
            throw new CoupounSystemException(ErrMsg.EMAIL_AND_PASSWORD_DO_ONT_MACH);
        }
        List<User> userList = userRepository.findByEmail(user.getEmail());
        user.setId(userList.get(0).getId());
        System.out.println(1234);
        System.out.println(user);
        return tokenService.addToken(user);
    }
}
