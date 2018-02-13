package com.citib.base.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validateUser(String userid, String password) {
        return userid.equalsIgnoreCase("kriti")
                && password.equalsIgnoreCase("1234");
    }

}