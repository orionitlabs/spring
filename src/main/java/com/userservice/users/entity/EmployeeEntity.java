package com.userservice.users.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("employees")
public class EmployeeEntity {
    @Id
    private ObjectId id;
    private String employeeFirstName;
    private String employeeLastName;
    @Indexed(unique = true)
    private String employeeId;
    private String employeeDepartment;
    private Integer employeeSalary;

}

