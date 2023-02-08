package com.userservice.users.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressEntity {
    private String streetName;
    private String aptNo;
    private String city;
    private String state;
    private Integer zip;
}
