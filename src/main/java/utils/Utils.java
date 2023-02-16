package com.userservice.users.utils;

import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

@Component
public class Utils {
    public static String createEmployeeId(){
//        return UUID.randomUUID().toString();
//        return new Random().ints(12345, 01234).toString();
        Random random = new Random();
        Integer id = random.nextInt(10000, 99999);
        return id.toString();
    }

//    public static Set<String> createStudentIds(){
//        Set<String> generated = new LinkedHashSet<>();
//        Random random = new Random();
//        while(generated.size()<5) {
//            generated.add(String.valueOf(random.nextInt(12345, 01234)));
//        }
//        return generated;
//    }
}
