package com.userservice.users.validator;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    public Long validatePhoneNumber(Long phoneNumber){
        //Validation
        //Ushawnini

        return phoneNumber;
    }

    public Integer validateZip(Integer zip){
        //Validation
        //Pavan
        return zip;
    }

    public String validateState(String state){
        //Validation
        //Harsha
        return state;
    }
}
