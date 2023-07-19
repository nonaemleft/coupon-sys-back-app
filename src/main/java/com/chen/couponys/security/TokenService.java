package com.chen.couponys.security;

import com.chen.couponys.bins.User;
import com.chen.couponys.login.ClientsType;
import java.util.UUID;

public interface TokenService {

   UUID addToken(User user);
    boolean isUserAllowed(UUID token, ClientsType type);

    User userFromToken(UUID token);

    void clear();
}
