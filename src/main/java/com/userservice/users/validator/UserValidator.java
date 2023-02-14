package com.userservice.users.validator;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    public String validatePhoneNumber(String phoneNumber){
        //Validation
        //Ushawnini
        //covert to Long and check length and again convert to string and send back

        return phoneNumber;
    }

    public Integer validateZip(Integer zip){
        //Validation
        //Pavan
        if(zip != null && String.valueOf(zip).length() == 5){
            return zip;
        }
        else{
            throw new RuntimeException("Invalid zip code");
        }
    }

    public String validateState(String state){
        //Validation
        //Harsha
        return state;
    }
}
