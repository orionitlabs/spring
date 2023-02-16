package com.userservice.users.utils;

import org.springframework.stereotype.Component;

@Component
public class Utils {
    public String createCustomerUserName(String customerFirstName, String customerLastName) {
        return customerFirstName+customerLastName.substring(0,5);
    }
}
