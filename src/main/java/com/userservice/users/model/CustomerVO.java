package com.userservice.users.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("Customers")
public class CustomerVO {
    private String customerFirstName;
    private String customerLastName;
    private String customerUserName;
    private String customerBillNo;

    @Indexed(unique = true)
    private String customerEmail;
}