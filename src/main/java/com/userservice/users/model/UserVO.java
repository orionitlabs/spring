package com.userservice.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Getters and Setter
@AllArgsConstructor // Provides all args cons for us
@NoArgsConstructor // Provides default args cons for us
@Builder
public class UserVO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private AddressVO address1;
    private AddressVO address2;
}
