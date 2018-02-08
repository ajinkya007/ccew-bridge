package com.test.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.checkmodel;

 
@RestController
@RequestMapping("/v1/forecasting")
public class Check {
 
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public checkmodel[] getAccounts() {
        checkmodel[] accounts = new checkmodel[] { new  checkmodel("123", "John R", BigDecimal.valueOf(235.00)),
                new  checkmodel("345", "Peter J", BigDecimal.valueOf(2505.60)) };
 
        return accounts;
    }
 
}