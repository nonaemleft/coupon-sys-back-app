package com.chen.couponys.security;

import com.chen.couponys.bins.User;
import com.chen.couponys.login.ClientsType;
import com.chen.couponys.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Service
public class TokenServiceImpl implements TokenService{
    @Autowired
    private UserService userService;

    private Map<UUID, Information> tokenMap = new HashMap<>();
    @Override
    public UUID addToken(User user) {
        UUID token =UUID.randomUUID();
        System.out.println(user);
        Information info = Information.builder().id(user.getId())
                .time(LocalDateTime.now())
                .clientTyp(user.getType())
                .build();
        System.out.println(info);

        tokenMap.put(token,info);
        return token;
    }

    @Override
    public boolean isUserAllowed(UUID token, ClientsType type) {
        Information info =tokenMap.get(token);
        System.out.println(info);
        ClientsType clientsType =info.getClientTyp();
        System.out.println(clientsType);

        return clientsType.equals(type);
    }

    @Override
    public User userFromToken(UUID token) {
        Information info = tokenMap.get(token);
        System.out.println(info);
        User user = userService.getById(info.getId());
        System.out.println(user);
        return  user;

    }

    @Override
    public void clear() {
        this.tokenMap.entrySet().removeIf(item-> item.getValue()
                .getTime().isBefore(LocalDateTime.now().minusMinutes(30)));


    }
}
