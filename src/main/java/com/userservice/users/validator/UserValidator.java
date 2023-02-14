package com.userservice.users.validator;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    public String validatePhoneNumber(String phoneNumber){
        //Validation
        //Ushawnini
        //covert to Long and check length and again convert to string and send back
        if(phoneNumber != null &&phoneNumber.length() == 10){


            try {
                Long.parseLong(phoneNumber);
            } catch (NumberFormatException nfe) {
                throw new RuntimeException("invalid Phone Number");

            }
            return phoneNumber;
        }
        else{
            throw new RuntimeException("invalid Phone Number");
        }


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

