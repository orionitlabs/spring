package com.userservice.users.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Utils {
    public  String createEmployeeId(){
        return UUID.randomUUID().toString();
    }

    public String createCustomerUserName(String customerFirstName, String customerLastName) {
        return customerFirstName+customerLastName.substring(0,5);
    }
}
