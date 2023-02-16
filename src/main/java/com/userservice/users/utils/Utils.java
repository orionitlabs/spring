package com.userservice.users.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Utils {
    public  String createEmployeeId(){
        return UUID.randomUUID().toString();
    }
}
