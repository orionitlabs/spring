package com.userservice.users.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("Customers")
public class CustomerEntity {
    @Id
    private ObjectId id;
    private String customerFirstName;
    private String customerLastName;
    private String customerUserName;
    private String customerBillNo;
    private String customerEmail;

}
