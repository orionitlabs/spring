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
@Document("users")
public class UserEntity {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private AddressEntity address1;
    private AddressEntity address2;
}
