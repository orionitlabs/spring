package com.userservice.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressVO {
    private String streetName;
    private String aptNo;
    private String city;
    private String state;
    private Integer zip;
}
