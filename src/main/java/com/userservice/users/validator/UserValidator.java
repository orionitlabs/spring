package com.userservice.users.validator;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        if(String.valueOf(zip).length() == 5){
            return zip;
        }
        else{
            throw new RuntimeException("invalid zip code");
        }
    }

    public String validateState(String state){
        //Validation
        //Harsha
        if (state != null) {
            List<String> states = new ArrayList<>();
            Collections.addAll(states, "AL", "AK", "AS", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL", "GA",
                    "GU", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT",
                    "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "MP", "OH", "OK", "OR", "PA", "PR", "RI", "SC", "SD",
                    "TN", "TX", "UT", "VT", "VA", "VI", "WA", "WV", "WI", "WY");
            if (states.contains(state.toUpperCase()) == true)
                return state;
            else
                throw new RuntimeException("Invalid Entry for State");
        } else
            throw new RuntimeException("Invalid Entry for State");
    }
}
